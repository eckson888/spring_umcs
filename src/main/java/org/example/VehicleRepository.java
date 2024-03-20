package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepository implements IVehicleRepository {

    public List<Vehicle> vehicleList=new ArrayList<>();

    public VehicleRepository() {
        this.vehicleList = getFromCsv();
    }

    @Override
    public void rentCar(String nrRej) throws IOException {
        for(Vehicle v: vehicleList)
        {
            if(v.nrRej.equals(nrRej))
            {
                v.rented=true;
                save();
                break;
            }
        }
    }

    @Override
    public void returnCar(String nrRej) throws IOException {
        for(Vehicle v: vehicleList)
        {
            if(v.nrRej.equals(nrRej))
            {
                v.rented=false;
                save();
                break;
            }
        }

    }

    @Override
    public List<Vehicle> getVehicles() {
        return this.vehicleList;
    }

    public List<Vehicle> getFromCsv()
    {
        try (BufferedReader br = new BufferedReader(new FileReader("baza.csv")))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] values = line.split(";");
                if(values[6].equals("C"))
                {
                    vehicleList.add(new Car(values[0],
                            values[1],
                            values[2],
                            Integer.parseInt(values[3]),
                            Float.parseFloat(values[4]),
                            Boolean.getBoolean(values[5]),
                            values[6]) {});
                }
                else
                {
                    vehicleList.add(new Motorcycle(
                            values[0],
                            values[1],
                            values[2],
                            Integer.parseInt(values[3]),
                            Float.parseFloat(values[4]),
                            values[5],
                            Boolean.getBoolean(values[6]),
                            values[7]) {});
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return vehicleList;
    }

    @Override
    public void save() throws IOException {
        FileWriter fileWriter = new FileWriter("baza.csv");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.flush();
        printWriter.write("");
        for(Vehicle v: vehicleList)
        {
            printWriter.printf(v.toCsv());
        }
        printWriter.close();
        fileWriter.close();
    }
}