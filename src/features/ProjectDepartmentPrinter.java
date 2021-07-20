package features;

import entities.*;

import java.util.*;

public class ProjectDepartmentPrinter {
    // Culori pentru o vizualizare mai buna a asignarii
    // angajatilor in consola.
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";

    // Metoda care gaseste departamentele in functie de proiectul dat ca parametru
    public static List<Department> findDepartmentsByProject(Project project) {
        List<Department> departmentList = new ArrayList<>();

        // Parcurgerea tuturor angajatilor din companie.
        // Se adauga toate departamentele unui angajat in cazul
        // in care acesta ia parte la un proiect.
        for (Employee e : Application.company.getEmployeeList()) {
            for (Project p : e.getProjects()) {
                if (p.equals(project)) {
                    for (DepartmentWithDirectSuperior d : e.getDepartments()) {
                        departmentList.add(d.getDepartment());
                    }
                }
            }
        }

        // Stergerea duplicatelor
        Set<Department> departmentSet = new HashSet<>(departmentList);
        departmentList.clear();
        departmentList.addAll(departmentSet);

        return departmentList;
    }

    public static void testDepartmentPrinterByProject() {
        System.out.println("#############################################");
        System.out.println("TESTING DEPARTMENTS BY PROJECT PRINTER METHOD");
        System.out.println("#############################################" + "\n");
        for (Project p : Application.company.getProjectList()) {
            System.out.println(RED + p.getProjectName().toUpperCase(Locale.ROOT) + ": " + RESET);
            List<Department> departmentList = findDepartmentsByProject(p);
            for (Department d : departmentList) {
                System.out.println(d.getDepartmentName());
            }
            System.out.println();
        }
    }
}
