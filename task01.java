// Java Program to manage student details, calculate percentage, grade, and scholarship eligibility
import java.util.Scanner;

// Student Class to hold student details and perform calculations
class Student {

    // Student Details
    String name;
    int rollNo;
    int[] marks = new int[5];
    double percentage;
    String grade;
    double attendance;
    boolean isFailInAnySubject = false;

    // Calculate Percentage
    void calculatePercentage() {

        int sum = 0;

        for (int i = 0; i < 5; i++) {
            sum += marks[i];

            if (marks[i] < 50) {
                isFailInAnySubject = true;
            }
        }

        percentage = (sum / 500.0) * 100;
    }

    // Calculate Grade
    void calculateGrade() {

        if (isFailInAnySubject) {
            grade = "F";
        }
        else if (percentage >= 85) {
            grade = "A";
        }
        else if (percentage >= 70) {
            grade = "B";
        }
        else if (percentage >= 50) {
            grade = "C";
        }
        else {
            grade = "F";
        }
    }

    // Scholarship Check
    boolean checkScholarship(double percentage, double attendance) {

        return (percentage > 85 && attendance > 90 && !isFailInAnySubject);
    }

    // Display Result
    void displayResult() {

        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Percentage: " + percentage);
        System.out.println("Grade: " + grade);

        if (checkScholarship(percentage, attendance)) {
            System.out.println("Scholarship: Eligible");
        } else {
            System.out.println("Scholarship: Not Eligible");
        }

        System.out.println("----------------------------------");
    }
}


public class task01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[5];

        for (int i = 0; i < 5; i++) {

            students[i] = new Student();
            System.out.println("==============================");
            System.out.println("Enter details for Student " + (i + 1));
            System.out.println("==============================");
            // Safe Name Input
           while(true) {
                System.out.print("Enter Name: ");
                students[i].name = sc.nextLine();
                if (!students[i].name.trim().isEmpty()) {
                    break;
                } else {
                    System.out.println("Name cannot be empty. Please enter a valid name.");
                }
            }
            // Safe Roll No Input
            while (true) {
                try {
                    System.out.print("Enter Roll No: ");
                    students[i].rollNo = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter numeric Roll No.");
                }
            }

            // Safe Marks Input
            for (int j = 0; j < 5; j++) {
                while (true) {
                    try {
                        System.out.print("Enter marks of Subject " + (j + 1) + ": ");
                        int m = Integer.parseInt(sc.nextLine());

                        if (m >= 0 && m <= 100) {
                            students[i].marks[j] = m;
                            break;
                        } else {
                            System.out.println("Marks must be between 0 and 100.");
                        }

                    } catch (Exception e) {
                        System.out.println("Invalid input! Enter numeric marks.");
                    }
                }
            }

            // Safe Attendance Input
            while (true) {
                try {
                    System.out.print("Enter Attendance (%): ");
                    double att = Double.parseDouble(sc.nextLine());

                    if (att >= 0 && att <= 100) {
                        students[i].attendance = att;
                        break;
                    } else {
                        System.out.println("Attendance must be between 0 and 100.");
                    }

                } catch (Exception e) {
                    System.out.println("Invalid input! Enter numeric attendance.");
                }
            }

            students[i].calculatePercentage();
            students[i].calculateGrade();
        }

        // Display Results
        System.out.println("\n===== STUDENT RESULTS =====\n");

        for (int i = 0; i < 5; i++) {
            students[i].displayResult();
        }

        // Find Topper (Only Passed Students Considered)
        Student topper = null;

        for (int i = 0; i < 5; i++) {

            if (!students[i].isFailInAnySubject) {

                if (topper == null || students[i].percentage > topper.percentage) {
                    topper = students[i];
                }
            }
        }

        System.out.println("===== CLASS TOPPER =====");

        if (topper != null) {
            System.out.println("Topper Name: " + topper.name);
            System.out.println("Roll No: " + topper.rollNo);
            System.out.println("Percentage: " + topper.percentage);
        } else {
            System.out.println("No student qualified as topper (All failed).");
        }

        sc.close();
    }
}