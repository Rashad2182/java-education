package Interface;

import java.sql.SQLException;
import java.util.List;

public interface CrudFileInterface<T> {

    void writeToFile(List<T> t) throws SQLException;

    List<T> readFromFile() throws SQLException;
}
