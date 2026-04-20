package Model.Enum;

public enum Status {
    ADMIN(1),
    USER(2);

    private final int role;


     Status(int role) {
         this.role = role;
    }

    public int getRole() {
        return role;
    }
}
