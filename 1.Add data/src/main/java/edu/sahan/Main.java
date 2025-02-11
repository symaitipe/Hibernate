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
        st.setAge(20);


        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        //Need to open a transaction when you manipulate database
        Transaction transaction = session.beginTransaction();

        //since save is depreciated, we can use persist
        session.persist(st);
        transaction.commit();

        //session factory is a resource intensive tool, so need to close them after work done.
        session.close();
        sf.close();


    }
}