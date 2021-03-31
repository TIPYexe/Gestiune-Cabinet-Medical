package administrator;
import java.util.Date;

class Cos {
    private int id_cos;
    private int id_client;
    private Date data_achizitie;

    public Cos(int id_client, Date data_achizitie) {
        this.id_client = id_client;
        this.data_achizitie = data_achizitie;
    }

    public int getId_cos() {
        return id_cos;
    }

    public int getId_client() {
        return id_client;
    }

    public Date getData_achizitie() {
        return data_achizitie;
    }
}
