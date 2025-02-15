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

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.configure();
        try (SessionFactory sf = cfg.buildSessionFactory();
                Session session = sf.openSession();
        ){
            Transaction transaction  = session.beginTransaction();

            session.merge(st);

            transaction.commit();
        }


    }
}