package models;

public class Drink extends Product{
    private Integer quantity;

    public Drink(){
        this.quantity = 0;
    }

    public Drink(String name, Double price, Integer calories, Integer quantity){
        super(name, price, calories);
        this.quantity = quantity;
    }

    public Integer getQuantity(){
        return quantity;
    }

    public void setSize(Integer quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "Drink, " + super.toString() + ", " + quantity + "ml";
    }
}
