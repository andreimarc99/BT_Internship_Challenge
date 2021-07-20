package features;

import entities.Employee;

import java.time.LocalDate;
import java.time.Period;

public class SalaryCalculator {
    // Culori pentru o vizualizare mai buna a asignarii
    // angajatilor in consola.
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    // Metoda care returneaza diferenta de ani dintre doua date
    public static int getYearDifference(Employee employee) {
        LocalDate now = LocalDate.now();
        LocalDate dateHired = LocalDate.of(employee.getDateHired().getYear(), employee.getDateHired().getMonth(), employee.getDateHired().getDate());
        return Period.between(dateHired, now).getYears();
    }

    // Metoda care calculeaza salariul angajatului primit ca parametru
    // in functie de salariul de baza si data angajarii
    public static float calculateSalary(Employee employee) {
        int difference = getYearDifference(employee);
        if (difference != 0) {
            return employee.getPosition().getBaseSalary() * difference;
        } else {
            return employee.getPosition().getBaseSalary();
        }
    }

    // Metoda care creeaza un string pentru vizualizarea mai facila a salariului calculat, impreuna cu experienta
    // in ani a angajatului si a salariului de baza impus de catre functia ocupata de catre angajat
    public static String getSalaryCalculatorOutput(Employee employee) {
        return employee.getName() + "'s salary: " + GREEN + calculateSalary(employee) + RESET + ", from " +
               RED + employee.getPosition().getBaseSalary() + RESET + " base salary and " + RED + getYearDifference(employee) + RESET + "y of experience";
    }

    // Metoda care creeaza angajatii de test si este apelata din metoda main a aplicatiei
    public static void testSalaryCalculatorMethod() {
        System.out.println("################################");
        System.out.println("TESTING SALARY CALCULATOR METHOD");
        System.out.println("################################" + "\n");

        for (Employee e : Application.company.getEmployeeList()) {
            System.out.println(getSalaryCalculatorOutput(e));
        }
        System.out.println();
    }
}
