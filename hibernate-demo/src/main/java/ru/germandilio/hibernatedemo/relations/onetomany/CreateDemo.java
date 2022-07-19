package ru.germandilio.hibernatedemo.relations.onetomany;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.germandilio.hibernatedemo.relations.onetomany.model.Course;
import ru.germandilio.hibernatedemo.relations.onetomany.model.Instructor;
import ru.germandilio.hibernatedemo.relations.onetomany.model.InstructorDetail;

public class CreateDemo {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {

            // create instructor, detail and courses
            final var instructor = new Instructor("Susan", "Public", "email@edu.hse.ru");
            final var instructorDetail = new InstructorDetail("http://www.yotube.com", "Play Video Games");
            instructor.setDetail(instructorDetail);

            final var course1 = new Course("Learning Spring and Hibernate");
            final var course2 = new Course("Mastering deploying Spring Application on AWS");

            instructor.addCourse(course1);
            instructor.addCourse(course2);

            try(var session = sessionFactory.getCurrentSession()) {
                session.beginTransaction();

                final int id = 1;
                var retrievedInstructor = session.get(Instructor.class, id);
                if (retrievedInstructor == null) {
                    session.save(instructor);
                    retrievedInstructor = instructor;
                }

                retrievedInstructor.addCourse(course1);
                retrievedInstructor.addCourse(course2);

                // SAVE COURSES
                session.save(course1);
                session.save(course2);

                session.getTransaction().commit();
                System.out.println("Done!!!");
            }
        }
    }
}
