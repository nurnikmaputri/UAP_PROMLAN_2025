package util;

import model.Tabungan;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_PATH = "data/tabungan.csv";

    public static ArrayList<Tabungan> loadData() {
        ArrayList<Tabungan> list = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Tabungan t = new Tabungan(
                        Integer.parseInt(data[0]),
                        LocalDate.parse(data[1]),
                        data[2],
                        data[3],
                        Double.parseDouble(data[4])
                );
                list.add(t);
            }
        } catch (Exception e) {
            System.out.println("Gagal membaca file");
        }
        return list;
    }

    public static void saveData(ArrayList<Tabungan> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Tabungan t : list) {
                bw.write(t.getId() + "," +
                        t.getTanggal() + "," +
                        t.getKeterangan() + "," +
                        t.getJenis() + "," +
                        t.getJumlah());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file");
        }
    }
}
