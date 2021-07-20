package entities;

public class DepartmentWithDirectSuperior {
    // Departamentul din care face parte angajatul
    private Department department;
    // Superiorul angajatului in departamentul respectiv
    private Employee superior;

    public DepartmentWithDirectSuperior() {
    }

    public DepartmentWithDirectSuperior(Department department, Employee superior) {
        this.department = department;
        this.superior = superior;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getSuperior() {
        return superior;
    }

    public void setSuperior(Employee superior) {
        this.superior = superior;
    }
}
