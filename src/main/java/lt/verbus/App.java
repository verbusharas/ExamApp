package lt.verbus;

import lt.verbus.model.Exam;
import lt.verbus.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        Exam examMachineLearning = new Exam();
        examMachineLearning.setTopic("Machine Learning");

        Exam examProtocols = new Exam();
        examProtocols.setTopic("Protocols");


        Student studentTomas = new Student();
        studentTomas.setFullName("Tomas Tomaitis");
        studentTomas.setResult(100);
        studentTomas.setExam(examMachineLearning);

        Student studentJonas = new Student();
        studentJonas.setFullName("Jonas Jonaitis");
        studentJonas.setResult(72);
        studentJonas.setExam(examMachineLearning);

        Student studentAusra = new Student();
        studentAusra.setFullName("Aušra Aušrinė");
        studentAusra.setResult(95);
        studentAusra.setExam(examMachineLearning);

        Student studentLaima = new Student();
        studentLaima.setFullName("Laima Laimutė");
        studentLaima.setResult(83);
        studentLaima.setExam(examProtocols);

        Student studentEligijus = new Student();
        studentEligijus.setFullName("Eligijus Masiulis");
        studentEligijus.setResult(9);
        studentEligijus.setExam(examProtocols);


//        examMachineLearning.getStudents().add(studentTomas);


        try {
            tx = session.beginTransaction();
            // Database Queries
            session.saveOrUpdate(studentTomas);
            session.saveOrUpdate(studentJonas);
            session.saveOrUpdate(studentAusra);
            session.saveOrUpdate(studentLaima);
            session.saveOrUpdate(studentEligijus);
            session.saveOrUpdate(examMachineLearning);
            session.saveOrUpdate(examProtocols);

//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            CriteriaQuery<Student> cr = cb.createQuery(Student.class);
//            Root<Student> root = cr.from(Student.class);
//            cr.select(root).where(cb.like(root.get("topic"), "Protocol"));
//            Query<Student> query = session.createQuery(cr);
//            List<Student> results = query.getResultList();
//            results.forEach(student -> System.out.println(student.getFullName()));

            // End
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
    }


}
