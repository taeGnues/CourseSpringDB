package com.springboot.learnjpaandhibernate.course.jdbc;

import com.springboot.learnjpaandhibernate.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS", "in29minutes"));
        repository.insert(new Course(2, "Learn Azure", "in29minutes"));
        repository.insert(new Course(3, "Learn Devops", "in29minutes"));

        repository.deleteById(1);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    } // Spring 시작시 실행됨.
}
