package administrator;

import com.sun.jdi.ClassType;

import java.io.*;
import java.lang.ref.Cleaner;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class ReadWriteCSV
{

    private static ReadWriteCSV single_instance = null;

    //region CSV

    //region Read Log File

    public static <T> void updateLogFile(T obiect, boolean tip) throws IOException {

        // tip = adevarat, daca e un update
        //       fals, daca e adaugare

        String logInfo = "create";
        if(tip)
            logInfo = "update";

        FileWriter csvWriter = new FileWriter("Log-File.csv", true);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        if(obiect instanceof Client){
            logInfo += "Client";
        }

        if(obiect instanceof Servicii){
            logInfo += "Servicii";
        }

        if(obiect instanceof Programare){
            logInfo += "Programare";
        }

        if(obiect instanceof Medici){
            logInfo += "Medici";
        }

        csvWriter.append(logInfo).append(',').append(timestamp.toString());
        csvWriter.append('\n');
    }

    //endregion

    //region Read From File

    public static <T> void ReadFromFile(List<T> lista, String numeFisier) throws IOException, ParseException {

        BufferedReader csvReader = new BufferedReader(new FileReader("Data-" + numeFisier + ".csv"));
        String row;
        // sar peste primul rand, cel cu coloane
        row = csvReader.readLine();

        while ((row = csvReader.readLine()) != null) {

            // nu inteleg de ce csv-ul meu are ; in loc de ,
            String[] data = row.split(";");

            // le iau pe cazuri pt ca trb sa pasez informatia diferit in functie de fiecare tip de clasa
            if(numeFisier.equals("Client")) {

                Date data_nastere = new SimpleDateFormat("dd/MM/yyyy").parse(data[5].replace('.', '/'));
                Client nou = new Client(data[1], data[2], data[6], data[7], Integer.parseInt(data[0]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), data_nastere);

                lista.add((T) nou);
            }

            if(numeFisier.equals("Medici")) {
                Medici nou = new Medici(data[1], data[2], data[4], data[5], Integer.parseInt(data[0]), Integer.parseInt(data[3]));

                lista.add((T) nou);
            }

            if(numeFisier.equals("Servicii")) {
                Servicii nou = new Servicii(Integer.parseInt(data[0]), data[1], Float.parseFloat(data[2]), Float.parseFloat(data[3]), Integer.parseInt(data[4]));

                lista.add((T) nou);
            }

            if(numeFisier.equals("Programare")) {
                Date data_rezervare = new SimpleDateFormat("dd/MM/yyyy").parse(data[4].replace('.', '/'));
                Date data_efectuata = new SimpleDateFormat("dd/MM/yyyy").parse(data[5].replace('.', '/'));
                Programare nou = new Programare(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), data_rezervare, data_efectuata);

                lista.add((T) nou);
            }

        }
        csvReader.close();
    }

    //endregion

    //region Read File fara functie generica

