package com.sandro.tealan.repositories;

import com.sandro.tealan.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 18.11.2023
 */


public interface JpaLessonRepository extends PagingAndSortingRepository<Lesson, Long>, JpaRepository<Lesson, Long> {
}
