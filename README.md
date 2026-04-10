
![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Language-Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)

## TokoLaptop
---

**Toko Laptop** adalah aplikasi Android sederhana yang dirancang untuk menampilkan katalog 10 laptop populer dari berbagai kategori — mulai dari laptop gaming premium seperti Asus ROG Strix hingga laptop bisnis seperti Lenovo ThinkPad X1.

Aplikasi ini merupakan tugas praktikum (Week 3 PAB) yang dibangun menggunakan **Kotlin** untuk mendemonstrasikan pemahaman dasar pengembangan Android, khususnya penggunaan **Intent**, **RecyclerView**, dan **Activity Lifecycle**.

---

## ✨ Fitur Utama

- **Katalog Laptop:** Menampilkan 10 laptop populer dalam antarmuka RecyclerView yang rapi dan scrollable.
- **Detail Laptop:** Menampilkan informasi lengkap seperti Nama, Spesifikasi, Harga, dan Deskripsi produk.
- **Navigasi Lancar:** Menggunakan *Explicit Intent* untuk perpindahan halaman dan pengiriman data objek antar Activity.
- **Fitur Ekstra:**
  - Tombol **Share Info Laptop** (*Implicit Intent*) untuk membagikan detail laptop ke aplikasi lain (WhatsApp, Telegram, Email, dll.).

---

## 🔧 Cara Kerja Aplikasi

Aplikasi ini mengimplementasikan konsep dasar `Activity`, `Intent`, `RecyclerView`, dan `View` di Android:

1. **`MainActivity.kt` (Halaman Utama)** — Berfungsi menampilkan daftar laptop menggunakan `RecyclerView` dengan `LinearLayoutManager`. Data laptop diinisialisasi sebagai `ArrayList<Laptop>` yang berisi 10 objek. Setiap item dibungkus dalam `CardView` yang bertindak sebagai tombol interaktif (*clickable*). Ketika diklik, aplikasi mengumpulkan data laptop dan mengirimkannya ke halaman berikutnya menggunakan `Intent.putExtra()` dengan objek `Serializable`.

2. **`LaptopAdapter.kt` (RecyclerView Adapter)** — Berfungsi sebagai jembatan antara data dan tampilan. Adapter meng-*inflate* layout `item_laptop.xml` untuk setiap item dan menangani event klik menggunakan `setOnClickListener`, di mana *Explicit Intent* ke `DetailActivity` dibuat dan dijalankan.

3. **`DetailActivity.kt` (Halaman Detail)** — Berfungsi menerima data dari `MainActivity` melalui `intent.getSerializableExtra("EXTRA_LAPTOP")`. Data yang diterima kemudian ditampilkan pada komponen antarmuka seperti `ImageView`, `TextView`, dan `Button`. Fitur *Implicit Intent* (`ACTION_SEND`) diimplementasikan di sini untuk membagikan informasi laptop.

4. **`Laptop.kt` (Data Class)** — Model data utama yang menyimpan atribut `name`, `specs`, `price`, `description`, dan `imageResId`. Mengimplementasikan `Serializable` agar objek dapat dikirim antar Activity.

---

## 📸 Cuplikan Layar (Screenshots)

| Halaman Utama | Halaman Detail |
|---|---|
| Daftar 10 laptop dalam RecyclerView | Detail lengkap dengan tombol Share |

> *Screenshot akan ditambahkan setelah build final.*

---

## 🚀 Panduan Instalasi

Ikuti langkah-langkah berikut untuk menjalankan *project* ini di komputermu:

1. **Clone repositori ini** melalui terminal atau Git Bash:
```bash
git clone https://github.com/USERNAME/tokoLaptop.git
```

2. **Buka di Android Studio** — File → Open → pilih folder hasil clone.

3. **Sync Gradle** — Tunggu hingga proses sinkronisasi selesai.

4. **Jalankan aplikasi** — Gunakan emulator atau perangkat Android fisik (min. API 24).

---

## 👥 Kelompok

Anggota tim yang berkontribusi dalam pengembangan aplikasi ini:

1. **Abdul Latief**             (L0324001)
2. **Anton Sulaiman**           (L0324004)
3. **Muhammad Hafizh Fadhilah** (L0324021)

---

## 📁 Struktur Project

```
app/
├── src/main/
│   ├── java/com/example/tokolaptop/
│   │   ├── MainActivity.kt        # Activity utama, setup RecyclerView & data
│   │   ├── DetailActivity.kt      # Activity detail, Implicit Intent share
│   │   ├── LaptopAdapter.kt       # RecyclerView Adapter, Explicit Intent
│   │   └── Laptop.kt              # Data class model laptop (Serializable)
│   └── res/
│       ├── layout/
│       │   ├── activity_main.xml      # Layout halaman utama
│       │   ├── activity_detail.xml    # Layout halaman detail
│       │   └── item_laptop.xml        # Layout item RecyclerView
│       └── drawable/
│           └── laptop1-10.png         # Gambar-gambar laptop
```

---

## 🛠️ Tech Stack

| Komponen | Detail |
|---|---|
| Bahasa | Kotlin |
| Min SDK | API 24 (Android 7.0) |
| Target SDK | API 34 (Android 14) |
| UI Components | RecyclerView, CardView, ScrollView |
| Navigasi | Explicit Intent + Implicit Intent |
| Data Transfer | Serializable object via Intent extras |
