package org.example;

import java.io.IOException;
import java.util.List;

public interface IVehicleRepository {
    public void rentCar(String nrRej) throws IOException;
    public void returnCar(String nrRej) throws IOException;
    public List<Vehicle> getVehicles();
    public void save() throws IOException;
    public List<Vehicle> getFromCsv();
}
