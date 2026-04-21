package Interface;

import java.sql.SQLException;
import java.util.List;

public interface CrudFileInterface<T> {

    void writeToFile(T t) throws SQLException;

    T[] readFromFile() throws SQLException;
}
