package layanan;

import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;
import model.Koleksi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KatalogPerpustakaan {

    private final List<Koleksi> koleksi = new ArrayList<>();

    public void tambah(Koleksi item) {
        koleksi.add(item);
    }

    public List<Koleksi> getDaftar() {
        return List.copyOf(koleksi);
    }

    public void cetakStatus() {
        for (int i = 0; i < koleksi.size(); i++) {
            Koleksi item = koleksi.get(i);

            System.out.println((i + 1) + ". " + item.deskripsi());
            System.out.println("   Status: " + tentukanStatus(item));
        }
    }

    private String tentukanStatus(Koleksi item) {
        if (item.isSedangDipinjam()) {
            return "SEDANG DIPINJAM";
        }

        if (item.layakDipinjam()) {
            return "LAYAK DIPINJAM";
        }

        return "TIDAK LAYAK DIPINJAM";
    }

    public void urut(Comparator<Koleksi> pembanding) {
        koleksi.sort(pembanding);
    }

    public void pinjam(String kode) throws PustakaException {

        Koleksi ditemukan = null;

        for (Koleksi item : koleksi) {
            if (item.getKodeKoleksi().equals(kode)) {
                ditemukan = item;
                break;
            }
        }

        if (ditemukan == null) {
            throw new PustakaException(
                    "Koleksi dengan kode " + kode + " tidak ditemukan."
            );
        }

        if (ditemukan.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(
                    ditemukan.getJudul()
            );
        }

        if (!ditemukan.layakDipinjam()) {
            throw new KoleksiTidakLayakException(
                    ditemukan.getJudul()
            );
        }

        ditemukan.setSedangDipinjam(true);
    }
}