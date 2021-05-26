package repositories;

import administrator.Client;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

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

    public static void insertClient(Client client, Connection conn) throws SQLException {
        String query = "insert into clienti (id_client, id_card, puncte, nume, prenume, telefon, mail, data_nastere)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, client.getId());
        preparedStmt.setInt(2, client.getCardId());
        preparedStmt.setInt(3, client.getPuncte());
        preparedStmt.setString(4, client.getNume());
        preparedStmt.setString(5, client.getPrenume());
        preparedStmt.setString(6, client.getTelefon());
        preparedStmt.setString(7, client.getMail());
        java.sql.Date data_nastere = java.sql.Date.valueOf(client.getData_nastere().toString());
        preparedStmt.setDate(8, data_nastere);
    }
    
    public static void deleteClient(List<Client> clienti, int id, Connection conn) throws SQLException {

        String query = "DELETE FROM clienti where id_client = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, id);
        preparedStmt.executeUpdate();

        PreparedStatement commit = conn.prepareStatement("COMMIT");
        commit.execute();
        
        int i=0;
        for(Client elem: clienti){
            if(elem.getId() == id)
            {
                clienti.remove(i);
                break;
            }
            i++;
        }
    }
    
    public static void updateClient(List<Client> clienti, int toChange, int id_client, Scanner sc, Connection conn) throws SQLException {
        System.out.print("Ce camp actualizati: ");
        String toUpdateString = sc.next();

        // ex input: id_medic sau data_programare
        if(toUpdateString.toLowerCase().contains("card")){

            String query = "update clienti set id_card = ? where id_client = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_client);

            // Aici fac modificarea in BD
            System.out.print("Introduceti valoarea noua: ");
            String toUpdateValue = sc.next();
            preparedStmt.setInt(1, Integer.parseInt(toUpdateValue));

            // Aici fac modificarea in lista locala
            clienti.get(toChange).setId_card(Integer.parseInt(toUpdateValue));
            preparedStmt.executeUpdate();

        } else if(toUpdateString.toLowerCase().contains("nume")){
            String query = "update clienti set nume = ? where id_client = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_client);

            System.out.print("Introduceti numele corect: ");
            String toUpdateValue = sc.next();
            preparedStmt.setString(1, toUpdateValue);

            clienti.get(toChange).setNume(toUpdateValue);
            preparedStmt.executeUpdate();

        } else if(toUpdateString.toLowerCase().contains("prenume")){
            String query = "update clienti set prenume = ? where id_client = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_client);

            System.out.print("Introduceti prenumele corect: ");
            String toUpdateValue = sc.next();
            preparedStmt.setString(1, toUpdateValue);

            clienti.get(toChange).setPrenume(toUpdateValue);
            preparedStmt.executeUpdate();

        } else if(toUpdateString.toLowerCase().contains("telefon")) {
            String query = "update clienti set telefon = ? where id_client = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(2, id_client);

            System.out.print("Introduceti noul numar: ");
            String toUpdateValue = sc.next();
            preparedStmt.setString(1, toUpdateValue);

            clienti.get(toChange).setTelefon(toUpdateValue);
            preparedStmt.executeUpdate();
        } else if(toUpdateString.toLowerCase().contains("mail")) {
            String query = "update clienti set mail = ? where id_client = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_client);

            System.out.print("Introduceti noua adresa: ");
            String toUpdateValue = sc.next();
            preparedStmt.setString(1, toUpdateValue);

            clienti.get(toChange).setMail(toUpdateValue);
            preparedStmt.executeUpdate();

        } else if(toUpdateString.toLowerCase().contains("nastere")){
            String query = "update clienti set data_nastere = ? where id_client = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_client);

            System.out.print("Introduceti valoarea noua (yyyy-mm-dd): ");
            String toUpdateValue = sc.next();
            java.sql.Date data_nastere = java.sql.Date.valueOf(toUpdateValue);

            preparedStmt.setDate(1, data_nastere);

            clienti.get(toChange).setData_nastere(data_nastere);
            preparedStmt.executeUpdate();
        }


        PreparedStatement commit = conn.prepareStatement("COMMIT");
        commit.execute();
    }
}
