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

        try (SessionFactory sf = cfg.buildSessionFactory();
             Session session  = sf.openSession()) {

            Transaction transaction = session.beginTransaction();

            Student student = (Student) session.get(Student.class, 100);

//            Student student = session.load(Student.class,100);

            /*Load only fire the actual query if you access the property of the object
                Unless, it believe the will be an object for the given PK and return a fake object
             */

            transaction.commit();
            System.out.println(student.toString());


        }

    }
}
