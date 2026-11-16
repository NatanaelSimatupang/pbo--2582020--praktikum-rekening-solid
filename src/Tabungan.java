import java.util.Locale;

public class Tabungan extends Rekening implements BerBunga {
    private final double sukuBunga;

    public Tabungan(int nomor, String pemilik, long saldo, double sukuBunga) {
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

    /** Saldo di bawah Rp500.000 dikenakan biaya admin Rp5.000, selain itu gratis. */
    @Override
    public long biayaAdmin() {
        return saldo < 500_000 ? 5_000 : 0;
    }

    @Override
    public String deskripsi() {
        return String.format(Locale.US, "Tabungan, bunga %.1f%% per bulan", sukuBunga);
    }
}
