package com.example.day13injavacamp.HomeWork.Controller;

import com.example.day13injavacamp.HomeWork.DTO.ApiResponse;
import com.example.day13injavacamp.HomeWork.Service.StudentService;
import com.example.day13injavacamp.HomeWork.advisor.Student;
import com.example.day13injavacamp.HomeWork.model.StudentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public ResponseEntity<List<StudentService>> getStudent(){
        List<StudentService> students=studentService.getStudent();
        return ResponseEntity.status(200).body(students);
    }
    @PostMapping
    public ResponseEntity<ApiResponse> setStudent(@RequestBody @Valid StudentService student){
        studentService.addStudent(student);
        return ResponseEntity.status(201).body(new ApiResponse("New student added !",201));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> putStudent(@RequestBody @Valid StudentService student , @PathVariable Integer id){
        studentService.putStudent(id,student);
        return ResponseEntity.status(201).body(new ApiResponse("New student updated !",201));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable @Valid Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(201).body(new ApiResponse("New student deleted !",201));

    }
    // get by Student by id
    @GetMapping("/id/{id}")
    public ResponseEntity getStudentByID(@PathVariable @Valid Integer id){
        StudentModel student=studentService.getStudentById(id);
        return ResponseEntity.status(200).body(student);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity getStudentByName(@PathVariable @Valid String name){
        StudentModel student=studentService.findStudentByName(name);
        return ResponseEntity.status(200).body(student);
    }
    @GetMapping("major/{major}")
    public ResponseEntity getStudentsByMajor(@PathVariable @Valid String major){
        StudentModel student= (StudentModel) studentService.getStudentsByMajor(major);
        return ResponseEntity.status(200).body(student);

    }
    @GetMapping("/age")
    public ResponseEntity<List> getStudentsByAge(@RequestBody Integer age){
        List<StudentService> students= studentService.getStudentsByAge(age);
        return ResponseEntity.status(200).body(students);
    }


}
