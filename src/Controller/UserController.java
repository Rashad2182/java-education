package Controller;
import Interface.UserInterface;
import java.sql.SQLException;

/**
 * Burada Controller yaratdıq və İnterface-i ~implements~ etdik
 * bu Controller içində nə işlər görəcəyimizi yazacıq
 * silmək əməliyyatı
 * yeniləmək əməliyyatı
 * yeni User yaratmaq əməliyyatı
 * bütün bunları Controller içərisində həyata keçiririk
 */

public class UserController implements UserInterface {

    /**
     * Bu method içərisində yeni User yaradacıyıq
     */

    @Override
    public void create() throws SQLException {

    }

    /**
     * Bu method içərisində
     */

    @Override
    public void edit() throws SQLException {

    }

    @Override
    public void show() throws SQLException {

    }

    @Override
    public void update() throws SQLException {

    }

    @Override
    public void delete() throws SQLException {

    }
}
