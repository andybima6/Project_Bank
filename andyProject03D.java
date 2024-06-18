import java.util.Calendar;
import java.util.Scanner;

public class andyProject03D {
    static long[] saldoNasabah = {500000000, 8000000, 1000000000, 2000000002, 900000000, 2000000000};
    static int platinum = 5000000, gold = 4000000, silver = 3000000;
    static long saldoHistory[] = new long[saldoNasabah.length];
    static Scanner andyNugraha03D = new Scanner(System.in);// saya membuat 2 scanner terlebih dahulu karena buatberjaga agar ketika ada suatu inputan fungsi string  atau long input saya bisa memisahkannya agar tidak jumping
    //    String
    static Scanner andyNugraha031D = new Scanner(System.in);//kenapa  kita memakai 1 scan saja,kalau harus 1 scanner kita harus memilah data mana yang harus didahulukan.ketika inputan int masih aman  ketika inputan int ke string
    //int
    static long admin;
    
    //    Nama,Jenis Kartu,Nomer Rekening,Alamat
    static String dataNasabah[][] = {{"Athala bin solikhin", "Gold", "123456789", "Bali"},
            {"Andy Nugraha putra", "Platinum", "1234567890", "Jakarta"},
            {"Fakhrudin Arif", "Silver", "12345678901", "Malang"},
            {"Akbar muzzxfin", "Gold", "123456789012", "Papua"},
            {"Yuma Rakha", "Silver", "1234567890123", "Kediri"},
            {"Farrellia Putri Gusti", "Silver", "12345678901234", "Blitar"},
    };
   
    static String[][] data = {
            {"Athala", "1234"},
            {"Andy", "2345"},
            {"Arif", "3456"},
            {"Akbar", "4567"},
            {"Yuma", "5678"},
            {"Farrellia", "6789"}
    };
    
