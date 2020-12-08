# Go-Ride App

This repository is a final project (Java GUI) from Object-Oriented Programming Class, Teknik Informatika Universitas Padjadjaran.

[Challenge Guidelines](challenge-guideline.md)

**Go-Ride adalah aplikasi yang mensimulasikan pelayanan ojek online dimana pengguna memesan driver kemudian akan ditampilkan nama driver terdekat beserta 
estimasi harganya lalu akan ditampilkan rute jalan user ke tempat tujuan. Kemudian driver akan mengantarkan pengguna ke tempat tujuan.**

## Credits

| NPM          | Name                           |
| ------------ | ------------------------------ |
| 140810190005 | Mohamad Fahrio Ghanial Fatihah |
| 140810190033 | Chandra Wijaya                 |
| 140810190045 | Adam Din Naufan                |

## Change log

- **[Sprint Planning](changelog/sprint-planning.md) - (18/11/2020)**

  - Berdiskusi membentuk Challenge Guidelines, dan menentukan sprint backlog

- **[Sprint 1](changelog/sprint-1.md) - (18/11/2020 - 24/11/2020)**
  - Membuat drawing board                                
  - Membuat indikator map                                
  - Membuat indikator user                     
  - Membuat indikator driver    
  - Membuat input koordinat dan button konfirmasi        
  - Membuat button history    

- **[Sprint 2](changelog/sprint-2.md) - (25/11/2020 - 1/12/2020)**
  - Membuat window yang menampilkan driver terdekat dan estimasi harga	
  - Membuat window yang menampilkan rute jalan	
  - Membuat button proceed layanan go-ride dan membuat algoritma proceed layanan
  
- **[Sprint 3](changelog/sprint-3.md) - (2/12/2020 - 8/12/2020)**
  - Merapihkan antarmuka
  - Mengimplementasikan Challenges Ideas (Membuat Animasi)
  - Membuat UML & Finishing 

## Running The App

Nama main file adalah *GoRide.java* <br>
Compile terlebih dahulu file main tersebut dengan command:
```
javac GoRide.java
```

Selanjutnya jalankan aplikasi. <br>
Terdapat dua cara untuk menjalankan app ini

### 1. Running tanpa menggunakan parameter
```
java GoRide
```

Secara default akan terbentuk:
- 20 x 20 map
- 5 driver pada random koordinat
- 1 user pada random koordinat

### 2. Running menggunakan parameter
```
java GoRide custommapsize
```
contoh:
```
java GoRide 15
```

Secara default akan terbentuk:
- n x n map (custom size)
- 5 driver pada random koordinat
- 1 user pada random koordinat

## Classes Used

**1. GoRide (Goride.java)**
Program Utama

### Folder action
**1. Animation (Animation.java)**
*Action event listener* dari class Timer, untuk menampilkan animasi
**2. ConfirmAction (ConfirmAction.java)**
*Action event listener* dari button "Konfirmasi Tujuan"
**3. HistoryAction (HistoryAction.java)**
*Action event listener* dari button "History"
**4. OrderAgainAction (OrderAgainAction.java)**
*Action event listener* dari button "Pesan Lagi"
**5. ProceedAction (ProceedAction.java)**
*Action event listener* dari button "Proses Layanan"


### Folder ui
**1. Avatar (Avatar.java)**
Untuk membuat objek avatar user dan avatar driver
**2. DrawingBoard (DrawingBoard.java)**
Drawing board untuk menampilkan peta, jalur, user, dan driver
**3. Map (Map.java)**
Untuk membuat objek peta
**4. MenuPanel (MenuPanel.java)**
*Nested container object* dari menu-menu yang terdapat pada app
**5. Pathways (Pathways.java)**
Untuk membuat objek jalur
**6. UserInterface (UserInterface.java)**
User Interface yang berisi drawing board dan menu panel

UML image here

## Notable Assumption and Design App Details.
### Saat Aplikasi Dijalankan
  - Terdapat titik titik koordinat *map* yang ukurannya dapat disesuaikan dengan keinginan *user* (ukuran default : 20x20)
  - Terdapat 1 avatar *user* yang berwarna Putih dan 5 avatar *driver* yang berwarna Hijau, Magenta, Pink, Kuning, Merah. Avatar-avatar tersebut akan berada pada koordinat *random*
  - Terdapat garis untuk koordinat kartesius yang berwarna oranye
  - Terdapat menu-menu:
    - *Spinner* untuk memilih tujuan x pada koordinat kartesius
    - *Spinner* untuk memilih tujuan y pada koordinat kartesius
    - *Button* "Konfirmasi Tujuan" untuk mengkonfirmasi tujuan
    - *Button* "History" untuk melihat riwayat perjalanan.
### Detail Aplikasi
  - Titik pojok kiri atas terletak pada koordinat 23,23 (koordinat JPanel) dengan jarak antar titik adalah 18 (koordinat JPanel)
  - Riwayat perjalanan akan terhapus ketika aplikasi ditutup
  - Ketika *user* menekan *button* "Konfirmasi Tujuan" akan terdapat:
    - Keterangan koordinat tujuan
    - Keterangan driver terdekat
    - Keterangan harga
    - Titik-titik putih pada map yang menunjukkan jalur yang akan ditempuh dari koordinat *user* ke koordinat tujuan
    - *Button* "Proses Layanan".
  - Ketika *user* menekan *button* "Proses Layanan" akan terdapat:
    - *Button* "Pesan Lagi"
    - Animasi *driver* menghampiri *user*
    - Animasi *driver* dan *user* menuju koordinat tujuan (setelah sampai, driver akan berpindah ke koordinat *random*.
