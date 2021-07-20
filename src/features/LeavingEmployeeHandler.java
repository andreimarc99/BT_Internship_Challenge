package features;

import entities.DepartmentWithDirectSuperior;
import entities.Employee;
import entities.Project;

import java.util.Date;
import java.util.Random;

public class LeavingEmployeeHandler {
    // Culori pentru o vizualizare mai buna a asignarii
    // angajatilor in consola.
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public static void handleLeavingEmployee(Employee employee, Employee substitute) {
        boolean isValid = false;
        for (Employee e : Application.company.getEmployeeList()) {
            if (e.equals(employee)) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            System.out.println("Employee does not exist in the company.");
            return;
        } else {
            // Copierea departamentelor
            System.out.println("Adding departments to the new substitute...");
            String departments = "";
            for (DepartmentWithDirectSuperior d : employee.getDepartments()) {
                departments += d.getDepartment().getDepartmentName() + ", ";
            }
            departments = departments.substring(0, departments.length() - 2);
            System.out.println("Added: " + departments + "\n");
            substitute.setDepartments(employee.getDepartments());

            // Copierea proiectelor
            System.out.println("Adding projects to the new substitute...");
            String projects = "";
            for (Project p : employee.getProjects()) {
                projects += p.getProjectName() + ", ";
            }
            projects = projects.substring(0, projects.length() - 2);
            System.out.println("Added: " + projects + "\n");
            substitute.setProjects(employee.getProjects());

            // Inlocuirea ca superior ierarhic direct in departamente, daca este cazul
            for (Employee e : Application.company.getEmployeeList()) {
                for (DepartmentWithDirectSuperior d : e.getDepartments()) {
                    if (d.getSuperior().equals(employee)) {
                        System.out.println("Setting " + substitute.getName() + " as superior to " + e.getName() + " for \"" + d.getDepartment().getDepartmentName() + "\" department...");
                        d.setSuperior(substitute);
                    }
                }
            }
            String leaverName = employee.getName();
            // Stergerea din companie a angajatului
            Application.company.getEmployeeList().remove(employee);
            System.out.println("Done. " + RED + leaverName + RESET + "'s info was removed from the company, being substituted by " + GREEN + substitute.getName() + RESET + ".");
        }
    }

    public static void testLeavingEmployeeHandler() {
        System.out.println("########################################");
        System.out.println("TESTING EMPLOYEE LEAVING HANDLING METHOD");
        System.out.println("########################################" + "\n");
        Random rand = new Random();
        Employee leaver = Application.company.getEmployeeList().get(1);
        Employee substitute = new Employee("Substitute One", new Date(1994,3,12),
                Application.company.getPositionList().get(rand.nextInt(Application.company.getPositionList().size())),
                new Date(2021, 7, 20));
        System.out.println("Substituting " + RED + leaver.getName() + RESET + " with " + GREEN + substitute.getName() + RESET + "\n");
        handleLeavingEmployee(leaver, substitute);
    }
}
