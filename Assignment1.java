package assignment1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Mykyta Naumenko #200348171
 */

public class Assignment1 extends Application {
    Stage window;
    TableView<Subject> table;
    TextField cNameInput, cNumInput, instInput, gradeInput;
    Button addInput, deleteInput;
    ArrayList<Integer> gradeList = new ArrayList();
    Label avgValue = new Label();
    Label letterValue = new Label();
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Set up the Stage
        window = primaryStage;
        window.setTitle("Courses and Grades");
        
        //BEGIN ADDING COLUMNS TO THE TABLEVIEW
        //1st column
        TableColumn<Subject, String> nameColumn = new TableColumn<>("Course Name");
        nameColumn.setMinWidth(270);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        
        //2nd column
        TableColumn<Subject, String> numColumn = new TableColumn<>("Course Code");
        numColumn.setMinWidth(150);
        numColumn.setCellValueFactory(new PropertyValueFactory<>("courseNum"));
        
        //3rd column
        TableColumn<Subject, String> instructorColumn = new TableColumn<>("Instructor");
        instructorColumn.setMinWidth(200);
        instructorColumn.setCellValueFactory(new PropertyValueFactory<>("instructor"));
        
        //4th column
        TableColumn<Subject, String> gradeColumn = new TableColumn<>("Grade");
        gradeColumn.setMinWidth(50);
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
        
        //5th column 
   
        TableColumn<Subject, String> letterGradeColumn = new TableColumn<>("Letter Grade");
        letterGradeColumn.setMinWidth(50);
        letterGradeColumn.setCellValueFactory(new PropertyValueFactory<>("letterGrade"));
        //END OF THE COLUMNS
        
        //INPUT FIELDS AND BUTTONS
        //Course Name
        cNameInput = new TextField();
        cNameInput.setPromptText("Course Name");
        cNameInput.setMinWidth(100);
        //Course Num
        cNumInput = new TextField();
        cNumInput.setPromptText("Course Code");
        cNumInput.setMinWidth(100);
        //Instructor
        instInput = new TextField();
        instInput.setPromptText("Instructor");
        instInput.setMinWidth(100);
        //Grade
        gradeInput = new TextField();
        gradeInput.setPromptText("Course Grade");
        gradeInput.setMinWidth(50);
        //Add Button
        addInput = new Button("Add");
        addInput.setOnAction(e -> addButtonPress());
        //Delete Button
        deleteInput = new Button("Remove");
        deleteInput.setOnAction(e -> deleteButtonPress());
        //END INPUTS
        
        Label avgLabel = new Label("Your average grade is: ");
        Label letterLabel = new Label(", which is the letter grade of: ");
        
        //Add the data to the tableview
        table = new TableView<>();
        table.setItems(getData());
        table.getColumns().addAll(nameColumn, numColumn, instructorColumn, gradeColumn, letterGradeColumn);
        
        //Setting up the Layouts
        HBox inputsLayout = new HBox();
        inputsLayout.setPadding(new Insets(10, 10, 10, 10));
        inputsLayout.setSpacing(10);
        inputsLayout.getChildren().addAll(cNameInput, cNumInput, instInput, gradeInput, addInput, deleteInput);
                
        HBox labelsLayout = new HBox();
        labelsLayout.setPadding(new Insets(0, 10, 10, 10));
        labelsLayout.getChildren().addAll(avgLabel, avgValue, letterLabel, letterValue);
        
        VBox layout = new VBox();
        layout.getChildren().addAll(table, inputsLayout, labelsLayout);
        
        Scene scene = new Scene(layout, 760, 400);
        window.setScene(scene);
        window.show();
        
        //Run method to check the average
        pureMagic();
    }
 
    //Default values present in the table
    public ObservableList<Subject> getData(){
        ObservableList<Subject> course = FXCollections.observableArrayList();
        course.add(new Subject("Programming Fundamentals", "COMP1030", "Jaret Wright", 99));
        course.add(new Subject("Project Management", "MGMT2003", "Jaret Wright", 88));
        course.add(new Subject("Relational DB", "COMP2003", "Jaret Wright", 76));
        course.add(new Subject("Web Fundamentals", "COMP1002", "Rich Freeman", 91));
        course.add(new Subject("Math for the Computer Industry", "MATH1003", "Anju Chawla", 75));
        return course;
    }
    
    //What happens when "Add" button is pressed
    public void addButtonPress(){
        Subject grade = new Subject();
        grade.setCourseName(cNameInput.getText());
        grade.setCourseNum(cNumInput.getText());
        grade.setInstructor(instInput.getText());
        grade.setGrade(Integer.parseInt(gradeInput.getText()));
        double inputGrade = Double.parseDouble(gradeInput.getText());
        grade.setLetterGrade(letterConverter(inputGrade));
        table.getItems().add(grade);
        cNameInput.clear();
        cNumInput.clear();
        instInput.clear();
        gradeInput.clear();
        pureMagic();
    }
    
    //What happens when the "Remove" button is pressed
    public void deleteButtonPress(){
        ObservableList<Subject> courseSelected, allCourse;
        allCourse = table.getItems();
        courseSelected = table.getSelectionModel().getSelectedItems();
        courseSelected.forEach(allCourse::remove);
        pureMagic();
    }
    
    //Calculates the average in the Array
    private double calculateAverage(List <Integer> marks) {
        Integer sum = 0;
        if(!marks.isEmpty()) {
            sum = marks.stream().map((mark) -> mark).reduce(sum, Integer::sum);
            return sum.doubleValue() / marks.size();
          }
          return sum;
        }
    
    //Takes a double and passes it down through IFs to find corresponding Letter, returns string with letter
    public static String letterConverter(double grade) {
        String letterGrade = null;
        if(grade >= 80.0){
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
    
    //This method clears the Array and calculates everything again, also it assignes values to the labels.
    //After the ammount of time i spent figuring this out, this method trully seems like magic 
    public void pureMagic(){
        gradeList.clear();
        table.getItems().forEach(item -> gradeList.add(item.getGrade()));
        
        double avg = calculateAverage(gradeList);
        DecimalFormat decimals = new DecimalFormat("#.#");
        
        avgValue.setText(decimals.format(avg) + "%");
        letterValue.setText(letterConverter(calculateAverage(gradeList)));
    }
}
