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

    private static final String FILE_NAME = "Users.txt";

    private User[] users;

    @Override
    public void writeToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt", true))) {
            writer.write(user.getId() + ". " +
                    "fullname => " + user.getUsername() + "  |  " +
                    "email => " + user.getEmail() + "  |  " +
                    "password => " + user.getPassword() + "  |  " +
                    "role => " + user.getStatus());
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User[] readFromFile() {
        File file = new File(FILE_NAME);
        // file yoxdursa boş array qaytar
        if (!file.exists() || file.length() == 0) {
            return new User[0];
        }
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILE_NAME)))) {
            Object obj = in.readObject();
            if (obj instanceof User[]) {
                return (User[]) obj; // 🔥 əsas hissə
            } else {
                System.out.println("File format səhvdir!");
            }
        } catch (IOException e) {
            System.out.println("File oxunarkən xəta!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new User[0];
    }

    private int idCount = 1;

    private User createUser() throws SQLException {
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
        writeToFile(user);
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
        System.out.print("Select the user you want to update  :  ");
        int updateIndex = new Scanner(System.in).nextInt();
        User user = users[updateIndex - 1];
        getUser(updateIndex - 1);
        System.out.print("What part of the user you selected did you want to update? ( username , email , password , role )  :  ");
        String text = (new Scanner(System.in).nextLine());
        switch (text) {
            case "username" -> user.setUsername(new Scanner(System.in).nextLine());
            case "email" -> user.setEmail(new Scanner(System.in).nextLine());
            case "password" -> user.setPassword(new Scanner(System.in).nextLine());
            case "role" -> user.setStatus(new Scanner(System.in).nextInt());
            default -> System.out.println("Is there a cell you want to update?");
        }
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public User getUser(int id) throws SQLException {
        try (BufferedReader br = new BufferedReader(new FileReader("Users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(".|");
                int userId = Integer.parseInt(data[0]);
                if (userId == id) {
                    User user = new User();
                    user.setId(userId);
                    user.setUsername(data[1]);
                    user.setEmail(data[2]);
                    user.setPassword(data[3]);
                    user.setStatus(Integer.parseInt(data[4]));

                    System.out.print("\n" + user.getId() + ".");
                    System.out.println("\tusername => " + user.getUsername());
                    System.out.println("\temail => " + user.getEmail());
                    System.out.println("\tpassword => " + user.getPassword());
                    System.out.println("\trole => " + user.getStatus() + "\n");
                    return user;
                }
            }
            System.out.println("User not found with id   : " + id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public User[] getUsers(User[] users) throws SQLException {
        if (users == null) System.out.println("Users not found");
        for (User user : users) {
            if (user != null) {
                System.out.print(user.getId() + ".");
                System.out.println("\tusername => " + user.getUsername());
                System.out.println("\temail => " + user.getEmail());
                System.out.println("\tpassword => " + user.getPassword());
                System.out.println("\tstatus => " + user.getStatus());
                System.out.println();
            }
        }
        return users;
    }

//    public User getUser(int id) {
//        List<User> users = readFromFile();
//
//        for (User user : users) {
//            if (user.getId() == id) {
//                return user;
//            }
//        }
//
//        return null;
//    }
}
