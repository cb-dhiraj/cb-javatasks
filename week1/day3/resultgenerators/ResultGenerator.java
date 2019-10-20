package week1.day3.resultgenerators;
import week1.day3.student.Student;

public class ResultGenerator {
    public static void generateResult(Student stud){
        System.out.println("Student Id: " + stud.studentId + " Student Name: "+ stud.studentName + " Student Gender: "+ stud.gender);
        stud.sub.averageMarks();
    }
}
