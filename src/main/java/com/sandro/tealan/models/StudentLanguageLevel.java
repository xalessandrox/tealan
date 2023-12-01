package com.sandro.tealan.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sandro.tealan.enums.Language;
import com.sandro.tealan.enums.Level;
import jakarta.persistence.*;
import lombok.*;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 01.12.2023
 */

@Entity
@Table(name = "student_language_level")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentLanguageLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = true)
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

}
