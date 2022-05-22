package models;

import java.util.Objects;

public class User {
    private String email;
    private String password;
    private String first_name;
    private String last_name;

    public User(){
        this.email = "undefined";
        this.password = "undefined";
        this.first_name = "undefined";
        this.last_name = "undefined";
    }

    public User(String email, String password, String first_name, String last_name){
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getEmail(){
        return email;
    }

    public String getFirst_name(){
        return first_name;
    }

    public String getLast_name(){
        return last_name;
    }

    public String getPassword(){
        return password;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(first_name, user.first_name) && Objects.equals(last_name, user.last_name) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, first_name, last_name, password);
    }

    @Override
    public String toString() {
        return email + " - " + first_name + " " + last_name;
    }
}
