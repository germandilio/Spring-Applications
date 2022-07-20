package ru.germandilio.hibernatedemo.relations.manytomany;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.germandilio.hibernatedemo.relations.manytomany.model.*;

public class DeleteCourseDemo {
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

                final int studentId = 2;
                System.out.println("Retrieving student...");
                var student = session.get(Student.class, studentId);

                System.out.println("Student: " + student);

                var courses = student.getCourses();

                var hibernateCourses = courses.stream()
                        .filter(course -> course.getTitle().equals("Hibernate"))
                        .toList();

                hibernateCourses.forEach(session::delete);

                session.getTransaction().commit();
                System.out.println("Done!!!");
            }
        }
    }
}
