package administrator;

class Produse {
    private String cod_bare;
    private String nume;
    private float pret;
    private float pret_vanzare;
    private int nr_produse;

    public Produse(String cod_bare, String nume, float pret, float pret_vanzare, int nr_produse) {
        this.cod_bare = cod_bare;
        this.nume = nume;
        this.pret = pret;
        this.pret_vanzare = pret_vanzare;
        this.nr_produse = nr_produse;
    }

    public int getNr_produse() {
        return nr_produse;
    }

    public void setNr_produse(int nr_produse) {
        this.nr_produse = nr_produse;
    }

    public void addNr_produse(int nr_produse) {
        this.nr_produse += nr_produse;
    }

    public String getNume() {
        return nume;
    }

    public float getPret() {
        return pret;
    }

    public float getPret_vanzare() {
        return pret_vanzare;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public void setPret_vanzare(float pret_vanzare) {
        this.pret_vanzare = pret_vanzare;
    }
}
