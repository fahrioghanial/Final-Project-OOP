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
  - Short changes 1
  - Short changes 2

## Running The App

Nama main file adalah *GoRide.java*. 
Compile terlebih dahulu file main tersebut dengan command:
```
javac GoRide.java
```

Selanjutnya jalankan aplikasi.
Terdapat dua cara untuk menjalankan app ini

###1. Running tanpa menggunakan parameter
```
java GoRide
```

Secara default akan terbentuk:
- 20 x 20 map
- 5 driver pada random koordinat
- 1 user pada random koordinat

###2. Running menggunakan parameter
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

TO;DO

UML image here

## Notable Assumption and Design App Details

TO;DO
