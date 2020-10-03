package basics.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Fire enough employees so taht the total salary will fit the budget.
 * You must not fire pregnant employees
 *
 */
public class PleaseImproveMe {

    private static final Logger logger = LoggerFactory.getLogger(PleaseImproveMe.class.getName());

    private static final long SALARY = 10000L;
    private static final int NUMBER_OF_EMPLOYEES = 100000;
    private static final BigInteger MAX_TOTAL_SALARY = new BigInteger("550000000");

    private static BigInteger totalSalary = new BigInteger("0");

    public static void main(String[] args) {
        PleaseImproveMe pleaseImproveMe = new PleaseImproveMe();
        Profiler myProfiler = new Profiler("PleaseImproveMe");
        myProfiler.start("process");
        try {
            pleaseImproveMe.runProcess();
        } catch (Exception e) {
            logger.error("Not possible to solve");
        }
        myProfiler.stop().print();
    }

    public void runProcess() throws Exception {
        // build list of employees
        List<Emp> employees = getEmployees();
        int empIndexToFire = 0;
        // fire employees, until the total salary is fits the budget
        while (totalSalary.longValue() > MAX_TOTAL_SALARY.longValue()) {
            logger.debug(getSalaryMessage(totalSalary.longValue(), MAX_TOTAL_SALARY.longValue()));
            try {
                Emp employeeToFire = getEmployeeToFire(employees, empIndexToFire);
                totalSalary = totalSalary.subtract(new BigInteger(String.valueOf(employeeToFire.getSalary())));
                logger.debug("Firing employee {}", employeeToFire);
                employees.remove(empIndexToFire);
            } catch (Exception e) {
                logger.warn("Cannot fire employee!");
                empIndexToFire++;
            }
            if (empIndexToFire >= employees.size()) {
                throw new Exception("Not possible");
            }
        }
    }

    private Emp getEmployeeToFire(List<Emp> employees, int empIndexToFire) throws Exception {
        // pregnant employees must not get fired
        if (employees.get(empIndexToFire).isPregnant()) {
            throw new Exception();
        }
        return employees.get(empIndexToFire);
    }

    private String getSalaryMessage(long current, long max) {
        String message = "Max total salary allowed = ";
        message += max;
        message += " and current total salary is = ";
        message += current;
        return message;
    }

    private List<Emp> getEmployees() {
        List<Emp> employees = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_EMPLOYEES; i++) {
            boolean isPregnant = (i % 2 == 0);
            Long salary = SALARY;
            totalSalary = totalSalary.add(new BigInteger(String.valueOf(salary)));
            Emp employee = new Emp(new Long(i), isPregnant, salary);
            employees.add(employee);
        }
        return employees;
    }
}
