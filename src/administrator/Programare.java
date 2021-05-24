package administrator;
import java.util.Date;
import java.sql.*;

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

    public void loadProgramari(Programare nou) throws ClassNotFoundException, SQLException {
        String myDriver = "org.gjt.mm.mysql.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/cabinet-medical";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "");

        // our SQL SELECT query.
        // if you only need a few columns, specify them by name instead of using "*"
        String query = "SELECT * FROM programari";

        // create the java statement
        Statement st = conn.createStatement();

        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);

        // iterate through the java resultset
        while (rs.next())
        {
            setId_programare(rs.getInt("id_programare"));
            setId_medic(rs.getInt("id_medic"));
            setId_serviciu(rs.getInt("id_serviciu"));
            setData_ora_programare(rs.getString("data_ora_programare"));
            setData_ora_efectuata(rs.getString("data_ora_efectuata"));
            Date dateCreated = rs.getDate("date_created");
            boolean isAdmin = rs.getBoolean("is_admin");
            int numPoints = rs.getInt("num_points");

            // print the results
            System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
        }
        st.close();
    }
}

