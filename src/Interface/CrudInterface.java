package Interface;

import Model.User;

import java.sql.SQLException;
import java.util.List;

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

    public void delete() throws SQLException;

    public User getUser() throws SQLException;

    public List<User> getUsers() throws SQLException;

    /**
     * ~default~ method
     */

    default void createTable() throws SQLException {
    }
}
