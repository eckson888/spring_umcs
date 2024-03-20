package org.example;

import java.io.IOException;
import java.util.List;

public interface IVehicleRepository {
    public void rentCar(String nrRej) throws IOException;
    public void returnCar(String nrRej) throws IOException;
    public List<Vehicle> getVehicles();

    void removeVehicle(String plate) throws IOException;

    public void save() throws IOException;
    public List<Vehicle> getFromCsv();


    public void addVehicle(Vehicle v) throws IOException;


}
