package week1.day3.student;
import week1.day3.resultgenerators.ResultGenerator;

public class StudentDemo {
    void storeStudentData(Student stud){
        stud.studentId = 1;
        stud.studentName = "Dhiraj";
        stud.gender = "Male";
        stud.sub.addMarks(55.50f, 76.45f, 89.66f);
    }

    public static void main(String[] args) {
        StudentDemo studDemo = new StudentDemo();
        Student stud = new Student();
        ResultGenerator res = new ResultGenerator();
        studDemo.storeStudentData(stud);
        res.generateResult(stud);
    }
}
