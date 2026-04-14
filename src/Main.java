import Controller.UserController;
import Model.User;

import java.sql.SQLException;

void main() throws SQLException {

    String menu = """
            1. New User
            2. Add User
            3. Update User
            4. Delete User
            5. Find User
            6. All Users
            """;
    System.out.print("Select the desired operation :  ");
    int menus = new Scanner(System.in).nextInt();
    UserController userController = new UserController();
    switch (menus) {
        case 1, 2:
            userController.create();
            break;
        case 3:
            userController.update();
            break;
        case 4:
            userController.delete();
            break;
            case 5:

    }
}
