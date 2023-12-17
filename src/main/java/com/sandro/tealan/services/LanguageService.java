package com.sandro.tealan.services;

import com.sandro.tealan.models.Student;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 22.11.2023
 */


public interface LanguageService {

    void mapLanguageEnum(Student... students);

    void sortLanguageLevel(Student... students);

}
