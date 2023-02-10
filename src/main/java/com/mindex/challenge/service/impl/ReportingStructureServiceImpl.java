package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    /** Obtains the employee with the given id, then creates a reporting structure for them. */
    @Override
    public ReportingStructure getEmployeeReportingStructure(String employeeId) {
        // Log that a reporting structure is being created.
        LOG.debug("Creating reporting structure for employee with id [{}]", employeeId);
        // Find the employee with the given id, if they exist.
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + employeeId);
        }
        int numberOfReports = countDirectReports(employee, new ArrayList<Employee>());
        // Create and return a reporting structure for the employee.
        return new ReportingStructure(employee, numberOfReports);
    }

    /** Recursively counts number of reporting employees under the given employee. 
     * 
     * param 'employee': Employee for which to count their number of reporting employees
     *       'uniqueReports': Running list of all employees encountered when counting. Ensures no one is counted twice.
     * 
     * returns 'numReports': Number of reporting employees under the given employee
    */
    private int countDirectReports(Employee employee, List<Employee> uniqueReports) {
        List<Employee> reports = employee.getDirectReports();
        if (reports == null || reports.isEmpty()) { 
            return 0; 
        } else {
            int numReports = 0;
            for (Employee report : reports) {
                // Get the full report using the employee controller.
                Employee fullReport = this.employeeRepository.findByEmployeeId(report.getEmployeeId());
                // If an employee is in uniqueReports, they and their lower reports have been counted already, so we skip them.
                if (!uniqueReports.contains(fullReport)) {
                    // Add this reporting employee to the list of unique reports so they're not counted again.
                    uniqueReports.add(fullReport);
                    // Add this reporting employee and their reporting employees to the running count.
                    numReports += (1 + countDirectReports(fullReport, uniqueReports));
                }
            }
            return numReports;
        }
    }
}
