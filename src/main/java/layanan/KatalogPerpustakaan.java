package layanan;

import model.Koleksi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KatalogPerpustakaan {
    private final List<Koleksi> daftar = new ArrayList<>();

    public void tambah(Koleksi koleksi) {
        daftar.add(koleksi);
    }

    public List<Koleksi> getDaftar() {
        return Collections.unmodifiableList(daftar);
    }

    public void cetakStatus() {
        int nomor = 1;

        for (Koleksi k : daftar) {
            System.out.println(nomor++ + ". " + k.deskripsi());
            System.out.println("   Status: " + status(k));
        }
    }

    public void urut(Comparator<? super Koleksi> pembanding) {
        daftar.sort(pembanding);
    }

    private String status(Koleksi k) {
        if (k.isSedangDipinjam()) {
            return "SEDANG DIPINJAM";
        }

        return k.layakDipinjam()
                ? "LAYAK DIPINJAM"
                : "TIDAK LAYAK DIPINJAM";
    }
}