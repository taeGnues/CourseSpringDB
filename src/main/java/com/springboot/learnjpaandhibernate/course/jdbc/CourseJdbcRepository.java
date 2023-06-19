package com.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // 데이터에 접근하는 건 @Repository 이용하기
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;
    private static String INSERT_QUERY = // JdbcTemplate으로부터 쿼리문 작성
            """
               insert into course(id,name,author) 
               values(1,'Learn AWS', 'in28minutes');
           """;
    public void insert(){
        springJdbcTemplate.batchUpdate(INSERT_QUERY);
    }
}
