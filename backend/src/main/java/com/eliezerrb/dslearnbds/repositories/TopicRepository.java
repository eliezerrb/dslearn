package com.eliezerrb.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliezerrb.dslearnbds.entities.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long>{

}
