package administrator;
import java.util.Date;

public class Programare implements Comparable<Programare> {
    private int id_programare;
    private int id_medic;
    private int id_client;
    private int id_serviciu;
    private Date data_programare;
    private Date data_efectuata;

    public Programare() {
    }

    public Programare(int id_programare, int id_medic, int id_client, int serviciu, Date data_programare, Date data_efectuata) {
        this.id_programare = id_programare;
        this.id_medic = id_medic;
        this.id_client = id_client;
        this.id_serviciu = serviciu;
        this.data_programare = data_programare;
        this.data_efectuata = data_efectuata;
    }

    public int getServiciu() {
        return id_serviciu;
    }

    public int getId() {
        return id_programare;
    }

    public int getId_medic() {
        return id_medic;
    }

    public int getId_client() {
        return id_client;
    }

    public Date getData_programare() {
        return data_programare;
    }

    public Date getData_efectuata() {
        return data_efectuata;
    }

    public void addData_efectuata(Date zi_ora){
        data_efectuata = zi_ora;
    }

    public void updatemedic(int id_nou){
        id_medic = id_nou;
    }

    @Override
    public int compareTo(Programare o) {
        if (getData_programare() == null || o.getData_programare() == null){
            return  0;
        }
        return getData_programare().compareTo(o.getData_programare());
    }

    public void setId_programare(int id_programare) {
        this.id_programare = id_programare;
    }

    public void setId_medic(int id_medic) {
        this.id_medic = id_medic;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setId_serviciu(int id_serviciu) {
        this.id_serviciu = id_serviciu;
    }

    public void setData_programare(Date data_programare) {
        this.data_programare = data_programare;
    }

    public void setData_efectuata(Date data_efectuata) {
        this.data_efectuata = data_efectuata;
    }
}

