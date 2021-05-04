package administrator;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class ReadWriteCSV
{

    private static ReadWriteCSV single_instance = null;

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

    public static void updateMediciFIle(List<Medici> lista) throws IOException {

        int nrLinii = countLines(new File("Data-Medici.csv")) - 1;
        FileWriter csvWriter = new FileWriter("Data-Medici.csv", true);

        for(int i = nrLinii; i < lista.size(); i++){
            csvWriter.append(String.valueOf(lista.get(i).getId())).append(String.valueOf(';')).append(lista.get(i).getNume()).append(String.valueOf(';')).append(lista.get(i).getPrenume()).append(String.valueOf(';')).append(String.valueOf(lista.get(i).getId_salon())).append(String.valueOf(';')).append(lista.get(i).getMail()).append(String.valueOf(';')).append(lista.get(i).getTelefon());
            csvWriter.append('\n');
        }

        csvWriter.close();
    }

    public static void updateProgramariFIle(List<Programare> lista) throws IOException {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

        int nrLinii = countLines(new File("Data-Programare.csv")) - 1;
        FileWriter csvWriter = new FileWriter("Data-Programare.csv", true);

        for(int i = nrLinii; i < lista.size(); i++){
            csvWriter.append(String.valueOf(lista.get(i).getId())).append(String.valueOf(';')).append(String.valueOf(lista.get(i).getId_medic())).append(String.valueOf(';')).append(String.valueOf(lista.get(i).getId_client())).append(String.valueOf(';')).append(String.valueOf(lista.get(i).getServiciu())).append(String.valueOf(';')).append(df.format(lista.get(i).getData_programare())).append(String.valueOf(';')).append(df.format(lista.get(i).getData_efectuata()));
            csvWriter.append('\n');
        }

        csvWriter.close();
    }

    public static void updateServiciiFIle(List<Servicii> lista) throws IOException {
        int nrLinii = countLines(new File("Data-Servicii.csv")) - 1;
        FileWriter csvWriter = new FileWriter("Data-Servicii.csv", true);

        for(int i = nrLinii; i < lista.size(); i++){
            csvWriter.append(String.valueOf(lista.get(i).getId())).append(String.valueOf(';')).append(lista.get(i).getDenumire()).append(String.valueOf(';')).append(String.valueOf(lista.get(i).getPret())).append(String.valueOf(';')).append(String.valueOf(lista.get(i).getDurata())).append(String.valueOf(';')).append(String.valueOf(lista.get(i).getPuncte()));
            csvWriter.append('\n');
        }

        csvWriter.close();
    }

    //endregion

    //endregion

    private ReadWriteCSV(List<Programare> programari, List<Client> clienti, List<Servicii> servicii, List<Medici> medici) throws IOException, ParseException {
        readClientFromFile(clienti);
        readMediciFromFile(medici);
        readServiciiFromFile(servicii);
        readProgramareFromFile(programari);
    }

    public static ReadWriteCSV getInstance(List<Programare> programari, List<Client> clienti, List<Servicii> servicii, List<Medici> medici) throws IOException, ParseException {
        if (single_instance == null)
            single_instance = new ReadWriteCSV(programari, clienti, servicii, medici);

        return single_instance;
    }
}
