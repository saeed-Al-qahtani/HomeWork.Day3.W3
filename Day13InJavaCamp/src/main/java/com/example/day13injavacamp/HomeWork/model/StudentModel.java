package com.example.day13injavacamp.HomeWork.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class StudentModel {
    @NotNull(message = "Id can't be null")
    @Id
    private Integer id;
    @NotEmpty(message = "name can't be empty")
    private String name;
    @NotNull (message = "age can't be null")
    private Integer age;
    @NotEmpty (message = "name can't be empty")
    @Column(columnDefinition = "check ( major='CS' or major='MATH' or major='Engineer ' )")
    private String major;

}