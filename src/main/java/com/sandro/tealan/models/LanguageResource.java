package com.sandro.tealan.models;

import com.sandro.tealan.enums.Language;
import lombok.Getter;


/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 22.11.2023
 */

@Getter
public final class LanguageResource {

    private final String name;
    private final String description;
    private final String url;
    public LanguageResource(String languageAsString) {
        Language language = Language.valueOf(languageAsString);
        this.name = language.name();
        this.description = language.getValue();
        this.url = language.getFlagUrl();
    }

}
