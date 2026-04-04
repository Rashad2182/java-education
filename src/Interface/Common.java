package Interface;

import java.sql.SQLException;
import java.util.List;

public interface Common<T> {

    List<T> getList() throws SQLException;

    void writeToFile(List<T> t) throws SQLException;
}
