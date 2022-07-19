package ru.germandilio.hibernatedemo.relations.onetomany;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.germandilio.hibernatedemo.relations.onetomany.model.Course;
import ru.germandilio.hibernatedemo.relations.onetomany.model.Instructor;
import ru.germandilio.hibernatedemo.relations.onetomany.model.InstructorDetail;
import ru.germandilio.hibernatedemo.relations.onetomany.model.Review;

import java.time.LocalDateTime;

public class CreateReviewsDemo {
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

                // create instructor
                final var instructor = new Instructor("Hibernate", "Instructor", "newinstructor@edu.hse.ru");
                final var instructorDetail = new InstructorDetail("http://www.yotube.com", "Hibernate proficient");
                instructor.setDetail(instructorDetail);

                session.save(instructor);

                // create course
                var course = new Course("Mastering Hibernate");
                course.setInstructor(instructor);

                // create two reviews
                var goodReview = new Review(9, "Good course", LocalDateTime.now());
                var badReview = new Review(1, "Bad course", LocalDateTime.now());
                course.addReview(goodReview);
                course.addReview(badReview);

                // cascade saving of reviews with course
                session.save(course);

                session.getTransaction().commit();
                System.out.println("Done!!!");
            }
        }
    }
}
