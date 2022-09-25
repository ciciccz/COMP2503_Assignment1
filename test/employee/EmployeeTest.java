/**
 * 
 */
package employee;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author rafaelalarcon
 *
 */
public class EmployeeTest {
	
	
	Employee[] empList;
	
	@Before	
	public void setup() {
		empList = new Employee[] {
				new Employee(20101, "Arnold", "Finance", 'S', 78000.0, 168.0),
				new Employee(20112, "Bernie", "Personnel", 'H', 20.0, 60.0),
				new Employee(20123, "Carole", "Research", 'C', 70.0, 30.0),
		};
	}

	
	/**
	 * Test method for {@link employee.Employee#calcNetPay(double)}.
	 */
	@Test
	public void testCalcNetPay() {
		
		double netPay0 = empList[0].calcNetPay(20);
		assertEquals (1247.25, netPay0, 0.01);
		
		double netPay1 = empList[1].calcNetPay(61);
		assertEquals ((1400 - 48 - 75 - 66.5 - 25.2 - 18.20 - 14), netPay1, 0.01);
		
		double netPay2 = empList[2].calcNetPay(120);
		assertEquals (1750.45, netPay2, 0.01);
}

	/**
	 * Test method for {@link employee.Employee#compareTo(java.lang.Object)}.
	 */
	@Test
	public void testCompareTo() {
		
		assertEquals(1, empList[2].compareTo(empList[0]));
		assertEquals(0, empList[0].compareTo(empList[0]));
		assertEquals(-1, empList[0].compareTo(empList[2]));
	}
}