/**
 * Kelas dasar semua jenis rekening.
 * Kontrak tarik(): mengembalikan true jika berhasil, false jika gagal
 * (tidak melempar exception), sehingga semua subclass bisa saling menggantikan (LSP).
 */
public abstract class Rekening {
    private final int nomor;
    private final String pemilik;
    protected long saldo;

    public Rekening(int nomor, String pemilik, long saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public int getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setor(long jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
        }
    }

    /** Aturan umum: saldo tidak boleh minus. Subclass boleh mengubah aturannya. */
    public boolean tarik(long jumlah) {
        if (jumlah > 0 && saldo >= jumlah) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    /** Biaya admin bulanan, ditentukan oleh tiap jenis rekening. */
    public abstract long biayaAdmin();

    /** Keterangan jenis rekening untuk laporan. */
    public abstract String deskripsi();
}
