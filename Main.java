import java.util.Calendar;
import java.util.Scanner;

public class Main {


    static long[] saldoNasabah = {500000000, 8000000, 1000000000, 2000000002, 900000000, 2000000000};

    static int platinum = 5000000, gold = 4000000, silver = 3000000;
    static long saldoHistory[] = new long[saldoNasabah.length];

    static Scanner andyNugraha03D = new Scanner(System.in);
    //    String
    static Scanner andyNugraha031D = new Scanner(System.in);
    static long admin;

    static String [][] laporan = new String[1][3];
    static String [][] batas = new String[100][3];


    static int saldoAkhirPenarikan = 0,jmlhSetoran = 0,saldoAkhir = 0, ambil = 0, transfer = 0;
    static int counter = 0;

    //    Nama,Jenis Kartu,Nomer Rekening,Alamat
    static String dataNasabah[][] = {{"Athala bin solikhin", "Gold", "123456789", "Bali"},
            {"Andy Nugraha putra", "Platinum", "1234567890", "Jakarta"},
            {"Fakhrudin Arif", "Silver", "12345678901", "Malang"},
            {"Akbar muzzxfin", "Gold", "123456789012", "Papua"},
            {"Yuma Rakha", "Silver", "1234567890123", "Kediri"},
            {"Farrellia Putri", "Silver", "12345678901234", "Blitar"},
    };

    //    Int
    static String[][] data = {
            {"Athala", "1234"},
            {"Andy", "2345"},
            {"Arif", "3456"},
            {"Akbar", "4567"},
            {"Yuma", "5678"},
            {"Farrellia", "6789"}
    };

    static int user = -1;//tujuan rekening (-1 buat menandakan data yang dicari tidak ada)
    static int index;// login



    public static void main(String[] args) {
        // Menampilkan Menu
        menu03D();
    } // Tutup void Main

    static void menu03D() {

        System.out.println("==============================");
        System.out.println("         Bank Jali");
        System.out.println("==============================");
        login03D();
    }

