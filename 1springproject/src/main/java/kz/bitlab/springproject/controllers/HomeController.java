package kz.bitlab.springproject.controllers;


import kz.bitlab.springproject.models.DBmanager;
import kz.bitlab.springproject.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String index(Model model){
        ArrayList<Student> students =  DBmanager.getStudents();
        model.addAttribute("students",students);
        return "index";
    }
    @GetMapping(value = "/addStudent")
    public String addStudent(){
        return "addStudent";
    }
    @PostMapping(value = "/addStudent")
    public String addStudent(@RequestParam("student_name") String name,
                             @RequestParam("student_surname") String surname,
                             @RequestParam("student_exam") int exam , Model model){

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);

        DBmanager.AddStudent(student);

        return "redirect:/";
    }

}