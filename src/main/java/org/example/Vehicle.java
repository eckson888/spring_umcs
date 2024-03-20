package org.example;

public abstract class Vehicle {
    public String nrRej;
    public String brand;
    public String model;
    public Integer year;
    public Float price;
    public boolean rented;
    public String type;

    public Vehicle(String nrRej, String brand, String model, Integer year, Float price, boolean rented,String type)
    {
        this.nrRej = nrRej;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.rented = rented;
        this.type=type;
    }

    public String toCsv()
    {
        return (nrRej+";"+
                brand+";"+
                model+";"+
                year+";"+
                price+";"+
                rented+";"+
                type+"\n");
    }
    @Override
    public String toString()
    {
        return ("Nr Rejestracyjny: "+nrRej+"Marka: "+ brand+", Model: "+model+", Rok: "+year
                +", Cena: "+price+", Wypozyczony?: "+rented+", Typ: "+type);
    }
}
