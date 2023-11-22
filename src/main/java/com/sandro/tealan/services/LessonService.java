package com.sandro.tealan.services;

import com.sandro.tealan.models.Lesson;

import java.util.List;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 18.11.2023
 */


public interface LessonService {

    public Lesson saveLesson(Lesson lesson);
    public List<Lesson> getAllLessons();
}
