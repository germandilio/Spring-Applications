package ru.germandilio.hibernatedemo.relations.onetomany;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.germandilio.hibernatedemo.relations.onetomany.model.Course;
import ru.germandilio.hibernatedemo.relations.onetomany.model.Instructor;
import ru.germandilio.hibernatedemo.relations.onetomany.model.InstructorDetail;

public class RetrieveCoursesByInstructorDemo {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {

            try(var session = sessionFactory.getCurrentSession()) {
                session.beginTransaction();

                final int id = 1;
                var retrievedInstructor = session.get(Instructor.class, id);
                if (retrievedInstructor == null) {
                    System.out.println("There is no instructor with id=" + id + ".Check your database!");
                    return;
                }

                // get courses from instructor
                var courses = retrievedInstructor.getCourses();
                courses.forEach(System.out::println);

                session.getTransaction().commit();
                System.out.println("Done!!!");
            }
        }
    }
}