//    public static void readClientFromFile(List<Client> lista) throws IOException, ParseException {
//        BufferedReader csvReader = new BufferedReader(new FileReader("Data-Client.csv"));
//        String row;
//        // sar peste primul rand, cel cu coloane
//        row = csvReader.readLine();
//
//        while ((row = csvReader.readLine()) != null) {
//
//            // nu inteleg de ce csv-ul meu are ; in loc de ,
//            String[] data = row.split(";");
//
//            Date data_nastere = new SimpleDateFormat("dd/MM/yyyy").parse(data[5].replace('.', '/'));
//            Client nou = new Client(data[1], data[2], data[6], data[7], Integer.parseInt(data[0]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), data_nastere);
//
//            lista.add(nou);
//        }
//        csvReader.close();
//    }
//
//    public static void readMediciFromFile(List<Medici> lista) throws IOException, ParseException {
//        BufferedReader csvReader = new BufferedReader(new FileReader("Data-Medici.csv"));
//        String row;
//        // sar peste primul rand, cel cu coloane
//        row = csvReader.readLine();
//
//        while ((row = csvReader.readLine()) != null) {
//
//            // nu inteleg de ce csv-ul meu are ; in loc de ,
//            String[] data = row.split(";");
//
//            Medici nou = new Medici(data[1], data[2], data[4], data[5], Integer.parseInt(data[0]), Integer.parseInt(data[3]));
//
//            lista.add(nou);
//        }
//        csvReader.close();
//    }
//
//    public static void readServiciiFromFile(List<Servicii> lista) throws IOException, ParseException {
//        BufferedReader csvReader = new BufferedReader(new FileReader("Data-Servicii.csv"));
//        String row;
//        // sar peste primul rand, cel cu coloane
//        row = csvReader.readLine();
//
//        while ((row = csvReader.readLine()) != null) {
//
//            // nu inteleg de ce csv-ul meu are ; in loc de ,
//            String[] data = row.split(";");
//
//            Servicii nou = new Servicii(Integer.parseInt(data[0]), data[1], Float.parseFloat(data[2]), Float.parseFloat(data[3]), Integer.parseInt(data[4]));
//
//            lista.add(nou);
//        }
//        csvReader.close();
//    }
//
//    public static void readProgramareFromFile(List<Programare> lista) throws IOException, ParseException {
//        BufferedReader csvReader = new BufferedReader(new FileReader("Data-Programare.csv"));
//        String row;
//        // sar peste primul rand, cel cu coloane
//        row = csvReader.readLine();
//
//        while ((row = csvReader.readLine()) != null) {
//
//            // nu inteleg de ce csv-ul meu are ; in loc de ,
//            String[] data = row.split(";");
//
//            Date data_rezervare = new SimpleDateFormat("dd/MM/yyyy").parse(data[4].replace('.', '/'));
//            Date data_efectuata = new SimpleDateFormat("dd/MM/yyyy").parse(data[5].replace('.', '/'));
//            Programare nou = new Programare(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), data_rezervare, data_efectuata);
//
//            lista.add(nou);
//        }
//        csvReader.close();
//    }

    //endregion

    //region Write File fara generic

    public static void updateClientiFIle(List<Client> lista) throws IOException {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

        FileWriter csvWriter = new FileWriter("Data-Client.csv");

        for (Client client : lista) {
            csvWriter.append(String.valueOf(client.getId())).append(String.valueOf(';')).append(client.getNume()).append(String.valueOf(';')).append(client.getPrenume()).append(String.valueOf(';')).append(String.valueOf(client.getCardId())).append(String.valueOf(';')).append(String.valueOf(client.getPuncte())).append(String.valueOf(';')).append(df.format(client.getData_nastere())).append(String.valueOf(';')).append(client.getMail()).append(String.valueOf(';')).append(client.getTelefon());
            csvWriter.append('\n');
        }

        csvWriter.close();
    }

    public static void updateMediciFIle(List<Medici> lista) throws IOException {

        FileWriter csvWriter = new FileWriter("Data-Medici.csv");

        for (Medici medici : lista) {
            csvWriter.append(String.valueOf(medici.getId())).append(String.valueOf(';')).append(medici.getNume()).append(String.valueOf(';')).append(medici.getPrenume()).append(String.valueOf(';')).append(String.valueOf(medici.getId_salon())).append(String.valueOf(';')).append(medici.getMail()).append(String.valueOf(';')).append(medici.getTelefon());
            csvWriter.append('\n');
        }

        csvWriter.close();
    }

    public static void updateProgramariFIle(List<Programare> lista) throws IOException {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

        FileWriter csvWriter = new FileWriter("Data-Programare.csv");

        for (Programare programare : lista) {
            csvWriter.append(String.valueOf(programare.getId())).append(String.valueOf(';')).append(String.valueOf(programare.getId_medic())).append(String.valueOf(';')).append(String.valueOf(programare.getId_client())).append(String.valueOf(';')).append(String.valueOf(programare.getServiciu())).append(String.valueOf(';')).append(df.format(programare.getData_programare())).append(String.valueOf(';')).append(df.format(programare.getData_efectuata()));
            csvWriter.append('\n');
        }

        csvWriter.close();
    }

    public static void updateServiciiFIle(List<Servicii> lista) throws IOException {
        FileWriter csvWriter = new FileWriter("Data-Servicii.csv");

        for (Servicii servicii : lista) {
            csvWriter.append(String.valueOf(servicii.getId())).append(String.valueOf(';')).append(servicii.getDenumire()).append(String.valueOf(';')).append(String.valueOf(servicii.getPret())).append(String.valueOf(';')).append(String.valueOf(servicii.getDurata())).append(String.valueOf(';')).append(String.valueOf(servicii.getPuncte()));
            csvWriter.append('\n');
        }

        csvWriter.close();
    }

    //endregion

    //endregion

    private ReadWriteCSV(List<Programare> programari, List<Client> clienti, List<Servicii> servicii, List<Medici> medici) throws IOException, ParseException {
        ReadFromFile(programari, "Programare");
        ReadFromFile(servicii, "Servicii");
        ReadFromFile(clienti, "Client");
        ReadFromFile(medici, "Medici");
    }

    public static ReadWriteCSV getInstance(List<Programare> programari, List<Client> clienti, List<Servicii> servicii, List<Medici> medici) throws IOException, ParseException {
        if (single_instance == null)
            single_instance = new ReadWriteCSV(programari, clienti, servicii, medici);

        return single_instance;
    }
}
