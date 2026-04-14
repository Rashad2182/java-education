package Model.Enum;

public class Status2 {

    private static final Status2 ADMIN = new Status2(2);
    private static final Status2 USER = new Status2(1);

    private final int role;


    private Status2(int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }
}
