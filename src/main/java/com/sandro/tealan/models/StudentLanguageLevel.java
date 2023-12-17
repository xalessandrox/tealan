package com.sandro.tealan.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.sandro.tealan.enums.Language;
import com.sandro.tealan.enums.Level;
import jakarta.persistence.*;
import lombok.*;

import java.util.Comparator;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 01.12.2023
 */

@Entity(name = "student_language_level")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentLanguageLevel implements Comparable<StudentLanguageLevel> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lang_lev_seq")
    @SequenceGenerator(name = "lang_lev_seq", sequenceName = "members_lang_lev", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "student_id", nullable = false)
//    @JsonIncludeProperties({"id"})
    @JsonIgnore
    private Student student;
    private Language language;
    private Level level;

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Id: ").append(id).append("\n")
                .append("Language: ").append(language.getValue()).append(" ").append(language.getFlagUrl())
                .toString();
    }

    @Override
    public int compareTo(StudentLanguageLevel o) {
        return this.getLanguage().name().compareTo(o.getLanguage().name());
    }
}
