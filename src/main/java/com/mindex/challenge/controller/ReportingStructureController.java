package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReportingStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private ReportingStructureService reportingStructureService;

    /** Creates a reporting structure for the employee with the given id. */
    @GetMapping("/employee/{employeeId}/reportingStructure")
    public ReportingStructure getEmployeeReportingStructure(@PathVariable String employeeId) {
        // Log that the reporting structure request has been received.
        LOG.debug("Received employee reporting structure request for id [{}]", employeeId);
        // Create the reporting structure.
        return reportingStructureService.getEmployeeReportingStructure(employeeId);
    }
}
