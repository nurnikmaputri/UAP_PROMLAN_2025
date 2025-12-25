package view;

import model.Tabungan;
import util.FileManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;

public class ListTabungan extends JFrame {

    ArrayList<Tabungan> list;
    DefaultTableModel model;
    JTable table;

    public ListTabungan() {
        setTitle("List Tabungan");
        setSize(720,400);
        setLocationRelativeTo(null);

        list = FileManager.loadData();
        model = new DefaultTableModel(new String[]{"ID","Tanggal","Keterangan","Jenis","Jumlah"},0);
        table = new JTable(model);
        table.setRowHeight(22);
        loadTable();

        JTextField search = new JTextField();
        TableRowSorter sorter = new TableRowSorter(model);
        table.setRowSorter(sorter);
        search.addCaretListener(e -> sorter.setRowFilter(RowFilter.regexFilter(search.getText())));

        JButton edit = new JButton("Edit");
        JButton hapus = new JButton("Hapus");
        JButton kembali = new JButton("Kembali");

        edit.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r >= 0) new FormTabungan(list.get(table.convertRowIndexToModel(r)));
            dispose();
        });

        hapus.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r >= 0) {
                list.remove(table.convertRowIndexToModel(r));
                FileManager.saveData(list);
                loadTable();
            }
        });

        kembali.addActionListener(e -> { new Dashboard(); dispose(); });

        JPanel bottom = new JPanel();
        bottom.add(kembali);
        bottom.add(edit);
        bottom.add(hapus);

        add(search, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadTable() {
        model.setRowCount(0);
        for (Tabungan t : list) {
            model.addRow(new Object[]{
                    t.getId(), t.getTanggal(), t.getKeterangan(), t.getJenis(), t.getJumlah()
            });
        }
    }
}
