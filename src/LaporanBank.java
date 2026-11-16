import java.util.List;

/** Tanggung jawab tunggal: format dan cetak laporan. */
public class LaporanBank {

    /** Format rupiah dengan titik pemisah ribuan, contoh: Rp1.000.000 */
    public static String rupiah(long nilai) {
        String angka = String.valueOf(Math.abs(nilai));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < angka.length(); i++) {
            if (i > 0 && (angka.length() - i) % 3 == 0) {
                sb.append('.');
            }
            sb.append(angka.charAt(i));
        }
        return (nilai < 0 ? "-Rp" : "Rp") + sb;
    }

    public static void judul(String teks) {
        StringBuilder sb = new StringBuilder("========== " + teks + " ");
        while (sb.length() < 35) {
            sb.append('=');
        }
        System.out.println(sb);
    }

    public void cetak(String judul, List<Rekening> daftar) {
        judul(judul);
        for (Rekening r : daftar) {
            System.out.println(String.format("%d | %-6s | %12s",
                    r.getNomor(), r.getPemilik(), rupiah(r.getSaldo())));
            System.out.println("      " + r.deskripsi());
        }
    }

    public void cetakTotal(List<Rekening> daftar) {
        long total = 0;
        for (Rekening r : daftar) {
            total += r.getSaldo();
        }
        System.out.println("-----------------------------------");
        System.out.println("Total dana bank : " + rupiah(total));
    }
}{
}
