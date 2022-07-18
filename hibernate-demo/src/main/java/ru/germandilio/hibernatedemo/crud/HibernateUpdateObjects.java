package ru.germandilio.hibernatedemo.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.germandilio.hibernatedemo.crud.model.Student;

public class HibernateUpdateObjects {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {

            // update emails
            try(Session currentSession = sessionFactory.getCurrentSession()) {
                currentSession.beginTransaction();

//                var students = currentSession
//                        .createQuery("from Student s where s.firstName='Dua'", Student.class)
//                        .getResultList();
//                for (var student : students) {
//                    student.setEmail("duaLipa@gmail.com");
//                }

                // or update in query
                currentSession
                        .createQuery("update Student set email='newdualipa@gmail.com' where firstName='Dua'")
                        .executeUpdate();

                currentSession.getTransaction().commit();
            }
        }
    }
}
