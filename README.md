# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini merupakan aplikasi sederhana berbasis Java yang dibuat sebagai tugas akhir mata kuliah Pemrograman Berbasis Objek 1 dengan tema **Sistem Sewa Lapangan Padel Kenangan**.

## Deskripsi

Aplikasi ini digunakan untuk melakukan proses penyewaan lapangan padel. Pengguna dapat memilih jenis lapangan, memasukkan durasi penyewaan, kemudian sistem akan menghitung total biaya sesuai jenis lapangan yang dipilih. Untuk lapangan VIP terdapat fasilitas tambahan berupa raket, bola, akses lounge, serta biaya lounge yang ditambahkan secara otomatis ke total pembayaran.

Aplikasi ini mengimplementasikan berbagai konsep penting dalam Pemrograman Berorientasi Objek (Object Oriented Programming/OOP) seperti Class, Object, Atribut, Constructor, Mutator, Accessor, Encapsulation, Inheritance, Polymorphism (Method Overriding), Seleksi, Perulangan, Input Output Sederhana, Array, dan Error Handling.

---

# Penjelasan Kode

## 1. Class

Class merupakan blueprint atau cetakan untuk membuat object.

Pada program ini terdapat tiga class yaitu:

- `LapanganPadel`
- `LapanganVIP`
- `Main`

```java
public class LapanganPadel {
    ...
}

public class LapanganVIP extends LapanganPadel {
    ...
}

public class Main {
    ...
}
```

---

## 2. Object

Object merupakan hasil pembuatan dari sebuah class.

Pada program ini object dibuat saat mengisi array `daftarLapangan`.

```java
daftarLapangan[0] = new LapanganPadel("Outdoor (Standard)", 150000);

daftarLapangan[1] = new LapanganPadel("Indoor (Premium)", 200000);

daftarLapangan[2] = new LapanganVIP(
        "VIP Court",
        300000,
        "Gratis Raket, Bola, & Akses Lounge",
        50000);
```

---

## 3. Atribut

Atribut merupakan variabel yang dimiliki oleh suatu class.

Pada class **LapanganPadel** terdapat atribut:

```java
protected String tipeLapangan;
private double hargaPerJam;
```

Sedangkan pada class **LapanganVIP** terdapat atribut tambahan:

```java
private String fasilitasTambahan;
private double biayaTambahanLounge;
```

---

## 4. Constructor

Constructor digunakan untuk memberikan nilai awal pada object saat object dibuat.

Constructor pada class **LapanganPadel**:

```java
public LapanganPadel(String tipeLapangan, double hargaPerJam) {
    this.tipeLapangan = tipeLapangan;
    this.hargaPerJam = hargaPerJam;
}
```

Constructor pada class **LapanganVIP**:

```java
public LapanganVIP(String tipeLapangan,
        double hargaPerJam,
        String fasilitasTambahan,
        double biayaTambahanLounge) {

    super(tipeLapangan, hargaPerJam);

    this.fasilitasTambahan = fasilitasTambahan;
    this.biayaTambahanLounge = biayaTambahanLounge;
}
```

---

## 5. Mutator (Setter)

Mutator digunakan untuk mengubah nilai suatu atribut.

Pada program ini terdapat method setter:

```java
public void setHargaPerJam(double hargaPerJam) {
    this.hargaPerJam = hargaPerJam;
}
```

---

## 6. Accessor (Getter)

Accessor digunakan untuk mengambil nilai atribut.

```java
public String getTipeLapangan() {
    return tipeLapangan;
}

public double getHargaPerJam() {
    return hargaPerJam;
}
```

---

## 7. Encapsulation

Encapsulation diterapkan dengan membuat atribut `hargaPerJam` menjadi `private` sehingga tidak dapat diakses secara langsung dari luar class.

```java
private double hargaPerJam;
```

Atribut tersebut hanya dapat diakses melalui method getter dan setter.

---

## 8. Inheritance

Inheritance merupakan konsep pewarisan sifat dari superclass ke subclass.

Pada program ini class `LapanganVIP` mewarisi class `LapanganPadel`.

```java
public class LapanganVIP extends LapanganPadel {
    ...
}
```

---

## 9. Polymorphism (Method Overriding)

Polymorphism diterapkan melalui **method overriding**.

Method `hitungTotalBiaya()` pada class `LapanganVIP` menggantikan method yang ada pada superclass sehingga biaya lounge ikut dihitung.

```java
@Override
public double hitungTotalBiaya(int durasiJam) {
    return (getHargaPerJam() * durasiJam) + biayaTambahanLounge;
}
```

Method `tampilkanInfo()` juga dioverride sehingga informasi fasilitas VIP ikut ditampilkan.

```java
@Override
public void tampilkanInfo() {
    super.tampilkanInfo();
    System.out.println("Fasilitas VIP: " + fasilitasTambahan);
    System.out.println("Charge Lounge: Rp " + biayaTambahanLounge + " (Flat)");
}
```

---

## 10. Seleksi

Seleksi digunakan menggunakan percabangan `if`.

```java
if (pilihan == 4) {
    ...
}

if (pilihan < 1 || pilihan > 4) {
    ...
}

if (durasi <= 0) {
    ...
}

if (durasi > 24) {
    ...
}
```

---

## 11. Perulangan

Program menggunakan perulangan `while` agar aplikasi terus berjalan selama pengguna belum memilih keluar.

```java
while (!selesai) {
    ...
}
```

Selain itu digunakan perulangan `for` untuk menampilkan daftar lapangan.

```java
for (int i = 0; i < daftarLapangan.length; i++) {
    ...
}
```

---

## 12. Input Output Sederhana

Input dilakukan menggunakan class `Scanner`.

```java
Scanner input = new Scanner(System.in);
```

Sedangkan output ditampilkan menggunakan `System.out.println()`.

```java
System.out.println("=== SISTEM SEWA LAPANGAN PADEL KENANGAN ===");
```

---

## 13. Array

Array digunakan untuk menyimpan beberapa object lapangan dalam satu variabel.

```java
LapanganPadel[] daftarLapangan = new LapanganPadel[3];
```

Array tersebut berisi dua object `LapanganPadel` dan satu object `LapanganVIP`.

---

## 14. Error Handling

Program menggunakan `try-catch` untuk menangani kesalahan input maupun error lainnya.

```java
try {

    ...

} catch (NumberFormatException e) {

    System.out.println("[ERROR] Input harus berupa angka!");

} catch (Exception e) {

    System.out.println("[ERROR] Terjadi kesalahan : " + e.getMessage());

}
```

Error handling ini membuat program tidak langsung berhenti ketika pengguna memasukkan input yang salah.

---

# Usulan Nilai

| No | Materi | Nilai |
|:--:|----------------------|:----:|
|1|Class|5|
|2|Object|5|
|3|Atribut|5|
|4|Constructor|5|
|5|Mutator|5|
|6|Accessor|5|
|7|Encapsulation|5|
|8|Inheritance|5|
|9|Polymorphism|10|
|10|Seleksi|5|
|11|Perulangan|5|
|12|IO Sederhana|10|
|13|Array|15|
|14|Error Handling|15|
||**TOTAL**|**100**|

---

# Pembuat

**Nama : Nor Indah Sari**

**NPM : 2410010427**
