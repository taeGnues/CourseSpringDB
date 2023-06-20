package com.springboot.learnjpaandhibernate.springdatajpa;

import com.springboot.learnjpaandhibernate.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CourseSpringDatJpaRepository extends JpaRepository<Course, Long> { // <관리하려고 하는 객체, 기본키 타입>


}
