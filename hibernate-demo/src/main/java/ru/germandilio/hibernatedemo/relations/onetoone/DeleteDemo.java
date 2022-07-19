package ru.germandilio.hibernatedemo.relations.onetoone;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.germandilio.hibernatedemo.relations.onetoone.model.Instructor;
import ru.germandilio.hibernatedemo.relations.onetoone.model.InstructorDetail;

public class DeleteDemo {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {

            try(var session = sessionFactory.getCurrentSession()) {
                session.beginTransaction();

                final String searchableFirstName = "Denis";
                final String searchableLastName = "Zavedeev";
                // get instructor by name
                var instructors = session
                        .createQuery("from Instructor instructor where instructor.firstName=:searchableFirstName and" +
                                " instructor.lastName=:searchableLastName", Instructor.class)
                        .setParameter("searchableFirstName", searchableFirstName)
                        .setParameter("searchableLastName", searchableLastName)
                        .getResultList();

                if (instructors.size() < 1) {
                    System.out.printf("Instructor with first name: %s and last name: %s not found%n", searchableFirstName, searchableLastName);
                    System.out.println("Create instructor before delete");
                    return;
                }

                var instructor = instructors.get(0);
                // will also delete instructor detail
                session.delete(instructor);

                session.getTransaction().commit();
                System.out.println("Done!!!");
            }
        }
    }
}
