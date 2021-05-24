package administrator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class Client extends Om {
    private int id_client;
    private int id_card;
    private int puncte;
    private Date data_nastere;

    public Client() {
    }

    public Client(String nume, String prenume, String mail, String telefon, int id_client, int id_card, int puncte, Date data_nastere) {
        super(nume, prenume, mail, telefon);
        this.id_client = id_client;
        this.id_card = id_card;
        this.puncte = puncte;
        this.data_nastere = data_nastere;
    }

    public int getId(){
        return id_client;
    }

    public int getCardId(){
        return id_card;
    }

    public int getPuncte() {
        return puncte;
    }

    public Date getData_nastere() {
        return data_nastere;
    }

    public void addPuncte(int nr){
        puncte+=nr;
    }

    public void addCard(int nr){
        id_card = nr;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    public void setPuncte(int puncte) {
        this.puncte = puncte;
    }

    public void setData_nastere(Date data_nastere) {
        this.data_nastere = data_nastere;
    }


}
