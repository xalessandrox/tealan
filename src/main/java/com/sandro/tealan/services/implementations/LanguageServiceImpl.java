package com.sandro.tealan.services.implementations;

import com.sandro.tealan.models.LanguageResource;
import com.sandro.tealan.models.Student;
import com.sandro.tealan.models.StudentLanguageLevel;
import com.sandro.tealan.repositories.JpaStudentLanguageLevelRepository;
import com.sandro.tealan.repositories.JpaStudentRepository;
import com.sandro.tealan.services.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 22.11.2023
 */

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final JpaStudentLanguageLevelRepository jpaStudentLanguageLevelRepository;
    private final JpaStudentRepository jpaStudentRepository;

    @Override
    public void mapLanguageEnum(Student... students) {
        for (Student student : students) {
            Set<LanguageResource> languageResources = new HashSet<>();
            for (StudentLanguageLevel languageLevel : student.getLanguageLevel()) {
                languageResources.add(new LanguageResource(languageLevel.getLanguage()));
                jpaStudentRepository.save(student);
                languageLevel.setStudent(student);
                jpaStudentLanguageLevelRepository.save(languageLevel);
            }
            student.setLanguageResources(languageResources);
        }
    }
}
