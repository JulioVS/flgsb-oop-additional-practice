// StudentRegistry class to test the Student class
public class StudentRegistry {
    public static void main(String[] args) {

        // Step 1: Create two instances of the Student class
        System.out.println("\nStep 1:\n");

        Student s1 = new Student();
        Student s2 = new Student();
        
        
        // Step 2: Use setter methods to set values for all attributes of first student
        // Example values: ID "S001", name "John Doe", grade 85.5, active true
        System.out.println("\nStep 2:\n");

        s1.setStudentId("A001");
        s1.setName("Annika");
        s1.setGrade(90);
        s1.setIsActive(true);
        
        // Step 3: Set values for second student
        // Example values: ID "S002", name "Jane Smith", grade 92.0, active true
        System.out.println("\nStep 3:\n");

        s2.setStudentId("B001");
        s2.setName("Julian");
        s2.setGrade(75);
        s2.setIsActive(true);        
        
        // Step 4: Display details of both students
        System.out.println("\nStep 4:\n");

        s1.displayDetails();
        s2.displayDetails();

        // Step 5: Compare the grades of the two students and print who has the higher grade
        // Hint: Create a separate method for this comparison
        System.out.println("\nStep 5 and 9:\n");

        Student best = compareGrades(s1, s2);
        System.out.println(best.getName() 
                            + " is the best student with a grade of " 
                            + best.getGrade()
                            + " and a letter of '"
                            + best.getLetterGrade()
                            + "'.\n");

        // Step 6: Test the letter grade method for both students
        System.out.println("\nStep 6:\n");

        System.out.println(s1.getName() + " has a grade of '" + s1.getLetterGrade() + "'.");
        System.out.println(s2.getName() + " has a grade of '" + s2.getLetterGrade() + "'.");
        
        // Step 7: Test the passing status method for both students
        System.out.println("\nStep 7:\n");

        System.out.println(s1.getName() + (s1.isPassing() ? " is passing!" : " is failing."));
        System.out.println(s2.getName() + (s2.isPassing() ? " is passing!" : " is failing."));

        // Step 8: Change one student to inactive and display the updated information
        System.out.println("\nStep 8:\n");
        
        s2.setIsActive(false);
        s2.displayDetails();

        // End of exercise
        System.out.println("\n-End-\n");

    }
    
    // Step 9: Create a static method to compare two students' grades and return the student with the higher grade
    // Hint: Take two Student objects as parameters
    public static Student compareGrades(Student s1, Student s2) {
        if (s1.getGrade() >= s2.getGrade()) {
            return s1;
        }
        else {
            return s2;
        }
    }

}
