package com.eliezerrb.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliezerrb.dslearnbds.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long>{

}
