package com.sandro.tealan.services.implementations;

import com.sandro.tealan.models.Lesson;
import com.sandro.tealan.repositories.JpaLessonRepository;
import com.sandro.tealan.services.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 18.11.2023
 */

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final JpaLessonRepository jpaLessonRepository;
    @Override
    public Lesson saveLesson(Lesson lesson) {
        return jpaLessonRepository.save(lesson);
    }

    @Override
    public List<Lesson> getAllLessons() {
        return jpaLessonRepository.findAll();
    }
}
