package Abstract;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Burada bir Abstract Class yaradırıq hansıki özündə DataBase bağlantısı saxlayır
 */

public abstract class DataBaseConnect {
    private static final String url = "jdbc:mysql://localhost:3306/databaseName";  // axırda database adı yazmalısan , yaratdığın DataBase-in adını
    private static final String username = "root";
    private static final String password = "";

    /**
     * Bu method Abstract method-dur (kankret method) və bu methodu istəsən @Override edə bilərsən Class-ı extends etməklə
     */

    public Connection getConnect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * Bu method isə abstract method-lardır və bunları ~implements~ edirsən
     */

    public abstract void connect() throws ClassNotFoundException, SQLException;

    /**
     *  Bədənsiz method-u ~implements~ edirsən (Kankret method) bədəni olanı isə əzirsən @Override edirsən
     */
}
