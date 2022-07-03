package academy.learnprogramming;
import java.util.Scanner;
public class AppCafe {
    public static Scanner sc = new Scanner(System.in);
    public static int pilih3, jumlah;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Daftar data Produk
        cProduk prd1 = new cProduk("Susu Regal",15000,"M001",0,0);
        cProduk prd2 = new cProduk("Si Keren",17000,"M002",0,0);
        cProduk prd3 = new cProduk("Si Hejo ",17000,"M003",0,0);
        cProduk prd4 = new cProduk("Blk Boka",12000,"M004",0,0);
        cProduk prd5 = new cProduk("LR Cream  ",15000,"M005",0,0);
        // Daftar data User
        cUser admin = new cUser("admin","admin","123",000);
        cUser pemilik = new cUser("owner","owner","123",001);
        // Daftar data Pembeli
        cUser_Pembeli nonmbr = new cUser_Pembeli("nonmem","nonmbr","123",100,0);
        cUser_Pembeli mbr1 = new cUser_Pembeli("Rendy ","rendy123","123",101,0);
        cUser_Pembeli mbr2 = new cUser_Pembeli("Bryan ","bryan123","123",102,0);
        cUser_Pembeli mbr3 = new cUser_Pembeli("Iwam ","iwam123","123",103,0);
        int member;
        String nama = null, username, password;
        double diskon = 0.05;
        int totalPenjualan = 0;
        int totalPembelian = 0;
        int totalDiskon = 0;
        

        //Terdapat dua linkedlist menghimpun transaksi satu pembeli (beli) ketika melakukan transaksi yang belum diproses
        // dan seluruh transaksi (jual)
        cDaftarTransaksi transaksi_penjualan = new cDaftarTransaksi();
        int pilih, pilih2 = 0,pesanan = 0,notransaksi = 0;

