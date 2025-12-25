package view;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard() {
        setTitle("Dashboard Tabungan Mahasiswa");
        setSize(420, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel title = new JLabel("📘 Student Saving Manager", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));

        JButton btnInput = new JButton("➕ Input Tabungan");
        JButton btnList = new JButton("📋 List Tabungan");
        JButton btnLaporan = new JButton("📊 Laporan");

        btnInput.addActionListener(e -> new FormTabungan(null));
        btnList.addActionListener(e -> new ListTabungan());
        btnLaporan.addActionListener(e -> new LaporanTabungan());

        JPanel panel = new JPanel(new GridLayout(3, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setBackground(new Color(230, 245, 255));

        panel.add(btnInput);
        panel.add(btnList);
        panel.add(btnLaporan);

        add(panel);
        setVisible(true);
    }
}
