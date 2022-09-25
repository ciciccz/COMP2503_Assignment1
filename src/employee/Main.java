package employee;

/**
 * Main class to run Java application
 * 
 * @author Colin Cui and rafaelalarcon
 */
public class Main {
	
	/**
	 * Main method to run application
	 * 
	 * @param args String array with the method to run the application
	 * @author Colin Cui and rafaelalarcon
	 */
	public static void main(String[] args) {
		
		Employee[] empList = {
				new Employee(20101, "Arnold", "Finance", 'S', 78000.0, 168.0),
				new Employee(20112, "Bernie", "Personnel", 'H', 20.0, 60.0),
				new Employee(20123, "Carole", "Research", 'C', 70.0, 30.0),
		};
		
		testToString(empList);
		testCalcNetPay(empList);
	}
	
	/**
	 * Method to print out all the employee details to format
	 * @param empList Employee array with all current employees
	 * 
	 * @author Colin Cui and rafaelalarcon
	 * 
	 */
	private static void testToString(Employee[] empList) {
		for (Employee emp : empList) {
			System.out.println(emp.toString());
		}
	}
	
	/**
	 * MEthod to print out all current employee's net pay. 
	 * @param empList Employee array with all current employees
	 * 
	 * Employee array with all current employees
	 */
	private static void testCalcNetPay(Employee[] empList) {
		System.out.println(empList[0].calcNetPay(20));
		System.out.println(empList[1].calcNetPay(80));
		System.out.println(empList[2].calcNetPay(120));
	}

	/**
	 * Method to round up/down doubles with epsilon approach
	 * 
	 * @param a double number with amount
	 * @param b double number with amount
	 * @return boolean to compare equality with 1 cent precision
	 * 
	 * Employee array with all current employees
	 */
	private static boolean equalDouble(double a, double b) {
		return Math.abs(a - b) < 0.01;
	}

	
}
