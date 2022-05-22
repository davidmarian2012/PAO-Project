package models;

public class Pasta extends Product{
    private Boolean spicy;

    public Pasta(){
        this.spicy = false;
    }

    public Pasta(String name, Double price, Integer calories, Boolean spicy){
        super(name, price, calories);
        this.spicy = spicy;
    }

    public Boolean getSpicy(){
        return spicy;
    }

    public void setSpicy(Boolean spicy){
        this.spicy = spicy;
    }

    public String toString() {
        String is_spicy;
        if (spicy)
            is_spicy = "Spicy";
        else
            is_spicy = "";
        return "Pasta, " + super.toString() + ", " + is_spicy;
    }
}
