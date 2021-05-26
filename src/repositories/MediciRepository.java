package repositories;

import administrator.Medici;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

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

    public static void insertMedici(Medici medic, Connection conn) throws SQLException {
        String query = "insert into medici (id_medic, id_cabinet, nume, prenume, telefon, mail)"
                + " values (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, medic.getId());
        preparedStmt.setInt(2, medic.getId_cabinet());
        preparedStmt.setString(3, medic.getNume());
        preparedStmt.setString(4, medic.getPrenume());
        preparedStmt.setString(5, medic.getTelefon());
        preparedStmt.setString(6, medic.getMail());
    }

    public static void deleteMedici(int id, Connection conn) throws SQLException {

        String query = "DELETE FROM medici where id_medic = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, id);
        preparedStmt.executeUpdate();

        PreparedStatement commit = conn.prepareStatement("COMMIT");
        commit.execute();
    }

    public static void updateMedici(int id_medic, Scanner sc, Connection conn) throws SQLException {
        System.out.print("Ce camp actualizati: ");
        String toUpdateString = sc.useDelimiter("\n").next();

        if(toUpdateString.toLowerCase().contains("cabinet")){

            String query = "update medici set id_cabinet = ? where id_medic = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_medic);

            // Aici fac modificarea in BD
            System.out.print("Introduceti valoarea noua: ");
            String toUpdateValue = sc.next();
            preparedStmt.setInt(1, Integer.parseInt(toUpdateValue));

            preparedStmt.executeUpdate();

        } else if(toUpdateString.toLowerCase().contains("nume")){
            String query = "update medici set nume = ? where id_medic = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_medic);

            System.out.print("Introduceti numele corect: ");
            String toUpdateValue = sc.next();
            preparedStmt.setString(1, toUpdateValue);

            preparedStmt.executeUpdate();

        } else if(toUpdateString.toLowerCase().contains("prenume")){
            String query = "update medici set prenume = ? where id_medic = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_medic);

            System.out.print("Introduceti prenumele corect: ");
            String toUpdateValue = sc.next();
            preparedStmt.setString(1, toUpdateValue);

            preparedStmt.executeUpdate();

        } else if(toUpdateString.toLowerCase().contains("telefon")) {
            String query = "update medici set telefon = ? where id_medic = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(2, id_medic);

            System.out.print("Introduceti noul numar: ");
            String toUpdateValue = sc.next();
            preparedStmt.setString(1, toUpdateValue);

            preparedStmt.executeUpdate();

        } else if(toUpdateString.toLowerCase().contains("mail")) {
            String query = "update medici set mail = ? where id_medic = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_medic);

            System.out.print("Introduceti noua adresa: ");
            String toUpdateValue = sc.next();
            preparedStmt.setString(1, toUpdateValue);

            preparedStmt.executeUpdate();

        } else
            System.out.println("Field not found!");


        PreparedStatement commit = conn.prepareStatement("COMMIT");
        commit.execute();
    }
}
