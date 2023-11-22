package com.sandro.tealan.enums;

import lombok.Getter;

/**
* @author Alessandro Formica
* @version 1.0
* @since 15.11.2023
*/

@Getter
public enum Language {

    ENGLISH("English", "src/main/resources/static/flags/gb-eng.png"),
    GERMAN("German", "src/main/resources/static/flags/de.png"),
    ITALIAN("Italian", "src/main/resources/static/flags/it.png")
    ;

    private final String value;
    private final String flagUrl;

    Language(String value, String flagUrl) {
        this.value = value;
        this.flagUrl = flagUrl;
    }

    @Override
    public String toString() {
        return this.value + "!" + flagUrl;
    }

}
