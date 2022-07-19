package ru.germandilio.hibernatedemo.relations.onetomany;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.germandilio.hibernatedemo.relations.onetomany.model.Course;
import ru.germandilio.hibernatedemo.relations.onetomany.model.Instructor;
import ru.germandilio.hibernatedemo.relations.onetomany.model.InstructorDetail;
import ru.germandilio.hibernatedemo.relations.onetomany.model.Review;

import java.time.LocalDateTime;

public class GetCourseReviewsDemo {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory()) {

            try (var session = sessionFactory.getCurrentSession()) {
                session.beginTransaction();

                // get course
                final String courseName = "Mastering Hibernate";

                var courses = session
                        .createQuery("from Course course where course.title= :courseName", Course.class)
                        .setParameter("courseName", courseName)
                        .getResultList();

                if (courses == null || courses.size() < 1) {
                    System.out.println("Course not found. Check your database.");
                    return;
                }

                final var course = courses.get(0);

                // should be retrieved at that moment because of lazy fetching
                var reviews = course.getReviews();
                reviews.forEach(System.out::println);

                session.getTransaction().commit();
                System.out.println("Done!!!");
            }
        }
    }
}
