package administrator;

public class Om {
    private String nume;
    private String prenume;
    private String mail;

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    private String telefon;

    public Om() {
    }

    public Om(String nume, String prenume, String mail, String telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.mail = mail;
        this.telefon = telefon;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getMail() {
        return mail;
    }

    public String getTelefon() {
        return telefon;
    }

    public void updateMail(String mail) {
        this.mail = mail;
    }

    public void updateTelefon(String telefon) {
        this.telefon = telefon;
    }
}
