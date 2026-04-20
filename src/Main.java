import Controller.UserController;
import Interface.CrudInterface;
import Model.User;

import java.sql.SQLException;

void main() throws SQLException {

    CrudInterface crud = new UserController();

    while (true) {
        String menu = """
                1. New User
                2. Update User
                3. Delete User
                4. Find User
                5. All Users
                """;

        System.out.print("Select the desired operation :  ");
        int menus = new Scanner(System.in).nextInt();

        User[] users = new User[menus];

        switch (menus) {
            case 1:
                crud.create();
                break;
            case 2:
                crud.update();
                break;
            case 3:
                crud.delete();
                break;
            case 4:
                crud.getUser();
                break;
            case 5:
                crud.getUsers(users);
            default:
                break;
        }
    }
}
