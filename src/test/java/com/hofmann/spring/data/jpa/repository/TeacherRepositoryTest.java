package com.hofmann.spring.data.jpa.repository;

import com.hofmann.spring.data.jpa.entity.Course;
import com.hofmann.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseGAW = Course.builder()
                .title("GAW")
                .credit(5)
                .build();

        Course courseCSHARP = Course.builder()
                .title("SHARP")
                .credit(5)
                .build();


        Teacher teacher =
                Teacher.builder()
                        .firstName("Lehrer1")
                        .lastName("LehrerNachname1")
                        //.courses(List.of(courseCSHARP, courseGAW))
                        .build();

        teacherRepository.save(teacher);
    }
}