package com.sandro.tealan.models.dtos;

import com.sandro.tealan.enums.Status;
import com.sandro.tealan.models.LanguageResource;
import com.sandro.tealan.models.Lesson;
import com.sandro.tealan.models.StudentLanguageLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 01.12.2023
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int balance;
    private Status status;
    private LocalDate createdAt;
    private Set<StudentLanguageLevel> studentLanguageLevel;
    private Set<LanguageResource> languageResources;
    private Set<Lesson> lessons;

}
