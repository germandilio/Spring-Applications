package ru.germandilio.hibernatedemo.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.germandilio.hibernatedemo.crud.model.Student;

public class HibernateDeleteObject {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {

            // delete Dua Lipa student
            try(Session currentSession = sessionFactory.getCurrentSession()) {
                currentSession.beginTransaction();

//                var students = currentSession
//                        .createQuery("from Student s where s.firstName='Dua'", Student.class)
//                        .getResultList();
//                for (var student : students) {
//                    currentSession.delete(student);
//                }

                // or delete in query
                currentSession
                        .createQuery("delete Student where firstName='Dua'")
                        .executeUpdate();

                currentSession.getTransaction().commit();
            }
        }
    }
}
