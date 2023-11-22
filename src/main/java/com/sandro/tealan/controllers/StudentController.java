package com.sandro.tealan.controllers;

import com.sandro.tealan.models.HttpResponse;
import com.sandro.tealan.models.Student;
import com.sandro.tealan.services.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 15.11.2023
 */

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<HttpResponse> createStudent(@RequestBody Student student) {
        Student studentPersist = studentService.saveStudent(student);
        log.info("Creating student {}", studentPersist);
        return ResponseEntity
                .created(URI.create(""))
                .body(
                        HttpResponse.builder()
                                .timeStamp(LocalDateTime.now().toString())
                                .message("Student created")
                                .httpStatus(HttpStatus.CREATED)
                                .statusCode(HttpStatus.CREATED.value())
                                .data(Map.of(
                                        "student", studentPersist
                                ))
                                .build());
    }

    @GetMapping("/getAll")
    public ResponseEntity<HttpResponse> getAllStudents(@RequestParam Optional<Integer> pageNumber, @RequestParam Optional<Integer> size) {
        return ResponseEntity
                .ok()
                .body(
                        HttpResponse.builder()
                                .timeStamp(LocalDateTime.now().toString())
                                .message("Retrieved list of all students")
                                .httpStatus(HttpStatus.OK)
                                .statusCode(HttpStatus.OK.value())
                                .data(Map.of(
                                        "page", studentService.getAllStudents(pageNumber.orElse(0), size.orElse(10))
                                ))
                                .build());
    }

}
