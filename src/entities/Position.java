package entities;

public class Position {
    // Numele functiei
    private String positionName;
    // Salariul de baza al functiei
    private float baseSalary;

    public Position() {
    }

    public Position(String positionName, float baseSalary) {
        this.positionName = positionName;
        this.baseSalary = baseSalary;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }
}
