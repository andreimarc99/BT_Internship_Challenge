package entities;

import java.util.Date;

public class Project {
    // Numele proiectului
    private String projectName;
    // Data de inceput a proiectului
    private Date startDate;
    // Deadline-ul proiectului
    private Date deadline;

    public Project() {
    }

    public Project(String projectName, Date startDate, Date deadline) {
        this.projectName = projectName;
        this.startDate = startDate;
        this.deadline = deadline;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
