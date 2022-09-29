package com.eliezerrb.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliezerrb.dslearnbds.entities.Enrollment;
import com.eliezerrb.dslearnbds.entities.pk.EnrollmentPK;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK>{

}
