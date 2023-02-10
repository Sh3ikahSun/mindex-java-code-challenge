package com.mindex.challenge.data;

import java.util.Date;

/** Object that holds compensation information about an employee; namely, their salary and effective date. */
public class Compensation {
    private Employee employee;
    private float salary;
    private Date effectiveDate;

    /** Constructor */
    public Compensation(Employee employee, float salary, Date effectiveDate) {
        this.employee = employee;
        this.salary = salary;
        this.effectiveDate = effectiveDate;
    }


    /** Get the employee who's being compensated. */
    public Employee getEmployee() { return this.employee; }

    /** Set employee to be compensated. */
    public void setEmployee(Employee employee) { this.employee = employee; }

    /** Get the employee's salary. */
    public float getSalary() { return this.salary; }

    /** Set the employee's salary. */
    public void setSalary(float salary) { this.salary = salary; }

    /** Get the effective date for the employee's salary. */
    public Date getEffectiveDate() { return this.effectiveDate; }

    /** Set the effective date for the employee's salary. */
    public void setEffectiveDate(Date date) { this.effectiveDate = date; }
}
