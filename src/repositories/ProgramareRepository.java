package repositories;

import administrator.Programare;

import java.sql.*;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class ProgramareRepository {
    public static void loadProgramari(List<Programare> programari, Statement st) throws SQLException {

        String query = "SELECT * FROM programari";

        ResultSet rs = st.executeQuery(query);


        while (rs.next()) {
            Programare nou = new Programare();
            nou.setId_programare(rs.getInt("id_programare"));
            nou.setData_ora_programare(rs.getDate("data_ora_programare"));
            nou.setData_ora_efectuata(rs.getDate("data_ora_efectuata"));
            nou.setId_medic(rs.getInt("id_medic"));
            nou.setId_client(rs.getInt("id_client"));
            nou.setId_serviciu(rs.getInt("id_serviciu"));

            // setData_ora_programare(new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("data_ora_programare").replace('-', '/')));
            // setData_ora_efectuata(new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("data_ora_efectuata").replace('-', '/')));
            // System.out.println(nou.getId() + " " + nou.getId_medic() + " " + nou.getId_client() + " " + nou.getId_serviciu());
            programari.add(nou);
        }
    }

    public static void insertProgramari(Programare programare, Connection conn) throws SQLException {

        String query = "insert into programari (id_programare, id_medic, id_client, id_serviciu, data_ora_programare, data_ora_efectuata)"
                + " values (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt (1, programare.getId());
        preparedStmt.setInt (2, programare.getId_medic());
        preparedStmt.setInt (3, programare.getId_client());
        preparedStmt.setInt (4, programare.getId_serviciu());
        preparedStmt.setDate(5, programare.getData_ora_programare());
        preparedStmt.setDate(6, programare.getData_ora_efectuata());

        preparedStmt.execute();

    }

    // Sterg o programare, dupa ID_programare
    public static void deleteProgramari(List<Programare> programari, int id, Connection conn) throws SQLException {

        // Aici o sterg din DB
        String query = "DELETE FROM programari where id_programare = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, id);
        preparedStmt.executeUpdate();

        PreparedStatement commit = conn.prepareStatement("COMMIT");
        commit.execute();

        // Aici o sterg din lista. Fac asta in loc de recitirea datelor din DB pt ca mi se
        // pare mai eficient decat n realocari de memorie.
        int i=0;
        for(Programare elem: programari){
            if(elem.getId() == id)
            {
                programari.remove(i);
                break;
            }
            i++;
        }

    }

    public static void updateProgramari(List<Programare> programari, int toChange, int id_programare, Scanner sc, Connection conn) throws SQLException, ParseException {
        System.out.print("Ce camp actualizati: ");
        String toUpdateString = sc.next();

        // ex input: id_medic sau data_programare
        if(toUpdateString.toLowerCase().contains("medic")){

            String query = "update programari set id_medic = ? where id_programare = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_programare);

            // Aici fac modificarea in BD
            System.out.print("Introduceti valoarea noua: ");
            String toUpdateValue = sc.next();
            preparedStmt.setInt(1, Integer.parseInt(toUpdateValue));

            // Aici fac modificarea in lista locala
            programari.get(toChange).setId_medic(Integer.parseInt(toUpdateValue));
            preparedStmt.executeUpdate();

        } else if(toUpdateString.toLowerCase().contains("client")){
            String query = "update programari set id_client = ? where id_programare = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_programare);

            System.out.print("Introduceti valoarea noua: ");
            String toUpdateValue = sc.next();
            preparedStmt.setInt(1, Integer.parseInt(toUpdateValue));

            programari.get(toChange).setId_client(Integer.parseInt(toUpdateValue));
            preparedStmt.executeUpdate();

        } else if(toUpdateString.toLowerCase().contains("serviciu")){
            String query = "update programari set id_serviciu = ? where id_programare = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_programare);

            System.out.print("Introduceti valoarea noua: ");
            String toUpdateValue = sc.next();
            preparedStmt.setInt(1, Integer.parseInt(toUpdateValue));

            programari.get(toChange).setId_serviciu(Integer.parseInt(toUpdateValue));
            preparedStmt.executeUpdate();

        } else if(toUpdateString.toLowerCase().contains("programare")){
            String query = "update programari set data_ora_programare = ? where id_programare = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_programare);

            System.out.print("Introduceti valoarea noua (yyyy-mm-dd): ");
            String toUpdateValue = sc.next();
            java.sql.Date data_programare = java.sql.Date.valueOf(toUpdateValue);

            preparedStmt.setDate(1, (java.sql.Date) data_programare);

            programari.get(toChange).setData_ora_programare(data_programare);
            preparedStmt.executeUpdate();

        } else if(toUpdateString.toLowerCase().contains("efectuata")){
            String query = "update programari set data_ora_efectuata = ? where id_programare = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (2, id_programare);

            System.out.print("Introduceti valoarea noua (yyyy-mm-dd): ");
            String toUpdateValue = sc.next();
            java.sql.Date data_programare = java.sql.Date.valueOf(toUpdateValue);

            preparedStmt.setDate(1, data_programare);

            programari.get(toChange).setData_ora_programare(data_programare);
            preparedStmt.executeUpdate();
        }


        PreparedStatement commit = conn.prepareStatement("COMMIT");
        commit.execute();
    }
}
