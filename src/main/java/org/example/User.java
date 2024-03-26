package org.example;
import org.apache.commons.codec.digest.DigestUtils;
public class User
{

    public String login;
    public String password;
    public String role;
    public String rentedCar;

    public User(String login, String password, String role, String rentedCar) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.rentedCar = rentedCar;
    }

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.rentedCar = "NaN";
    }

    public String toCsv()
    {
//        String password_encrypted=DigestUtils.sha256Hex(password);
        return (login+";"+
                password+";"+
                role+";"+
                rentedCar+"\n");
    }
}
