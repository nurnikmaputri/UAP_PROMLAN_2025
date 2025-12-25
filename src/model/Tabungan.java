package model;

import java.time.LocalDate;

public class Tabungan {
    private int id;
    private LocalDate tanggal;
    private String keterangan;
    private String jenis;
    private double jumlah;

    public Tabungan(int id, LocalDate tanggal, String keterangan, String jenis, double jumlah) {
        this.id = id;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
        this.jenis = jenis;
        this.jumlah = jumlah;
    }

    public int getId() {
        return id;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getJenis() {
        return jenis;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }
}
