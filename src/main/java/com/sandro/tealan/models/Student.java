package com.sandro.tealan.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sandro.tealan.enums.Status;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 15.11.2023
 */

@Entity(name = "students")
@Getter
@Setter
@SuperBuilder
@ToString(exclude = "lessons")
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Transactional
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "students_seq")
    @SequenceGenerator(name = "students_seq", sequenceName = "members_students", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int balance;
    private Status status;
    private LocalDate createdAt;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<StudentLanguageLevel> languageLevel;

    @Transient
    private Set<LanguageResource> languageResources;

    @JsonIgnoreProperties({"students"})
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Lesson.class, mappedBy = "students")
    private Set<Lesson> lessons;

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
