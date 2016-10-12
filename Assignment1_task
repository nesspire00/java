package assignment1;

import java.util.Scanner;

/**
 *
 * @author Mykyta Naumenko #200348171
 */
public class Assignment1 {

    public static void main(String[] args) {
        
        //Prompt user to enter a grade 5 times and store it
        double grade1 = promptUser();
        double grade2 = promptUser();
        double grade3 = promptUser();
        double grade4 = promptUser();
        double grade5 = promptUser();
        
        //Print the grades and send them to the grade-to-lettergrade converter method
        System.out.printf("%nThe mark for your first course was %.0f%%, which is the letter grade of %s", grade1, letterConverter(grade1));
        System.out.printf("%nThe mark for your second course was %.0f%%, which is the letter grade of %s", grade2, letterConverter(grade2));
        System.out.printf("%nThe mark for your third course was %.0f%%, which is the letter grade of %s", grade3, letterConverter(grade3));
        System.out.printf("%nThe mark for your fourth course was %.0f%%, which is the letter grade of %s", grade4, letterConverter(grade4));
        System.out.printf("%nThe mark for your fifth course was %.0f%%, which is the letter grade of %s", grade5, letterConverter(grade5));
        
        //Send the grades to the method which prints the average out.
        printAverage(grade1, grade2, grade3, grade4, grade5);
    }
    
    //Convert grades to lettergrades
    public static String letterConverter(double grade) {
        String letterGrade = "";
        if(grade >= 80.0 && grade <= 100.0){
            letterGrade = "A";
        } else if (grade <= 79.0 && grade >= 70.0){
            letterGrade = "B";
        } else if (grade <= 69.0 && grade >= 60.0) {
            letterGrade = "C";
        } else if (grade <= 59.0 && grade >= 50.0) {
            letterGrade = "D";
        } else if (grade <= 49.0 && grade >= 0.0) {
            letterGrade = "F";  
        }
        return letterGrade;
    }
    
    //Prompt user to enter a grade
    public static double promptUser(){
        System.out.print("Please enter a grade: ");
        Scanner key = new Scanner(System.in);
        double grade = key.nextDouble();
        return grade;
    }
    
    //Prints out the average grade, and throws it to the letterConverter method
    public static void printAverage(double g1, double g2, double g3, double g4, double g5){
        double avg = (g1 + g2 + g3 + g4 + g5) / 5;
        System.out.printf("%nYour overall average grade is %.1f%%, which is the letter grade of %s%n", avg, letterConverter(avg));
    }
}
