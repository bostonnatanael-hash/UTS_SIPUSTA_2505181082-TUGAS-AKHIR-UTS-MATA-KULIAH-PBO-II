package layanan;

import model.Koleksi;

import java.util.Comparator;

public class UrutLayakLaluJudul implements Comparator<Koleksi> {

    @Override
    public int compare(Koleksi pertama, Koleksi kedua) {

        boolean layakPertama = pertama.layakDipinjam();
        boolean layakKedua = kedua.layakDipinjam();

        if (layakPertama != layakKedua) {
            return layakPertama ? -1 : 1;
        }

        return pertama.getJudul()
                .compareToIgnoreCase(kedua.getJudul());
    }
}