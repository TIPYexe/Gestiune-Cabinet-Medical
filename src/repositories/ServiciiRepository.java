package repositories;

import administrator.Servicii;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

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

    public static void insertServicii(Servicii serviciu, Connection conn) throws SQLException {
        String query = "insert into servicii (id_serviciu, pret, durata, puncte)"
                + " values (?, ?, ?, ?)";

        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, serviciu.getId_serviciu());
        preparedStmt.setFloat(2, serviciu.getPret());
        preparedStmt.setFloat(3, serviciu.getDurata());
        preparedStmt.setInt(4, serviciu.getPuncte());
    }

    public static void deleteServicii(List<Servicii> servicii, int id, Connection conn) throws SQLException {

        String query = "DELETE FROM servicii where id_serviciu = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, id);
        preparedStmt.executeUpdate();

        PreparedStatement commit = conn.prepareStatement("COMMIT");
        commit.execute();

        int i=0;
        for(Servicii elem: servicii){
            if(elem.getId_serviciu() == id)
            {
                servicii.remove(i);
                break;
            }
            i++;
        }
    }

    public static void updateServicii(List<Servicii> servicii, int toChange, int id_serviciu, Scanner sc, Connection conn) throws SQLException {
        System.out.print("Ce camp actualizati: ");
        String toUpdateString = sc.useDelimiter("\n").next();

        if(toUpdateString.toLowerCase().contains("pret")){

            String query = "update servicii set pret = ? where id_serviciu = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_serviciu);

            // Aici fac modificarea in BD
            System.out.print("Introduceti noul pret: ");
            String toUpdateValue = sc.next();
            preparedStmt.setFloat(1, Float.parseFloat(toUpdateValue));

            // Aici fac modificarea in lista locala
            servicii.get(toChange).setPret(Float.parseFloat(toUpdateValue));
            preparedStmt.executeUpdate();

        } else if(toUpdateString.toLowerCase().contains("durata")){
            String query = "update servicii set durata = ? where id_serviciu = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_serviciu);

            System.out.print("Introduceti timpul corect: ");
            String toUpdateValue = sc.next();
            preparedStmt.setFloat(1, Float.parseFloat(toUpdateValue));

            servicii.get(toChange).setDurata(Float.parseFloat(toUpdateValue));
            preparedStmt.executeUpdate();

        } else if(toUpdateString.toLowerCase().contains("puncte")){
            String query = "update servicii set puncte = ? where id_serviciu = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_serviciu);

            System.out.print("Introduceti noua valoare: ");
            String toUpdateValue = sc.next();
            preparedStmt.setInt(1, Integer.parseInt(toUpdateValue));

            servicii.get(toChange).setPuncte(Integer.parseInt(toUpdateValue));
            preparedStmt.executeUpdate();

        } else
            System.out.println("Field not found!");


        PreparedStatement commit = conn.prepareStatement("COMMIT");
        commit.execute();
    }
}
