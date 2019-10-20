package week1.day3.subjects;

public class Subject {
    String subject1, subject2, subject3;
    float marks1, marks2, marks3;
    public void addMarks(float m1, float m2, float m3){
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
    }
    public void averageMarks(){
        System.out.println("Subject1: "+this.marks1+" Subject2: "+this.marks2+" Subject3: "+ this.marks3);
        float totalMarks = this.marks1 + this.marks2 + this.marks3;
        float averageMarks = totalMarks/3;
        System.out.println("Total Marks: "+ totalMarks);
        System.out.println("Average Marks: "+ averageMarks);
    }

}
