package academy.learnprogramming;

public class cProduk {
    // Object Produk memiliki atribut :
    // Nama - Ex. "Regal", Harga - Ex.  15000, id - "M001, akumulasi - 0"
    String nama;
    int harga;
    String id;
    int akumulasi;
    int jumakumulasi;

    public cProduk(String n, int h, String d, int ak, int jumak) {
        nama = n;
        harga = h;
        id = d;
        akumulasi = ak;
        jumakumulasi = jumak;

    }
    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getId() {
        return id;
    }
    public int getakumulasi() {
        return akumulasi;
    }

    public void setAkumulasi(int akumulasi) {
        this.akumulasi =  this.akumulasi + akumulasi;
    }

    public int getJumakumulasi() {
        return jumakumulasi;
    }

    public void setJumakumulasi(int jumakumulasi) {
        this.jumakumulasi = this.jumakumulasi + jumakumulasi;
    }
}