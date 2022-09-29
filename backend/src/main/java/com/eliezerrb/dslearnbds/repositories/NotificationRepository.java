package com.eliezerrb.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliezerrb.dslearnbds.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
