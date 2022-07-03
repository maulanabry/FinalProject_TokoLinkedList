package academy.learnprogramming;

public class cTransaksi {
    public cTransaksi next;
    int NomorTransaksi;
    cUser_Pembeli pembeli;
    cProduk produk;
    int jumlahprd;
    int status;
    int total;

    cTransaksi (int nt, cUser_Pembeli pem, cProduk pr, int jum, int s, int t){
        NomorTransaksi = nt; pembeli = pem; produk = pr; jumlahprd = jum; status = s; total = t;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNomorTransaksi() {
        return NomorTransaksi;
    }

    public cUser_Pembeli getPembeli() {
        return pembeli;
    }

    public cProduk getProduk() {
        return produk;
    }

    public int getJumlahprd() {
        return jumlahprd;
    }

    public int getStatus() {
        return status;
    }

    public int getTotal() {
        return total;
    }
}
