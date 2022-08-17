package com.example.day13injavacamp.HomeWork.Controller;

import com.example.day13injavacamp.HomeWork.DTO.ApiResponse;
import com.example.day13injavacamp.HomeWork.Service.TeacherService;
//import com.example.day13injavacamp.HomeWork.model.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class Teacher {

    private final TeacherService teacherService;
    @GetMapping
    public ResponseEntity<List> getTeacher(){
        List<TeacherService> teachers=teacherService.getStudent();
        return ResponseEntity.status(200).body(teachers);
    }
    @PostMapping
    public ResponseEntity<ApiResponse> setTeacher(@RequestBody @Valid TeacherService teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(201).body(new ApiResponse("New teacher added !",201));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> putTeacher(@RequestBody @Valid TeacherService teacher, @PathVariable Integer id){
        teacherService.putTeacher(id,teacher);
        return ResponseEntity.status(201).body(new ApiResponse("New teacher updated !",201));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteTeacher(@PathVariable @Valid Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(201).body(new ApiResponse("New teacher deleted !",201));

    }
    // get by teacher by id
    @GetMapping("/search/{id}")
    public ResponseEntity getTeacherByID(@PathVariable @Valid Integer id){
        TeacherService teacher=teacherService.findTeacherById(id);
        return ResponseEntity.status(200).body(teacher);
    }
    @GetMapping("/salary")
    public ResponseEntity<List> getTeachersBySalary(@RequestBody Integer salary){
        List<TeacherService> teachers= teacherService.getTeachersBySalary(salary);
        return ResponseEntity.status(200).body(teachers);
    }
}
