package dhl.db.pojo;

public class User {
    private String mail;
    private String username;
    private String password;
    private int power;

    public User(String mail, String username, String password, int power) {
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.power = power;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "userDao{" +
                "mail='" + mail + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", power=" + power +
                '}';
    }
}
