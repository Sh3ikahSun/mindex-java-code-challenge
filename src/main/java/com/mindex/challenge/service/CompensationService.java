package com.mindex.challenge.service;

import java.util.Date;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;

public interface CompensationService {
    /** Create a new compensation instance in the repository with the given employee, salary, and effective date. */
    Compensation create(Employee employee, float salary, Date effectiveDate);

    /** Read a compensation instance from the repository for the employee with the given id. */
    Compensation read(String employeeId);
}
