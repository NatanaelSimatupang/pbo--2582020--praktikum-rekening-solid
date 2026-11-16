/** Rekening yang memperoleh bunga setiap bulan. */
public interface BerBunga {
    /** Suku bunga per bulan dalam persen, misalnya 2.5 berarti 2,5%. */
    double getSukuBunga();

    /** Besar bunga bulan ini (dibulatkan ke rupiah terdekat). */
    long hitungBunga();
}
