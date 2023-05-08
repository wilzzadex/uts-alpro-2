import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Member> memberList = new ArrayList<>();
    private static ArrayList<Barang> barangList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Member");
            System.out.println("2. Tambah Barang");
            System.out.println("3. Lihat Daftar Member");
            System.out.println("4. Lihat Daftar Barang");
            System.out.println("5. Input transaksi pembelian");
            System.out.println("0. Keluar");

            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    tambahMember();
                    break;
                case 2:
                    tambahBarang();
                    break;
                case 3:
                    lihatDaftarMember();
                    break;
                case 4:
                    lihatDaftarBarang();
                    break;
                case 5:
                    inputTransaksi();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while (choice != 0);
    }

    private static void tambahMember() {
        Member member = new Member();
        System.out.print("Masukkan kode member: ");
        String kodeMember = scanner.nextLine();
        member.setKodeMember(kodeMember);
        System.out.print("Masukkan nama member: ");
        String nama = scanner.nextLine();
        member.setNama(nama);
        System.out.print("Masukkan nomor telepon member: ");
        String nomorTelepon = scanner.nextLine();
        member.setNomorTelepon(nomorTelepon);
        memberList.add(member);
        System.out.println("Member berhasil ditambahkan.");
    }

    private static void tambahBarang() {
        Barang barang = new Barang();
        System.out.print("Masukkan kode barang: ");
        String kodeBarang = scanner.nextLine();
        barang.setKodeBarang(kodeBarang);
        System.out.print("Masukkan nama barang: ");
        String nama = scanner.nextLine();
        barang.setNama(nama);
        System.out.print("Masukkan harga barang: ");
        double harga = scanner.nextDouble();
        barang.setHarga(harga);
        barangList.add(barang);
        System.out.println("Barang berhasil ditambahkan.");
    }

    private static void lihatDaftarMember() {
        if (memberList.isEmpty()) {
            System.out.println("Daftar member kosong.");
        } else {
            System.out.println("Daftar member:");
            for (Member member : memberList) {
                System.out.println("==================================" + "\n");
                System.out.println("Kode member: " + member.getKodeMember());
                System.out.println("Nama: " + member.getNama());
                System.out.println("Nomor telepon: " + member.getNomorTelepon());
                System.out.println("==================================" + "\n");
            }
        }
    }

    private static void lihatDaftarBarang() {
        if (barangList.isEmpty()) {
            System.out.println("Daftar barang kosong.");
        } else {

            System.out.println("Daftar barang:");
            for (Barang barang : barangList) {
                System.out.println("==================================" + "\n");
                System.out.println("Kode barang: " + barang.getKodeBarang());
                System.out.println("Nama: " + barang.getNama());
                System.out.println("Harga: " + barang.getHarga());
                System.out.println("==================================" + "\n");
            }

        }
    }

    // create function inputTransaksi

    private static void inputTransaksi(){
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan kode member: ");
        System.out.println("*jika tidak ada, masukkan 0");

        String kodeMember = input.nextLine();
        Member member = cariMember(kodeMember);
        if (member == null){

        }

        lihatDaftarBarang();

        System.out.println("Masukkan kode barang: ");
        String kodeBarang = input.nextLine();
        Barang barang = cariBarang(kodeBarang);
        if (barang == null){
            System.out.println("Barang tidak ditemukan.");
            return;
        }

        System.out.println("Masukkan jumlah barang: ");

        int jumlah = input.nextInt();
        if (jumlah < 0){
            System.out.println("Jumlah barang tidak boleh negatif.");
            return;
        }

//        Double totalHarga = barang.getHarga() * jumlah;
//
//        Double diskon = 0.0;
//        if(totalHarga > 1000000 && totalHarga < 5000000){
//            diskon = 0.01;
//            if(member != null){
//                // add diskon 0.01
//                diskon+=0.01;
//            }
//        }else if(totalHarga > 5000000 && totalHarga < 10000000) {
//            diskon = 0.025;
//            if (member != null) {
//                diskon += 0.015;
//            }
//        }else if (totalHarga > 10000000) {
//            diskon = 0.05;
//            if (member != null) {
//                diskon += 0.02;
//            }
//        } else {
//            diskon = 0.0;
//        }

//        Double totalDiskon = totalHarga * diskon;
//
//        Double totalBayar = totalHarga - totalDiskon;

        Transaksi transaksi = new Transaksi();
        transaksi.tambahBarang(barang);

        if (member != null){
            transaksi.setMember(member);
        }

        // rerun inputTransaksi
        System.out.println("Apakah anda ingin menambahkan barang? (y/n)");
        String pilihan = input.nextLine();
        if (pilihan.equalsIgnoreCase("y")){
            inputTransaksi();
        }else{
            System.out.println("Apakah anda ingin melihat detail transaksi? (y/n)");
            String pilihan2 = input.nextLine();
            if (pilihan2.equalsIgnoreCase("y")){
                transaksi.printStruk();
            }else{
                System.out.println("Terima kasih telah berbelanja.");
            }
        }





    }

    private static Member cariMember(String kodeMember){
        for (Member member : memberList){
            if (member.getKodeMember().equals(kodeMember)){
                return member;
            }
        }
        return null;
    }

    private static Barang cariBarang(String kodeBarang){
        for (Barang barang : barangList){
            if (barang.getKodeBarang().equals(kodeBarang)){
                return barang;
            }
        }
        return null;
    }



}
