package database;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;

public class GenerateDB {

    public static void Generator(Connection conn) throws FileNotFoundException {
        ScriptRunner sr = new ScriptRunner(conn);
        Reader reader = new BufferedReader(new FileReader("src/DataBase/Script.sql"));
        sr.runScript(reader);
    }

    public static void InsertData(Connection conn) throws FileNotFoundException {
        ScriptRunner sr = new ScriptRunner(conn);
        Reader reader = new BufferedReader(new FileReader("src/DataBase/INSERTURI.sql"));
        sr.runScript(reader);
    }

}
