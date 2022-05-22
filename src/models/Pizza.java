package models;

public class Pizza extends Product{
    private Boolean isVegetarian;

    public Pizza(){
        this.isVegetarian = false;
    }

    public Pizza(String name, Double price, Integer calories, Boolean isVegetarian){
        super(name, price, calories);
        this.isVegetarian = isVegetarian;
    }

    public Boolean getIsVegetarian(){
        return isVegetarian;
    }

    public void setIsVegetarian(Boolean isVegetarian){
        this.isVegetarian = isVegetarian;
    }

    public String toString() {
        String veg;
        if (isVegetarian)
            veg = "Vegetarian";
        else
            veg = "";
        return "Pizza, " + super.toString() + ", " + veg;
    }
}
