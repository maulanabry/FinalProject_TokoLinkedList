package academy.learnprogramming;

public class cDaftarTransaksi {
    cTransaksi front, rear;
    int jumlah;
    double nominal;
    cDaftarTransaksi (){
        front = rear = null;
        jumlah = 0;
    }
    public cTransaksi getFront(){
        return front;
    }
    public cTransaksi getRear(){
        return rear;
    }
    public void tambahTransaksi (cTransaksi baru){ // Untuk penambahan item
        if (rear == null){
            front = rear = baru;
        }
        else {
            rear.next = baru;
            rear=baru;
        }
        System.out.println("Penambahan Sukses...");
    }
    public void hapusTransaksi (int hps){
        cTransaksi t = front;
        cTransaksi prev = null;
        int i = 1;
        if (hps ==1){ // Dihapus nomer 1
            if (t.next == null){
                front = rear = null;
            }
            else {
                front = front.next;
                t.next = null;
            }
            System.out.println("["+t.getProduk().getNama()+"] dihapus");
        }
        if (hps > 1 && t.next != null) { // posisi tengah
            for (;t != null;t=t.next){
                if (i == hps){
                    break;
                }
                i++;
                prev = t; // menyimpan t sebelumnya dihapus
            }
            // Yang dihapus di ujung belakang
            if (t.next == null){
                rear = prev;
                rear.next = null;
            } else { // Jika tidak simpul t dilompati
                prev.next = t.next;
                t.next = null;
            }
            System.out.println("["+t.getProduk().getNama()+"] dihapus");
        }
    }
    public void lihatTransaksi (){
        int i=1;

        System.out.println("\t\t\t Daftar Transaksi");
        System.out.println("-------------------------------------------------");
        System.out.println("No Kode  Pembeli        Item \t\t\tHarga\t\t Jumlah\t   Status\t   Total");
        for (cTransaksi t=front; t!=null; t=t.next){
            System.out.print(i+".");
            System.out.print(" 00"+t.getNomorTransaksi());
            System.out.print("   "+t.getPembeli().getNama()+" \t\t");
            System.out.print(t.getProduk().getNama()+"\t\t");
            System.out.print("Rp"+t.getProduk().getHarga()+"\t\t\t");
            System.out.print(t.getJumlahprd()+"\t\t ");
            System.out.print(t.getStatus()+"\t\t ");
            System.out.println("  Rp"+t.getTotal()+"");
            i++;
        }
        System.out.println("=================================================");
    }
    public void sambungTransaksi (cTransaksi depan, cTransaksi belakang){
        // Pengecekan jika antrian kosong
        if (rear == null){
            front = depan;
            rear  = belakang;
        }
        else {
            // Sambungkan transaksi
            rear.next = depan; // ekor transaksi lama dihubungkan dengan depan
            // Update posisi rear
            rear = belakang; // ekor baru diisi belakang dr transaksi pembeli
        }
    }
    public  void prosesTransaksi (cTransaksi temp){
        temp.setStatus(1);
        temp.getProduk().setAkumulasi(temp.getTotal());
        temp.getPembeli().setAkumulasi(temp.getTotal());
        temp.getProduk().setJumakumulasi(temp.getJumlahprd());
        System.out.println("Berhasil Diproses...");
        System.out.println("-------------------------------------------------");
    }
    public void historyPembelian (){
        int i =1;
        System.out.println("No Kode  Pembeli        Item \t\t\tHarga\t\t Jumlah\t   Status\t   Total");
        for (cTransaksi t=front; t!=null; t=t.next){
            if (t.getStatus() == 0) {
                System.out.print(i+".");
                System.out.print(" 00"+t.getNomorTransaksi());
                System.out.print("   "+t.getPembeli().getNama()+" \t\t");
                System.out.print(t.getProduk().getNama()+"\t\t");
                System.out.print("Rp"+t.getProduk().getHarga()+"\t\t\t");
                System.out.print(t.getJumlahprd()+"\t\t ");
                System.out.print(t.getStatus()+"\t\t ");
                System.out.println("  Rp"+t.getTotal()+"");
                i++;
            }
        }
    }
    public void historyPenjualan (){
        int i =1;
        System.out.println("No Kode  Pembeli        Item \t\t\tHarga\t\t Jumlah\t   Status\t   Total");
        for (cTransaksi t=front; t!=null; t=t.next){
            if (t.getStatus() == 1) {
                System.out.print(i+".");
                System.out.print(" 00"+t.getNomorTransaksi());
                System.out.print("   "+t.getPembeli().getNama()+" \t\t");
                System.out.print(t.getProduk().getNama()+"\t\t");
                System.out.print("Rp"+t.getProduk().getHarga()+"\t\t\t");
                System.out.print(t.getJumlahprd()+"\t\t ");
                System.out.print(t.getStatus()+"\t\t ");
                System.out.println("  Rp"+t.getTotal()+"");
                i++;
            }
        }
    }
}
