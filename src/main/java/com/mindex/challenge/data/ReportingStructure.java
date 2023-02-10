package com.mindex.challenge.data;

/** Object that holds an employee and the number of employees that report to them. */
public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;    // Number of employees that report to the employee.

    /** Constructor */
    public ReportingStructure(Employee employee, int numReports) {
        this.employee = employee;
        this.numberOfReports = numReports;
    }


    /** Get employee object for this reporting structure. */
    public Employee getEmployee() { return this.employee; }

    /** Set employee object for this reporting structure and update the number of reports. */
    public void setEmployee(Employee employee) { this.employee = employee; }

    /** Get number of reports under the employee in this reporting structure. */
    public int getNumberOfReports() { return this.numberOfReports; }

    /** Determine and set number of reports under the employee in this reporting structure. */
    public void setNumberOfReports(int numReports) { this.numberOfReports = numReports; }
}
