package administrator;

class Cabinet {
    private int id;
    private String nume;
    private String adresa;
    private String telefon;

    public Cabinet(String nume, String adresa, String telefon) {
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void updateNume(String nume) {
        this.nume = nume;
    }

    public void updateTelefon(String telefon) {
        this.telefon = telefon;
    }

}
