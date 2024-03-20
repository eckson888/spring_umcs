package org.example;

public class Motorcycle extends Vehicle {
    public String category;

    public Motorcycle(String nrRej, String brand, String model, Integer year, Float price,String category, boolean rented, String type) {
        super(nrRej, brand, model, year, price, rented, type);
        this.category=category;
    }

    @Override
    public String toCsv()
    {
        return (nrRej+";"+brand+";"+model+";"+year+";"+price+";"+category+";"+rented+";"+type);
    }

    @Override
    public String toString()
    {
        return ("Nr Rejestracyjny: "+nrRej+
                "Marka: "+ brand+
                ", Model: "+model+
                ", Rok: "+year+
                ", Cena: "+price+
                ", Kategoria: "+category+
                ", Wypozyczony?: "+rented+
                ", Typ: "+type);
    }
}
