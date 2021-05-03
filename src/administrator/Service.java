package administrator;

import org.w3c.dom.ranges.Range;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.text.DateFormat;

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
        System.out.println("4. Asigneaza programarea altui medic.");

        System.out.println("---PRODUSE---");
        System.out.println("5. Afiseaza stocul de produse.");
        System.out.println("6. Cauta produs dupa nume");
        System.out.println("7. Actualizare produse stoc.");
        System.out.println("8. Adauga produs nou.");
        System.out.println("9. Schimba pretul de vanzare.");
        System.out.println("10. Schimba pretul de la retailer.");

        System.out.println("---CLIENTI---");
        System.out.println("11. Afiseaza toti clientii avuti vreodata.");
        System.out.println("12. Cauta client dupa nume.");
        System.out.println("13. Adauga client nou.");
        //System.out.println("14. Modifica adresa mail.");
        //System.out.println("15. Modifica numar de telefon.");
        //System.out.println("16. Adauga card fidelitate.");

        System.out.println("---MEDICI---");
        System.out.println("17. Afiseaza toti medicii.");
        System.out.println("18. Cauta medic dupa nume.");
        System.out.println("19. Adauga medic nou.");
        //System.out.println("20. Modifica adresa mail.");
        //System.out.println("21. Modifica numar de telefon.");

        //System.out.println("---SERVICII---");
        //System.out.println("22. Afiseaza toate serviciile.");
        //System.out.println("23. Cauta serviciu dupa nume.");
        //System.out.println("24. Adauga serviciu nou.");
        //System.out.println("25. Modifica cost.");
        //System.out.println("26. Modifica numar de puncte.");
    }

    public static String findClientNameById(List<Client> lista, int id) {
        for (Client elem : lista) {
            if (elem.getId() == id)
                return elem.getNume() + ' ' + elem.getPrenume();
        }
        return null;
    }

    public static String findServiciuNameById(List<Servicii> lista, int id) {
        for (Servicii elem : lista) {
            if (elem.getId() == id)
                return elem.getDenumire();
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


    //region CSV

    public static int countLines(File aFile) throws IOException {
        LineNumberReader reader = null;
        try {
            reader = new LineNumberReader(new FileReader(aFile));
            while ((reader.readLine()) != null);
            return reader.getLineNumber();
        } catch (Exception ex) {
            return -1;
        } finally {
            if(reader != null)
                reader.close();
        }
    }

    //region Read From File


    public static void readClientFromFile(List<Client> lista) throws IOException, ParseException {
        BufferedReader csvReader = new BufferedReader(new FileReader("Data-Client.csv"));
        String row;
        // sar peste primul rand, cel cu coloane
        row = csvReader.readLine();

        while ((row = csvReader.readLine()) != null) {

            // nu inteleg de ce csv-ul meu are ; in loc de ,
            String[] data = row.split(";");

            Date data_nastere = new SimpleDateFormat("dd/MM/yyyy").parse(data[5].replace('.', '/'));
            Client nou = new Client(data[1], data[2], data[6], data[7], Integer.parseInt(data[0]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), data_nastere);

            lista.add(nou);
        }
        csvReader.close();
    }

    public static void readMediciFromFile(List<Medici> lista) throws IOException, ParseException {
        BufferedReader csvReader = new BufferedReader(new FileReader("Data-Medici.csv"));
        String row;
        // sar peste primul rand, cel cu coloane
        row = csvReader.readLine();

        while ((row = csvReader.readLine()) != null) {

            // nu inteleg de ce csv-ul meu are ; in loc de ,
            String[] data = row.split(";");

            Medici nou = new Medici(data[1], data[2], data[4], data[5], Integer.parseInt(data[0]), Integer.parseInt(data[3]));

            lista.add(nou);
        }
        csvReader.close();
    }

    public static void readServiciiFromFile(List<Servicii> lista) throws IOException, ParseException {
        BufferedReader csvReader = new BufferedReader(new FileReader("Data-Servicii.csv"));
        String row;
        // sar peste primul rand, cel cu coloane
        row = csvReader.readLine();

        while ((row = csvReader.readLine()) != null) {

            // nu inteleg de ce csv-ul meu are ; in loc de ,
            String[] data = row.split(";");

            Servicii nou = new Servicii(Integer.parseInt(data[0]), data[1], Float.parseFloat(data[2]), Float.parseFloat(data[3]), Integer.parseInt(data[4]));

            lista.add(nou);
        }
        csvReader.close();
    }

    public static void readProgramareFromFile(List<Programare> lista) throws IOException, ParseException {
        BufferedReader csvReader = new BufferedReader(new FileReader("Data-Programare.csv"));
        String row;
        // sar peste primul rand, cel cu coloane
        row = csvReader.readLine();

        while ((row = csvReader.readLine()) != null) {

            // nu inteleg de ce csv-ul meu are ; in loc de ,
            String[] data = row.split(";");

            Date data_rezervare = new SimpleDateFormat("dd/MM/yyyy").parse(data[4].replace('.', '/'));
            Date data_efectuata = new SimpleDateFormat("dd/MM/yyyy").parse(data[5].replace('.', '/'));
            Programare nou = new Programare(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), data_rezervare, data_efectuata);

            lista.add(nou);
        }
        csvReader.close();
    }

    //endregion

    //region Write File

    public static void updateClientiFIle(List<Client> lista) throws IOException {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

        int nrLinii = countLines(new File("Data-Client.csv")) - 1;
        FileWriter csvWriter = new FileWriter("Data-Client.csv", true);

        for(int i = nrLinii; i < lista.size(); i++){
            csvWriter.append(String.valueOf(lista.get(i).getId())).append(String.valueOf(';')).append(lista.get(i).getNume()).append(String.valueOf(';')).append(lista.get(i).getPrenume()).append(String.valueOf(';')).append(String.valueOf(lista.get(i).getCardId())).append(String.valueOf(';')).append(String.valueOf(lista.get(i).getPuncte())).append(String.valueOf(';')).append(df.format(lista.get(i).getData_nastere())).append(String.valueOf(';')).append(lista.get(i).getMail()).append(String.valueOf(';')).append(lista.get(i).getTelefon());
            csvWriter.append('\n');
        }

        csvWriter.close();
    }

    //endregion

    //endregion
}
