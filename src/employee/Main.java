package employee;

/**
 * Main class to run Java application
 * 
 * @author Colin Cui and rafaelalarcon
 */
public class Main {

	private static final int EMP_NUMBER_1 = 20101;
	private static final String NAME_1 = "Arnold";
	private static final String DEPARTMENT_1 = "Finance";
	private static final char TYPE_1 = Employee.EMPLOYEE_TYPE_SALARY;
	private static final double PAY_RATE_1 = 78000;
	private static final double MAX_HOURS_1 = 168;
	private static final int EMP_NUMBER_2 = 20112;
	private static final String NAME_2 = "Bernie";
	private static final String DEPARTMENT_2 = "Personnel";
	private static final char TYPE_2 = Employee.EMPLOYEE_TYPE_HOURLY;
	private static final double PAY_RATE_2 = 20;
	private static final double MAX_HOURS_2 = 60;
	private static final int EMP_NUMBER_3 = 20123;
	private static final String NAME_3 = "Carole";
	private static final String DEPARTMENT_3 = "Research";
	private static final char TYPE_3 = Employee.EMPLOYEE_TYPE_CONTRACTOR;
	private static final double PAY_RATE_3 = 70;
	private static final double MAX_HOURS_3 = 30;

	/**
	 * Main method to run application
	 * 
	 * @param args String array with the method to run the application
	 * @author Colin Cui and rafaelalarcon
	 */
	public static void main(String[] args) {
		Employee emp_1 = makeEmployee(EMP_NUMBER_1, NAME_1, DEPARTMENT_1, TYPE_1, PAY_RATE_1, MAX_HOURS_1);
		Employee emp_2 = makeEmployee(EMP_NUMBER_2, NAME_2, DEPARTMENT_2, TYPE_2, PAY_RATE_2, MAX_HOURS_2);
		Employee emp_3 = makeEmployee(EMP_NUMBER_3, NAME_3, DEPARTMENT_3, TYPE_3, PAY_RATE_3, MAX_HOURS_3);

		testEmptyEmployee();
		testCalcNetPay();
		System.out.println(emp_1);
		System.out.println(emp_2);
		System.out.println(emp_3);
		System.out.println("System working as expected");
	}

	
	/**
	 * Method to test setters and getters
	 */
	private static void testEmptyEmployee() {

		Employee emp = makeEmployee(EMP_NUMBER_1, NAME_1, DEPARTMENT_1, TYPE_1, PAY_RATE_1, MAX_HOURS_1);

		if (emp.getEmpNo() != EMP_NUMBER_1) {
			System.out.println("Bad employee number");
		}
		if (!emp.getEmpName().equals(NAME_1)) {
			System.out.println("Bad employee name");

		}
		if (!emp.getDeparment().equals(DEPARTMENT_1)) {
			System.out.println("Bad department name");

		}
		if (emp.getType() != TYPE_1) {
			System.out.println("Bad employee type");

		}
		if (emp.getPayRate() != PAY_RATE_1) {
			System.out.println("Bad employee pay rate");

		}
		if (emp.getMaxHours() != MAX_HOURS_1) {
			System.out.println("Bad employee max hours");

		}

	}
	
	private static void testCalcNetPay() {

		// Object with the three types of employees for testing
		Employee emp_1 = makeEmployee(EMP_NUMBER_1, NAME_1, DEPARTMENT_1, TYPE_1, PAY_RATE_1, MAX_HOURS_1);
		Employee emp_2 = makeEmployee(EMP_NUMBER_2, NAME_2, DEPARTMENT_2, TYPE_2, PAY_RATE_2, MAX_HOURS_2);
		Employee emp_3 = makeEmployee(EMP_NUMBER_3, NAME_3, DEPARTMENT_3, TYPE_3, PAY_RATE_3, MAX_HOURS_3);

		if (!equalDouble(emp_1.calcNetPay(1730.76), (1568.07 - 82.21 - 31.15 - 22.5))) {
			System.out.println(emp_1.calcNetPay(1730.76));
			System.out.println("Net pay amount not right" + "TaxDeductions betwwenn 1000 and 2000");
		}
		if (!equalDouble(emp_1.calcNetPay(990), (915.75 - 47.02 - 17.82 - 12.87))) {
			System.out.println(emp_1.calcNetPay(990));
			System.out.println("Net pay amount not right" + "TaxDeductions under 1000");
		}
		if (!equalDouble(emp_1.calcNetPay(2001), (1805.83 - 95.04 - 36.02 - 26.01))) {
			System.out.println(emp_1.calcNetPay(2001));
			System.out.println("Net pay amount not right" + "TaxDeductions above 2000");
		}

		double hourlyCalcOverMaxHours = emp_2.calcGrossPay(61);
		if (!equalDouble(emp_2.calcNetPay(hourlyCalcOverMaxHours), (1400 - 48 - 75 - 66.5 - 25.2 - 18.20 - 14))) {
			System.out.println("not working");
		}
		double hourlyCalcOverWeeklyHours = emp_2.calcGrossPay(41);
		if (!equalDouble(emp_2.calcNetPay(hourlyCalcOverWeeklyHours), (830 - 62.25 - 39.42 - 14.94 - 10.79 - 8.3))) {
			System.out.println("not working");
		}
		double hourlyCalc = emp_2.calcGrossPay(40);
		if (!equalDouble(emp_2.calcNetPay(hourlyCalc), (800 - 60 - 38 - 14.4 - 10.4 - 8))) {
			System.out.println("not working");
		}

		double contractorCalcOverMaxHours = emp_3.calcGrossPay(31);
		if (!equalDouble(emp_3.calcNetPay(contractorCalcOverMaxHours), (2100 - 17 - 75 - 120 - 99.75 - 37.8))) {
			System.out.println("not working");
		}
		double contractorCalcUnderMsxHours = emp_3.calcGrossPay(29);
		if (!equalDouble(emp_3.calcNetPay(contractorCalcUnderMsxHours), (2030 - 5.1 - 75 - 120 - 96.425 - 36.54))) {
			System.out.println("not working");
		}
		emp_1.setType('X');

		if (emp_1.calcNetPay(12345) != 4) {

			System.out.println("Bad net pay calculation " + 'X');
		}
	}

	/**
	 * Test helper method to assert Employee instantiation
	 * 
	 * @return emp Employee object with initial information for testing
	 * @author Colin Cui and rafaelalarcon
	 */
	private static Employee makeEmployee(int a, String b, String c, char d, double e, double f) {

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
	 * Method to round up/down doubles with epsilon approach
	 * 
	 * @param a double number with amount
	 * @param b double number with amount
	 * @return boolean to compare equality with 1 cent precision
	 */
	private static boolean equalDouble(double a, double b) {
		return Math.abs(a - b) < 0.01;
	}

	
}
