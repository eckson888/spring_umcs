package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Car car=new Car("1","tojodaaa","jaris",2000, 5.6F,false,"C");
        Car car2=new Car("2","nisannnnn","mikra",2001, 5.1F,false,"C");
        Car car3=new Car("3","nisannnnn","mikra",2001, 5.1F,false,"C");
        VehicleRepository vehicles=new VehicleRepository();
        vehicles.vehicleList.add(car);
        for(Vehicle v: vehicles.vehicleList)
        {
            System.out.println(v.nrRej);
        }
        vehicles.rentCar("1");
        //vehicles.save();

    }

}