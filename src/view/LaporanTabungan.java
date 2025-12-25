package view;

import model.Tabungan;
import util.FileManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class LaporanTabungan extends JFrame {

    private ArrayList<Tabungan> list;
    private DefaultTableModel model;

    public LaporanTabungan() {
        setTitle("Laporan Tabungan Mahasiswa");
        setSize(650, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        list = FileManager.loadData();

        // ================= RINGKASAN =================
        double masuk = 0, keluar = 0;
        for (Tabungan t : list) {
            if (t.getJenis().equalsIgnoreCase("Masuk")) {
                masuk += t.getJumlah();
            } else {
                keluar += t.getJumlah();
            }
        }

        JTextArea ringkasan = new JTextArea(
                "Total Masuk   : " + masuk +
                        "\nTotal Keluar  : " + keluar +
                        "\nSaldo Akhir   : " + (masuk - keluar)
        );
        ringkasan.setEditable(false);
        ringkasan.setFont(new Font("Consolas", Font.BOLD, 14));
        ringkasan.setBackground(new Color(245, 245, 245));

        // ================= TABEL =================
        model = new DefaultTableModel(
                new String[]{"Jenis", "Jumlah", "Tanggal"}, 0
        );
        JTable table = new JTable(model);
        loadTable();

        // ================= BUTTON =================
        JButton sortTanggalAsc = new JButton("Tanggal Lama → Baru");
        JButton sortTanggalDesc = new JButton("Tanggal Baru → Lama");
        JButton sortMasuk = new JButton("Masuk Dahulu");
        JButton sortKeluar = new JButton("Keluar Dahulu");
        JButton kembali = new JButton("Kembali");

        // ================= AKSI =================
        sortTanggalAsc.addActionListener(e -> {
            list.sort(Comparator.comparing(Tabungan::getTanggal));
            loadTable();
        });

        sortTanggalDesc.addActionListener(e -> {
            list.sort(Comparator.comparing(Tabungan::getTanggal).reversed());
            loadTable();
        });

        sortMasuk.addActionListener(e -> {
            list.sort((a, b) -> b.getJenis().compareTo(a.getJenis()));
            loadTable();
        });

        sortKeluar.addActionListener(e -> {
            list.sort((a, b) -> a.getJenis().compareTo(b.getJenis()));
            loadTable();
        });

        kembali.addActionListener(e -> {
            new Dashboard();
            dispose();
        });

        // ================= PANEL =================
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(ringkasan, BorderLayout.NORTH);

        JPanel panelSort = new JPanel(new GridLayout(2, 2, 10, 10));
        panelSort.setBorder(BorderFactory.createTitledBorder("Sorting Data"));
        panelSort.add(sortTanggalAsc);
        panelSort.add(sortTanggalDesc);
        panelSort.add(sortMasuk);
        panelSort.add(sortKeluar);

        JPanel panelBawah = new JPanel();
        panelBawah.add(kembali);

        add(panelAtas, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(panelSort, BorderLayout.WEST);
        add(panelBawah, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadTable() {
        model.setRowCount(0);
        for (Tabungan t : list) {
            model.addRow(new Object[]{
                    t.getJenis(),
                    t.getJumlah(),
                    t.getTanggal()
            });
        }
    }
}
