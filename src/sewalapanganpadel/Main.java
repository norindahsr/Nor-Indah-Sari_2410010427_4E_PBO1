package sewalapanganpadel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // IO Sederhana
        // Scanner digunakan untuk menerima input dari pengguna
        Scanner input = new Scanner(System.in);

        // Array of Object
        // Membuat array yang berisi 3 objek bertipe LapanganPadel
        LapanganPadel[] daftarLapangan = new LapanganPadel[3];

        // Object
        // Membuat objek lapangan Outdoor
        daftarLapangan[0] = new LapanganPadel("Outdoor (Standard)", 150000);

        // Object
        // Membuat objek lapangan Indoor
        daftarLapangan[1] = new LapanganPadel("Indoor (Premium)", 200000);

        // Object + Polymorphism
        // Membuat objek LapanganVIP dan menyimpannya
        // ke dalam array bertipe LapanganPadel
        daftarLapangan[2] = new LapanganVIP(
                "VIP Court",
                300000,
                "Gratis Raket, Bola, & Akses Lounge",
                50000);

        // Variabel untuk mengontrol perulangan program
        boolean selesai = false;

        // Perulangan (Looping)
        // Program akan terus berjalan sampai pengguna memilih keluar
        while (!selesai) {

            // Error Handling
            // Menangani kesalahan yang mungkin terjadi saat input
            try {

                System.out.println("\n=========================================");
                System.out.println("=== SISTEM SEWA LAPANGAN PADEL KENANGAN ===");
                System.out.println("=========================================");

                // Perulangan (for)
                // Menampilkan seluruh daftar lapangan
                for (int i = 0; i < daftarLapangan.length; i++) {

                    System.out.println((i + 1) + ". Padel "
                            + daftarLapangan[i].getTipeLapangan()
                            + " (Rp "
                            + daftarLapangan[i].getHargaPerJam()
                            + "/jam)");
                }

                System.out.println("4. Keluar");
                System.out.print("Pilih Lapangan (1-4) : ");

                // IO Sederhana
                // Membaca pilihan menu dari pengguna
                int pilihan = Integer.parseInt(input.nextLine());

                // Seleksi (if)
                // Jika memilih menu keluar
                if (pilihan == 4) {

                    System.out.println("\nTerima kasih telah menggunakan Sistem Sewa Lapangan Padel Kenangan.");
                    selesai = true;
                    continue;
                }

                // Seleksi (if)
                // Validasi pilihan menu
                if (pilihan < 1 || pilihan > 4) {

                    System.out.println("\n[ERROR] Pilihan hanya boleh 1 sampai 4.");
                    continue;
                }

                System.out.print("Masukkan Durasi Sewa (Jam) : ");

                // IO Sederhana
                // Membaca durasi penyewaan
                int durasi = Integer.parseInt(input.nextLine());

                // Seleksi (if)
                // Validasi durasi minimal
                if (durasi <= 0) {

                    System.out.println("\n[ERROR] Durasi minimal 1 jam.");
                    continue;
                }

                // Seleksi (if)
                // Validasi durasi maksimal
                if (durasi > 24) {

                    System.out.println("\n[ERROR] Maksimal penyewaan hanya 24 jam.");
                    continue;
                }

                System.out.println("\n======================================");
                System.out.println("          NOTA PEMBAYARAN");
                System.out.println("======================================");

                // Polymorphism
                // Memanggil method tampilkanInfo().
                // Jika objek yang dipilih adalah LapanganVIP,
                // maka method overriding pada subclass akan dijalankan.
                daftarLapangan[pilihan - 1].tampilkanInfo();

                // Polymorphism
                // Menghitung total biaya sesuai jenis lapangan
                double total = daftarLapangan[pilihan - 1].hitungTotalBiaya(durasi);

                System.out.println("Durasi Main : " + durasi + " Jam");
                System.out.println("--------------------------------------");
                System.out.println("TOTAL BAYAR : Rp " + total);
                System.out.println("======================================");

                System.out.print("\nApakah ingin melakukan transaksi lagi? (Y/T) : ");

                // IO Sederhana
                // Membaca pilihan pengguna untuk mengulang transaksi
                String ulang = input.nextLine();

                // Seleksi (if)
                // Jika pengguna memilih T maka program selesai
                if (ulang.equalsIgnoreCase("T")) {
                    selesai = true;
                    System.out.println("\nTerima kasih telah menggunakan Sistem Sewa Lapangan Padel Kenangan.");
                }

            }
            // Error Handling
            // Menangani kesalahan jika pengguna memasukkan huruf
            // pada input yang seharusnya berupa angka
            catch (NumberFormatException e) {

                System.out.println("\n[ERROR] Input harus berupa angka!");

            }
            // Error Handling
            // Menangani error lain yang tidak terduga
            catch (Exception e) {

                System.out.println("\n[ERROR] Terjadi kesalahan : " + e.getMessage());
            }
        }
        // Menutup Scanner agar tidak terjadi resource leak
        input.close();
    }
}