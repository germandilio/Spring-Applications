package ru.germandilio.hibernatedemo.relations.onetoone;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.germandilio.hibernatedemo.relations.onetoone.model.Instructor;
import ru.germandilio.hibernatedemo.relations.onetoone.model.InstructorDetail;

public class BidirectionalDemo {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {

            // check existence in database
            final int detailId = 1;

            try(var session = sessionFactory.getCurrentSession()) {
                session.beginTransaction();

                var detail = session.get(InstructorDetail.class, detailId);
                if (detail == null) {
                    System.out.println("Not found in database!!!");
                    return;
                }

                System.out.println("detail.getInstructor() = " + detail.getInstructor());

                // check NO cascading delete
                // try to delete detail (also it should delete instructor)

                // prepare for deletion (otherwise it would be re-saved by hibernate)
                detail.getInstructor().setDetail(null);

                session.delete(detail);

                session.getTransaction().commit();
                System.out.println("Done!!!");
            }
        }
    }
}
