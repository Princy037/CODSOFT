import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asking for the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        int totalMarks = 0;
        // Input marks for each subject and calculate the total
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            totalMarks += scanner.nextInt();
        }

        // Calculate the average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;
        String grade;

        // Assign grade based on average percentage
        if (averagePercentage >= 90) grade = "A";
        else if (averagePercentage >= 80) grade = "B";
        else if (averagePercentage >= 70) grade = "C";
        else if (averagePercentage >= 60) grade = "D";
        else grade = "F";

        // Display the results
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
