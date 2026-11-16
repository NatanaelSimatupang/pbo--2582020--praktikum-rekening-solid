import java.util.Locale;

/**
 * Deposito: tanpa biaya admin, berbunga, dan tidak bisa ditarik sebelum jatuh tempo.
 * tarik() mengembalikan false (bukan melempar exception) agar tetap mematuhi
 * kontrak Rekening.tarik (Liskov Substitution Principle).
 */
public class Deposito extends Rekening implements BerBunga {
    private final double sukuBunga;

    public Deposito(int nomor, String pemilik, long saldo, double sukuBunga) {
        super(nomor, pemilik, saldo);
        this.sukuBunga = sukuBunga;
    }

    @Override
    public double getSukuBunga() {
        return sukuBunga;
    }

    @Override
    public long hitungBunga() {
        return Math.round(saldo * sukuBunga / 100.0);
    }

    @Override
    public boolean tarik(long jumlah) {
        return false; // belum jatuh tempo
    }

    @Override
    public long biayaAdmin() {
        return 0;
    }

    @Override
    public String deskripsi() {
        return String.format(Locale.US, "Deposito, bunga %.1f%% per bulan", sukuBunga);
    }
}