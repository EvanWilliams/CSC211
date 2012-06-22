/**
 * @author Evan Williams
 * CsC 211
 * Inner Classes Lab 13.9
 * June 18th 2012
 *
 */


public class EmployeeDriver {
	    public static void main(String[] args)
	    {
	    	 Employee.Date x =  new Employee().new Date("January", 1, 2004);
	    	
	        HourlyEmployee joe = new HourlyEmployee("Joe Worker", 
	        		x, 50.50, 160);

	        System.out.println("joe's longer name is " + joe.getName());

	        System.out.println("Changing joe's name to Josephine.");
	        joe.setName("Josephine");

	        System.out.println("joe's record is as follows:");
	        System.out.println(joe);
	       }
	}
//OutPut:
//	joe's longer name is Joe Worker
//	Changing joe's name to Josephine.
//	joe's record is as follows:
//	Josephine January 1, 2004
//	$50.5 per hour for 160.0 hours

