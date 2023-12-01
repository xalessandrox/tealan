package com.sandro.tealan.models;

import com.sandro.tealan.enums.Language;
import com.sandro.tealan.enums.Level;
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
    private final String flagUrl;
    public LanguageResource(Language language) {
        this.name = language.name();
        this.description = language.getValue();
        this.flagUrl = language.getFlagUrl();
    }

}
