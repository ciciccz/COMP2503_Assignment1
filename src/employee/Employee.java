package employee;

/**
 * Employee class
 * 
 * @author Colin Cui and rafaelalarcon
 *
 */
public class Employee {

	// Constant used to process weekly gross pay, deductions, and net pay
	public static final int NUM_YEARLY_WEEKS = 52;
	public static final int WEEKLY_HOURS = 40;
	public static final int WEEKLY_MAX_HOURS = 60;
	public static final double OVERTIME_PAY_INCREASE = 1.5;
	public static final char EMPLOYEE_TYPE_SALARY = 'S';
	public static final char EMPLOYEE_TYPE_HOURLY = 'H';
	public static final char EMPLOYEE_TYPE_CONTRACTOR = 'C';

	// Fields for Employee class
	private int empNo;
	private String empName;
	private String deparment;
	private char type;
	private double payRate;
	private double maxHours;

	/**
	 * Parameterized constructor for Employee class
	 * 
	 * @param empNo     integer with employee's number
	 * @param empName   String with emplotyee's name
	 * @param deparment String with employee's department
	 * @param type      char with abbreviation of employee's type
	 * @param payRate   double with employee's hourly pay rate
	 * @param maxHours  double with employee's maximum number of hours
	 * @author Colin Cui and rafaelalarcon
	 */
	public Employee(int empNo, String empName, String deparment, char type, double payRate, double maxHours) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.deparment = deparment;
		this.type = type;
		this.payRate = payRate;
		this.maxHours = maxHours;
	}

	/**
	 * Copy parameterized constructor for Employee class
	 * 
	 * @param employee  Object Employee with initializing values
	 * @param empNo     integer with employee's number
	 * @param empName   String with employee's name
	 * @param deparment String with employee's department
	 * @author Colin Cui and rafaelalarcon
	 */
	public Employee(Employee employee, int empNo, String empName, String deparment) {
		this.empNo = empNo;
		this.empName = empName;
		this.deparment = deparment;
		this.type = employee.type;
		this.payRate = employee.maxHours;
		this.maxHours = employee.maxHours;
	}

	/**
	 * Default constructor for Employee class
	 * 
	 * @author Colin Cui and rafaelalarcon
	 */
	public Employee() {
		empNo = 0;
		empName = null;
		deparment = null;
		payRate = 0;
		maxHours = 0;
	}

	/**
	 * Accessor method to obtain employee's number
	 * 
	 * @return integer with employee's number
	 * @author Colin Cui and rafaelalarcon
	 */
	public int getEmpNo() {
		return empNo;
	}

	/**
	 * Mutator method to assign employee's number
	 * 
	 * @param empNo integer with employee's number
	 * @author Colin Cui and rafaelalarcon
	 */
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	/**
	 * Accesor method to obtain employee's name
	 * 
	 * @return empName String with the employee name
	 * @author Colin Cui and rafaelalarcon
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * Mutator method to assign employee's name
	 * 
	 * @param empName String with employee's name
	 * @author Colin Cui and rafaelalarcon
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * Accessor method to obtain employee's department
	 * 
	 * @return String with employee's department
	 * @author Colin Cui and rafaelalarcon
	 */
	public String getDeparment() {
		return deparment;
	}

	/**
	 * Mutator method to assign employee's department
	 * 
	 * @param deparment String with employee's department
	 * @author Colin Cui and rafaelalarcon
	 */
	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}

	/**
	 * Accessor method to obtain employee's type
	 * 
	 * @return char with abbreviation of employees type
	 * @author Colin Cui and rafaelalarcon
	 */
	public char getType() {
		return type;
	}

	/**
	 * Mutator method to assign employee's type
	 * 
	 * @param type char with employee's abbreviation type
	 * @author Colin Cui and rafaelalarcon
	 */
	public void setType(char type) {
		this.type = type;
	}

	/**
	 * Accesor method to obtain employee's hourly pay rate
	 * 
	 * @return double with employee's pay rate
	 * @author Colin Cui and rafaelalarcon
	 */
	public double getPayRate() {
		return payRate;
	}

	/**
	 * Mutator method to assign employee's hourly pay rate
	 * 
	 * @param payRate double with employee's hourly pay rate
	 * @author Colin Cui and rafaelalarcon
	 */
	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	/**
	 * Accesor method to obtain employee's maximum number of hours
	 * 
	 * @return double with employee's maximum number of hours
	 * @author Colin Cui and rafaelalarcon
	 */
	public double getMaxHours() {
		return maxHours;
	}

	/**
	 * Mutator method to assign employee's maximum number of hours
	 * 
	 * @param maxHours double with employee's maximum number of hours
	 * @author Colin Cui and rafaelalarcon
	 */
	public void setMaxHours(double maxHours) {
		this.maxHours = maxHours;
	}

	/**
	 * Method to calculate employee's gross pay
	 * 
	 * @param hoursWorked double with employee's hours worked per week
	 * @return double with employee's amount of gross pay per week
	 * @author Colin Cui and rafaelalarcon
	 */
	public double calcGrossPay(double hoursWorked) {

		switch (type) {
		case EMPLOYEE_TYPE_SALARY:
			return payRate / NUM_YEARLY_WEEKS;
		case EMPLOYEE_TYPE_HOURLY:
			if (hoursWorked > WEEKLY_MAX_HOURS) {
				return payRate * WEEKLY_HOURS + payRate * OVERTIME_PAY_INCREASE * (WEEKLY_MAX_HOURS - WEEKLY_HOURS);
			}
			if (hoursWorked > WEEKLY_HOURS) {
				return payRate * WEEKLY_HOURS + (hoursWorked - WEEKLY_HOURS) * payRate * OVERTIME_PAY_INCREASE;
			}
			return payRate * hoursWorked;
		case EMPLOYEE_TYPE_CONTRACTOR:
			if (hoursWorked > maxHours) {
				return payRate * maxHours;
			}
			return payRate * hoursWorked;
		default:
			return 0;
		}
	}

	/**
	 * Method to calculate employee's federal income tax deductions
	 * 
	 * @param grossWkPay double with employee's gross pay per week
	 * @return double with employee's deducted amount from Federal Income Tax
	 * @author Colin Cui and rafaelalarcon
	 */
	public double calcWithhold(double grossWkPay) {

		final double FIRST_TAX_BRACKET = 1000 * 0.075;
		final double SECOND_TAX_BRACKET = 1000 * 0.12;

		if (grossWkPay < 1000) {
			return grossWkPay * 0.075;
		} else if (grossWkPay < 2000) {
			return (grossWkPay - 1000) * 0.12 + FIRST_TAX_BRACKET;
		}
		return (grossWkPay - 2000) * 0.17 + FIRST_TAX_BRACKET + SECOND_TAX_BRACKET;

	}

	/**
	 * Method to calculate employee's CPP deduction
	 * 
	 * @param grossWkPay double with employee's gross pay per week
	 * @return double with employees deducted amount from CPP
	 * @author Colin Cui and rafaelalarcon
	 */
	public double calcCPP(double grossWkPay) {
		return grossWkPay * 0.0475;
	}

	/**
	 * Method to calculate employee's EI deduction
	 * 
	 * @param grossWkPay double with employees gross pay per week
	 * @return double with employee's deducted amount from EI
	 * @author Colin Cui and rafaelalarcon
	 */
	public double calcEI(double grossWkPay) {
		return grossWkPay * 0.018;
	}

	/**
	 * Method to calculate employees' extended health benefit deduction
	 * 
	 * @param grossWkPay double with employees gross pay per week
	 * @return double with employee's deducted amount from extended health benefit
	 * @author Colin Cui and rafaelalarcon
	 */
	public double calcExtHealth(double grossWkPay) {
		if (type == 'S' || type == 'H') {
			return grossWkPay * 0.013;
		}
		return 0;
	}

	/**
	 * Method to calculate employee's union dues deduction
	 * 
	 * @param grossWkPay double with employees gross pay per week
	 * @return double with employee's deducted amount from union dues
	 * @author Colin Cui and rafaelalarcon
	 */
	public double calcUnionDues(double grossWkPay) {
		if (type == 'H') {
			return grossWkPay * 0.01;
		}
		return 0;
	}

	/**
	 * 
	 * @param grossPay
	 * @return
	 */
	public double calcNetPay(double grossPay) {
		switch (type) {
		case EMPLOYEE_TYPE_SALARY:
			double salaryTaxDeductedPay = commonDeductions(grossPay) - calcExtHealth(grossPay);
			return salaryTaxDeductedPay;
		case EMPLOYEE_TYPE_HOURLY:
			double hourlyTaxDeductedPay = commonDeductions(grossPay) - calcExtHealth(grossPay)
					- calcUnionDues(grossPay);
			return hourlyTaxDeductedPay;
		case EMPLOYEE_TYPE_CONTRACTOR:
			double contractorTaxDeductedPay = commonDeductions(grossPay);
			return contractorTaxDeductedPay;
		default:
			return 4;
		}

	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public int compareTo(Object obj) {
		if (this == obj)
			return 0;
		if (obj == null)
			return -1;
		if (getClass() != obj.getClass())
			return -1;
		Employee other = (Employee) obj;
		if (this.getEmpNo() < other.getEmpNo()) {
			return -1;
		}
		if (this.getEmpNo() > other.getEmpNo()) {
			return 1;
		}
		return 0;
	}

	/**
	 * ToString method
	 */
	public String toString() {
		return String.format(
				"Employee's number: " + "\t\t%d%n" + "Employee's name: " + "\t\t%s%n" + "Employee's department: "
						+ "\t\t%s%n" + "Employee's type: " + "\t\t%s%n" + "Employee's hourly pay rate: " + "\t%.2f%n"
						+ "Employee's maximum hours: " + "\t%.2f%n",
				getEmpNo(), getEmpName(), getDeparment(), getTypeFull(), getPayRate(), getMaxHours());

	}

	/**
	 * Helper method to calculate deductions common to all employees type
	 * 
	 * @param grossPay double with employee's calculated gross pay
	 * @return double with employee's calculated common deductions
	 * @author Colin Cui and rafaelalarcon
	 */
	private double commonDeductions(double grossPay) {
		return grossPay - calcWithhold(grossPay) - calcCPP(grossPay) - calcEI(grossPay);
	}

	private String getTypeFull() {
		switch(getType()) {
		case EMPLOYEE_TYPE_SALARY:
			return "Salary";
		case EMPLOYEE_TYPE_HOURLY:
			return "Hourly";
		case EMPLOYEE_TYPE_CONTRACTOR:
			return "Contractor";
		default:
			return "unknown";
		}
	}
}
