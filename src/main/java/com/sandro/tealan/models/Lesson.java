package com.sandro.tealan.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 15.11.2023
 */

@Entity
@Table(name= "lessons")
@Getter
@Setter
@ToString(exclude = "students")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @CreatedDate
    private Date createdAt;
    private Date startsAt;
    private Date finishesAt;
    private int duration;
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Student.class)
    @JsonIgnoreProperties({"lessons"})
    private List<Student> students;
    @Transient
    private LanguageResource language;

}
