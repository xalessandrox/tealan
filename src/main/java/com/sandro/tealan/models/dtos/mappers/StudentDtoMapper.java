package com.sandro.tealan.models.dtos.mappers;

import com.sandro.tealan.models.Student;
import com.sandro.tealan.models.dtos.StudentDto;
import org.springframework.beans.BeanUtils;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 01.12.2023
 */


public class StudentDtoMapper {

    public static StudentDto fromStudent(Student student) {
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student, studentDto);
        return studentDto;
    }
    public static Student toStudent(StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        return student;
    }

}
