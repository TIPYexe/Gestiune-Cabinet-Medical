package administrator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

class Medici extends Om {
    private int id_medic;
    private int id_cabinet;

    public Medici(String nume, String prenume, String mail, String telefon, int id_medic, int id_salon) {
        super(nume, prenume, mail, telefon);
        this.id_medic = id_medic;
        this.id_cabinet = id_salon;
    }

    public Medici() {
    }

    public int getId() {
        return id_medic;
    }

    public int getId_cabinet() {
        return id_cabinet;
    }

    public void setId_medic(int id_medic) {
        this.id_medic = id_medic;
    }

    public void setId_cabinet(int id_cabinet) {
        this.id_cabinet = id_cabinet;
    }


}
