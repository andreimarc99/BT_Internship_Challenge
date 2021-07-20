package entities;

import java.util.Date;

public class Vacation {
    // Data de inceput a concediului
    private Date startDate;
    // Data de incheiere a concediului
    private Date endDate;

    public Vacation() {
    }

    public Vacation(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
