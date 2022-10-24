package htl.steyr.bank_account.model;

import org.postgresql.Driver;

import java.sql.*;

public class Database {

    private String host = "localhost";
    private String user = "4ahitn";
    private String db = "4ahitn";
    private String password = "4ahitn";
    private int port = 4306;
    private String driverType = "mysql";

    private static Connection connection = null;

    static{//wird beim Laden einer Klasse aufgerufen
        try {//ein nicht-statischer Block wird beim initialisieren aufgerufen.
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Database(){
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:" + driverType + "://" + host + ":" + port + "/" + db + "?useSSL=false",
                    user,
                    password);
            connection = c;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if (connection == null){
            new Database();
        }

        return connection;
    }

}
