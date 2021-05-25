package administrator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static administrator.Service.*;


public class Main {


    public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {

        String myUrl = "jdbc:mysql://localhost:3306/cabinet-medical";

        Connection conn = DriverManager.getConnection(myUrl, "root", "");

        Statement st = conn.createStatement();

        List<Medici> medici = new ArrayList<>();
        List<Client> clienti = new ArrayList<>();
        List<Cos> cosuri = new ArrayList<>();
        List<Oferte> oferte = new ArrayList<>();
        List<Produse> produse = new ArrayList<>();
        List<Programare> programari = new ArrayList<>();
        List<Cabinet> cabinete = new ArrayList<>();
        List<Servicii> servicii = new ArrayList<>();
        List<Stoc> stocuri = new ArrayList<>();

        //region Citim din fisiere si incarcam in liste
        loadProgramari(programari, st);
        loadClienti(clienti, st);
        loadMedici(medici, st);
        loadServicii(servicii, st);

        //endregion

        boolean menu = true;
        while (menu) {
            System.out.println("Press any key to continue...");

            int optiune;
            Scanner sc = new Scanner(System.in);

            // fac asta ca sa nu mai dea clear screen imediat dupa ce termina
            // de executat functiile.
            sc.nextLine();

            print_menu();
            optiune = sc.nextInt();
            clearScreen();

            switch (optiune) {
                case 0: {
                    menu = false;
                    st.close();
                    break;
                }

                case 1: {
                    if (programari.size() == 0) {
                        System.out.println("Nu mai sunt programari!");
                    } else {

                        //sortez programarile dupa data
                        Collections.sort(programari);
                        for (Programare elem : programari) {
                            System.out.println(elem.getId_serviciu());
                            System.out.println(elem.getData_ora_programare());
                            System.out.println(findMedicNameById(medici, elem.getId_medic()));
                            System.out.println(findClientNameById(clienti, elem.getId_client()));
                            System.out.println();
                        }

                    }
                    break;
                }

                case 2: {

                    if(medici.size() == 0){
                        System.out.println("Nu avem niciun angajat!");
                    }
                    else {
                        Programare new_programare = new Programare();

                        System.out.print("id-medic: ");
                        int id = sc.nextInt();
                        new_programare.setId_medic(id);

                        System.out.print("id-client: ");
                        id = sc.nextInt();
                        new_programare.setId_client(id);

                        System.out.print("id-serviciu: ");
                        id = sc.nextInt();
                        new_programare.setId_serviciu(id);

                        int zi, luna, an;
                        System.out.println("Data (zz-ll-aaaa): ");
                        String dataFormat = sc.nextLine();

                        Date data_programare = new SimpleDateFormat("dd/MM/yyyy").parse(dataFormat.replace('-','/'));
                        new_programare.setData_ora_programare(data_programare);

                        programari.add(new_programare);

                        break;
                    }
                }

                case 3: {

                    System.out.print("Id-ul programarii de actalizat: ");
                    int id = sc.nextInt();
                    int toChange = findProgramareById(programari, id);

                    String zi, luna, an;
                    System.out.println("Data (zz-ll-aaaa): ");
                    String dataFormat = sc.nextLine();

                    Date data_programare = new SimpleDateFormat("dd/MM/yyyy").parse(dataFormat.replace('-', '/'));
                    programari.get(toChange).setData_ora_programare(data_programare);

                    break;
                }

                case 4: {
                    System.out.print("Id-ul programarii de actalizat: ");
                    int id = sc.nextInt();
                    int toChange = findProgramareById(programari, id);

                    System.out.print("id-medic: ");
                    id = sc.nextInt();
                    programari.get(toChange).setId_medic(id);

                    break;
                }

                case 5:{
                    if(clienti.size() == 0)
                        System.out.println("Nu am avut niciun client pana acum!");
                    else {
                        for (Client elem : clienti) {
                            System.out.println("Nume: " + elem.getNume() + " " + elem.getPrenume());
                            System.out.println("Data nastere: " + elem.getData_nastere());
                            System.out.println("Puncte: " + elem.getPuncte());
                            System.out.println("email: " + elem.getMail());
                            System.out.println("Telefon: " + elem.getTelefon());
                            System.out.println("------------------");
                        }
                    }

                    break;
                }

                case 6: {
                    System.out.print("Introduceti id-ul clientului: ");
                    int id = sc.nextInt();
                    int index = findClientById(clienti, id);
                    System.out.println("Nume: " + clienti.get(index).getNume() + " " + clienti.get(index).getPrenume());
                    System.out.println("Data nastere: " + clienti.get(index).getData_nastere());
                    System.out.println("Puncte: " + clienti.get(index).getPuncte());
                    System.out.println("email: " + clienti.get(index).getMail());
                    System.out.println("Telefon: " + clienti.get(index).getTelefon());

                    break;
                }

                case 7: {
                    String nume, prenume, mail, telefon;

                    System.out.print("Prenume: ");
                    prenume = sc.nextLine();

                    System.out.print("Nume: ");
                    nume = sc.nextLine();

                    System.out.print("Data nasterii (zz-ll-aaaa): ");
                    String dataFormat = sc.nextLine();
                    Date data_nastere = new SimpleDateFormat("dd/MM/yyyy").parse(dataFormat.replace('-','/'));

                    System.out.print("Email: ");
                    mail = sc.nextLine();

                    System.out.print("Telefon: ");
                    telefon = sc.nextLine();

                    Client nou = new Client(nume, prenume, mail, telefon, clienti.size(), clienti.size(), 0, data_nastere);
                    clienti.add(nou);

                    break;
                }

                case 10: {
                    if(medici.size() == 0)
                        System.out.println("Nu avem niciun angajat!");
                    else {
                        for (Medici elem : medici) {
                            System.out.println("Nume: " + elem.getNume() + " " + elem.getPrenume());
                            System.out.println("email: " + elem.getMail());
                            System.out.println("Telefon: " + elem.getTelefon());
                            System.out.println("------------------");
                        }
                    }

                    break;
                }

                case 11: {
                    System.out.print("Introduceti id-ul medicului: ");
                    int id = sc.nextInt();
                    int index = findClientById(clienti, id);
                    System.out.println("Nume: " + clienti.get(index).getNume() + " " + clienti.get(index).getPrenume());
                    System.out.println("Data nastere: " + clienti.get(index).getData_nastere());
                    System.out.println("Puncte: " + clienti.get(index).getPuncte());
                    System.out.println("email: " + clienti.get(index).getMail());
                    System.out.println("Telefon: " + clienti.get(index).getTelefon());

                    break;
                }

                case 12: {

                    String nume, prenume,  mail, telefon;
                    int id_cabinet;

                    System.out.print("ID-ul cabinetului la care lucreaza: ");
                    id_cabinet = sc.nextInt();

                    System.out.print("Prenume: ");
                    prenume = sc.nextLine();

                    System.out.print("Nume: ");
                    nume = sc.nextLine();

                    System.out.print("Email: ");
                    mail = sc.nextLine();

                    System.out.print("Telefon: ");
                    telefon = sc.nextLine();

                    Medici nou = new Medici(nume, prenume, mail, telefon, medici.size(), id_cabinet);
                    medici.add(nou);

                    break;
                }

                case 15: {
                    for(Servicii elem:servicii){
                        System.out.println("ID: " + elem.getId_serviciu());
                        System.out.println("Pret: " + elem.getPret());
                        System.out.println("Durata: " + elem.getDurata());
                        System.out.println("Puncte: " + elem.getPuncte());
                    }
                    break;
                }
            }
        }
    }
}
