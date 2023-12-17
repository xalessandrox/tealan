package com.sandro.tealan.services.implementations;

import com.sandro.tealan.enums.Status;
import com.sandro.tealan.models.Student;
import com.sandro.tealan.models.StudentLanguageLevel;
import com.sandro.tealan.repositories.JpaStudentLanguageLevelRepository;
import com.sandro.tealan.repositories.JpaStudentRepository;
import com.sandro.tealan.services.LanguageService;
import com.sandro.tealan.services.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 15.11.2023
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final JpaStudentRepository jpaStudentRepository;
    private final JpaStudentLanguageLevelRepository jpaStudentLanguageLevelRepository;
    private final LanguageService languageService;

    @Override
    public Student saveStudent(Student student) {
        log.info("Creating student {}", student);
        student.setCreatedAt(LocalDate.now());
        student.setStatus(Status.ENABLED);
        languageService.mapLanguageEnum(student);
        return student;
    }

    @Override
    public Page<Student> getAllStudents(int pageNumber, int size) {
        log.info("Retrieving students");
        Page<Student> pageStudent = jpaStudentRepository.findAll(PageRequest.of(pageNumber, size));
        List<Student> students = pageStudent.getContent();
        languageService.mapLanguageEnum(students.toArray(Student[]::new));
        languageService.sortLanguageLevel(students.toArray(Student[]::new));
        return pageStudent;
    }

    @Override
    public Student getStudentDetail(Long studentId) {
        Student student = jpaStudentRepository.findById(studentId).orElseThrow();
        languageService.mapLanguageEnum(student);
        Collections.sort(student.getLanguageLevel());
        return student;
    }

    @Override
    public Student updateStudent(Student student) {

        List<StudentLanguageLevel> languageLevels = student.getLanguageLevel();
        for (StudentLanguageLevel languageLevel : languageLevels) {
            languageLevel.setStudent(student);
            jpaStudentLanguageLevelRepository.save(languageLevel);
        }
        Collections.sort(languageLevels);
        student.setLanguageLevel(languageLevels);
        return jpaStudentRepository.save(student);
    }
}
