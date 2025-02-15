package edu.sahan;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student st = new Student();
        st.setRollNo(100);
        st.setName("Amith");
        st.setAge(23);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();


        /*
         In Hibernate, the remove() operation only works on persistent entities
         that are already associated with the current session.

         ----------------------------------------------------

         So you have to either save the object using the current session or
         load it first and then delete it.
         */

         Student student = session.get(Student.class,100);

        if (student != null) {
            session.remove(student);
        } else {
            System.out.println("Student not found");
        }

        transaction.commit();
        session.close();
        sf.close();

    }
}