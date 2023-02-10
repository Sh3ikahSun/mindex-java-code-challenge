package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

    /** Request to create a new compensation object in the database. */
    @PostMapping("/employee/{id}/compensation")
    public Compensation create(Employee employee, float salary, Date effectiveDate) {
        LOG.debug("Received compensation create request for [{}]", employee);
        return compensationService.create(employee, salary, effectiveDate);
    }

    /** Read request for compensation object in database given an employee id. */
    @GetMapping("/employee/{id}/compensation")
    Compensation read(String employeeId) {
        LOG.debug("Received compensation read request for id [{}]", employeeId);
        return compensationService.read(employeeId);
    }
}
