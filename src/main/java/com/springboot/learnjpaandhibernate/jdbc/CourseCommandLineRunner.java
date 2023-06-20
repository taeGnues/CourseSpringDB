package com.springboot.learnjpaandhibernate.jdbc;

import com.springboot.learnjpaandhibernate.Course;
import com.springboot.learnjpaandhibernate.jpa.CourseJpaRepository;
import com.springboot.learnjpaandhibernate.springdatajpa.CourseSpringDatJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;
//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDatJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS", "in29minutes"));
        repository.save(new Course(2, "Learn Azure by dataJPA", "in29minutes"));
        repository.save(new Course(3, "Learn Devops by dataJPA", "in29minutes"));

        repository.deleteById(1l);
        // ID타입이 LONG으로 예상하고 있으니깐 이에 맞게 바꿔줘야함.

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));
        System.out.println(repository.findAll());
    } // Spring 시작시 실행됨.
}
