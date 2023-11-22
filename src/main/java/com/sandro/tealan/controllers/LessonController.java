package com.sandro.tealan.controllers;

import com.sandro.tealan.models.HttpResponse;
import com.sandro.tealan.models.Lesson;
import com.sandro.tealan.services.LessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 18.11.2023
 */

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
@Slf4j
public class LessonController {

    private final LessonService lessonService;

    @PostMapping
    public ResponseEntity<HttpResponse> createLesson(@RequestBody Lesson lesson) {
        Lesson lessonPersist = lessonService.saveLesson(lesson);
        log.info("Creating student {}", lessonPersist);
        return ResponseEntity
                .created(URI.create(""))
                .body(
                        HttpResponse.builder()
                                .timeStamp(LocalDateTime.now().toString())
                                .message("Lesson created")
                                .httpStatus(HttpStatus.CREATED)
                                .statusCode(HttpStatus.CREATED.value())
                                .data(Map.of(
                                        "lesson", lessonPersist
                                ))
                                .build());
    }
    @GetMapping("/getAll")
    public ResponseEntity<HttpResponse> getAllLessons() {
        return ResponseEntity
                .ok()
                .body(
                        HttpResponse.builder()
                                .timeStamp(LocalDateTime.now().toString())
                                .message("Retrieved list of all lessons")
                                .httpStatus(HttpStatus.OK)
                                .statusCode(HttpStatus.OK.value())
                                .data(Map.of(
                                        "lessons", lessonService.getAllLessons()
                                ))
                                .build());
    }


}
