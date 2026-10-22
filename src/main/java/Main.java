import model.BerkasDigital;
import model.BukuCetak;
import model.Koleksi;
import model.Majalah;
import model.Terarsip;

import java.util.ArrayList;
import java.util.List;

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

        Koleksi[] koleksi = {
            bk1, bk2, mj1, mj2, bd1, bd2
        };

        System.out.println("=== SOAL 1: HIERARKI KOLEKSI ===");

        for (Koleksi k : koleksi) {
            System.out.println(k.deskripsi());
            System.out.println("Layak dipinjam: " + k.layakDipinjam());
            System.out.println();
        }

        System.out.println("=== SOAL 2: INTERFACE TERARSIP ===");

        List<Terarsip> arsip = new ArrayList<>();
        arsip.add(bk1);
        arsip.add(bk2);
        arsip.add(mj1);
        arsip.add(mj2);

        for (Terarsip t : arsip) {
            System.out.println(t.ringkasanArsip());
        }
    }
}