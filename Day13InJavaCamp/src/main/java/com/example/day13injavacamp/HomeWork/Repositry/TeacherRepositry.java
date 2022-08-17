package com.example.day13injavacamp.HomeWork.Repositry;

import com.example.day13injavacamp.HomeWork.model.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepositry extends JpaRepository<TeacherModel,Integer> {
    TeacherModel findTeacherById(Integer id);
    List<TeacherModel> findBySalaryGreaterThanEqual(Integer salary);


}