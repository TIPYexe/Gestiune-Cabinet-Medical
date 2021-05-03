package administrator;

class Servicii {
    private int id_serviciu;
    private String denumire;
    private float pret;
    private float durata;
    private int puncte;

    public Servicii(int id_serviciu, String denumire, float pret, float durata, int puncte) {
        this.id_serviciu = id_serviciu;
        this.denumire = denumire;
        this.pret = pret;
        this.durata = durata;
        this.puncte = puncte;
    }

    public String getDenumire() {
        return denumire;
    }

    public int getPuncte() {
        return puncte;
    }

    public int getId() {
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
}
