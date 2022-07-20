package ru.germandilio.hibernatedemo.relations.manytomany;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.germandilio.hibernatedemo.relations.manytomany.model.*;

public class DeleteStudentDemo {
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

                final int courseID = 12;
                System.out.println("Retrieving course...");
                var course = session.get(Course.class, courseID);

                System.out.println("Course: " + course);

                var students = course.getStudents();

                final String firstName = "John";
                final String lastName = "Doe";
                var hibernateCourses = students.stream()
                        .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                        .toList();

                hibernateCourses.forEach(session::delete);

                session.getTransaction().commit();
                System.out.println("Done!!!");
            }
        }
    }
}
