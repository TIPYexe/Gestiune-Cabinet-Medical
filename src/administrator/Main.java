package administrator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static administrator.Service.*;


public class Main {


    public static void main(String[] args) throws ParseException {

        List<Medici> medici = new ArrayList<>();
        List<Client> clienti = new ArrayList<>();
        List<Cos> cosuri = new ArrayList<>();
        List<Oferte> oferte = new ArrayList<>();
        List<Produse> produse = new ArrayList<>();
        List<Programare> programari = new ArrayList<>();
        List<Cabinet> cabinete = new ArrayList<>();
        List<Servicii> servicii = new ArrayList<>();
        List<Stoc> stocuri = new ArrayList<>();

        boolean menu = true;
        while (menu) {

            print_menu();

            int optiune;
            Scanner sc = new Scanner(System.in);
            optiune = sc.nextInt();

            clearScreen();

            switch (optiune) {
                case 0: {
                    menu = false;
                    break;
                }

                case 1: {
                    if (programari.size() == 0) {
                        System.out.println("Nu mai sunt programari!");
                    } else {

                        //sortez programarile dupa data
                        Collections.sort(programari);
                        for (Programare elem : programari) {
                            System.out.println(elem.getServiciu());
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

                case 5: {

                    break;
                }

                case 6: {

                    break;
                }

                case 7: {

                    break;
                }

                case 8: {

                    break;
                }

                case 9: {

                    break;
                }

                case 10: {

                    break;
                }

                case 11:{
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

                case 12: {
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

                case 13: {
                    String nume, prenume, data, mail, telefon;
                    int zi, luna, an;

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

                case 17: {
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

                case 18: {
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

                case 19: {

                    String nume, prenume, data, mail, telefon;
                    int zi, luna, an, id_salon;

                    System.out.print("ID-ul salonului la care lucreaza: ");
                    id_salon = sc.nextInt();

                    System.out.print("Prenume: ");
                    prenume = sc.nextLine();

                    System.out.print("Nume: ");
                    nume = sc.nextLine();

                    System.out.print("Email: ");
                    mail = sc.nextLine();

                    System.out.print("Telefon: ");
                    telefon = sc.nextLine();

                    Medici nou = new Medici(nume, prenume, mail, telefon, medici.size(), id_salon);
                    medici.add(nou);

                    break;
                }
            }
        }
    }
}