    static void login03D() {
        
        Calendar waktu = Calendar.getInstance();
        System.out.print("Masukkan username Anda : ");
        String inputindexname = andyNugraha03D.nextLine();
        System.out.print("Masukkan Password Anda : ");
        String inputPassword = andyNugraha03D.nextLine();

        boolean login = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i][0].equals(inputindexname) && data[i][1].equals(inputPassword)) {
                login = true;
                index = i;
            }
        }

        if (login == true) {

            System.out.println("Tanggal Login : " + waktu.get(Calendar.DATE) + "-" + (waktu.get(Calendar.MONTH) + 1) + "-" + waktu.get(Calendar.YEAR));
            System.out.println("Waktu Login : " + waktu.get(Calendar.HOUR_OF_DAY) + ":" + waktu.get(Calendar.MINUTE) + ":" + waktu.get(Calendar.SECOND));
            System.out.println("Selamat Datang!!!!");
            transaksi03D();
        } else {
            System.out.println("username/Password salah!");
            login03D();
        }
    }

    static void transaksi03D() {
        int pilihan03D;
        boolean running = true;
        while (running) {
            System.out.println("\n=======================================");
            System.out.println("\t Pilih Jenis Transaksi");
            System.out.println("========================================");
            System.out.println("1. Data         \t 3. Pembayaran");
            System.out.println("2. Info Rekening\t 4. Transfer ");
            System.out.println("5. Penarikan    \t 6. Setor Tabungan");
            System.out.println("7. Cetak Laporan\t 8. Keluar");
            System.out.println("=======================================");
            System.out.print("Masukkan Pilihan : ");
            pilihan03D = andyNugraha031D.nextInt();

            switch (pilihan03D) {
                case 1:
                    System.out.println("\nData");
                    dataNasabah03D();

                    break;

                case 2:
                    System.out.println("\nInfo Rekening");
                    infoSaldo03D();
                    break;

                case 3:
                    System.out.println("\nPembayaran");
                    pembayaran03D();
                    break;

                case 4:
                    System.out.println("\nTransfer");
                    transfer03D();
                    break;

                case 5:
                    System.out.println("\nPenarikan");
                    penarikan03D();
                    break;

                case 6:
                    System.out.println("\nSetor Tabungan");
                    setorTabungan03D();
                    break;

                case 7:
                    System.out.println("\nCetak Laporan");
                    cetakLaporan03D();

                case 8:
                    running = false;
                    System.out.println("terima kasih telah berkunjung");
                    break;


                default:
                    System.out.println("Pilihan Tidak Tersedia");
                    break;
            }
        }
    }
    static void dataNasabahFull03D(){
        
        System.out.println("============================================================================================================");
        System.out.println("                                                Data Nasabah");
        System.out.println("============================================================================================================");
        System.out.printf("|%12s       |%15s     |%17s   |%12s       |%12s     \n", "Nama", "Jenis Kredit", "Nomer Rekening", "Alamat", "Saldo");
        for (int i = 0; i < dataNasabah.length; i++) {
            for (int j = 0; j < dataNasabah[i].length; j++) {
                System.out.printf("|%-20s", dataNasabah[i][j]);
            }
            System.out.printf("|%,-20d", saldoNasabah[i]);
            System.out.println("|");
        }
    }
    static void dataNasabah03D() {
        System.out.println("============================================================================================================ \n\n\n");
        System.out.println("=======================================");
        System.out.println("               Data");
        System.out.println("=======================================");
        System.out.println("Nama : " + dataNasabah[index][0]);
        System.out.println("Jenis Kartu : " + dataNasabah[index][1]);
        System.out.println("indexname : " + data[index][0]);
        System.out.println("Pin : " + data[index][1]);
        System.out.println("Nomor Rekening : " +dataNasabah[index][2]);
        System.out.println("=======================================\n\n");
            }
        
    
    static void infoSaldo03D() {

        boolean running = true;

        while (running) {
            System.out.println("====================================");
            System.out.println("\t   Informasi Saldo ");
            System.out.println("====================================");
            System.out.println("Saldo : " + saldoNasabah[index]);
            System.out.print("Tekan 1 Untuk Keluar Dari Sistem || Ketik 2 Untuk Kembali: ");
            int pilih = andyNugraha031D.nextInt();
            if (pilih == 1) {
                System.out.println("Terima Kasih Telah Berkunjung");
                System.exit(pilih);

            } else if (pilih == 2) {
                break;
            } else {
                System.out.println("Input Yang Anda Masukkan Salah, Silahkan Input Lagi");
                continue;
            }
        }
    }
    static void pembayaran03D() {
        long jenisBayar;

        boolean running = true;

        while (running){
            System.out.println("============================");
            System.out.println("       Bank Jali");
            System.out.println("============================");


            System.out.println();

            System.out.print("Masukkan Nama Yang Anda Tuju : ");
            String Nama = andyNugraha03D.nextLine();
            for (int i = 0; i < data.length;i++){ 
                if(Nama.equals(data[index][0])){
                System.out.println("Input data Anda masukkan Sudah Sesuai data yang pakai!!");
                
            }
                for(int j = 0; j < data[i].length;j++){
                     if(Nama.equals(data[i][0])) {
                        index = i;
                    }
                }
            }
            if (index < 0){
                System.out.println("Nama Yang Anda Masukkan Salah!");
                return;
            }
            System.out.print("Masukkan Nomer Rekening Yang Anda Tuju : ");
            String inputNorek = andyNugraha03D.nextLine();
            for (int i = 0; i < dataNasabah.length;i++){
                for(int j = 0; j < dataNasabah[i].length;j++){
                    if(inputNorek.equals(dataNasabah[index][2])){
                        System.out.println("Input data Anda masukkan Sudah Sesuai data yang pakai!!");
                        return;
                    }else if(inputNorek.equals(dataNasabah[i][2])) {
                        index = i; 
                        running = false;

                    }
                    System.out.println("No Rek Yang Anda Masukkan Salah ");
                    return;
                }

            }
            if(!running)
            System.out.println("Masukkan Jumlah Uang Untuk Pembayaran : ");
            jenisBayar = andyNugraha031D.nextInt();
            saldoNasabah[index] = saldoNasabah[index] - jenisBayar;
            System.out.println("\nPembayaran Ke Bank " + inputNorek + " Atas Nama " + Nama + " Berhasil");
            System.out.println("Saldo Anda Tersisa " + saldoNasabah[index]);
            nota03D();

            System.out.print("Tekan 1 Untuk Keluar Dari Sistem || Ketik 2 Untuk Kembali: ");
            int pilih = andyNugraha031D.nextInt();
            if (pilih == 1) {
                System.out.println("Terima Kasih Telah Berkunjung");

                System.exit(pilih);

            } else if (pilih == 2) {
                break;
            } else {
                System.out.println("Input Yang Anda Masukkan Salah, Silahkan Input Lagi");
                continue;
            }
        }
    }
    public  static void transfer03D() {

        long transfer;
        long saldoAkhir = 0;
        boolean running = true;
        int index2 ;


        while (running) {
            System.out.println("============================");
            System.out.println("       Bank Jali");
            System.out.println("============================");


            System.out.println();

          System.out.print("Masukkan PIN Anda: ");
            String pinindex = andyNugraha03D.nextLine();
            for (int i = 0; i < data.length;i++){
                for(int j = 0; j < data[i].length;j++){
                    if(pinindex.equals(data[index][1])) {
                        System.out.println("Pin Anda benar");
                    } else {
                        System.out.println("Pin Anda Salah!");
                        return;
                    }
                }
            }
            System.out.print("Masukkan Nomer Rekening: ");
            String inputNorek = andyNugraha03D.nextLine();
            for (int i = 0; i < dataNasabah.length;i++){
                for(int j = 0; j < dataNasabah[i].length;j++){
                    if(inputNorek.equals(dataNasabah[index][j])){
                        System.out.println("Input data Anda masukkan Sudah Sesuai data yang pakai!!");
                        return;
                    }else if(inputNorek.equals(dataNasabah[i][j])) {
                        index2 = i;
                        running = false;
                  }
                }

            }

            if (!running) {System.out.println("Pilih Tujuan Bank Anda :");
                System.out.println("1. Bank Jali ");
                System.out.println("2. Bank Selain Bank Jali  ");
                System.out.print("Pilih menu: ");
                int tujuan = andyNugraha031D.nextInt();
                admin03D(tujuan);

                System.out.println("Masukkan Jumlah Nominal Yang Akan anda Transfer");
                transfer = andyNugraha031D.nextInt();
                if (dataNasabah[index][1].equalsIgnoreCase("Platinum")) {
                    if (transfer >= platinum) {
                        System.out.println("Transfer Anda Terlalu Besar,Silahkan Coba Lagi");
                    }
                    else {
                        transaksiTranfer03D(transfer, saldoAkhir,admin);
                        nota03D();
                    }
                } else if (dataNasabah[index][1].equalsIgnoreCase("Gold")) {
                    if (transfer >= gold) {
                        System.out.println("Transfer Anda Terlalu Besar,Silahkan Coba Lagi");
                    }
                    else {
                        transaksiTranfer03D(transfer, saldoAkhir,admin);
                        nota03D();
                    }
                } else if (dataNasabah[index][1].equalsIgnoreCase("Silver")) {
                    if (transfer >= silver) {
                        System.out.println("Transfer Anda Terlalu Besar,Silahkan Coba Lagi");
                    }
                    else {
                        transaksiTranfer03D(transfer, saldoAkhir,admin);
                        nota03D();
                    }
                }
                System.out.print("Tekan 1 Untuk Keluar Dari Sistem || Ketik 2 Untuk Kembali: ");
                int pilih = andyNugraha031D.nextInt();
                if (pilih == 1) {
                    System.out.println("Terima Kasih Telah Berkunjung");
                    System.exit(pilih);

                } else if (pilih == 2) {
                    break;
                } else {
                    System.out.println("Input Yang Anda Masukkan Salah, Silahkan Input Lagi");
                    continue;
                }
            }
        }
        dataNasabah03D();
    }
    static void transaksiTranfer03D(long transfer, long saldoAkhir,long biayaAdmin) {
        saldoHistory[index] = saldoHistory[index] + transfer;
        System.out.printf("Saldo Awal : %,d \n", saldoNasabah[index]);
        System.out.printf("Anda telah melakukan transfer uang sebesar Rp. %,d kepada %s\n", transfer, dataNasabah[indexUser][0]);
        saldoAkhir = saldoNasabah[index]- biayaAdmin - transfer;
        System.out.printf("Saldo Anda Sekarang Adalah : %,d\n", saldoAkhir);
        saldoNasabah[index] = saldoAkhir;
    }
    static void admin03D(int a){
        if (a == 1) {
            admin = 0;
        } else {
            admin = 2500;
        }
        System.out.println("Jumlah Tambah Admin : " + admin);
    }


    static void penarikan03D() {
        int Tarik;
        String coba;
        long ambil;
        long saldoAkhirPenarikan=0;


        boolean running = true;
        while (running) {
            long[] nominal = {500000, 1000000, 2000000, 3000000, 5000000, 7500000, 100000000};
            System.out.println("===========================");
            System.out.println("Pilih Jenis Nominal");
            System.out.println("===========================");
            System.out.println("1. 500000 \t5.  5000000");
            System.out.println("2. 1000000\t6.  7500000");
            System.out.println("3. 2000000\t7. 100000000");
            System.out.println("4. 3000000");
            System.out.println("===========================");
            Tarik = andyNugraha031D.nextInt();
            if (dataNasabah[index][1].equalsIgnoreCase("Platinum")) {
                if (nominal[Tarik - 1] > platinum) {
                    System.out.println("Penarikan Anda Terlalu Besar,Silahkan Coba Lagi");
                }
                else {
                    transaksiPenarikan03D(nominal[Tarik - 1], saldoAkhirPenarikan);
                    nota03D();
                }
            } else if (dataNasabah[index][1].equalsIgnoreCase("Gold")) {
                if (nominal[Tarik - 1] >= gold) {
                    System.out.println("Penarikan Anda Terlalu Besar,Silahkan Coba Lagi");
                }
                else {
                    transaksiPenarikan03D(nominal[Tarik - 1], saldoAkhirPenarikan);
                    nota03D();
                }
            } else if (dataNasabah[index][1].equalsIgnoreCase("Silver")) {
                if (nominal[Tarik - 1] >= silver) {
                    System.out.println("Penarikan Anda Terlalu Besar,Silahkan Coba Lagi");
                }
                else {
                    transaksiPenarikan03D(nominal[Tarik - 1],saldoAkhirPenarikan);
                    nota03D();
                }
            }

            System.out.print("Tekan 1 Untuk Keluar Dari Sistem || Ketik 2 Untuk Kembali: ");
            int pilih = andyNugraha031D.nextInt();
            if (pilih == 1) {
                System.out.println("Terima Kasih Telah Berkunjung");
                System.exit(pilih);
            } else if (pilih == 2) {
                break;
            } else {
                System.out.println("Input Yang Anda Masukkan Salah, Silahkan Input Lagi");
                continue;
            }

        }
    }


    static void transaksiPenarikan03D(long ambil, long saldoAkhirPenarikan) {
        saldoHistory[index] = saldoHistory[index] + ambil;
        System.out.printf("Saldo Awal : %,d \n", saldoNasabah[index]);
        System.out.printf("Anda telah melakukan penarikan uang sebesar Rp. %,d ", ambil);
        saldoAkhirPenarikan = saldoNasabah[index] - ambil;
        System.out.printf("Saldo Anda Sekarang Adalah : %,d\n", saldoAkhirPenarikan);
        saldoNasabah[index] = saldoAkhirPenarikan;
    }
    static void setorTabungan03D() {
        int jmlSetoran;
        boolean running = true;

        while (running) {
            System.out.println("===============================================");

            //input jumlah setoran
            System.out.println("Masukkan jumlah setoran: ");
            jmlSetoran = andyNugraha031D.nextInt();

            //proses setoran
            saldoNasabah[index] = saldoNasabah[index] + jmlSetoran;

            //output saldo terbaru
            System.out.println("Saldo yang tersisa adalah: " + saldoNasabah[index]);
            System.out.println("\n");
            nota03D();
            System.out.println("==============================================");
            System.out.print("Tekan 1 Untuk Keluar Dari Sistem || Ketik 2 Untuk Kembali: ");
            int pilih = andyNugraha031D.nextInt();
            if (pilih == 1) {
                System.out.println("Terima Kasih Telah Berkunjung");
                System.exit(pilih);

            } else if (pilih == 2) {
                break;
            } else {
                System.out.println("Input Yang Anda Masukkan Salah, Silahkan Input Lagi");
                continue;
            }
        }
    }

    static void nota03D(){
        System.out.println("");
        System.out.println("==========================================");
        System.out.println("\t       *Bank Jali*");
        System.out.println("==========================================");
        System.out.println("   Nama       \t: " + dataNasabah[index][0]);
        System.out.println("   No Rekening\t: " + dataNasabah[index][2]);
        System.out.println("   Jumlah     \t: Rp. " + saldoHistory[index]);
        System.out.println("   Saldo      \t: Rp. " + saldoNasabah[index]);
        System.out.println("");

    }



    static void cetakLaporan03D() {
        for (int j = 0; j < laporan[0].length; j++) {
            laporan[0][0] = String.valueOf(saldoAkhirPenarikan);
            laporan[0][1] = String.valueOf(jmlhSetoran + saldoAkhir);
            laporan[0][2] = String.valueOf(saldoNasabah[index]);
            batas[counter][j] = laporan[0][j];
        }
        System.out.println("-------------------------------------------------");
        System.out.print("|");
        for (int i = 0; i < batas.length; i++) {
            System.out.print(" " + batas[i] + "\t\t");
        }
        System.out.print("|");
        System.out.println();
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < laporan.length; i++) {
            for (int j = 0; j < laporan[0].length; j++) {
                System.out.print(" " + batas[i][j] + "\t\t");
            }System.out.println("");
        }
        jmlhSetoran = 0;
        ambil = 0;
        transfer = 0;

    }
}