package Controller;

import Interface.CrudFileInterface;
import Interface.CrudInterface;
import Model.User;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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

    private static final String FILE_NAME = "Users.txt";

    private User[] users;

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

    private int idCount = 1;

    private User createUser() {
        System.out.println();
        User user = new User();
        user.setId(idCount++);
        System.out.print("Enter name  :  ");
        user.setUsername(new Scanner(System.in).nextLine());
        System.out.print("Enter email :  ");
        user.setEmail(new Scanner(System.in).nextLine());
        System.out.print("Enter password :  ");
        user.setPassword(new Scanner(System.in).nextLine());
        System.out.print("Enter status :  ");
        user.setStatus(new Scanner(System.in).nextInt());
        if (user.getStatus() < 1 || user.getStatus() > 2) {
            System.out.println("Invalid role");
        }
        return user;
    }

    @Override
    public void create() throws SQLException {
        System.out.print("How many users will you create?  :  ");
        int additionalCount = new Scanner(System.in).nextInt();
        if (users == null) {
            users = new User[additionalCount];
            for (int i = 0; i < additionalCount; i++) {
                System.out.println();
                users[i] = createUser();
            }
        } else if (users != null) {
            User[] newUsers = new User[users.length + additionalCount];
            for (int i = 0; i < users.length; i++) {
                System.out.println();
                newUsers[i] = users[i];
            }
            for (int i = users.length; i < newUsers.length; i++) {
                System.out.println();
                newUsers[i] = createUser();
            }
            users = newUsers;
        }
        System.out.println("\n");
        getUsers(users);
    }

    @Override
    public void update() throws SQLException {
        for (int i = 0; i < users.length; i++) {

        }
    }

    @Override
    public void delete() throws SQLException {

    }

    @Override
    public User getUser() throws SQLException {
        return null;
    }

    @Override
    public void getUsers(User[] users) throws SQLException {
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i]);
        }
    }
}
