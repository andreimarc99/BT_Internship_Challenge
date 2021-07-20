package features;

import entities.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application {
    public static Company company;

    // Metoda principala a aplicatiei,
    // unde se testeaza functionalitatile implementate
    public static void main(String[] args) {
        List<Project> projects = new ArrayList<>() {
            {
                add(new Project("Project Alpha", new Date(2021, 8, 20), new Date(2021, 10, 20)));
                add(new Project("Project Beta", new Date(2021, 5, 20), new Date(2021, 7, 20)));
                add(new Project("Project Delta", new Date(2021, 7, 20), new Date(2021, 8, 20)));
            }
        };

        Position programmerPosition = new Position("Programmer", 2950.5F);
        Position directorPosition = new Position("Director", 7000);

        List<Position> positions = new ArrayList<>() {
            {
                add(programmerPosition);
                add(directorPosition);
            }
        };

        Employee e1 = new Employee("Programmer One", new Date(1990,1,2), programmerPosition, new Date(2019, 7, 20));
        e1.addVacation(new Vacation(new Date(2021, 7, 8), new Date(2021, 8, 8)));

        Employee e2 = new Employee("Programmer Two", new Date(1996,10,20), programmerPosition, new Date(2021, 3, 12));
        e2.addVacation(new Vacation(new Date(2021, 9, 8), new Date(2021, 10, 8)));

        Employee e3 = new Employee("Programmer Three", new Date(1980,6,3), programmerPosition, new Date(2017,3,6));
        e3.addVacation(new Vacation(new Date(2021, 10, 8), new Date(2021, 11, 8)));
        e3.addVacation(new Vacation(new Date(2021, 5, 27), new Date(2021, 6, 3)));

        Employee e4 = new Employee("Programmer Four", new Date(1996,10,20), programmerPosition, new Date(2021, 3, 12));
        e4.addVacation(new Vacation(new Date(2021, 5, 3), new Date(2021, 10, 3)));
        Employee s1 = new Employee("Superior One", new Date(1996,5,25), programmerPosition, new Date(2018, 6, 23));
        Employee d = new Employee("Director", new Date(1980,6,3), directorPosition, new Date(2017,3,6));

        List<Employee> employees = new ArrayList<>() {
            {
                add(e1);
                add(e2);
                add(e3);
                add(e4);
                add(s1);
                add(d);
            }
        };

        Department dep1 = new Department(d, "Department One");
        Department dep2 = new Department(d, "Department Two");
        List<Department> departments = new ArrayList<>() {
            {
                add(dep1);
                add(dep2);
            }
        };

        e1.addDepartment(new DepartmentWithDirectSuperior(dep1, s1));
        e1.addDepartment(new DepartmentWithDirectSuperior(dep2, d));

        e2.addDepartment(new DepartmentWithDirectSuperior(dep1, d));

        e3.addDepartment(new DepartmentWithDirectSuperior(dep1, e2));

        e4.addDepartment(new DepartmentWithDirectSuperior(dep2, e1));

        company = new Company(departments, employees, positions, projects);
        SalaryCalculator.testSalaryCalculatorMethod();
        ProjectAssignator.testAssignationMethod();
        DepartmentPrinter.testDepartmentPrinterMethod();
        ProjectDepartmentPrinter.testDepartmentPrinterByProject();
        LeavingEmployeeHandler.testLeavingEmployeeHandler();
    }
}
