package com.mindex.challenge.data;

public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;    // Number of employees that report to the employee.

    /** Constructor */
    public ReportingStructure(Employee employee) {
        this.employee = employee;
        setNumberOfReports();
    }


    /** Get employee object for this reporting structure. */
    public Employee getEmployee() { return this.employee; }

    /** Set employee object for this reporting structure and update the number of reports. */
    public void setEmployee(Employee employee) { 
        this.employee = employee;
        setNumberOfReports();
    }

    /** Get number of reports under the employee in this reporting structure. */
    public int getNumberOfReports() { return this.numberOfReports; }

    /** Determine and set number of reports under the employee in this reporting structure. */
    private void setNumberOfReports() {
        this.numberOfReports = countDirectReports(this.employee);
    }

    /** Recursively counts number of reporting employees under the given employee. */
    private int countDirectReports(Employee employee, List<Employee> uniqueReports) {
        List<Employee> reports = employee.getDirectReports();
        if (reports.isEmpty()) { 
            return 0; 
        } else {
            int numReports = 0;
            for (Employee report : reports) {
                // If an employee is in uniqueReports, they and their lower reports have been counted already, so we skip them.
                if (!uniqueReports.contains(report)) {
                    // Add this reporting employee to the list of unique reports so they're not counted again.
                    uniqueReports.add(report);
                    // Add this reporting employee and their reporting employees to the running count.
                    numReports = 1 + countDirectReports(report);
                }
            }
            return numReports;
        }
    }
}
