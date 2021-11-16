package com.hofmann.spring.data.jpa.repository;

import com.hofmann.spring.data.jpa.entity.Course;
import com.hofmann.spring.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {


    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial(){
        Course course =
                Course.builder()
                        .title("ABC").
                        credit(5).
                        build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.google.com")
                        .course(course)
                        .build();

        repository.save(courseMaterial);
    }

}
