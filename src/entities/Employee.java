package entities;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    // Numele angajatului
    private String name;
    // Data nasterii
    private Date birthDate;
    // Functia angajatului
    private Position position;
    // Data angajarii
    private Date dateHired;
    // Departamentele din care face parte angajatul. Este o structura care stocheaza
    // departamentul efectiv si superiorul direct al angajatului
    private List<DepartmentWithDirectSuperior> departments = new ArrayList<>();
    // Lista de proiecte la care ia parte angajatul
    private List<Project> projects = new ArrayList<>();
    // Lista de concedii a angajatului
    private List<Vacation> vacations = new ArrayList<>();

    public Employee(String name, Date birthDate, Position position, Date dateHired) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
        this.dateHired = dateHired;
    }

    public Employee(String name, Date birthDate, Position position, Date dateHired, List<DepartmentWithDirectSuperior> departments,
                    List<Project> projects, List<Vacation> vacations) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
        this.dateHired = dateHired;
        this.departments = departments;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    public List<DepartmentWithDirectSuperior> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentWithDirectSuperior> departments) {
        this.departments = departments;
    }

    public void addDepartment(DepartmentWithDirectSuperior department) {
        departments.add(department);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public List<Vacation> getVacations() {
        return vacations;
    }

    public void setVacations(List<Vacation> vacations) {
        this.vacations = vacations;
    }

    public void addVacation(Vacation vacation) {
        vacations.add(vacation);
    }
}
