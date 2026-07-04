package sewalapanganpadel;

// Class induk (Superclass) yang menyimpan data dasar lapangan padel
public class LapanganPadel {

    // Atribut tipe lapangan menggunakan protected
    // agar dapat diwariskan ke subclass
    protected String tipeLapangan;

    // Atribut harga sewa dibuat private
    // sebagai penerapan Encapsulation
    private double hargaPerJam;

    // Constructor
    // Digunakan untuk menginisialisasi nilai atribut
    // saat objek pertama kali dibuat
    public LapanganPadel(String tipeLapangan, double hargaPerJam) {
        this.tipeLapangan = tipeLapangan;
        this.hargaPerJam = hargaPerJam;
    }

    // Accessor (Getter)
    // Mengambil nilai tipe lapangan
    public String getTipeLapangan() {
        return tipeLapangan;
    }

    // Accessor (Getter)
    // Mengambil nilai harga sewa per jam
    public double getHargaPerJam() {
        return hargaPerJam;
    }

    // Mutator (Setter)
    // Mengubah nilai harga sewa apabila diperlukan
    public void setHargaPerJam(double hargaPerJam) {
        this.hargaPerJam = hargaPerJam;
    }

    // Method untuk menghitung total biaya sewa
    // Rumus = harga per jam × durasi sewa
    public double hitungTotalBiaya(int durasiJam) {
        return this.hargaPerJam * durasiJam;
    }

    // Method untuk menampilkan informasi lapangan
    public void tampilkanInfo() {
        System.out.println("Tipe Lapangan: Padel " + tipeLapangan);
        System.out.println("Tarif Sewa   : Rp " + hargaPerJam + " / jam");
    }
}