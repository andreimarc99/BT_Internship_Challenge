package entities;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Department> departmentList = new ArrayList<>();
    private List<Employee> employeeList = new ArrayList<>();
    private List<Position> positionList = new ArrayList<>();
    private List<Project> projectList = new ArrayList<>();

    public Company(List<Department> departmentList, List<Employee> employeeList, List<Position> positionList, List<Project> projectList) {
        this.departmentList = departmentList;
        this.employeeList = employeeList;
        this.positionList = positionList;
        this.projectList = projectList;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
