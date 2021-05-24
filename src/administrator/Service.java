package administrator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Service {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void print_menu() {

        System.out.println("0. Exit");

        System.out.println("---PROGRAMARI---");
        System.out.println("1. Afiseaza programarile.");
        System.out.println("2. Adauga programare.");
        System.out.println("3. Actualizeaza data programare.");
        System.out.println("4. Sterge programare.");

        System.out.println("---PRODUSE---");
//        System.out.println("5. Afiseaza stocul de produse.");
//        System.out.println("6. Cauta produs dupa nume");
//        System.out.println("7. Actualizare produse stoc.");
//        System.out.println("8. Adauga produs nou.");
//        System.out.println("9. Schimba pretul de vanzare.");
//        System.out.println("10. Schimba pretul de la retailer.");
        System.out.println("Work in progress!");

        System.out.println("---CLIENTI---");
        System.out.println("5. Afiseaza toti clientii avuti vreodata.");
        System.out.println("6. Cauta client dupa ID.");
        System.out.println("7. Adauga client nou.");
        System.out.println("8. Modifica adresa mail.");
        System.out.println("9. Sterge client.");

        System.out.println("---MEDICI---");
        System.out.println("10. Afiseaza toti medicii.");
        System.out.println("11. Cauta medic dupa nume.");
        System.out.println("12. Adauga medic nou.");
        System.out.println("13. Modifica adresa mail.");
        System.out.println("14. Sterge medic.");

        System.out.println("---SERVICII---");
        System.out.println("15. Afiseaza toate serviciile.");
        System.out.println("16. Cauta serviciu dupa nume.");
        System.out.println("17. Adauga serviciu nou.");
        System.out.println("18. Modifica cost.");
        System.out.println("19. Sterge serviciu.");
    }

    public static String findClientNameById(List<Client> lista, int id) {
        for (Client elem : lista) {
            if (elem.getId() == id)
                return elem.getNume() + ' ' + elem.getPrenume();
        }
        return null;
    }

    public static String findMedicNameById(List<Medici> lista, int id) {
        for (Medici elem : lista) {
            if (elem.getId() == id)
                return elem.getNume() + ' ' + elem.getPrenume();
        }
        return null;
    }

    public static int findClientById(List<Client> lista, int id) {
        int index = 0;
        for (Client elem : lista) {
            if (elem.getId() == id)
                return index;
            index++;
        }
        return -1;
    }

    public static int findMedicById(List<Medici> lista, int id) {
        int index = 0;
        for (Medici elem : lista) {
            if (elem.getId() == id)
                return index;
            index++;
        }
        return -1;
    }

    public static int findProgramareById(List<Programare> lista, int id) {
        int index = 0;
        for (Programare elem : lista) {
            if (elem.getId() == id)
                return index;
            index++;
        }
        return -1;
    }

//    public static <T extends Programare Client> int findById(List<T> lista, int id) {
//        int index = 0;
//        for (T elem : lista) {
//            if (elem.getId() == id)
//                return index;
//            index++;
//        }
//        return -1;
//    }

    public static Produse findProdusByName(List<Produse> lista, String nume) {
        for (Produse elem : lista) {
            if (elem.getNume().equals(nume))
                return elem;
        }
        return null;
    }

    public static int findProdusByName_int(List<Produse> lista, String nume) {
        int index = 0;
        for (Produse elem : lista) {
            if (elem.getNume().equals(nume))
                return index;
            index++;
        }
        return -1;
    }

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
