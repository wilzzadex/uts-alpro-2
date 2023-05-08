import java.util.ArrayList;

public class Transaksi {
    private Member member;
    private ArrayList<Barang> listBarang = new ArrayList<>();
    private double totalHarga;

    public void setMember(Member member) {
        this.member = member;
    }

    public void tambahBarang(Barang barang) {
        listBarang.add(barang);
        totalHarga += barang.getHarga();
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public double getDiskon() {
        double diskon = 0;

        if (totalHarga >= 100000 && totalHarga <= 500000) {
            diskon = 0.01;
        } else if (totalHarga > 500000 && totalHarga <= 1000000) {
            diskon = 0.025;
        } else if (totalHarga > 1000000) {
            diskon = 0.05;
        }

        if (member != null) {
            diskon += 0.01;

            if (totalHarga > 500000 && totalHarga <= 1000000) {
                diskon += 0.015;
            } else if (totalHarga > 1000000) {
                diskon += 0.02;
            }
        }

        return diskon;
    }

    public double getHargaSetelahDiskon() {
        return totalHarga * (1 - getDiskon());
    }

    // print struk
    public void printStruk() {
        System.out.println("=========Struk Belanja=========");
        System.out.println("Nama Member: " + member.getNama());
        System.out.println("Daftar Belanja: ");
        for (Barang barang : listBarang) {
            System.out.println(barang.getNama() + " - " + barang.getHarga());
        }
        System.out.println("Total Harga: " + totalHarga);
        System.out.println("Diskon: " + getDiskon());
        System.out.println("Total Bayar: " + getHargaSetelahDiskon());
    }
}
