package administrator;
import java.util.Date;

class Oferte {
    private int id_oferta;
    private String descriere;
    private Date data_expirare;
    private int puncte; // cate puncte se vor lua de la client daca
                       // beneficiaza de oferta


    public Oferte(String descriere, Date data_expirare, int puncte) {
        this.descriere = descriere;
        this.data_expirare = data_expirare;
        this.puncte = puncte;
    }

    public int getId_oferta() {
        return id_oferta;
    }

    public String getDescriere() {
        return descriere;
    }

    public Date getData_expirare() {
        return data_expirare;
    }

    public int getPuncte() {
        return puncte;
    }

    public void updateData_expirare(Date data_expirare) {
        this.data_expirare = data_expirare;
    }

    public void updatePuncte(int puncte) {
        this.puncte = puncte;
    }
}
