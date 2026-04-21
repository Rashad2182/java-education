package Interface;

import Model.User;
import java.sql.SQLException;

/**
 * Burada bir İnterface yaratdıq və interface-lərin bütün method-ları bədənsiz olur ona görədə hamısı
 * ~implements~ olmağı tələb edir
 * İnterface-in kankret-method olmur hamısı bədənsizdir o üzdən hamısı ~implements~ tələb edir
 * İnterface method-ların hamısının qarşısına Java default olaraq (public abstract) yazılır
 * Interface digər Interface-dən ~extends~ edə bilər
 * ama İnterface içində ~default~ method-da ola bilər
 */

public interface CrudInterface {

    public void create() throws SQLException;

    public void update() throws SQLException;

    public void delete(int id) throws SQLException;

    public User getUser(int id) throws SQLException;

    public User[] getUsers(User[] users) throws SQLException;

    /**
     * ~default~ method
     */

    default void createTable() throws SQLException {
    }
}
