package administrator;
import java.util.Date;

public class Programare implements Comparable<Programare> {
    private int id_programare;
    private int id_medic;
    private int id_client;
    private int id_serviciu;
    private Date data_ora_programare;
    private Date data_ora_efectuata;

    public Programare() {
    }

    public Programare(int id_medic, int id_client, int serviciu, Date data_ora_programare, Date data_ora_efectuata) {
        this.id_medic = id_medic;
        this.id_client = id_client;
        this.id_serviciu = serviciu;
        this.data_ora_programare = data_ora_programare;
        this.data_ora_efectuata = data_ora_efectuata;
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

    public Date getData_ora_programare() {
        return data_ora_programare;
    }

    public Date getData_ora_efectuata() {
        return data_ora_efectuata;
    }

    public void addData_efectuata(Date zi_ora){
        data_ora_efectuata = zi_ora;
    }

    public void updatemedic(int id_nou){
        id_medic = id_nou;
    }

    @Override
    public int compareTo(Programare o) {
        if (getData_ora_programare() == null || o.getData_ora_programare() == null){
            return  0;
        }
        return getData_ora_programare().compareTo(o.getData_ora_programare());
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

    public void setData_ora_programare(Date data_ora_programare) {
        this.data_ora_programare = data_ora_programare;
    }

    public void setData_ora_efectuata(Date data_ora_efectuata) {
        this.data_ora_efectuata = data_ora_efectuata;
    }
}

