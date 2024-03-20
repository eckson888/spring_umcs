package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        VehicleRepository vehicles=new VehicleRepository();
        UserRepository users=new UserRepository();
        Car car=new Car("3","honda","civic",1998, 1.0F,false,"C");
        vehicles.addVehicle(car);
        User test=new User("mat123","mat123","admin",car);
        users.addUser(test);
        for(User u: users.getUsers())
        {
            System.out.println(u.password);
        }

        //vehicles.save();

    }

}