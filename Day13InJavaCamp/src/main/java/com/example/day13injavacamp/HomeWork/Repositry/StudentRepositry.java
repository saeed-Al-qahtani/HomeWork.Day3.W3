package com.example.day13injavacamp.HomeWork.Repositry;


import com.example.day13injavacamp.HomeWork.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Integer> {

    StudentModel findStudentById(Integer id);
    StudentModel findStudentByName(String name);
    List<StudentModel> findAllByMajor(String major);
    List<StudentModel> findByAgeGreaterThanEqual(Integer age);

}