    static int user = -1;//yang dituju
    static int user2;//tujuan buat user 2 adalah agar tidak berubah nilai,jadinya akses indeks arraynya sesuai tujuan
    static int indexUser;//sebagai patokan menyimpan sebuah nilai/mencari data yang diinputkan dalam looping
    static String [] [] transaksi = new String [1] [4];
    //buat historyLaporan/buat kolom dan baris

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
        System.out.print("Masukkan Username Anda : ");
        String inputUsername = andyNugraha03D.nextLine();
        System.out.print("Masukkan Password Anda : ");
        String inputPassword = andyNugraha03D.nextLine();
        boolean login = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i][0].equals(inputUsername) && data[i][1].equals(inputPassword)) {
                login = true;
                indexUser = i;
            }
        }
        if (login == true) {
            System.out.println("Tanggal Login : " + waktu.get(Calendar.DATE) + "-" + (waktu.get(Calendar.MONTH) + 1) + "-" + waktu.get(Calendar.YEAR));
            System.out.println("Waktu Login : " + waktu.get(Calendar.HOUR_OF_DAY) + ":" + waktu.get(Calendar.MINUTE) + ":" + waktu.get(Calendar.SECOND));
            System.out.println("Selamat Datang!!!!");
            transaksi03D();
        } else {
            System.out.println("Username/Password salah!");
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
            // /t spase sebesar 10
            System.out.println("2. Info Rekening\t 4. Transfer ");
            System.out.println("5. Penarikan    \t 6. Setor Tabungan");
            System.out.println("7. Cetak Laporan\t 8. Keluar");
            System.out.println("=======================================");
            System.out.print("Masukkan Pilihan : ");
            pilihan03D = andyNugraha031D.nextInt();
            switch (pilihan03D) {
                case 1:
                    System.out.println("\nData");
                    dataNasabahFull03D();
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
                    catekLaporan03D();
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
        //kegunaan %-17s menandakan length.dengan penulisan nama jadi setelah nama terisi sisa2 length tersebut diisi oleh spasi.
        //kegunaan %17s menandakan length.dengan penulisan nama jadi setelah spasi sisa2 length diisi oleh nama.
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
        System.out.println("Nama : " + dataNasabah[indexUser][0]);
        System.out.println("Jenis Kartu : " + dataNasabah[indexUser][1]);
        System.out.println("Username : " + data[indexUser][0]);
        System.out.println("Pin : " + data[indexUser][1]);
        System.out.println("Nomor Rekening : " +dataNasabah[indexUser][2]);
        System.out.println("=======================================\n\n");
    }
    static void infoSaldo03D() {
        boolean running = true;
        while (running) {
            System.out.println("====================================");
            System.out.println("\t   Informasi Saldo ");
            System.out.println("====================================");
            System.out.println("Saldo : " + saldoNasabah[indexUser]);
            System.out.print("Tekan 1 Untuk Keluar Dari Sistem || Ketik 2 Untuk Kembali: ");
            int pilih = andyNugraha031D.nextInt();
            if (pilih == 1) {
                System.out.println("Terima Kasih Telah Berkunjung");
                System.exit(pilih);
                //memaksa menyelesai code
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
                for(int j = 0; j < data[i].length;j++){
                    if(Nama.equals(data[indexUser][j])){
                        System.out.println("Input data Anda masukkan Sudah Sesuai data yang pakai!!");
                        return;
                    }
                    else if(Nama.equals(data[i][j])) {
                        user = i;
                    }
                }
            }
            if (user < 0){
                System.out.println("Nama Yang Anda Masukkan Salah!");
                return;
            }
            System.out.print("Masukkan Nomer Rekening: ");
            String inputNorek = andyNugraha03D.nextLine();
            for (int i = 0; i < dataNasabah.length;i++){
                for(int j = 0; j < dataNasabah[i].length;j++){
                    if(inputNorek.equals(dataNasabah[indexUser][j])){
                        System.out.println("Input data Anda masukkan Sudah Sesuai data yang pakai!!");
                        return;
                    }else if(inputNorek.equals(dataNasabah[i][j])) {
                        user2 = i; //tujuan rekening
                        running = false;
                    }
                }
            }
            System.out.println("Masukkan Jumlah Uang Untuk Pembayaran : ");
            jenisBayar = andyNugraha031D.nextInt();
            saldoHistory[indexUser] = saldoHistory[indexUser] + jenisBayar;
            System.out.println("\nPembayaran Ke Bank " + inputNorek + " Atas Nama " + Nama + " Berhasil");
            saldoNasabah[indexUser] = saldoNasabah[indexUser] - jenisBayar;
            System.out.println("Saldo Anda Tersisa " + saldoNasabah[indexUser] );
            nota03D();
            //buat menambah baris pada array historyLaporan
            String transaksi2 [] [] = new String [transaksi.length + 1][transaksi[0].length];
            //fungsinya untuk mengisi/memindahkan array historylaporan menuju array transaksi2(yang isinya kosong) 
            for (int i = 0; i < transaksi.length; i++) {
                for (int j = 0; j < transaksi[i].length; j++) {
                    transaksi2 [i] [j] = transaksi [i] [j];
                    
                    
                }
            }
            //mengisi kolom pada baris terakhir
            transaksi2 [transaksi2.length -1] [0] = "Pembayaran";
            transaksi2 [transaksi2.length -1] [1] = Nama;
            String bayar = Long.toString(jenisBayar);
            transaksi2 [transaksi2.length -1] [2] = bayar;
            String saldo = Long.toString(saldoNasabah[indexUser]);
            transaksi2 [transaksi2.length -1] [3] = saldo;
            //menyamakan isi  transaksi2 dengan historyTransaksi
            transaksi = transaksi2;

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
        while (running) {
            System.out.println("============================");
            System.out.println("       Bank Jali");
            System.out.println("============================");
            System.out.println();
            System.out.print("Masukkan PIN Anda: ");
            String pinUser = andyNugraha03D.nextLine();
            for (int i = 0; i < data.length;i++){
                for(int j = 0; j < data[i].length;j++){
                    if(pinUser.equals(data[indexUser][1])) {
                        user = i; //gunanya untuk merujuk kedata
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
                    if(inputNorek.equals(dataNasabah[indexUser][j])){
                        System.out.println("Input data Anda masukkan Sudah Sesuai data yang pakai!!");
                        return;
                    }else if(inputNorek.equals(dataNasabah[i][j])) {
                        user2 = i; //merujuk ke data yang mau dikirim
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
                if (dataNasabah[indexUser][1].equalsIgnoreCase("Platinum")) {
                    if (transfer >= platinum) {
                        System.out.println("Transfer Anda Terlalu Besar,Silahkan Coba Lagi");
                    }
                    else {
                        transaksiTranfer03D(transfer, saldoAkhir,admin);
                        nota03D();
                        
                    }
                } else if (dataNasabah[indexUser][1].equalsIgnoreCase("Gold")) {
                    if (transfer >= gold) {
                        System.out.println("Transfer Anda Terlalu Besar,Silahkan Coba Lagi");
                    }
                    else {
                        transaksiTranfer03D(transfer, saldoAkhir,admin);
                        nota03D();
                    }
                } else if (dataNasabah[indexUser][1].equalsIgnoreCase("Silver")) {
                    if (transfer >= silver) {
                        System.out.println("Transfer Anda Terlalu Besar,Silahkan Coba Lagi");
                    }
                    else {
                        transaksiTranfer03D(transfer, saldoAkhir,admin);
                        nota03D();
                    }
                }

                String transaksi2 [] [] = new String [transaksi.length +1][transaksi[0].length];
                for (int i = 0; i < transaksi.length; i++) {
                    for (int j = 0; j < transaksi[i].length; j++) {
                        transaksi2 [i] [j] = transaksi [i] [j];
                    }
                }
                transaksi2 [transaksi2.length -1] [0] = "Transfer";
                transaksi2 [transaksi2.length -1] [1] = inputNorek;
                String bayar = Long.toString(transfer);
                transaksi2 [transaksi2.length -1] [2] = bayar;
                String saldo = Long.toString(saldoNasabah[indexUser]);
                transaksi2 [transaksi2.length -1] [3] = saldo;
                transaksi = transaksi2;

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
        saldoHistory[indexUser] = saldoHistory[indexUser] + transfer;
        System.out.printf("Saldo Awal : %,d \n", saldoNasabah[indexUser]);
        System.out.printf("Anda telah melakukan transfer uang sebesar Rp. %,d kepada %s\n", transfer, dataNasabah[user2][0]);
        saldoAkhir = saldoNasabah[indexUser]- biayaAdmin - transfer;
        System.out.printf("Saldo Anda Sekarang Adalah : %,d\n", saldoAkhir);
        saldoNasabah[indexUser] = saldoAkhir;
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
        long[] nominal = {500000, 1000000, 2000000, 3000000, 5000000, 7500000, 100000000};
        int Tarik = 0;
        String coba;
        long ambil;
        long saldoAkhirPenarikan=0;
        boolean running = true;
        while (running) {
            System.out.println("===========================");
            System.out.println("Pilih Jenis Nominal");
            System.out.println("===========================");
            System.out.println("1. 500000 \t5.  5000000");
            System.out.println("2. 1000000\t6.  7500000");
            System.out.println("3. 2000000\t7. 100000000");
            System.out.println("4. 3000000");
            System.out.println("===========================");
            Tarik = andyNugraha031D.nextInt();
            if (dataNasabah[indexUser][1].equalsIgnoreCase("Platinum")) {
                if (nominal[Tarik - 1] > platinum) {
                    System.out.println("Penarikan Anda Terlalu Besar,Silahkan Coba Lagi");
                }
                else  {

                    transaksiPenarikan03D(nominal[Tarik - 1], saldoAkhirPenarikan);
                    nota03D();
                    
                }
            } else if (dataNasabah[indexUser][1].equalsIgnoreCase("Gold")) {
                if (nominal[Tarik - 1] >= gold) {
                    //jadi sesuai index 1 yang 500000 ribu itu masih index 1,apabila indexnya -1 maka yang diprint nanti yang index 0.
                    //jadi ketika inputan tarik = 1 maka saya harus memproses long array yaitu 0,maka saya akan mengelolah data dengan cara tarik - 1 agar tampilan outputnya sama
                    System.out.println("Penarikan Anda Terlalu Besar,Silahkan Coba Lagi");
                }
                else {
                    
                    transaksiPenarikan03D(nominal[Tarik - 1], saldoAkhirPenarikan);
                    nota03D();
                }
            } else if (dataNasabah[indexUser][1].equalsIgnoreCase("Silver")) {
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
        String transaksi2 [] [] = new String [transaksi.length +1][transaksi[0].length];
        for (int i = 0; i < transaksi.length; i++) {
            for (int j = 0; j < transaksi[i].length; j++) {
                transaksi2 [i] [j] = transaksi [i] [j];
            }
        }
        transaksi2 [transaksi2.length -1] [0] = "Penarikan";
        transaksi2 [transaksi2.length -1] [1] = " ";
        String nmnlTari = Long.toString(nominal[Tarik-1]);
        transaksi2 [transaksi2.length -1] [2] = nmnlTari;
        String saldo = Long.toString(saldoNasabah[indexUser]);
        transaksi2 [transaksi2.length -1] [3] = saldo;
        transaksi = transaksi2;
    }
    static void transaksiPenarikan03D(long ambil, long saldoAkhirPenarikan) {
        saldoHistory[indexUser] = saldoHistory[indexUser] + ambil;
        System.out.printf("Saldo Awal : %,d \n", saldoNasabah[indexUser]);
        System.out.printf("Anda telah melakukan penarikan uang sebesar Rp. %,d ", ambil);
        saldoAkhirPenarikan = saldoNasabah[indexUser] - ambil;
        System.out.printf("Saldo Anda Sekarang Adalah : %,d\n", saldoAkhirPenarikan);
        saldoNasabah[indexUser] = saldoAkhirPenarikan;
    }
    static void setorTabungan03D() {
        int jmlSetoran = 0;
        boolean running = true;
        while (running) {
            System.out.println("===============================================");
            //input jumlah setoran
            System.out.println("Masukkan jumlah setoran: ");
            jmlSetoran = andyNugraha031D.nextInt();
            //proses setoran
            
            saldoHistory[indexUser] = saldoHistory[indexUser] + jmlSetoran;
            //output saldo terbaru
            System.out.println("Saldo yang tersisa adalah: " + saldoNasabah[indexUser]);
            saldoNasabah[indexUser] = saldoNasabah[indexUser] + jmlSetoran;
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
        String transaksi2 [] [] = new String [transaksi.length +1][transaksi[0].length];
        for (int i = 0; i < transaksi.length; i++) {
            for (int j = 0; j < transaksi[i].length; j++) {
                transaksi2 [i] [j] = transaksi [i] [j];
            }
        }
        transaksi2 [transaksi2.length -1] [0] = "Setor Tabungan";
        transaksi2 [transaksi2.length -1] [1] = " ";
        String jumlah = Long.toString(jmlSetoran);
        transaksi2 [transaksi2.length -1] [2] = jumlah;
        String saldo = Long.toString(saldoNasabah[indexUser]);
        transaksi2 [transaksi2.length -1] [3] = saldo;
        transaksi = transaksi2;
    }
    static void nota03D(){
        System.out.println("");
        System.out.println("==========================================");
        System.out.println("\t       *Bank Jali*");
        System.out.println("==========================================");
        System.out.println("   Nama       \t: " + dataNasabah[indexUser][0]);
        System.out.println("   No Rekening\t: " + dataNasabah[indexUser][2]);
        System.out.println("   Jumlah     \t: Rp. " + saldoHistory[indexUser]);
        System.out.println("   Saldo      \t: Rp. " + saldoNasabah[indexUser]);
        System.out.println("");
    }
    static void tidakMinus(){
        saldoNasabah[indexUser] = 0;
        
    }
    
    static void catekLaporan03D(){
       //        Jenis Pembayaran, Tujuan, Nominal, Saldo Akhir
       System.out.printf("|%22s        |%19s           |%18s            |%21s         |\n", "Jenis Pembayaran", "Tujuan", "Nominal", "Saldo Akhir");
       for (int i = 0; i < transaksi.length; i++) {
           for (int j = 0; j < transaksi[i].length; j++) {
               if (transaksi[i][j] != null) {
                   System.out.printf("|%-30s", transaksi[i][j]);
               }
           }
           System.out.println("|");
        }
    }
}