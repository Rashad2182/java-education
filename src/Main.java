import Controller.UserController;
import Interface.CrudInterface;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

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

            switch (menus) {
                case 1:
                    crud.create();
                    break;
                case 2:
                    crud.update();
                    break;
                case 3:
                    System.out.print("Enter the ID number of the user you want to delete : ");
                    int deleteId = new Scanner(System.in).nextInt();
                    crud.delete(deleteId);
                    break;
                case 4:
                    System.out.print("Type the ID number of the user you want to find : ");
                    int getId = new Scanner(System.in).nextInt();
                    crud.getUser(getId);
                    break;
                case 5:
                    //crud.getUsers();
                default:
                    break;
            }
        }
    }
}
