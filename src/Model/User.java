package Model;

/**
 * Burada bir Model yaratmışıq
 */
public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    private String role;


    /**
     * Bir ədəd boş Constructor yaradırıq Object yaradanda bizdən yerindəcə məlumatları doldurmağımızı istəməsin
     */
    public User() {}


    /**
     * Burada Class-ın Constructor-unu yaratmışıq
     * Bu Constructor-u çağıranda yerindəcə User məlumatlarını doldurmağını istiyəcək
     */
    public User(int id, String username, String email, String password, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /**
     * Aşağıda Model-in Getters və Setters method-larını yaratmışıq  yəniki (İncopsulation) yaratmışıq
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    /**
     * Burada Modelin toString method-un yaradırıq
     * Object-dən gələn toString methodunu əzirik @Override edirik
     * öz modelimizin toString method-unu yaradırıq
     * Object-dən gələn toString bu formada görünür (User@6d06d69c) bu şəkildə görsənir
     * Biz yazdığımız isə bu cür :
     * username -> Rashad Gasanov
     * email -> rashadgasanov@gmail.com
     * password -> $%^@#$@HFBtgbv%$GHB
     * role -> admin
     */
    @Override
    public String toString() {

        return id + "." + "username -> " + username + "\n" + "email -> " + email + "\n" + "password -> " + password + "\n" + "role -> " + role;
    }
}
