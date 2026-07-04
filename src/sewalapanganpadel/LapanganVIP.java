package sewalapanganpadel;

// Class LapanganVIP merupakan subclass
// yang mewarisi class LapanganPadel (Inheritance)
public class LapanganVIP extends LapanganPadel {

    // Atribut tambahan khusus untuk lapangan VIP
    private String fasilitasTambahan;
    private double biayaTambahanLounge;

    // Constructor subclass
    // Menggunakan super() untuk memanggil constructor superclass
    // sekaligus menginisialisasi atribut baru
    public LapanganVIP(String tipeLapangan, double hargaPerJam,
            String fasilitasTambahan, double biayaTambahanLounge) {

        super(tipeLapangan, hargaPerJam);
        this.fasilitasTambahan = fasilitasTambahan;
        this.biayaTambahanLounge = biayaTambahanLounge;
    }

    // Polymorphism (Method Overriding)
    // Method ini menggantikan method hitungTotalBiaya()
    // yang ada pada superclass
    @Override
    public double hitungTotalBiaya(int durasiJam) {

        // Total biaya = (harga per jam × durasi) + biaya lounge
        return (getHargaPerJam() * durasiJam) + biayaTambahanLounge;
    }

    // Polymorphism (Method Overriding)
    // Menampilkan informasi lapangan VIP
    @Override
    public void tampilkanInfo() {

        // Memanggil method tampilkanInfo() dari superclass
        super.tampilkanInfo();

        // Menampilkan informasi tambahan khusus VIP
        System.out.println("Fasilitas VIP: " + fasilitasTambahan);
        System.out.println("Charge Lounge: Rp " + biayaTambahanLounge + " (Flat)");
    }
}