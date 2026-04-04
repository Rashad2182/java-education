package Controller;

import Interface.UserInterface;
import Model.User;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Burada Controller yaratdıq və İnterface-i ~implements~ etdik
 * bu Controller içində nə işlər görəcəyimizi yazacıq
 * silmək əməliyyatı
 * yeniləmək əməliyyatı
 * yeni User yaratmaq əməliyyatı
 * bütün bunları Controller içərisində həyata keçiririk
 */

public class UserController implements UserInterface {

    @Override
    public void create() throws SQLException {

        System.out.println();

        User user = new User();
        System.out.print("A.S.A daxil edin : ");
        user.setUsername(new Scanner(System.in).nextLine());
        System.out.print("Email address daxil edin : ");
        user.setEmail(new Scanner(System.in).nextLine());
        System.out.print("Password daxil edin : ");
        user.setPassword(new Scanner(System.in).nextLine());
        System.out.print("Role daxil edin : ");
        user.setRole(new Scanner(System.in).nextLine());

        System.out.println();

        System.out.println("Yeni İstifadəçi yaradıldı ->" + "\n");
        System.out.println(user.toString());
    }

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
