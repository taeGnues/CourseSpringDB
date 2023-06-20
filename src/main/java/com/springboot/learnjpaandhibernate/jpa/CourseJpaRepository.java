package com.springboot.learnjpaandhibernate.jpa;

import com.springboot.learnjpaandhibernate.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext // @Autowired보다 더 구체적인 어노테이션을 사용함.
    private EntityManager entityManager;

    public void insert(Course course){
        entityManager.merge(course);
        // 이렇게 하면 끝. 이미 다 매핑됨.
        // id는 id 필드, name은 name 필드, author는 author 필드, course bean은 course 테이블로.
    }

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id){
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
