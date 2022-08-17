package com.example.day13injavacamp.HomeWork.Service;

import com.example.day13injavacamp.HomeWork.Exception.MessageException;
import com.example.day13injavacamp.HomeWork.Repositry.StudentRepository;
import com.example.day13injavacamp.HomeWork.advisor.Student;
import com.example.day13injavacamp.HomeWork.model.StudentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<StudentService> getStudent() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void putStudent(Integer id, Student student) {
        Student oldStudent=studentRepository.getById(id);
        oldStudent.setAge(student.getAge());
        oldStudent.setName(student.getName());
        oldStudent.setMajor(student.getMajor());
        studentRepository.save(oldStudent);
    }

    public void deleteStudent(Integer id) {
        StudentService student=studentRepository.getById(id);
        studentRepository.delete(student);
    }
    public StudentService getStudentById(Integer id){
        StudentService student= studentRepository.findStudentById(id);
        if(student==null){
            throw new MessageException("Wrong student ID!");
        }
        return student;
    }
    public StudentService findStudentByName(String name){
        StudentService student= studentRepository.findStudentByName(name);
        if(student==null){
            throw new MessageException("Wrong student ID!");
        }
        return student;
    }
    public List<StudentService> getStudentsByMajor(String major) {
        List<StudentModel> students=studentRepository.findAllByMajor(major);
        if (students.isEmpty()){
            throw new MessageException("Wrong , try another major!");
        }
        return students;
    }
    public List<StudentService> getStudentsByAge(Integer age) {
        List<StudentService> students=studentRepository.findByAgeGreaterThanEqual(age);
        if (students.isEmpty()){
            throw new MessageException("There is no students by this age or grater than!");
        }
        return students;
    }



}
