import java.util.List;

/**
 * Tanggung jawab tunggal: aturan proses akhir bulan.
 * Urutan: biaya admin -> bunga -> autodebet premi asuransi.
 * Tidak tahu jenis rekening konkret, hanya memakai Rekening dan BerBunga,
 * sehingga jenis rekening baru tidak membuat kelas ini berubah (Open/Closed).
 */
public class ProsesAkhirBulan {
    private static final long PREMI_ASURANSI = 50_000;

    public void jalankan(List<Rekening> daftar) {
        potongBiayaAdmin(daftar);
        tambahBunga(daftar);
        autodebetPremi(daftar);
    }

    private void potongBiayaAdmin(List<Rekening> daftar) {
        for (Rekening r : daftar) {
            long biaya = r.biayaAdmin();
            r.tarik(biaya);
            cetak(r, "biaya admin", LaporanBank.rupiah(biaya));
        }
    }

    private void tambahBunga(List<Rekening> daftar) {
        for (Rekening r : daftar) {
            if (r instanceof BerBunga) {
                long bunga = ((BerBunga) r).hitungBunga();
                r.setor(bunga);
                cetak(r, "bunga", LaporanBank.rupiah(bunga));
            }
        }
    }

    private void autodebetPremi(List<Rekening> daftar) {
        for (Rekening r : daftar) {
            boolean berhasil = r.tarik(PREMI_ASURANSI);
            cetak(r, "autodebet", berhasil ? LaporanBank.rupiah(PREMI_ASURANSI) : "gagal");
        }
    }

    private void cetak(Rekening r, String label, String nilai) {
        System.out.println(String.format("%d %-13s: %s", r.getNomor(), label, nilai));
    }
}
