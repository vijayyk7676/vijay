package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> theStudents;

    // define @PostConstruct to load the student data .. only once!

    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Vijay", "Kumar"));
        theStudents.add(new Student("Praveen", "Kumar"));
        theStudents.add(new Student("Pravallika", "Besta"));

    }
    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if((studentId > theStudents.size() || studentId <0)){
            throw new StudentNotFoundException("Student not found - " + studentId);
        }
        return theStudents.get(studentId);

    }

}










