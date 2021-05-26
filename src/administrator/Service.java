package administrator;

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
        System.out.println("3. Actualizeaza programare.");
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
        System.out.println("8. Modifica date client.");
        System.out.println("9. Sterge client.");

        System.out.println("---MEDICI---");
        System.out.println("10. Afiseaza toti medicii.");
        System.out.println("11. Cauta medic dupa nume.");
        System.out.println("12. Adauga medic nou.");
        System.out.println("13. Modifica adresa mail.");
        System.out.println("14. Sterge medic.");

        System.out.println("---SERVICII---");
        System.out.println("15. Afiseaza toate serviciile.");
        System.out.println("16. Adauga serviciu nou.");
        System.out.println("17. Modifica cost.");
        System.out.println("18. Sterge serviciu.");

        System.out.println("---INSERT DATA---");
        System.out.println("19. Incarca baza de date cu ceva random.");
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
}
