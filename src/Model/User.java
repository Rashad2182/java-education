package Model;

import Model.Enum.Status;

/**
 * Burada bir Model yaratmışıq
 */
public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    private int status;

    /**
     * Bir ədəd boş Constructor yaradırıq Object yaradanda bizdən yerindəcə məlumatları doldurmağımızı istəməsin
     */
    public User() {
    }


    /**
     * Burada Class-ın Constructor-unu yaratmışıq
     * Bu Constructor-u çağıranda yerindəcə User məlumatlarını doldurmağını istiyəcək
     */
    public User(int id, String username, String email, String password, int status) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        return id + ".\tusername => " + username + "\n" + "\temail => " + email + "\n" + "\tpassword => " + password + "\n" + "\tstatus => " + status + "\n\n";
    }
}
