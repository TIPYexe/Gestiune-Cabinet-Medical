package repositories;

import administrator.Medici;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MediciRepository {
    public static void loadMedici(List<Medici> medici, Statement st) throws SQLException {
        String query = "SELECT * FROM medici";

        ResultSet rs = st.executeQuery(query);


        while (rs.next()) {
            Medici nou = new Medici();
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
