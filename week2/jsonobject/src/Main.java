import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class Main {
    private String studentName, teacherName, studentStd, studentDOJ, studentID, teacherID, teacherDOJ;
    private Map<String, Long> marks = new HashMap<>();
    private List<String> teacherClasses = new ArrayList<>();

    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

    public void setTeacherName(String teacherName){
        this.teacherName = teacherName;
    }

    public void setStudentID(String studentID){
        this.studentID = studentID;
    }

    public void setStudentDOJ(String studentDOJ){
        this.studentDOJ = studentDOJ;
    }

    public void setTeacherID(String teacherID){
        this.teacherID = teacherID;
    }

    public void setTeacherDOJ(String teacherDOJ){
        this.teacherDOJ = teacherDOJ;
    }

    public void setStudentStd(String studentStd){
        this.studentStd = studentStd;
    }

    public void setMarks(String subject, long mark){
        this.marks.put(subject, mark);
    }

    public void setTeacherClasses(String classes){
        this.teacherClasses.add(classes);
    }

    public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
        JSONParser parser = new JSONParser();
        Main mainObj = new Main();
        Reader reader = new FileReader("/Users/cb-dhiraj/Task/src/week2/js.json");

        Object jsonObj = parser.parse(reader);

        JSONObject jsonObject = (JSONObject) jsonObj;

        JSONObject student = (JSONObject) jsonObject.get("Student");
        System.out.println("Student = " + student);

        String name = (String) student.get("Name");
        mainObj.setStudentName(name);
        System.out.println("Name = "+ name);

        String std = (String) student.get("Std");
        mainObj.setStudentStd(std);
        System.out.println("Std = "+ std);

        String DOJ = (String) student.get("Date of Joining");
        mainObj.setStudentDOJ(DOJ);
        System.out.println("Date of Joining = "+ DOJ);

        String ID = (String) student.get("ID");
        mainObj.setStudentID(ID);
        System.out.println("ID = " + ID);

        JSONArray marks = (JSONArray) student.get("Marks");

        for(int i=0; i<marks.size(); i++){
            JSONObject item  = (JSONObject) marks.get(i);
            String subject = (String) item.get("Subject");
            long mark = (long) item.get("Mark");
            mainObj.setMarks(subject, mark);
            System.out.println("Subject = " + subject + " - Mark = " + mark);
        }

        JSONObject teacher = (JSONObject) jsonObject.get("Teacher");
        String teacherName = (String) teacher.get("Name");
        mainObj.setTeacherName(teacherName);
        System.out.println("Name = "+ teacherName);

        String teacherDOJ = (String) teacher.get("Date of Joining");
        mainObj.setTeacherDOJ(teacherDOJ);
        System.out.println("Date of Joining = "+ teacherDOJ);

        String teacherID = (String) teacher.get("ID");
        mainObj.setTeacherID(teacherID);
        System.out.println("ID = " + teacherID);

        JSONArray classes = (JSONArray) teacher.get("Classes Taking Care Of");

        for(int i=0 ; i<classes.size() ; i++){
            String cl = (String) classes.get(i);
            mainObj.setTeacherClasses(cl);
            System.out.println(cl);
        }

        reader.close();
    }
    }