# 📘 Sistem Pencatatan Tabungan Mahasiswa

## 📌 Deskripsi Aplikasi
Sistem Pencatatan Tabungan Mahasiswa adalah aplikasi desktop berbasis **Java Swing** yang digunakan untuk mencatat transaksi tabungan mahasiswa, baik **tabungan masuk** maupun **tabungan keluar**.  
Aplikasi ini dikembangkan untuk memenuhi **Ujian Akhir Praktikum Pemrograman Lanjut**, dengan mengimplementasikan materi **Modul 1–6**.

Aplikasi mendukung pengelolaan data secara permanen menggunakan **File Handling**, sehingga data tetap tersimpan meskipun aplikasi ditutup.


## 🎯 Tujuan Pengembangan
- Menerapkan konsep **Object Oriented Programming (OOP)**
- Mengimplementasikan **GUI Java Swing**
- Menerapkan **CRUD (Create, Read, Update, Delete)**
- Menggunakan **File Handling (.csv / .txt)**
- Menggunakan **LocalDate** untuk pengelolaan tanggal
- Menerapkan **Exception Handling**
- Menyediakan fitur **sorting data**


## 🧩 Fitur Aplikasi

### 1️⃣ Dashboard
- Menu navigasi utama aplikasi
- Akses ke halaman input tabungan dan laporan tabungan

### 2️⃣ Input Tabungan
- Input data tabungan mahasiswa:
  - Nama Mahasiswa
  - Jenis Tabungan (Masuk / Keluar)
  - Jumlah Tabungan
  - Tanggal Transaksi
- Validasi:
  - Data tidak boleh kosong
  - Jumlah harus berupa angka
  - Format tanggal harus `yyyy-MM-dd`
- Data disimpan secara permanen ke file

### 3️⃣ Laporan Tabungan
- Menampilkan:
  - Total Tabungan Masuk
  - Total Tabungan Keluar
  - Saldo Akhir
- Menampilkan tabel data tabungan
- Fitur sorting:
  - Sorting berdasarkan tanggal (lama → baru)
  - Sorting berdasarkan tanggal (baru → lama)
  - Sorting berdasarkan jenis transaksi (Masuk / Keluar)
- Tombol kembali ke Dashboard

## 🛠️ Teknologi yang Digunakan
- **Bahasa Pemrograman** : Java
- **GUI** : Java Swing
- **Penyimpanan Data** : File Handling (.csv / .txt)
- **Tanggal** : `java.time.LocalDate`
- **IDE** : IntelliJ IDEA / NetBeans


## 📂 Struktur Folder
src/
├── model/
│ └── Tabungan.java
├── util/
│ └── FileManager.java
├── view/
│ ├── Dashboard.java
│ ├── FormTabungan.java
│ └── LaporanTabungan.java
└── MainApp.java


## ▶️ Cara Menjalankan Program
1. Pastikan **JDK sudah terinstal**
2. Buka project di **IntelliJ IDEA / NetBeans**
3. Jalankan file: MainApp.java
4. Aplikasi akan menampilkan halaman Dashboard


## 🧪 Skenario Pengujian Manual (Testing)

### 🔹 Pengujian Input Data
**Langkah:**
1. Buka menu Input Tabungan
2. Masukkan data tabungan
3. Klik tombol Simpan

**Hasil yang Diharapkan:**
- Data tersimpan ke file
- Data muncul di laporan
- Tidak terjadi error


### 🔹 Pengujian Validasi
**Kasus:**
- Input kosong
- Input jumlah bukan angka
- Format tanggal salah

**Hasil yang Diharapkan:**
- Muncul pesan error
- Data tidak disimpan


### 🔹 Pengujian Sorting
**Langkah:**
1. Buka halaman Laporan
2. Klik tombol sorting (tanggal / jenis)

**Hasil yang Diharapkan:**
- Data terurut sesuai kriteria
- Tidak mengubah isi data asli


## 🔍 Code Review Singkat
- Penamaan variabel sudah deskriptif
- Struktur package dipisah (model, view, util)
- Tidak ada duplikasi kode
- Exception Handling sudah diterapkan


## 👩‍🎓 Identitas Pengembang
- **Nama** : Putri Nurnikmatus Suharnani dan Rizka Amelia Rusadi
- **Program Studi** : Teknik Informatika  
- **Mata Kuliah** : Pemrograman Lanjut  
- **Tugas** : Ujian Akhir Praktikum  


## ✅ Kesimpulan
Aplikasi Sistem Pencatatan Tabungan Mahasiswa telah berhasil mengimplementasikan seluruh ketentuan UAP, mulai dari GUI, CRUD, File Handling, hingga sorting dan validasi input. Aplikasi ini diharapkan dapat membantu mahasiswa dalam mengelola tabungan secara sederhana dan efektif.

 
