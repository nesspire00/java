package assignment1;

public class Subject {
    
    private String courseName;
    private String courseNum;
    private String instructor;
    private int grade;
    private String letterGrade;
            
    public Subject(){
        this.courseName = "";
        this.courseNum = "";
        this.instructor = "";
        this.grade = 0;
        this.letterGrade = "";
    }
   
    public Subject(String courseName, String courseNum, String instructor, int grade){
        this.courseName = courseName;
        this.courseNum = courseNum;
        this.instructor = instructor;
        this.grade = grade;
        this.letterGrade = Assignment1.letterConverter(grade);        
    }
    
    //Getters and Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }
    
}
