package model;

public class BukuCetak extends Koleksi implements Terarsip {

    private final int jumlahHalaman;
    private final String rak;
    private final int lantai;
    private final boolean sedangDiperbaiki;

    public BukuCetak(String kodeKoleksi, String judul, int tahunTerbit,
                     int jumlahHalaman, String rak, int lantai,
                     boolean sedangDiperbaiki) {

        super(kodeKoleksi, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.rak = rak;
        this.lantai = lantai;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    public int getJumlahHalaman() {
        return jumlahHalaman;
    }

    public boolean isSedangDiperbaiki() {
        return sedangDiperbaiki;
    }

    @Override
    public String nomorRak() {
        return rak;
    }

    @Override
    public String lokasiLantai() {
        return "lantai " + lantai;
    }

    @Override
    public boolean layakDipinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String deskripsi() {
        String kondisi = sedangDiperbaiki
                ? "sedang diperbaiki"
                : "tidak diperbaiki";

        return super.deskripsi()
                + " | " + jumlahHalaman + " halaman"
                + " | " + ringkasanArsip()
                + " | " + kondisi;
    }
}