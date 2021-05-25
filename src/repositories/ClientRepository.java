package repositories;

import administrator.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClientRepository {
    public static void loadClienti(List<Client> clineti, Statement st) throws SQLException {
        String query = "SELECT * FROM clienti";

        ResultSet rs = st.executeQuery(query);


        while (rs.next()) {
            Client nou = new Client();
            nou.setId_client(rs.getInt("id_client"));
            nou.setId_card(rs.getInt("id_card"));
            nou.setPuncte(rs.getInt("puncte"));
            nou.setNume(rs.getString("nume"));
            nou.setPrenume(rs.getString("prenume"));
            nou.setTelefon(rs.getString("telefon"));
            nou.setMail(rs.getString("mail"));
            nou.setData_nastere(rs.getDate("data_nastere"));

            clineti.add(nou);
        }
    }
}
