package models;

public class Dessert extends Product{
    private Boolean has_sugar;

    public Dessert(){
        this.has_sugar = false;
    }

    public Dessert(String name, Double price, Integer calories, Boolean has_sugar){
        super(name, price, calories);
        this.has_sugar = has_sugar;
    }

    public Boolean getHas_sugar(){
        return has_sugar;
    }

    public void setHas_sugar(Boolean has_sugar) {
        this.has_sugar = has_sugar;
    }

    public String toString() {
        String sugar;
        if (has_sugar)
            sugar = "Contains sugar";
        else
            sugar = "No sugar";
        return "Dessert, " + super.toString() + ", " + sugar;
    }
}
