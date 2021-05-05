package administrator;

class Servicii {
    private int id_serviciu;
    private String denumire;
    private int pret;
    private int durata;
    private int puncte;

    public Servicii(int id_serviciu, String denumire, int pret, int durata, int puncte) {
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

    public int getPret() {
        return pret;
    }

    public int getDurata() {
        return durata;
    }

    public void updatePret(int pret) {
        this.pret = pret;
    }

    public void updateDurata(int durata) {
        this.durata = durata;
    }
}
