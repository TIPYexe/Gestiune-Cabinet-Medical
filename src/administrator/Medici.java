package administrator;

class Medici extends Om {
    private int id_medic;
    private int id_salon;

    public Medici(String nume, String prenume, String mail, String telefon, int id_medic, int id_salon) {
        super(nume, prenume, mail, telefon);
        this.id_medic = id_medic;
        this.id_salon = id_salon;
    }

    public int getId() {
        return id_medic;
    }

    public int getId_salon() {
        return id_salon;
    }
}
