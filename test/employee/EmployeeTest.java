/**
 * 
 */
package employee;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author rafaelalarcon
 *
 */
public class EmployeeTest {

	private final double EPSILON = 0.01;
	private final int EMP_NUMBER_1 = 20101;
	private final String NAME_1 = "Arnold";
	private final String DEPARTMENT_1 = "Finance";
	private final char TYPE_1 = Employee.EMPLOYEE_TYPE_SALARY;
	private final double PAY_RATE_1 = 78000;
	private final double MAX_HOURS_1 = 168;
	private final int EMP_NUMBER_2 = 20112;
	private final String NAME_2 = "Bernie";
	private final String DEPARTMENT_2 = "Personnel";
	private final char TYPE_2 = Employee.EMPLOYEE_TYPE_HOURLY;
	private final double PAY_RATE_2 = 20;
	private double MAX_HOURS_2 = 60;
	private final int EMP_NUMBER_3 = 20123;
	private final String NAME_3 = "Carole";
	private final String DEPARTMENT_3 = "Research";
	private final char TYPE_3 = Employee.EMPLOYEE_TYPE_CONTRACTOR;
	private final double PAY_RATE_3 = 70;
	private final double MAX_HOURS_3 = 30;

	/**
	 * Test helper method to assert Employee instantiation
	 * 
	 * @return emp Employee object with initial information for testing
	 * @author Colin Cui and rafaelalarcon
	 */
	private Employee makeEmployee(int a, String b, String c, char d, double e, double f) {

		Employee emp = new Employee();

		emp.setEmpNo(a);
		emp.setEmpName(b);
		emp.setDeparment(c);
		emp.setType(d);
		emp.setPayRate(e);
		emp.setMaxHours(f);

		return emp;
	}

	/**
	 * Test method for
	 * {@link employee.Employee#Employee(int, java.lang.String, java.lang.String, char, double, double)}.
	 */
	@Test
	public void testEmployeeIntStringStringCharDoubleDouble() {
		Employee emp_1 = makeEmployee(EMP_NUMBER_1, NAME_1, DEPARTMENT_1, TYPE_1, PAY_RATE_1, MAX_HOURS_1);
		Employee emp = makeEmployee(20101, "Arnold", "Finance", 'S', 78000, 168);
		assertEquals("Bad employee's number", emp_1.getEmpNo(), 20101);
	}

	/**
	 * Test method for {@link employee.Employee#calcNetPay(double)}.
	 */
	@Test
	public void testCalcNetPay() {
		Employee emp_2 = makeEmployee(EMP_NUMBER_2, NAME_2, DEPARTMENT_2, TYPE_2, PAY_RATE_2, MAX_HOURS_2);
		assertEquals("Calculation of net pay is wrong", emp_2.calcNetPay(emp_2.calcGrossPay(61)),
				(1400 - 48 - 75 - 66.5 - 25.2 - 18.20 - 14), EPSILON);
}

	/**
	 * Test method for {@link employee.Employee#compareTo(java.lang.Object)}.
	 */
	@Test
	public void testCompareTo() {

		// Object with the three types of employees for testing
		Employee emp_1 = makeEmployee(EMP_NUMBER_1, NAME_1, DEPARTMENT_1, TYPE_1, PAY_RATE_1, MAX_HOURS_1);
		Employee emp_2 = makeEmployee(EMP_NUMBER_2, NAME_2, DEPARTMENT_2, TYPE_2, PAY_RATE_2, MAX_HOURS_2);
		Employee emp_3 = makeEmployee(EMP_NUMBER_3, NAME_3, DEPARTMENT_3, TYPE_3, PAY_RATE_3, MAX_HOURS_3);

		assertEquals("Incorrect comparison -1", -1, emp_1.compareTo(emp_3));
		assertEquals("Employee's number should be the same", 0, emp_1.compareTo(emp_1));
		assertEquals("Incorrect comparison 1", 1, emp_3.compareTo(emp_1));
	}
}
