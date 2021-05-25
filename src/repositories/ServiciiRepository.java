package repositories;

import administrator.Servicii;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ServiciiRepository {
    public static void loadServicii(List<Servicii> servicii, Statement st) throws SQLException {
        String query = "SELECT * FROM servicii";

        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            Servicii nou = new Servicii();
            nou.setId_serviciu(rs.getInt("id_serviciu"));
            nou.setPret(rs.getFloat("pret"));
            nou.setDurata(rs.getFloat("durata"));
            nou.setPuncte(rs.getInt("puncte"));

            servicii.add(nou);
        }
    }
}
