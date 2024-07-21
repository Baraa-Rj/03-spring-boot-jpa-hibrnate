package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return _ -> {
            //createStudent(studentDAO);
            createMultipleStudents(studentDAO);
            //readStudent(studentDAO);
            //findAllStudents(studentDAO);
            //queryForLastName(studentDAO);
           // updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            //deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        studentDAO.deleteAll();
        System.out.println("Deleted all students");
    }

    private void deleteStudent(StudentDAO studentDAO) {
        System.out.println("Deleting student");
       studentDAO.deleteStudent(1);
        System.out.println("Deleted student");
    }

    private void updateStudent(StudentDAO studentDAO) {
        System.out.println("Updating student");
        Student student = studentDAO.findById(1);
        student.setFirstName("Baraa");
        studentDAO.update(student);
        System.out.println("Updated student");

    }

    private void queryForLastName(StudentDAO studentDAO) {
        System.out.println("Querying for last name");
        studentDAO.findByLastName("Doe").forEach(System.out::println);
    }

    private void findAllStudents(StudentDAO studentDAO) {
        System.out.println("Finding all students");
        studentDAO.findAll().forEach(System.out::println);
    }

    private void readStudent(StudentDAO studentDAO) {
        Student student = new Student("Doe", "John", "John@email");
        studentDAO.save(student);
        System.out.println("Reading student with id " + student);
        Student student1 = studentDAO.findById(student.getId());
        System.out.println("Found student with id " + student1);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating multiple students");
        Student student1 = new Student("Do2e", "Jo2hn", "John@email");
        Student student2 = new Student("D4oe", "Ja1ne", "Jane@email");
        Student student3 = new Student("Do3e", "Ja4ck", "Jack@email");
        System.out.println("saving students");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
        System.out.println("saved students");
    }

    public void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating student");
        Student student = new Student("Doe", "John", "John@email");
        System.out.println("saving student");
        studentDAO.save(student);
        System.out.println("saved student " + student.getId());
    }
}