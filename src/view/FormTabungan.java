package view;

import model.Tabungan;
import util.FileManager;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FormTabungan extends JFrame {

    private JTextField txtKet, txtJumlah;
    private JComboBox<String> cbJenis;
    private Tabungan dataEdit;

    public FormTabungan(Tabungan t) {
        dataEdit = t;

        setTitle(t == null ? "Tambah Tabungan" : "Edit Tabungan");
        setSize(420, 300);
        setLocationRelativeTo(null);

        txtKet = new JTextField();
        txtJumlah = new JTextField();
        cbJenis = new JComboBox<>(new String[]{"Masuk","Keluar"});

        if (t != null) {
            txtKet.setText(t.getKeterangan());
            txtJumlah.setText(String.valueOf(t.getJumlah()));
            cbJenis.setSelectedItem(t.getJenis());
        }

        JButton btnSimpan = new JButton("Simpan");
        JButton btnKembali = new JButton("Kembali");

        btnSimpan.setBackground(new Color(52,152,219));
        btnSimpan.setForeground(Color.WHITE);
        btnKembali.setBackground(Color.LIGHT_GRAY);

        btnKembali.addActionListener(e -> { new Dashboard(); dispose(); });
        btnSimpan.addActionListener(e -> simpan());

        JPanel form = new JPanel(new GridLayout(4,2,10,10));
        form.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
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
        if (txtKet.getText().trim().isEmpty() || txtJumlah.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Data tidak boleh kosong");
            return;
        }

        double jumlah;
        try {
            jumlah = Double.parseDouble(txtJumlah.getText());
            if (jumlah <= 0) throw new NumberFormatException();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Jumlah harus angka > 0");
            return;
        }

        ArrayList<Tabungan> list = FileManager.loadData();

        if (dataEdit == null) {
            list.add(new Tabungan(list.size()+1, LocalDate.now(),
                    txtKet.getText(), cbJenis.getSelectedItem().toString(), jumlah));
        } else {
            for (Tabungan t : list) {
                if (t.getId() == dataEdit.getId()) {
                    t.setKeterangan(txtKet.getText());
                    t.setJenis(cbJenis.getSelectedItem().toString());
                    t.setJumlah(jumlah);
                }
            }
        }

        FileManager.saveData(list);
        JOptionPane.showMessageDialog(this,"Data berhasil disimpan");
        new Dashboard();
        dispose();
    }
}
