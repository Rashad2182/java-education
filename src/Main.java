import Controller.UserController;

import java.sql.SQLException;

void main() throws SQLException {

    UserController userController = new UserController();

    userController.create();
}
