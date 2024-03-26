package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

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
        if(authentication.checkCredentials(login,password))
        {
            if(Objects.equals(users.getUserObject(login).role, "admin"))
            {
                System.out.println("Witaj, admin");
                Vehicle veh=new Car("lu 12345","honda","civic",1998,5000.F,false,"C");
                vehicles.addVehicle(veh);
                vehicles.removeVehicle("lu 12345");
            }
            else
            {
                System.out.println("Witaj, user");
            }
        }
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