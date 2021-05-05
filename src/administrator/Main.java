package administrator;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static administrator.Service.*;


public class Main {


    public static void main(String[] args) throws ParseException, IOException {

        List<Medici> medici = new ArrayList<>();
        List<Client> clienti = new ArrayList<>();
        List<Cos> cosuri = new ArrayList<>();
        List<Oferte> oferte = new ArrayList<>();
        List<Produse> produse = new ArrayList<>();
        List<Programare> programari = new ArrayList<>();
        List<Cabinet> cabinete = new ArrayList<>();
        List<Servicii> servicii = new ArrayList<>();
        List<Stoc> stocuri = new ArrayList<>();

        ReadWriteCSV Singleton = ReadWriteCSV.getInstance(programari, clienti, servicii, medici);

        boolean menu = true;
        while (menu) {

            System.out.print("Press ENTER to continue.");

            int optiune;
            Scanner sc = new Scanner(System.in);

            // astept un ENTER de la tastatura pentru a continua
            sc.nextLine();

            print_menu();

            optiune = sc.nextInt();

            clearScreen();

            switch (optiune) {
                case 0: {
                    menu = false;

                    ReadWriteCSV.updateClientiFIle(clienti);
                    ReadWriteCSV.updateMediciFIle(medici);
                    ReadWriteCSV.updateProgramariFIle(programari);
                    ReadWriteCSV.updateServiciiFIle(servicii);

                    break;
                }
                case 1: {
                    if (programari.size() == 0) {
                        System.out.println("Nu mai sunt programari!");
                    } else {

                        //sortez programarile dupa data
                        Collections.sort(programari);
                        for (Programare elem : programari) {
                            System.out.println("id_serviciu: " + findServiciuNameById(servicii, elem.getServiciu()));
                            System.out.println("data programare: " + elem.getData_programare());
                            System.out.println("Medic: " + findMedicNameById(medici, elem.getId_medic()));
                            System.out.println("Client: " + findClientNameById(clienti, elem.getId_client()));
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
                        String dataFormat = sc.next();

                        Date data_programare = new SimpleDateFormat("dd/MM/yyyy").parse(dataFormat.replace('-','/'));
                        new_programare.setData_programare(data_programare);

                        programari.add(new_programare);

                        ReadWriteCSV.updateLogFile(new_programare, true, 2);

                        break;
                    }
                }
                case 3: {

                    System.out.print("Id-ul programarii de actalizat: ");
                    int id = sc.nextInt();
                    int toChange = findProgramareById(programari, id);

                    String zi, luna, an;
                    System.out.println("Data (zz-ll-aaaa): ");
                    String dataFormat = sc.next();

                    Date data_programare = new SimpleDateFormat("dd/MM/yyyy").parse(dataFormat.replace('-', '/'));
                    programari.get(toChange).setData_programare(data_programare);

                    ReadWriteCSV.updateLogFile(toChange, true, 2);

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
                    if (produse.size() == 0) {
                        System.out.println("Inca nu vindem produse!");
                    } else {
                        for (Produse elem : produse) {
                            System.out.println(elem.getNume());
                            System.out.println(elem.getPret_vanzare());
                            System.out.println(elem.getPret());
                            System.out.println();
                        }
                    }
                    break;
                }
                case 6: {
                    System.out.print("Numele-ul produsului cautat: ");
                    String nume = sc.next();
                    Produse elem = findProdusByName(produse, nume);
                    assert elem != null;
                    System.out.println(elem.getNume());
                    System.out.println(elem.getPret_vanzare());
                    System.out.println(elem.getPret());
                    break;
                }
                case 7: {
                    System.out.print("Numele-ul produsului cautat: ");
                    String nume = sc.next();
                    int elem = findProdusByName_int(produse, nume);
                    System.out.print("Cate produse adaugam in stoc: ");
                    int nr = sc.nextInt();
                    produse.get(elem).addNr_produse(nr);

                    break;
                }
                case 8: {

                    String nume, cod_bare;
                    float pret, pret_vanzare;
                    int nr_produse;

                    System.out.print("Nume: ");
                    nume = sc.next();
                    System.out.print("Cod_bare: ");
                    cod_bare = sc.next();
                    System.out.print("Pret_vanzare: ");
                    pret_vanzare = sc.nextFloat();
                    System.out.print("Pret: ");
                    pret = sc.nextFloat();
                    System.out.print("Nr_produse: ");
                    nr_produse = sc.nextInt();
                    Produse new_produs = new Produse(cod_bare, nume, pret, pret_vanzare, nr_produse);

                    produse.add(new_produs);
                    break;
                }
                case 9: {
                    System.out.print("Numele-ul produsului de modificat: ");
                    String nume = sc.next();
                    int elem = findProdusByName_int(produse, nume);

                    float new_pret;
                    System.out.print("Noul pret de vanzare: ");
                    new_pret = sc.nextFloat();

                    produse.get(elem).setPret_vanzare(new_pret);

                    break;
                }
                case 10:{
                    System.out.print("Numele-ul produsului de modificat: ");
                    String nume = sc.next();
                    int elem = findProdusByName_int(produse, nume);

                    float new_pret;
                    System.out.print("Noul pret de cumparare: ");
                    new_pret = sc.nextFloat();

                    produse.get(elem).setPret(new_pret);

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
                    prenume = sc.next();

                    System.out.print("Nume: ");
                    nume = sc.next();

                    System.out.print("Data nasterii (zz-ll-aaaa): ");
                    String dataFormat = sc.next();
                    Date data_nastere = new SimpleDateFormat("dd/MM/yyyy").parse(dataFormat.replace('-','/'));

                    System.out.print("Email: ");
                    mail = sc.next();

                    System.out.print("Telefon: ");
                    telefon = sc.next();

                    Client nou = new Client(nume, prenume, mail, telefon, clienti.size()+1, clienti.size()+1, 0, data_nastere);
                    clienti.add(nou);

                    ReadWriteCSV.updateLogFile(nou, false, 0);

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
                    prenume = sc.next();

                    System.out.print("Nume: ");
                    nume = sc.next();

                    System.out.print("Email: ");
                    mail = sc.next();

                    System.out.print("Telefon: ");
                    telefon = sc.next();

                    Medici nou = new Medici(nume, prenume, mail, telefon, medici.size()+1, id_salon);
                    medici.add(nou);

                    ReadWriteCSV.updateLogFile(nou, false, 3);

                    break;
                }

                case 22: {
                    for(Servicii elem: servicii){
                        System.out.println("Denumire: " + elem.getDenumire());
                        System.out.println("Pret: " + elem.getPret());
                        System.out.println("Durata: " + elem.getDurata());
                        System.out.println("Puncte: " + elem.getPuncte());
                        System.out.println("--------------");
                        System.out.println();
                    }
                    break;
                }

                case 24: {
                    String denumire;
                    int puncte;
                    int pret;
                    int durata;

                    System.out.print("Denumirea serviciului: ");
                    denumire = sc.next();

                    System.out.print("Pret: ");
                    pret = sc.nextInt();

                    System.out.print("Durata: ");
                    durata = sc.nextInt();

                    System.out.print("Cate puncte valoreaza: ");
                    puncte = sc.nextInt();

                    Servicii nou = new Servicii(servicii.size()+1, denumire, pret, durata, puncte);
                    servicii.add(nou);

                    ReadWriteCSV.updateLogFile(nou, false, 1);
                }
            }
        }
    }
}
