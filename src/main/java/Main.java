
import eksepsi.PustakaException;
import layanan.KatalogPerpustakaan;
import layanan.UrutLayakLaluJudul;
import model.BerkasDigital;
import model.BukuCetak;
import model.Koleksi;
import model.Majalah;

public class Main {
    public static void main(String[] args) {
        BukuCetak bk1 = new BukuCetak(
                "BK-001", "Java How to Program", 2022,
                620, "A-12", 1, false
        );

        BukuCetak bk2 = new BukuCetak(
                "BK-002", "Basis Data Relasional", 2021,
                410, "B-04", 2, true
        );

        Majalah mj1 = new Majalah(
                "MJ-001", "Info Teknologi Edisi 88", 2026,
                88, "Agustus", "C-01", 1, true
        );

        Majalah mj2 = new Majalah(
                "MJ-002", "Info Teknologi Edisi 87", 2026,
                87, "Juli", "C-02", 1, false
        );

        BerkasDigital bd1 = new BerkasDigital(
                "BD-001", "Panduan Pemrograman Java", 2024,
                15, "unduh.polmed.ac.id/bd001"
        );

        BerkasDigital bd2 = new BerkasDigital(
                "BD-002", "Jurnal Rekayasa Perangkat", 2025,
                8, "unduh.polmed.ac.id/bd002"
        );

        Koleksi[] koleksi = {bk1, bk2, mj1, mj2, bd1, bd2};

        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        for (Koleksi k : koleksi) {
            katalog.tambah(k);
        }

        System.out.println("=== SOAL 3: STATUS KOLEKSI ===");
        katalog.cetakStatus();

        System.out.println();
        System.out.println("=== SOAL 4: URUT LAYAK LALU JUDUL ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        System.out.println();
        System.out.println("=== SOAL 5: PEMINJAMAN DAN EKSEPSI ===");
        cobaPinjam(katalog, "BK-001");
        cobaPinjam(katalog, "BK-001");
        cobaPinjam(katalog, "BK-002");
        cobaPinjam(katalog, "MJ-001");
        cobaPinjam(katalog, "BD-001");
        cobaPinjam(katalog, "XX-999");

        System.out.println();
        System.out.println("=== STATUS SETELAH PEMINJAMAN ===");
        katalog.cetakStatus();
    }

    private static void cobaPinjam(
            KatalogPerpustakaan katalog, String kode) {
        try {
            katalog.pinjam(kode);
            System.out.println(
                    "[BERHASIL] " + kode + " berhasil dipinjam."
            );
        } catch (PustakaException e) {
            System.out.println("[GAGAL] " + e.getMessage());
        }
    }
}
