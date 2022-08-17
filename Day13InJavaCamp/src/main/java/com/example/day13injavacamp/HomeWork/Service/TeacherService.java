package com.example.day13injavacamp.HomeWork.Service;

import com.example.day13injavacamp.HomeWork.Exception.MessageException;
import com.example.day13injavacamp.HomeWork.Repositry.TeacherRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TeacherService {



        private final TeacherRepositry teacherRepository;

        public List<TeacherService> getStudent() {
            return teacherRepository.findAll();
        }

        public void addTeacher(TeacherService teacher) {
            teacherRepository.save(teacher);
        }

        public void putTeacher(Integer id, TeacherService teacher) {
            TeacherService oldTeacher=teacherRepository.getById(id);
            oldTeacher.setName(teacher.getName());
            oldTeacher.setSalary(teacher.getSalary());
            teacherRepository.save(oldTeacher);

        }

        public void deleteTeacher(Integer id) {
            TeacherService teacher = teacherRepository.getById(id);
            teacherRepository.delete(teacher);
        }
        public TeacherService findTeacherById(Integer id){
            TeacherService teacher = teacherRepository.findTeacherById(id);
            if(teacher==null){
                throw new MessageException("Wrong teacher ID!");
            }
            return teacher;
        }
        public List<TeacherService> getTeachersBySalary(Integer salary) {
            List<TeacherService> teachers= teacherRepository.findBySalaryGreaterThanEqual(salary);
            if (teachers.isEmpty()){
                throw new MessageException("There is no teachers by this salary or grater than!");
            }
            return teachers;
        }
}
