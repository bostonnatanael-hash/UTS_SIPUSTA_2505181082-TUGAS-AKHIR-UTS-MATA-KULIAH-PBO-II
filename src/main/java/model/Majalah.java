package model;

public class Majalah extends Koleksi implements Terarsip {

    private final int nomorEdisi;
    private final String bulanTerbit;
    private final String rak;
    private final int lantai;
    private final boolean edisiTerbaru;

    public Majalah(String kodeKoleksi, String judul, int tahunTerbit,
                   int nomorEdisi, String bulanTerbit, String rak,
                   int lantai, boolean edisiTerbaru) {

        super(kodeKoleksi, judul, tahunTerbit);
        this.nomorEdisi = nomorEdisi;
        this.bulanTerbit = bulanTerbit;
        this.rak = rak;
        this.lantai = lantai;
        this.edisiTerbaru = edisiTerbaru;
    }

    public int getNomorEdisi() {
        return nomorEdisi;
    }

    public String getBulanTerbit() {
        return bulanTerbit;
    }

    public boolean isEdisiTerbaru() {
        return edisiTerbaru;
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
        return !edisiTerbaru;
    }

    @Override
    public String deskripsi() {
        String keterangan = edisiTerbaru
                ? "edisi terbaru"
                : "bukan terbaru";

        return super.deskripsi()
                + " | edisi " + nomorEdisi
                + " | " + bulanTerbit
                + " | " + ringkasanArsip()
                + " | " + keterangan;
    }
}