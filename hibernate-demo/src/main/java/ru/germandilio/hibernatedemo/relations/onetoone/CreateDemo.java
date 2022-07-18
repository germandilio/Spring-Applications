package ru.germandilio.hibernatedemo.relations.onetoone;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.germandilio.hibernatedemo.relations.onetoone.model.Instructor;
import ru.germandilio.hibernatedemo.relations.onetoone.model.InstructorDetail;

public class CreateDemo {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {

            try(var session = sessionFactory.getCurrentSession()) {
                session.beginTransaction();

                // create instructor
                var instructor = new Instructor("Denis", "Zaedeev", "email@edu.hse.ru");
                var instructorDetail = new InstructorDetail("http://www.yotube.com", "making pull requests");
                instructor.setDetail(instructorDetail);

                session.save(instructor);

                session.getTransaction().commit();
                System.out.println("Done!!!");
            }
        }
    }
}
