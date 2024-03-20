package org.example;
import org.apache.commons.codec.digest.DigestUtils;
public class User
{

    public String login;
    public String password;
    public String role;
    public Vehicle rentedCar;

    public User(String login, String password, String role, Vehicle rentedCar) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.rentedCar = rentedCar;
    }

    public String toCsv()
    {
        String password_encrypted=DigestUtils.sha256Hex(password);
        return (login+";"+
                password_encrypted+";"+
                role+";"+
                rentedCar.nrRej+"\n");
    }
}
