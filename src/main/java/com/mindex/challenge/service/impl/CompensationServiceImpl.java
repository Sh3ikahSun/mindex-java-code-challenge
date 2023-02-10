package com.mindex.challenge.service.impl;

import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
//import com.mindex.challenge.dao.CompensationRepository;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompensationServiceImpl implements CompensationService {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    // @Autowired
    // private CompensationRepository compensationRepository;

    /** Create a new compensation instance in the repository with the given employee, salary, and effective date. */
    @Override
    public Compensation create(Employee employee, float salary, Date effectiveDate) {
        LOG.debug("Creating compensation for employee [{}]", employee);
        Compensation comp = new Compensation(employee, salary, effectiveDate);
        //compensationRepository.insert(comp);
        return comp;
    }

    /** Read a compensation instance from the repository for the employee with the given id. */
    @Override
    public Compensation read(String employeeId) {
        LOG.debug("Reading compensation for employee with id [{}]", employeeId);
        //Compensation comp = compensationRepository.findByEmployeeId(employeeId);
        Compensation comp = new Compensation(new Employee(), 0, new Date());
        // if (comp == null) {
        //     throw new RuntimeException("Could not find compensation for employee with id:" + employeeId);
        // }
        return comp;
    }
}