        // Aplikasi AppCafe
        // 1. Pembeli -->
        // 2. Anggota -->
        // 3. Admin -->
        // 4. Pemilik -->
        do {
            System.out.println("=================================================");
            System.out.println("𝕊𝕖𝕝𝕒𝕞𝕒𝕥 𝕕𝕒𝕥𝕒𝕟𝕘 𝕕𝕚 𝔸𝕡𝕡ℂ𝕒𝕗𝕖 𝔹𝕠𝕓𝕒𝕝!!!");
            System.out.println("-------------------------------------------------");
            System.out.println("1. Pembeli\n2. Anggota\n3. Admin\n4. Pemilik\n5. Selesai");
            System.out.println("------------------------------------------------");
            System.out.print("Pilih Nomor :");
            pilih = sc.nextInt();
            System.out.println("=================================================");
            switch(pilih){
                case 1:
                // Pembeli Non-Member
                    notransaksi++;
                    int jumtrans = 0;
                    // Linked List memasukkan data dari pembeli
                    cDaftarTransaksi transaksi_pembelian = new cDaftarTransaksi();
                    System.out.print("Masukkan Nama = ");
                    nama = sc.next();
                    do {
                        System.out.println("-------------------------------------------------");
                        System.out.println("Halo, "+nama+" Selamat Datang di Menu Pembelian");
                        System.out.println("-------------------------------------------------");
                        System.out.println("1. Tambah\n2. Hapus\n3. Lihat\n4. Kembali");
                        System.out.println("-------------------------------------------------");
                        System.out.print("Pilih Nomor :");
                        pilih2 = sc.nextInt();
                        System.out.println("=================================================");
                        switch (pilih2){
                            case 1:
                                cTransaksi temp = null;
                                mPembeli_TambahBarang ();
                                if (pilih3==1){
                                    temp = new cTransaksi (notransaksi,nonmbr,prd1,jumlah,0,prd1.getHarga()*jumlah);
                                } else if (pilih3 == 2){
                                    temp = new cTransaksi (notransaksi,nonmbr,prd2,jumlah,0,prd2.getHarga()*jumlah);
                                }  else if (pilih3 == 3){
                                    temp = new cTransaksi (notransaksi,nonmbr,prd3,jumlah,0,prd3.getHarga()*jumlah);
                                }  else if (pilih3 == 4){
                                    temp = new cTransaksi (notransaksi,nonmbr,prd4,jumlah,0,prd4.getHarga()*jumlah);
                                } else if (pilih3 == 5){
                                    temp = new cTransaksi (notransaksi,nonmbr,prd5,jumlah,0,prd5.getHarga()*jumlah);
                                }
                                transaksi_pembelian.tambahTransaksi(temp);
                                jumtrans++;
                                totalPembelian = totalPembelian + temp.getTotal();
                                System.out.println("=================================================");
                                break;
                            case 2:
                                // Hapus Transaksi
                                //Agar tidak terjadi error ketika belum ada transasksi
                                if (jumtrans > 0) {
                                    transaksi_pembelian.lihatTransaksi();
                                    System.out.print("Hapus Nomor = ");
                                    int hapus = sc.nextInt();
                                    transaksi_pembelian.hapusTransaksi(hapus);
                                } else {
                                    System.out.println("Tidak ada transaksi");
                                }
                                break;
                            case 3:
                                transaksi_pembelian.lihatTransaksi();
                                break;
                            case 4:
                                //Transaksi selesai, sambungkan transaksi pembeli ke antrian transaksi overall
                                transaksi_penjualan.sambungTransaksi(transaksi_pembelian.getFront(), transaksi_pembelian.getRear());
                                break;

                        }
                    }while (pilih2!=4);
            break;
                case 2:
                    // Pembeli Member
                    transaksi_pembelian = new cDaftarTransaksi();
                    cUser_Pembeli tempMember = null;
                    boolean login = false, cek = false;

                        if (login == false) {
                            boolean found = false;
                            do {
                                System.out.println("=================================================");
                                System.out.print("|   Login  | ");
                                username = sc.next();
                                System.out.print("| Password | ");
                                password = sc.next();
                                System.out.println("=================================================");
                                    if (username.equals(mbr1.getId()) && password.equals(mbr1.getPass())) {
                                        member = 1;
                                        nama = mbr1.getNama();
                                        found = true;
                                        login = true;
                                        cek = true;
                                        tempMember  =mbr1;
                                    } else if (username.equals(mbr2.getId()) && password.equals(mbr2.getPass())) {
                                        member = 2;
                                        nama = mbr2.getNama();
                                        found = true;
                                        login = true;
                                        cek = true;
                                        tempMember  =mbr2;
                                    } else if (username.equals(mbr3.getId()) && password.equals(mbr3.getPass())) {
                                        member = 3;
                                        nama = mbr3.getNama();
                                        found = true;
                                        login = true;
                                        cek = true;
                                        tempMember  =mbr3;
                                    } else {
                                        System.out.println("Username/Password Salah");
                                        System.out.println("-------------------------------------------------");
                                        System.out.println("Mencoba Login Kembali?");
                                        System.out.println("1: Ya / 2: Tidak");
                                        System.out.print("Pilih = ");
                                        pilih3 = sc.nextInt();
                                    System.out.println("-------------------------------------------------");
                                        if (pilih3 == 1){
                                            login = false;
                                            found = false;
                                        } else if (pilih3 ==2 ) {
                                            found = true;
                                            login = false;
                                            break;
                                    }
                                }
                            } while (found != true);
                        }


                        if (login == true){
                            int tempDiskon = 0;
                            jumtrans = 0;
                            notransaksi++;
                            do {
                            System.out.println("Halo, "+nama+". Selamat Datang di Menu Pembelian");
                            System.out.println("------------------------------------------------");
                            System.out.println("Member akan mendapat diskon 5%");
                            System.out.println("------------------------------------------------");
                            System.out.println("1. Tambah\n2. Hapus\n3. Lihat\n4. Ubah Password\n5. Kembali");
                            System.out.println("-------------------------------------------------");
                            System.out.print("Pilih Nomor :");
                            pilih2 = sc.nextInt();
                            System.out.println("=================================================");
                            switch (pilih2){
                                case 1:
                                    cTransaksi temp = null;
                                    mPembeli_TambahBarang ();
                                    if (pilih3==1){
                                        tempDiskon = (int) (prd1.getHarga()*jumlah*diskon);
                                        temp = new cTransaksi (notransaksi,tempMember ,prd1,jumlah,0, (int) ((prd1.getHarga()*jumlah)- (tempDiskon)));
                                    } else if (pilih3 == 2){
                                        tempDiskon = (int) (prd2.getHarga()*jumlah*diskon);
                                        temp = new cTransaksi (notransaksi,tempMember ,prd2,jumlah,0, (int) (prd2.getHarga()*jumlah- (tempDiskon)));
                                    }  else if (pilih3 == 3){
                                        tempDiskon = (int) (prd3.getHarga()*jumlah*diskon);
                                        temp = new cTransaksi (notransaksi,tempMember ,prd3,jumlah,0, (int) (prd3.getHarga()*jumlah- (tempDiskon)));
                                    }  else if (pilih3 == 4){
                                        tempDiskon = (int) (prd4.getHarga()*jumlah*diskon);
                                        temp = new cTransaksi (notransaksi,tempMember ,prd4,jumlah,0, (int) (prd4.getHarga()*jumlah- (tempDiskon)));
                                    } else if (pilih3 == 5){
                                        tempDiskon = (int) (prd5.getHarga()*jumlah*diskon);
                                        temp = new cTransaksi (notransaksi,tempMember ,prd5,jumlah,0, (int) (prd5.getHarga()*jumlah- (tempDiskon)));
                                    }
                                    transaksi_pembelian.tambahTransaksi(temp);
                                    jumtrans++;
                                    totalPembelian = totalPembelian + temp.getTotal();
                                    totalDiskon = totalDiskon + tempDiskon;
                                    System.out.println("=================================================");
                                    break;
                                case 2:
                                    // Hapus Transaksi
                                    //Agar tidak terjadi error ketika belum ada transasksi
                                    if (jumtrans > 0) {
                                        transaksi_pembelian.lihatTransaksi();
                                        System.out.println("Hapus Nomor = ");
                                        int hapus = sc.nextInt();
                                        transaksi_pembelian.hapusTransaksi(hapus);
                                    } else {
                                        System.out.println("Tidak ada transaksi");
                                    }
                                    break;
                                case 3:
                                    transaksi_pembelian.lihatTransaksi();
                                    break;
                                case 4:
                                    System.out.println("=================================================");
                                    System.out.print("| Password Baru | ");
                                    password = sc.next();
                                    System.out.println("=================================================");
                                    tempMember.setPass(password);
                                    break;
                                case 5:
                                    //Transaksi selesai, sambungkan transaksi pembeli ke antrian transaksi overall
                                        transaksi_penjualan.sambungTransaksi(transaksi_pembelian.getFront(), transaksi_pembelian.getRear());
                                    break;


                            }
                        }while (pilih2 != 5) ;
                    }
                    break;
                case 3:
                    //Admin
                    boolean found = false;
                    do {
                        System.out.println("=================================================");
                        System.out.print("|   Login  | ");
                        username = sc.next();
                        System.out.print("| Password | ");
                        password = sc.next();
                        System.out.println("=================================================");
                        if (username.equals(admin.getId()) && password.equals(admin.getPass())){
                            found = true;
                        } else {
                            System.out.println("ID/PASSWORD SALAH !!!");
                            System.out.println("--------------------------------------------------");
                            System.out.println("Mencoba Login Kembali?");
                            System.out.println("1: Ya / 2: Tidak");
                            System.out.print("Pilih = ");
                            pilih3 = sc.nextInt();
                            if (pilih3 == 1){
                                found = false;
                            } else {
                                found = true;
                            }
                        }
                    }while (found != true);
                    if (username.equals(admin.getId()) && password.equals(admin.getPass())) {
                        do {
                            System.out.println("Halo, Selamat datang Admin");
                            System.out.println("-------------------------------------------------");
                            System.out.println("1. Lihat Transaksi\n2. Proses Transaksi\n3. Selesai");
                            System.out.println("-------------------------------------------------");
                            System.out.print("Pilih Nomor :");
                            pilih2 = sc.nextInt();
                            // Untuk Memproses transaksi Pembelian
                            switch (pilih2) {
                                case 1:
                                    transaksi_penjualan.lihatTransaksi();
                                    break;
                                case 2:
                                cTransaksi temp = transaksi_penjualan.getFront();
                                System.out.println("\t\t\t-Proses Transaksi-");
                                System.out.println("-------------------------------------------------");
                                System.out.println("No Kode  Pembeli        Item \t\t\tHarga\t\t Jumlah\t   Status\t   Total");
                                System.out.println("-------------------------------------------------");
                                int i = 1;
                                do {
                                    if (temp.getStatus() == 0) {
                                        System.out.print(i+".");
                                        System.out.print(" 00"+temp.getNomorTransaksi());
                                        System.out.print("   "+temp.getPembeli().getNama()+" \t\t");
                                        System.out.print(temp.getProduk().getNama()+"\t\t");
                                        System.out.print("Rp"+temp.getProduk().getHarga()+"\t\t\t");
                                        System.out.print(temp.getJumlahprd()+"\t\t ");
                                        System.out.print(temp.getStatus()+"\t\t ");
                                        System.out.println("  Rp"+temp.getTotal()+"");
                                        System.out.println("-------------------------------------------------");
                                        System.out.println("Transaksi (" + i + ") Pilih:");
                                        System.out.println("1. Diproses");
                                        System.out.println("2. Selesai");
                                        System.out.print("Pilih : ");
                                        int pilih3 = sc.nextInt();
                                        if (pilih3 == 1) {
                                            transaksi_penjualan.prosesTransaksi(temp);
                                            totalPenjualan = totalPenjualan + temp.getTotal();
                                            totalPembelian = totalPembelian - temp.getTotal();
                                            pesanan++;
                                        } else {
                                            break;
                                        }
                                    }
                                    temp = temp.next;
                                } while (temp != null);
                                if (temp == null){
                                    System.out.println("Tidak ada transaksi");
                                    System.out.println("-------------------------------------------------");
                                }
                            }
                        } while (pilih2 != 3);
                    }
                    break;
                case 4:
                    //Pemilik
                    found = false;
                    do {
                        System.out.println("=================================================");
                        System.out.print("|   Login  | ");
                        username = sc.next();
                        System.out.print("| Password | ");
                        password = sc.next();
                        System.out.println("=================================================");
                        if (username.equals(pemilik.getId()) && password.equals(pemilik.getPass())){
                            found = true;
                        } else {
                            System.out.println("ID/PASSWORD SALAH !!!");
                            System.out.println("--------------------------------------------------");
                            System.out.println("Mencoba Login Kembali?");
                            System.out.println("1: Ya / 2: Tidak");
                            System.out.print("Pilih = ");
                            pilih3 = sc.nextInt();
                            if (pilih3 == 1){
                            } else {
                                found = true;
                            }
                        }
                    }while (found != true);
                    if (username.equals(pemilik.getId()) && password.equals(pemilik.getPass())){
                        do {
                            System.out.println("Halo, Owner Selamat Datang");
                            System.out.println("--------------------------------------------------");
                            System.out.println("1. History Transaksi\n2. Merubah Menu\n3. Laporan Penjualan Produk" +
                                    "\n4. Laporan Pembelian Member\n5. Laporan Grafik Bulanan\n6. Kembali");
                            System.out.println("-------------------------------------------------");
                            System.out.print("Pilih Nomor :");
                            pilih2 = sc.nextInt();
                            System.out.println("=================================================");
                            switch (pilih2){
                                case 1:
                                    // History Transaksi Sesudah & Sebelum Diproses
                                    System.out.println("History Transaksi Pembelian Belum Diproses");
                                    System.out.println("-------------------------------------------------");
                                    System.out.println("Total Pembelian = Rp"+totalPembelian);
                                    transaksi_penjualan.historyPembelian();
                                    System.out.println("-------------------------------------------------");
                                    System.out.println("History Transaksi Penjualan");
                                    System.out.println("-------------------------------------------------");
                                    System.out.println("Total Penjualan = Rp"+totalPenjualan);
                                    transaksi_penjualan.historyPenjualan();
                                    System.out.println("=================================================");
                                    break;
                                case 2:
                                    // Perubahan Harga Menu
                                    cek = false;
                                    cProduk temp = null;
                                    System.out.println("NB : Perubahan harga akan mereset data penjualan produk");
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("\t \tMenu Bobal");
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("1. Susu Regal");
                                    System.out.println("2. Si Keren");
                                    System.out.println("3. Si Hejo");
                                    System.out.println("4. Blackcurrent Boba");
                                    System.out.println("5. La Red Cream");
                                    System.out.println("6. Kembali");
                                    System.out.println("--------------------------------------------------");
                                    System.out.print("Pilih = ");
                                    pilih3 = sc.nextInt();
                                    System.out.println("--------------------------------------------------");
                                    if (pilih3 == 1){
                                        temp = prd1;
                                        cek = true;
                                    } else if (pilih3 ==2 ){
                                        temp = prd2;
                                        cek = true;
                                    }else if (pilih3 ==3){
                                        temp = prd3;
                                        cek = true;
                                    }else if (pilih3 ==4){
                                        temp = prd4;
                                        cek = true;
                                    }else if (pilih3 == 5){
                                        temp = prd5;
                                        cek = true;
                                    } else{
                                        cek = false;
                                } if (cek = true) {
                                    System.out.println("Produk      = " + temp.getNama());
                                    System.out.println("Harga Lama  = " + temp.getHarga());
                                    System.out.print("Harga Baru  = ");
                                    int tempharga = sc.nextInt();
                                    temp.setHarga(tempharga);
                                    //Akumulasi harga akan direset
                                    temp.setAkumulasi(0);
                                    temp.setJumakumulasi(0);
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("Perubahan Berhasil...");
                                    System.out.println("--------------------------------------------------");
                                }
                                    break;
                                case 3:
                                    // Laporan Pemasukan Harian
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("\t \tLaporan Pemasukan Harian");
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("Total Penjualan = Rp"+totalPenjualan);
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("No  Item \t\t\tHarga\t\t Jumlah\t   Status\t   Total");
                                    System.out.println("1."+prd1.getNama() + "  = Rp" + prd1.getakumulasi() + "  - " +prd1.getJumakumulasi());
                                    System.out.println("2."+prd2.getNama() + "  = Rp" + prd2.getakumulasi() + "  - " +prd2.getJumakumulasi());
                                    System.out.println("3."+prd3.getNama() + "  = Rp" + prd3.getakumulasi() + "  - " +prd3.getJumakumulasi());
                                    System.out.println("4."+prd4.getNama() + "  = Rp" + prd4.getakumulasi() + "  - " +prd4.getJumakumulasi());
                                    System.out.println("5."+prd5.getNama() + "  = Rp" + prd5.getakumulasi() + "  - " +prd5.getJumakumulasi());
                                    System.out.println("=================================================");
                                    break;
                                case 4:
                                    // Laporan Pembelian Member
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("\t \tLaporan Pembelian Member");
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("Total Pembelian Member = Rp"+(mbr1.getAkumulasi()+mbr2.getAkumulasi()+mbr3.getAkumulasi()));
                                    System.out.println("--------------------------------------------------");
                                    System.out.println(mbr1.getNama() + " = Rp" + mbr1.getAkumulasi());
                                    System.out.println(mbr2.getNama() + " = Rp" + mbr2.getAkumulasi());
                                    System.out.println(mbr3.getNama() + " = Rp" + mbr3.getAkumulasi());
                                    System.out.println("=================================================");
                                    break;
                                case 5:
                                    // Laporan Grafik Bulanan
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("\t \tLaporan Grafik Bulanan");
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("Total Penjualan = Rp"+totalPenjualan);
                                    System.out.println("--------------------------------------------------");
                                    System.out.print(prd1.getNama()+"\t: ");
                                    for (int i = 0; i < prd1.getakumulasi()/10000; i++) {
                                        if ((prd1.getakumulasi()/10000)-i<1)break;
                                        System.out.print("X");
                                    }
                                    System.out.println(" - "+Math. floor (prd1.getakumulasi()));
                                    System.out.print(prd2.getNama()+"\t: ");
                                    for (int i = 0; i < prd2.getakumulasi()/10000; i++) {
                                        if ((prd2.getakumulasi()/10000)-i<1)break;
                                        System.out.print("X");
                                    }
                                    System.out.println(" - "+Math. floor (prd2.getakumulasi()));
                                    System.out.print(prd3.getNama()+"\t: ");
                                    for (int i = 0; i < prd3.getakumulasi()/10000; i++) {
                                        if ((prd3.getakumulasi()/10000)-i<1)break;
                                        System.out.print("X");
                                    }
                                    System.out.println(" - "+Math. floor (prd3.getakumulasi()));
                                    System.out.print(prd4.getNama()+"\t: ");
                                    for (int i = 0; i < prd4.getakumulasi()/10000; i++) {
                                        if ((prd4.getakumulasi()/10000)-i<1)break;
                                        System.out.print("X");
                                    }
                                    System.out.println(" - "+Math. floor (prd4.getakumulasi()));
                                    System.out.print(prd5.getNama()+"\t: ");
                                    for (int i = 0; i < prd5.getakumulasi()/10000; i++) {
                                        if ((prd5.getakumulasi()/10000)-i<1)break;
                                        System.out.print("X");
                                    }
                                    System.out.println(" - "+Math. floor (prd5.getakumulasi()));
                                    System.out.println("=================================================");
                                    break;
                            }
                        } while (pilih2 != 6);
                }
                    break;
            }
        } while (pilih != 5);
    }
    public static void mPembeli_TambahBarang (){
        System.out.println("\t \tMenu Bobal");
        System.out.println("--------------------------------------------------");
        System.out.println("1. Susu Regal");
        System.out.println("2. Si Keren");
        System.out.println("3. Si Hejo");
        System.out.println("4. Blackcurrent Boba");
        System.out.println("5. La Red Cream");
        System.out.println("--------------------------------------------------");
        System.out.print("Pilih = ");
        pilih3 = sc.nextInt();
        System.out.print("Jumlah = ");
        jumlah = sc.nextInt();
        System.out.println("=================================================");
    }
}
