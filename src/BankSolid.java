import java.util.ArrayList;
import java.util.List;

public class BankSolid {
    public static void main(String[] args) {
        List<Rekening> daftar = new ArrayList<>();
        daftar.add(new Tabungan(101, "Ani", 1_000_000, 2.5));
        daftar.add(new Tabungan(102, "Citra", 300_000, 2.0));
        daftar.add(new Giro(201, "Budi", 200_000, 500_000));
        daftar.add(new Deposito(301, "Dewi", 5_000_000, 4.0));

        LaporanBank laporan = new LaporanBank();
        ProsesAkhirBulan proses = new ProsesAkhirBulan();

        laporan.cetak("REKENING AWAL", daftar);
        System.out.println();

        LaporanBank.judul("AKHIR BULAN");
        proses.jalankan(daftar);
        System.out.println();

        laporan.cetak("REKENING AKHIR", daftar);
        laporan.cetakTotal(daftar);
    }
}
