package com.sandro.tealan.services.implementations;

import com.sandro.tealan.enums.Language;
import com.sandro.tealan.models.LanguageResource;
import com.sandro.tealan.models.Student;
import com.sandro.tealan.services.LanguageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 22.11.2023
 */

@Service
public class LanguageServiceImpl implements LanguageService {
    @Override
    public void mapLanguageEnum(Student... students) {
        for(Student student: students) {
            System.out.println("Doing it");
            List<LanguageResource> languageResources = new ArrayList<>();
            for(Language language: student.getLanguages()) {
                languageResources.add(new LanguageResource(language.name()));
            }
            student.setLanguageResources(languageResources);
        }
    }
}
