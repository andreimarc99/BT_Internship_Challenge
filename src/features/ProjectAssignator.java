package features;

import entities.*;

import java.util.List;
import java.util.Locale;

public class ProjectAssignator {
    // Culori pentru o vizualizare mai buna a asignarii
    // angajatilor in consola.
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    // Metoda unde se asigneaza angajatii la proiecte. S-au creat 3 proiecte random si se
    // verifica daca  perioada concediilor angajatilor se suprapune cu perioadele proiectelor
    public static void assignEmployees(List<Employee> employees) {
        for (Project p : Application.company.getProjectList()) {
            System.out.println(p.getProjectName().toUpperCase(Locale.ROOT) + ": ");
            for (Employee e : employees) {
                boolean isBusy = false;
                // Se verifica daca se suprapun perioadele
                for (Vacation v : e.getVacations()) {
                    if (p.getStartDate().getTime() <= v.getEndDate().getTime() && v.getStartDate().getTime() <= p.getDeadline().getTime()) {
                        isBusy = true;
                        break;
                    }
                }
                if (isBusy) {
                    System.out.println(e.getName() + RED + " is not available." + RESET);
                }  else {
                    e.addProject(p);
                    System.out.println(e.getName() + GREEN + " was assigned." + RESET);
                }
            }
            System.out.println();
        }
    }

    // Metoda apelata in metoda main a aplicatiei, unde se creeaza
    // angajati de test cu concedii random, si se apeleaza metoda de asignare
    public static void testAssignationMethod() {
        System.out.println("##################################");
        System.out.println("TESTING PROJECT ASSIGNATION METHOD");
        System.out.println("##################################" + "\n");
        assignEmployees(Application.company.getEmployeeList());
    }
}
