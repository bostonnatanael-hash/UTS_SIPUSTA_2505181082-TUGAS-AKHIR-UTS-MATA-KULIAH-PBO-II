package layanan;

import model.Koleksi;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EksporKatalog {

    public void ekspor(KatalogPerpustakaan katalog, String namaBerkas)
            throws IOException {

        List<Koleksi> data = katalog.getDaftar();

        int panjangJudul = 5;

        for (Koleksi item : data) {
            if (item.getJudul().length() > panjangJudul) {
                panjangJudul = item.getJudul().length();
            }
        }

        String pola = "%-8s %-14s %-"
                + panjangJudul
                + "s %-6s %-13s %s%n";

        try (BufferedWriter writer =
                     Files.newBufferedWriter(Path.of(namaBerkas))) {

            String header = String.format(
                    pola,
                    "KODE",
                    "JENIS",
                    "JUDUL",
                    "TAHUN",
                    "KELAYAKAN",
                    "DIPINJAM"
            );

            writer.write(header);
            writer.write("-".repeat(
                    header.length() - System.lineSeparator().length()
            ));
            writer.newLine();

            for (Koleksi item : data) {
                writer.write(String.format(
                        pola,
                        item.getKodeKoleksi(),
                        item.getClass().getSimpleName(),
                        item.getJudul(),
                        item.getTahunTerbit(),
                        item.layakDipinjam()
                                ? "Layak"
                                : "Tidak layak",
                        item.isSedangDipinjam()
                                ? "Ya"
                                : "Tidak"
                ));
            }
        }
    }
}