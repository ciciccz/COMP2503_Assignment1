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
	 * 
	 * @param employee
	 * @param empNo
	 * @param empName
	 * @param deparment
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
	 * 
	 * @return
	 * @author Colin Cui and rafaelalarcon
	 */
	public int getEmpNo() {
		return empNo;
	}


	/**
	 * 
	 * @param empNo
	 * @author Colin Cui and rafaelalarcon
	 */
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	
	/**
	 * 
	 * @return empName String with the employee name
	 * @author Colin Cui and rafaelalarcon
	 */
	public String getEmpName() {
		return empName;
	}


	/**
	 * 
	 * @param empName
	 * @author Colin Cui and rafaelalarcon
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}


	/**
	 * 
	 * @return
	 * @author Colin Cui and rafaelalarcon
	 */
	public String getDeparment() {
		return deparment;
	}


	/**
	 * 
	 * @param deparment
	 * @author Colin Cui and rafaelalarcon
	 */
	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}


	/**
	 * 
	 * @return
	 * @author Colin Cui and rafaelalarcon
	 */
	public char getType() {
		return type;
	}


	/**
	 * 
	 * @param type
	 * @author Colin Cui and rafaelalarcon
	 */
	public void setType(char type) {
		this.type = type;
	}


	/**
	 * 
	 * @return
	 * @author Colin Cui and rafaelalarcon
	 */
	public double getPayRate() {
		return payRate;
	}


	/**
	 * 
	 * @param payRate
	 * @author Colin Cui and rafaelalarcon
	 */
	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}


	/**
	 * 
	 * @return
	 * @author Colin Cui and rafaelalarcon
	 */
	public double getMaxHours() {
		return maxHours;
	}


	/**
	 * 
	 * @param maxHours
	 * @author Colin Cui and rafaelalarcon
	 */
	public void setMaxHours(double maxHours) {
		this.maxHours = maxHours;
	} 
	
	/**
	 * 
	 * @param hoursWorked
	 * @return
	 * @author Colin Cui and rafaelalarcon
	 */
	public double calcGrossPay(double hoursWorked) {
		switch (type) {
		case 'S':
			return payRate / 52;
		case 'H':
			if (hoursWorked > 40) {
				return payRate * 40 + (hoursWorked - 40) * payRate * 1.5;
			}
			return payRate * hoursWorked;
		}
		return payRate * hoursWorked;
	}
}
