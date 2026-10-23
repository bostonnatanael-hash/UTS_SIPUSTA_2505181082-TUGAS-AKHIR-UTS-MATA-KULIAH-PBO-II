import eksepsi.PustakaException;
import layanan.EksporKatalog;
import layanan.KatalogPerpustakaan;
import layanan.UrutLayakLaluJudul;
import model.BerkasDigital;
import model.BukuCetak;
import model.Koleksi;
import model.Majalah;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        KatalogPerpustakaan katalog = buatKatalog();

        System.out.println("=== SOAL 3: STATUS KOLEKSI ===");
        katalog.cetakStatus();

        System.out.println();
        System.out.println("=== SOAL 4: URUT LAYAK LALU JUDUL ===");

        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        System.out.println();
        System.out.println("=== SOAL 5: PEMINJAMAN DAN EKSEPSI ===");

        prosesPeminjaman(katalog, "BK-001");
        prosesPeminjaman(katalog, "BK-001");
        prosesPeminjaman(katalog, "BK-002");
        prosesPeminjaman(katalog, "MJ-001");
        prosesPeminjaman(katalog, "BD-001");
        prosesPeminjaman(katalog, "XX-999");

        System.out.println();
        System.out.println("=== STATUS SETELAH PEMINJAMAN ===");
        katalog.cetakStatus();

        System.out.println();
        System.out.println("=== SOAL 6: EKSPOR KATALOG ===");

        try {
            new EksporKatalog().ekspor(katalog, "katalog.txt");
            System.out.println("Berhasil menulis katalog.txt");
        } catch (IOException e) {
            System.out.println("Gagal menulis berkas: " + e.getMessage());
        }
    }

    private static KatalogPerpustakaan buatKatalog() {

        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        Koleksi[] daftar = {
            new BukuCetak(
                    "BK-001",
                    "Java How to Program",
                    2022,
                    620,
                    "A-12",
                    1,
                    false
            ),

            new BukuCetak(
                    "BK-002",
                    "Basis Data Relasional",
                    2021,
                    410,
                    "B-04",
                    2,
                    true
            ),

            new Majalah(
                    "MJ-001",
                    "Info Teknologi Edisi 88",
                    2026,
                    88,
                    "Agustus",
                    "C-01",
                    1,
                    true
            ),

            new Majalah(
                    "MJ-002",
                    "Info Teknologi Edisi 87",
                    2026,
                    87,
                    "Juli",
                    "C-02",
                    1,
                    false
            ),

            new BerkasDigital(
                    "BD-001",
                    "Panduan Pemrograman Java",
                    2024,
                    15,
                    "unduh.polmed.ac.id/bd001"
            ),

            new BerkasDigital(
                    "BD-002",
                    "Jurnal Rekayasa Perangkat",
                    2025,
                    8,
                    "unduh.polmed.ac.id/bd002"
            )
        };

        for (Koleksi item : daftar) {
            katalog.tambah(item);
        }

        return katalog;
    }

    private static void prosesPeminjaman(
            KatalogPerpustakaan katalog,
            String kode) {

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