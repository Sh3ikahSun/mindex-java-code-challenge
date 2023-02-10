package com.mindex.challenge.service;

import com.mindex.challenge.data.ReportingStructure;

public interface ReportingStructureService {
    /** Obtains the employee with the given id, then creates a reporting structure for them. */
    ReportingStructure getEmployeeReportingStructure(String employeeId);
}
