package models;

import java.util.Objects;

public class Product {
    private String name;
    private Double price;
    private Integer calories;

    public Product(){
        this.name = "undefined";
        this.price = 0.0;
        this.calories = 0;
    }

    public Product(String name, Double price, Integer calories){
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Integer getCalories(){
        return calories;
    }

    public void setCalories(Integer calories){
        this.calories = calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(calories, product.calories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, calories);
    }

    @Override
    public String toString() {
        return name + ", " + price + "$, " + calories + " cal";
    }
}
