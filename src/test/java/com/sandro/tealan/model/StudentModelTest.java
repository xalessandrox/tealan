package com.sandro.tealan.model;

import com.sandro.tealan.models.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 18.11.2023
 */

@SpringBootTest
public class StudentModelTest {

    static Student student = new Student();

    @BeforeAll
    static void setUp() {
        student.setEmail("student@test.com");
    }

    @Test
    void testEqualityByEmails() {

        Student student1 = new Student();
        student1.setEmail("student@test.com");
        assert (Objects.equals(student, student1));

        Student student2 = new Student();
        student2.setEmail("student@notequal.com");
        assert (!Objects.equals(student, student2));
    }

}
