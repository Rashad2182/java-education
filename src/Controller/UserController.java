package Controller;

import Interface.CrudFileInterface;
import Interface.CrudInterface;
import Model.User;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Burada Controller yaratdıq və İnterface-i ~implements~ etdik
 * bu Controller içində nə işlər görəcəyimizi yazacıq
 * silmək əməliyyatı
 * yeniləmək əməliyyatı
 * yeni User yaratmaq əməliyyatı
 * bütün bunları Controller içərisində həyata keçiririk
 */

public class UserController implements CrudFileInterface<User>, CrudInterface {

    private static final String FILE_NAME = "Status.txt";

    private User user;

    @Override
    public void writeToFile(List<User> user) throws SQLException {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_NAME)))) {
            out.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> readFromFile() throws SQLException {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILE_NAME)))) {
            return (List<User>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void create() throws SQLException {

        System.out.println();

        System.out.print("A.S.A daxil edin : ");
        user.setUsername(new Scanner(System.in).nextLine());
        System.out.print("Email address daxil edin : ");
        user.setEmail(new Scanner(System.in).nextLine());
        System.out.print("Password daxil edin : ");
        user.setPassword(new Scanner(System.in).nextLine());
        System.out.print("Role daxil edin : ");
        user.setRole(new Scanner(System.in).nextLine());

        System.out.println();

        System.out.println("Yeni İstifadəçi yaradıldı : " + "\n");
        System.out.println(user.toString());
    }

    @Override
    public void update() throws SQLException {
        System.out.println();
        if (user.getId() == -1) {
            user.setUsername(new Scanner(System.in).nextLine());
            user.setEmail(new Scanner(System.in).nextLine());
            user.setPassword(new Scanner(System.in).nextLine());
            user.setRole(new Scanner(System.in).nextLine());
        }
        System.out.println(user.toString());
    }

    @Override
    public void delete() throws SQLException {

    }

    @Override
    public User getUser() throws SQLException {
        return null;
    }

    @Override
    public List<User> getUsers() throws SQLException {
        return List.of();
    }
}
