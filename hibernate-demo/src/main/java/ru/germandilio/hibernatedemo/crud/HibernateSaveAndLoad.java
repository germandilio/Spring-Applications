package ru.germandilio.hibernatedemo.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.germandilio.hibernatedemo.crud.model.Student;

public class HibernateSaveAndLoad {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {

            var student1 = new Student("Taylor", "Swift", "email@email.com");
            var student2 = new Student("Dua", "Lipa", "email@email.com");
            var student3 = new Student("Ariana", "Grande", "email@email.com");

            // save students
            try (Session currentSession = sessionFactory.getCurrentSession()) {
                // save the student object
                System.out.println("Saving student to database...");
                currentSession.beginTransaction();

                currentSession.save(student1);
                currentSession.save(student2);
                currentSession.save(student3);

                currentSession.getTransaction().commit();
                System.out.println("Process done!");
            }


            // retrieve student by id
            try (Session currentSession = sessionFactory.getCurrentSession()) {
                System.out.println("Retrieving student1 by his ID...");
                currentSession.beginTransaction();

                var student = currentSession.get(Student.class, student1.getId());
                System.out.println("Retrieved student:" + student);

                currentSession.getTransaction().commit();
                System.out.println("Process done!");
            }

            try(Session currentSession = sessionFactory.getCurrentSession()) {
                currentSession.beginTransaction();

                // retrieve collection where first name is "David" or last name is "Mikhaylov"
                var result = currentSession
                        .createQuery("from Student s where s.firstName='Dua' OR s.lastName='Grande'", Student.class)
                        .getResultList();
                System.out.println("result = " + result.toString());

                result = currentSession
                        .createQuery("from Student s where s.firstName LIKE '%or'", Student.class)
                        .getResultList();
                System.out.println("result = " + result.toString());

                currentSession.getTransaction().commit();
            }
        }
    }
}
