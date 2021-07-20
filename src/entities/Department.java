package entities;

public class Department {
    // Numele departamentului
    private String departmentName;
    // Directorul departamentului - consideram ca directorul este si el un angajat
    private Employee director;

    public Department() {
    }

    public Department(Employee director, String departmentName) {
        this.director = director;
        this.departmentName = departmentName;
    }


    public Employee getDirector() {
        return director;
    }

    public void setDirector(Employee director) {
        this.director = director;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
