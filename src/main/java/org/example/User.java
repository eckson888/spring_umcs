package org.example;
import org.apache.commons.codec.digest.DigestUtils;
public class User
{
    private String login;
    private String password;
    public String role;
    public Vehicle rentedCar;

    public String toCsv()
    {


        String password_encrypted;

        return (login+";"+
                password_encrypted+";"+
                role+";"+
                rentedCar.nrRej+"\n");
    }
}
