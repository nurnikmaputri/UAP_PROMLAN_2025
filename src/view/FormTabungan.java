package view;

import model.Tabungan;
import util.FileManager;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class FormTabungan extends JFrame {

    private JTextField txtTanggal, txtKet, txtJumlah;
    private JComboBox<String> cbJenis;
    private Tabungan dataEdit;

    public FormTabungan(Tabungan t) {
        dataEdit = t;

        //support create and update
        setTitle(t == null ? "Tambah Tabungan" : "Edit Tabungan");
        setSize(420, 340);
        setLocationRelativeTo(null);

        txtTanggal = new JTextField();
        txtKet = new JTextField();
        txtJumlah = new JTextField();
        cbJenis = new JComboBox<>(new String[]{"Masuk", "Keluar"});

        if (t != null) {
            txtTanggal.setText(t.getTanggal().toString());
            txtKet.setText(t.getKeterangan());
            txtJumlah.setText(String.valueOf(t.getJumlah()));
            cbJenis.setSelectedItem(t.getJenis());
        }

        JButton btnSimpan = new JButton("Simpan");
        JButton btnKembali = new JButton("Kembali");

        btnSimpan.setBackground(new Color(52, 152, 219));
        btnSimpan.setForeground(Color.WHITE);

        btnKembali.addActionListener(e -> {
            new Dashboard();
            dispose();
        });

        btnSimpan.addActionListener(e -> simpan());

        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        form.add(new JLabel("Tanggal (yyyy-MM-dd)"));
        form.add(txtTanggal);
        form.add(new JLabel("Keterangan"));
        form.add(txtKet);
        form.add(new JLabel("Jenis"));
        form.add(cbJenis);
        form.add(new JLabel("Jumlah"));
        form.add(txtJumlah);

        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBtn.add(btnKembali);
        panelBtn.add(btnSimpan);

        add(form, BorderLayout.CENTER);
        add(panelBtn, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void simpan() {

        //validasi kosong
        if (txtTanggal.getText().trim().isEmpty()
                || txtKet.getText().trim().isEmpty()
                || txtJumlah.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua data wajib diisi!");
            return;
        }

        LocalDate tanggal;
        try {
            tanggal = LocalDate.parse(txtTanggal.getText());
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Format tanggal harus yyyy-MM-dd");
            return;
        }

        double jumlah;
        try {
            jumlah = Double.parseDouble(txtJumlah.getText());
            if (jumlah <= 0) throw new NumberFormatException();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Jumlah harus angka dan > 0");
            return;
        }

        ArrayList<Tabungan> list = FileManager.loadData();

        if (dataEdit == null) {
            int idBaru = list.size() + 1;
            list.add(new Tabungan(
                    idBaru,
                    tanggal,
                    txtKet.getText(),
                    cbJenis.getSelectedItem().toString(),
                    jumlah
            ));
        } else {
            for (Tabungan t : list) {
                if (t.getId() == dataEdit.getId()) {
                    t.setTanggal(tanggal);
                    t.setKeterangan(txtKet.getText());
                    t.setJenis(cbJenis.getSelectedItem().toString());
                    t.setJumlah(jumlah);
                }
            }
        }

        FileManager.saveData(list);
        JOptionPane.showMessageDialog(this, "Data tabungan berhasil disimpan");
        new Dashboard();
        dispose();
    }
}
