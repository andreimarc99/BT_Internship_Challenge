package features;

import entities.*;

import java.util.Locale;

public class DepartmentPrinter {
    // Culori pentru o vizualizare mai buna a asignarii
    // angajatilor in consola.
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";

    // Metoda care listeaza angajatii dupa un departament dat ca parametru
    public static void listEmployees(Department department) {
        System.out.println(RED + department.getDepartmentName().toUpperCase(Locale.ROOT) + ": " + RESET);
        for (Employee e : Application.company.getEmployeeList()) {
            for (DepartmentWithDirectSuperior d : e.getDepartments()) {
                if (d.getDepartment().equals(department)) {
                    System.out.println(e.getName());
                }
            }
        }
        System.out.println();
    }

    // Metoda care primeste compania din metoda main si apeleaza listEmployees()
    public static void testDepartmentPrinterMethod() {
        System.out.println("#################################");
        System.out.println("TESTING DEPARTMENT PRINTER METHOD");
        System.out.println("#################################" + "\n");
        for (Department d : Application.company.getDepartmentList()) {
            listEmployees(d);
        }
    }
}
