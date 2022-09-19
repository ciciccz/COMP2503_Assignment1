package employee;

public class Employee {
	private int empNo;
	private String empName;
	private String deparment;
	private char type;
	private double payRate;
	private double maxHours;
	
	
	public Employee(int empNo, String empName, String deparment, char type, double payRate, double maxHours) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.deparment = deparment;
		this.type = type;
		this.payRate = payRate;
		this.maxHours = maxHours;
	}
	
	public Employee(Employee employee, int empNo, String empName, String deparment) {
		this.empNo = empNo;
		this.empName = empName;
		this.deparment = deparment;
		this.type = employee.type;
		this.payRate = employee.maxHours;
		this.maxHours = employee.maxHours;
	}
	
	public Employee() {
		empNo = 0;
		empName = null;
		deparment = null;
		payRate = 0;
		maxHours = 0;
	}


	public int getEmpNo() {
		return empNo;
	}


	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getDeparment() {
		return deparment;
	}


	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}


	public char getType() {
		return type;
	}


	public void setType(char type) {
		this.type = type;
	}


	public double getPayRate() {
		return payRate;
	}


	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}


	public double getMaxHours() {
		return maxHours;
	}


	public void setMaxHours(double maxHours) {
		this.maxHours = maxHours;
	} 
	
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
