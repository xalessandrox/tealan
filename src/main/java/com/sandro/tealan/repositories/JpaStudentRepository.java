package com.sandro.tealan.repositories;

import com.sandro.tealan.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Alessandro Formica
 * @version 1.0
 * @since 15.11.2023
 */


public interface JpaStudentRepository extends PagingAndSortingRepository<Student, Long>, JpaRepository<Student, Long> {


    @Override
    Page<Student> findAll(Pageable pageable);

}
