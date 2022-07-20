package ru.germandilio.hibernatedemo.relations.manytomany;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.germandilio.hibernatedemo.relations.manytomany.model.*;

public class CreateDemo {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory()) {

            try(var session = sessionFactory.getCurrentSession()) {
                session.beginTransaction();

                final var newCourse1 = new Course("Java 101");
                final var newCourse2 = new Course("Hibernate");
                final var newCourse3 = new Course("AWS Devops");

                var student1 = new Student("John", "Doe", "joghn@gmail.com");
                var student2 = new Student("Mary", "Public", "public@gmail.com");

                newCourse1.addStudent(student1);
                newCourse1.addStudent(student2);

                newCourse2.addStudent(student2);

                newCourse3.addStudent(student1);

                // Saving course and students
                session.save(newCourse1);
                session.save(newCourse2);
                session.save(newCourse3);


                session.save(student1);
                session.save(student2);

                session.getTransaction().commit();
                System.out.println("Done!!!");
            }
        }
    }
}
