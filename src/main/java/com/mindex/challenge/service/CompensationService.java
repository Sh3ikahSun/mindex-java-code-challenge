package com.mindex.challenge.service;

import java.util.Date;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;

public interface CompensationService {
    Compensation create(Employee employee, float salary, Date effectiveDate);
    Compensation read(String employeeId);
}
