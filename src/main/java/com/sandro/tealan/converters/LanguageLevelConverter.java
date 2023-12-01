package com.sandro.tealan.converters;

import com.sandro.tealan.enums.Language;
import com.sandro.tealan.enums.Level;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 01.12.2023
 */

@Converter(autoApply = true)
public class LanguageLevelConverter implements AttributeConverter<Map<Language, Level>, Map<String, String> > {


    @Override
    public Map<String, String> convertToDatabaseColumn(Map<Language, Level> languageLevelMap) {
        Set<Language> languages = languageLevelMap.keySet();
        Map<String, String> returnMap = new HashMap<>();
        for(Language language: languages) {
            returnMap.put(language.name(), languageLevelMap.get(language).name());
        }
        return returnMap;
    }

    @Override
    public Map<Language, Level> convertToEntityAttribute(Map<String, String> stringStringMap) {
        Set<String> languages = stringStringMap.keySet();
        Map<Language, Level> returnMap = new HashMap<>();
        for(String language: languages) {
            returnMap.put(Language.valueOf(language), Level.valueOf(stringStringMap.get(language)));
        }
        return returnMap;
    }
}
