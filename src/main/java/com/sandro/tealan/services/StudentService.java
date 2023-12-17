package com.sandro.tealan.services;

import com.sandro.tealan.models.Student;
import org.springframework.data.domain.Page;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 15.11.2023
 */


public interface StudentService {

    Student saveStudent(Student student);
    Page<Student> getAllStudents(int page, int size);

    Student getStudentDetail(Long studentId);

    Student updateStudent(Student student);
}
