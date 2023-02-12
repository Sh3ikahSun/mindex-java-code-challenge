package com.mindex.challenge;

//import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBootstrapTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ReportingStructureService reportingStructureService;
    
    // @Autowired
    // private CompensationRepository compensationRepository;


    @Test
    public void test() {
        Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
        assertNotNull(employee);
        assertEquals("John", employee.getFirstName());
        assertEquals("Lennon", employee.getLastName());
        assertEquals("Development Manager", employee.getPosition());
        assertEquals("Engineering", employee.getDepartment());
    }

    /** Given an invalid employee id, make sure a user doesn't exist. */
    @Test
    public void givenInvalidIdCheckIfUserExists() {
        Employee employee = employeeRepository.findByEmployeeId("2345");
        assertNull(employee);
    }

    /** Given a valid employee id, check that the reporting structure counts the correct number of reporting employees. */
    @Test
    public void givenValidEmployeeIdCheckForCorrectReportingStructure() {
        ReportingStructure repStructure = reportingStructureService.
            getEmployeeReportingStructure("16a596ae-edd3-4847-99fe-c4518e82c86f");
        assertNotNull(repStructure);
        assertEquals(4, repStructure.getNumberOfReports());
    }

    // @Test
    // public void givenInvalidEmployeeIdCheckForNullReportingStructure() {
    //     ReportingStructure repStructure = reportingStructureService.getEmployeeReportingStructure("2345");
    //     // Here I want to assert that getEmployeeReportingStructure throws a RuntimeException since the 
    //     // employee will not exist.
    //     //assertThrows(RuntimeException.class, repStructure);
    // }


    // Some other tests one might include, that would probably use a mock database/repository, would be:
    //  - Add a new employee or updating an existing employee
    //  - Adding, reading, and updating compensation objects
    //  - More tests for actions that would throw exceptions or errors.
}