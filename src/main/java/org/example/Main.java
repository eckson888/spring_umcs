package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.codec.digest.DigestUtils;
public class Main {
    public static void main(String[] args) throws IOException {

        VehicleRepository vehicles=new VehicleRepository();
        UserRepository users=new UserRepository();
        System.out.println("Podaj login oraz hasło:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String login = reader.readLine();
        String password= reader.readLine();
        Auth authentication=new Auth();
        authentication.checkCredentials(login,password);
        //        if(users.checkLogin(login))
//        {
//            System.out.println("Podaj Hasło:");
//            String password= reader.readLine();
//            password = DigestUtils.sha256Hex(password);
//            if(users.checkPassword(password))
//            {
//                System.out.println("Zalogowano pomyslnie!");
//            }
//        }
        users.save();
        //vehicles.save();

    }

}