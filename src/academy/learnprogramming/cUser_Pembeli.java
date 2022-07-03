package academy.learnprogramming;

public class cUser_Pembeli extends cUser {
    int akumulasi;
    public cUser_Pembeli(String n, String d, String p, int nm, int ak) {
        super(n,d,p,nm);
        nama = n;
        id = d;
        pass = p;
        nomer = nm;
        akumulasi = ak;


    }

    public int getAkumulasi() {
        return akumulasi;
    }

    public void setAkumulasi(int akumulasi) {
        this.akumulasi = this.akumulasi +akumulasi;
    }
    public void setPass (String pass){
        this.pass = pass;
    }
}
