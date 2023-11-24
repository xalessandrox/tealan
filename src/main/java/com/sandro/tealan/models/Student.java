package com.sandro.tealan.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sandro.tealan.enums.Language;
import com.sandro.tealan.enums.Level;
import com.sandro.tealan.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 15.11.2023
 */

@Entity
@Getter
@Setter
@ToString(exclude = "lessons")
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private List<Language> languages;
    @Transient
    private List<LanguageResource> languageResources;
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Lesson.class, mappedBy = "students")
    @JsonIgnoreProperties({"students"})
    private List<Lesson> lessons;
    private int balance;
    private Status status;
    private Level level;
    private LocalDateTime createdAt = LocalDateTime.now();

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Student other)) return false;
        return other.getEmail().equals(this.getEmail());
    }

    @Override
    public int hashCode() {
        int hashCode = (int) (17 * this.id);
        hashCode = this.email != null ? hashCode * this.email.hashCode() : hashCode;
        return hashCode;
    }
}
