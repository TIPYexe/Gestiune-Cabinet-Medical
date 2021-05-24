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

    public static void loadMedici(List<Medici> medici, Statement st) throws SQLException {
        String query = "SELECT * FROM medici";

        ResultSet rs = st.executeQuery(query);

        Medici nou = new Medici();
        while (rs.next())
        {
            nou.setId_medic(rs.getInt("id_medic"));
            nou.setNume(rs.getString("nume"));
            nou.setPrenume(rs.getString("prenume"));
            nou.setMail(rs.getString("mail"));
            nou.setTelefon(rs.getString("telefon"));
            nou.setId_cabinet(rs.getInt("id_cabinet"));

            medici.add(nou);
        }
    }
}
