package com.sandro.tealan.enums;

import lombok.Getter;

import java.util.Comparator;

/**
* @author Alessandro Formica
* @version 1.0
* @since 15.11.2023
*/

@Getter
public enum Language implements Comparator<Language> {

    ENGLISH("English", "assets/flags/gb-eng.png"),
    GERMAN("German", "assets/flags/de.png"),
    ITALIAN("Italian", "assets/flags/it.png")
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

    @Override
    public int compare(Language o1, Language o2) {
        return o1.name().compareTo(o2.name());
    }
}
