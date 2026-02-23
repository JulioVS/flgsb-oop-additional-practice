// TestEncapsulation class to test the Employee class
public class TestEncapsulation {
    public static void main(String[] args) {

        // Step 1: Create two instances of the Employee class
        // One using the parameterized constructor and one using default constructor with setters
        System.out.println("\nStep 1:\n");

        Employee e1, e2;

        e1 = new Employee("Julio", 53, 900);
        e2 = new Employee();

        e2.setName("Annika");
        e2.setAge(31);
        e2.setSalary(1500.0);
        
        // Step 2: Print details of both employees
        System.out.println("\nStep 2:\n");

        e1.displayDetails();
        e2.displayDetails();
        
        // Step 3: Try setting invalid values (null name, age outside range, negative salary)
        // and see if your validation works
        System.out.println("\nStep 3:\n");

        e1.setName(null);
        e1.setAge(17);
        e1.setSalary(-1);
        
        // Step 4: Give both employees a 10% raise and display their details again
        System.out.println("\nStep 4:\n");

        e1.giveRaise(10);
        e2.giveRaise(10);

        e1.displayDetails();
        e2.displayDetails();
        
        // Step 5: Clone the first employee and display the cloned employee details
        // Hint: Use try-catch block to handle CloneNotSupportedException
        // Employee clonedEmployee = (Employee) employee1.clone();
        System.out.println("\nStep 5:\n");
        Employee e3; 

        try {
            e3 = (Employee) e1.clone();
            e3.displayDetails();
        }
        catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
            e3 = new Employee();
        }
        
        // Step 6: Modify the original employee and verify that the clone remains unchanged
        // This demonstrates that cloning creates a separate object
        System.out.println("\nStep 6:\n");

        e1.setName("Julianna");
        e1.setAge(25);

        e1.displayDetails();
        e3.displayDetails();

        // Step 7: Create a method that compares the salaries of two employees
        // and returns the name of the employee with the higher salary
        // If salaries are equal, return "Equal salaries"
        System.out.println("\nStep 7:\n");

        System.out.println(compareSalaries(e1,e2));
        System.out.println(compareSalaries(e2,e3));
        System.out.println(compareSalaries(e1,e3));
    
        // End of exercise
        System.out.println("\n-End-\n");

    }

    public static String compareSalaries(Employee e1, Employee e2) {
        if (e1.getSalary() > e2.getSalary()) {
            return e1.getName();
        }
        else if (e2.getSalary() > e1.getSalary()) {
            return e2.getName();
        }
        else {
            return "Equal salaries";
        }
    }

}
