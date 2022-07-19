package ru.germandilio.hibernatedemo.relations.onetomany;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.germandilio.hibernatedemo.relations.onetomany.model.Course;
import ru.germandilio.hibernatedemo.relations.onetomany.model.Instructor;
import ru.germandilio.hibernatedemo.relations.onetomany.model.InstructorDetail;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {

            try(var session = sessionFactory.getCurrentSession()) {
                session.beginTransaction();

                final int id = 11;
                var retrievedCourse = session.get(Course.class, id);
                if (retrievedCourse == null) {
                    System.out.println("There is no course with id=" + id + ".Check your database!");
                    return;
                }

                // delete the course (expected to delete course without Instructor)
                session.delete(retrievedCourse);

                session.getTransaction().commit();
                System.out.println("Done!!!");
            }
        }
    }
}
