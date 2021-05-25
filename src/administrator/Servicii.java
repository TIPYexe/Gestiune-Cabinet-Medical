package administrator;

class Servicii {
    private int id_serviciu;
    private float pret;
    private float durata;
    private int puncte;

    public Servicii() {
    }

    public Servicii(float pret, float durata, int puncte) {
        this.pret = pret;
        this.durata = durata;
        this.puncte = puncte;
    }

    public int getPuncte() {
        return puncte;
    }

    public int getId_serviciu() {
        return id_serviciu;
    }

    public float getPret() {
        return pret;
    }

    public float getDurata() {
        return durata;
    }

    public void updatePret(float pret) {
        this.pret = pret;
    }

    public void updateDurata(float durata) {
        this.durata = durata;
    }

    public void setId_serviciu(int id_serviciu) {
        this.id_serviciu = id_serviciu;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public void setDurata(float durata) {
        this.durata = durata;
    }

    public void setPuncte(int puncte) {
        this.puncte = puncte;
    }
}
