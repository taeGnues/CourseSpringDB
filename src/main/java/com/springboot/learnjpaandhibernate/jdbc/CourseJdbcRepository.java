package com.springboot.learnjpaandhibernate.jdbc;

import com.springboot.learnjpaandhibernate.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // 데이터에 접근하는 건 @Repository 이용하기
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;
    private static String INSERT_QUERY = // JdbcTemplate으로부터 쿼리문 작성
            """
               insert into course(id,name,author) 
               values(?,?,?);
           """; // 이렇게 ???를 넣으면 해당 부분에 값이 들어감.

    private static String DELTE_QUERY = // JdbcTemplate으로부터 쿼리문 작성
            """
               delete from course
               where id=?
           """; // 이렇게 ???를 넣으면 해당 부분에 값이

    private static String SELECT_QUERY =
            """
                select * from course
                where id = ?
            """;
    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id){ // 삭제 구현
        springJdbcTemplate.update(DELTE_QUERY, id);
    }

    public Course findById(long id){ // 삭제 구현
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
        // select 연산으로 얻은 결과를 Object로 만듦.
        // select로 연산 결과로 얻은 결과 세트(객체)를 Bean에 매핑하는 과정이 필요함
        // Bean => Row Mapper로 이어줌.
    }
}
