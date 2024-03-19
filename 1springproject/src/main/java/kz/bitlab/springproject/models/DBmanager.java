package kz.bitlab.springproject.models;

import java.util.ArrayList;


public class DBmanager {


    private static ArrayList <Student> students = new ArrayList<>();

    private static long id = 6L;

    static {
        students.add(new Student(1L,"Bekarys","Yertay",100,"A"));
        students.add(new Student(2L,"Arman","Zhan",50,"D"));
        students.add(new Student(3L,"Zhandos","Shan",65,"C"));
        students.add(new Student(4L,"Yeldos","Zhandarbek",78,"B"));
        students.add(new Student(5L,"Zhan","zhanov",48,"F"));
    }

    public  static  void  AddStudent(Student student){
        student.setId(id);
        if(student.getExam()>90){
            student.setMark("A");
        } else if (student.getExam()>75 && student.getExam()<90) {
            student.setMark("B");
        }else if (student.getExam()>60 && student.getExam()<75) {
            student.setMark("C");
        }else if (student.getExam()>50 && student.getExam()<60) {
            student.setMark("D");
        }else{
            student.setMark("Error");
        }
        students.add(student);
        id++;
    }

    public  static  ArrayList<Student> getStudents(){
        return students;
    }

    public static Student addStudent(Long idbek){
        return students.stream().filter(student -> student.getId()==idbek).findFirst().orElseThrow();
    }

}
