package console.app.dao;

import console.app.excention.DataProcessingException;
import console.app.model.Lecturer;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class LecturerDaoImpl implements LecturerDao {
    private final SessionFactory sessionFactory;

    public LecturerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Lecturer> findAllByTemplate(String template) {
        try (Session session = sessionFactory.openSession()) {
            Query<Lecturer> getMovieSession = session
                    .createQuery("SELECT l FROM Lecturer l "
                                    + "WHERE l.surname LIKE :template or l.lastname "
                                    + "LIKE :template", Lecturer.class);
            getMovieSession.setParameter("template", "%" + template + "%");
            return getMovieSession.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can`t get orders history where user Id: "
                    + template, e);
        }
    }

    @Override
    public Lecturer add(Lecturer lecturer) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(lecturer);
            transaction.commit();
            return lecturer;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert lecturer entity " + lecturer, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
