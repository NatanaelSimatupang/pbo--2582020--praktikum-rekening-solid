public class Giro extends Rekening {
    private final long batasOverdraft;

    public Giro(int nomor, String pemilik, long saldo, long batasOverdraft) {
        super(nomor, pemilik, saldo);
        this.batasOverdraft = batasOverdraft;
    }

    public long getBatasOverdraft() {
        return batasOverdraft;
    }

    /** Saldo boleh minus sampai batas overdraft. */
    @Override
    public boolean tarik(long jumlah) {
        if (jumlah > 0 && saldo - jumlah >= -batasOverdraft) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    @Override
    public long biayaAdmin() {
        return 15_000;
    }

    @Override
    public String deskripsi() {
        return "Giro, batas overdraft " + LaporanBank.rupiah(batasOverdraft);
    }
}
