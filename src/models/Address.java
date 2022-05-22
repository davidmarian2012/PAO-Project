package models;

import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private String postalCode;

    public Address(){
        city = "undefined";
        street = "undefined";
        postalCode = "undefined";
    }

    public Address(String city, String street, String postalCode){
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public String getPostalCode(){
        return postalCode;
    }

    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, postalCode);
    }

    @Override
    public String toString() {
        return city + ", " + street + ", " + postalCode;
    }
}
