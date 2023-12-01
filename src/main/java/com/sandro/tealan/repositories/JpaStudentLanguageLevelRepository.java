package com.sandro.tealan.repositories;

import com.sandro.tealan.models.StudentLanguageLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 01.12.2023
 */

@Repository
public interface JpaStudentLanguageLevelRepository extends JpaRepository<StudentLanguageLevel, Long> {
}
