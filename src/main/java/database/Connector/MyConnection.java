package database.Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private static Connection con;

    private static String driver = "org.postgresql.Driver";
    final static String useru = "admin";
    final static String password = "12345";
    final static String url = "jdbc:postgresql://192.168.1.105:5432/demodb";

    public  MyConnection(){}

    public static Connection openConnection() throws ClassNotFoundException, SQLException {

        if(con==null){

            Class.forName(driver);
            con = DriverManager.getConnection(url, useru, password);
        }

        return con;

    }

    public static void closeConnection()throws SQLException{

        if(con!=null){

            con.close();
        }
        con = null;
    }
}
