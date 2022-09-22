package employee;

/**
 * 
 * @author Colin Cui and rafaelalarcon
 *
 */
public class Employee {
	private int empNo;
	private String empName;
	private String deparment;
	private char type;
	private double payRate;
	private double maxHours;
	
	
	/**
	 * 
	 * @param empNo
	 * @param empName
	 * @param deparment
	 * @param type
	 * @param payRate
	 * @param maxHours
	 * @author Colin Cui
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
	 * 
	 * @param employee
	 * @param empNo
	 * @param empName
	 * @param deparment
	 * @author Colin Cui
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
	 * @author Colin Cui
	 */
	public Employee() {
		empNo = 0;
		empName = null;
		deparment = null;
		payRate = 0;
		maxHours = 0;
	}


	/**
	 * 
	 * @return
	 * @author Colin Cui
	 */
	public int getEmpNo() {
		return empNo;
	}


	/**
	 * 
	 * @param empNo
	 * @author Colin Cui
	 */
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	
	/**
	 * 
	 * @return empName String with the employee name
	 * @author Colin Cui
	 */
	public String getEmpName() {
		return empName;
	}


	/**
	 * 
	 * @param empName
	 * @author Colin Cui
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}


	/**
	 * 
	 * @return
	 * @author Colin Cui
	 */
	public String getDeparment() {
		return deparment;
	}


	/**
	 * 
	 * @param deparment
	 * @author Colin Cui
	 */
	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}


	/**
	 * 
	 * @return
	 * @author Colin Cui
	 */
	public char getType() {
		return type;
	}


	/**
	 * 
	 * @param type
	 * @author Colin Cui
	 */
	public void setType(char type) {
		this.type = type;
	}


	/**
	 * 
	 * @return
	 * @author Colin Cui 
	 */
	public double getPayRate() {
		return payRate;
	}


	/**
	 * 
	 * @param payRate
	 * @author Colin Cui
	 */
	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}


	/**
	 * 
	 * @return
	 * @author Colin Cui
	 */
	public double getMaxHours() {
		return maxHours;
	}


	/**
	 * 
	 * @param maxHours
	 * @author Colin Cui
	 */
	public void setMaxHours(double maxHours) {
		this.maxHours = maxHours;
	} 
	
	/**
	 * 
	 * @param hoursWorked
	 * @return amount of gross pay per week
	 * @author Colin Cui
	 */
	public double calcGrossPay(double hoursWorked) {
		
		final int numYearlyWeeks = 52;
		final int weeklyHours = 40;
		final int weeklyMaxHours = 60;
		final double overTimePayIncrease = 1.5;
		
		if (type == 'S') {			
			return payRate / numYearlyWeeks;
		}
		
		if (type == 'H') {			
			if (hoursWorked > weeklyMaxHours) {
				return payRate * weeklyHours + payRate * overTimePayIncrease * (weeklyMaxHours - weeklyHours);
			}
			if (hoursWorked > weeklyHours) {
				return payRate * weeklyHours + (hoursWorked - weeklyHours) * payRate * overTimePayIncrease;
			}
			return payRate * hoursWorked;
		}
		
		if (type == 'C') {
			if (hoursWorked > maxHours) {
				return payRate * maxHours;
			}
			return payRate * hoursWorked;
		}	
		else {
			return 0;
		}
	}
	/**
	 * 
	 * @param grossWkPay
	 * @return amount of deduction from Federal Income Tax
	 */
	public double calcWithhold(double grossWkPay) {
		
		final double firstTaxBracket = 1000 * 0.075;
		final double secondTaxBracket = 1000 * 0.12;
		
		if (grossWkPay < 1000) {
			return grossWkPay * 0.075;
		}
		if (grossWkPay < 2000 && grossWkPay > 1000) {
			return (grossWkPay - 1000) * 0.12 + firstTaxBracket;
		}
		return (grossWkPay - 2000) * 0.17 + firstTaxBracket + secondTaxBracket;
			
	}
	/**
	 * 
	 * @param grossWkPay
	 * @return amount of deduction from CPP
	 */
	public double calcCPP(double grossWkPay) {
		return grossWkPay * 0.0475;
	}
	/**
	 * 
	 * @param grossWkPay
	 * @return amount of deduction from EI
	 */
	public double calcEI(double grossWkPay) {
		return grossWkPay * 0.018;
	}
	/**
	 * 
	 * @param grossWkPay
	 * @return amount of deduction from Extended Health Benefit
	 */
	public double calcExtHealth(double grossWkPay) {
		if (type == 'S' || type == 'H') {			
			return grossWkPay * 0.013;
		}
		return 0;
	}
	/**
	 * 
	 * @param grossWkPay
	 * @return amount of deduction from union dues
	 */
	public double calcUnionDues(double grossWkPay) {
		if (type == 'H') {
			return grossWkPay * 0.01;
		}
		return 0;
	}
}
