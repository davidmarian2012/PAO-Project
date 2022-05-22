package models;

public class Admin extends User{
    private Integer reports;

    public Admin(){
        reports = 0;
    }

    public Admin(String email, String password, String first_name, String last_name, Integer reports){
        super(email ,password, first_name, last_name);
        this.reports = reports;
    }

    public Integer getReports(){
        return reports;
    }

    public void setReports(Integer reports){
        this.reports = reports;
    }

    public String toString() {
        return "Admin, " + super.toString() + ", reports: " + reports;
    }
}
