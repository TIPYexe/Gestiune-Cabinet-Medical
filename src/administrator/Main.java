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
                            System.out.println(findMedicById(medici, elem.getId_medic()));
                            System.out.println(findClientById(clienti, elem.getId_client()));
                            System.out.println();
                        }

                    }
                    break;
                }
                case 2: {

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
                    System.out.print("Zi: ");
                    zi = sc.nextInt();
                    System.out.print("Luna: ");
                    luna = sc.nextInt();
                    System.out.print("Anul: ");
                    an = sc.nextInt();

                    Date data_programare = new SimpleDateFormat("dd/MM/yyyy").parse(Integer.toString(zi) + '/' + Integer.toString(luna) + '/' + Integer.toString(an));
                    new_programare.setData_ora_programare(data_programare);

                    programari.add(new_programare);

                    break;
                }
                case 3: {

                    System.out.print("Id-ul programarii de actalizat: ");
                    int id = sc.nextInt();
                    int toChange = findProgramareById(programari, id);

                    int zi, luna, an;
                    System.out.print("Zi: ");
                    zi = sc.nextInt();
                    System.out.print("Luna: ");
                    luna = sc.nextInt();
                    System.out.print("Anul: ");
                    an = sc.nextInt();

                    Date data_programare = new SimpleDateFormat("dd/MM/yyyy").parse(Integer.toString(zi) + '/' + Integer.toString(luna) + '/' + Integer.toString(an));
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
                }
                    break;
            }
        }
    }
}
