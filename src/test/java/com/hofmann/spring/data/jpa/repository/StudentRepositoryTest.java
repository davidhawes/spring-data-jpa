package com.hofmann.spring.data.jpa.repository;

import com.hofmann.spring.data.jpa.entity.Guardian;
import com.hofmann.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("david@gmail.com")
                .firstName("David")
                .lastName("Hofmann")
                //.guardianName("guardian1")
                //.guardianEmail("guardian1@gmail.com")
                //.guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentwithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("guardian1@gmail.com")
                .mobile("9999999999")
                .name("guardian1")
                .build();

        Student student = Student.builder()
                .firstName("Daniel")
                .emailId("Daniel@gmail.com")
                .lastName("Dobermann")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){

        List<Student> students =
                studentRepository.findByFirstName("daniel");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){

        List<Student> students =
                studentRepository.findByFirstNameContaining("da");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("guardian1");
        System.out.println("students = " + students);
    }

    @Test
    public void printgetStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress("david@gmail.com");
        System.out.println("student = " + student);

    }

    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String firstname =
                studentRepository.getStudentFirstNameByEmailAddress("david@gmail.com");
        System.out.println("firstname = " + firstname);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative("david@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam("david@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudenNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailID(
                "Dafit",
                "david@gmail.com");
    }
}
