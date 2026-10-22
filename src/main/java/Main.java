java
import model.BerkasDigital;
import model.BukuCetak;
import model.Majalah;

public class Main {
    public static void main(String[] args) {

        BukuCetak bk1 = new BukuCetak(
                "BK-001",
                "Java How to Program",
                2022,
                620,
                "A-12",
                1,
                false
        );

        Majalah mj1 = new Majalah(
                "MJ-001",
                "Info Teknologi Edisi 88",
                2026,
                88,
                "Agustus",
                "C-01",
                1,
                true
        );

        BerkasDigital bd1 = new BerkasDigital(
                "BD-001",
                "Panduan Pemrograman Java",
                2024,
                15,
                "unduh.polmed.ac.id/bd001"
        );

        System.out.println("=== SOAL 1: Hierarki Koleksi ===");

        System.out.println();
        System.out.println(bk1.deskripsi());
        System.out.println("Layak dipinjam: " + bk1.isLayakDipinjam());

        System.out.println();
        System.out.println(mj1.deskripsi());
        System.out.println("Layak dipinjam: " + mj1.isLayakDipinjam());

        System.out.println();
        System.out.println(bd1.deskripsi());
        System.out.println("Layak dipinjam: " + bd1.isLayakDipinjam());
    }
}
