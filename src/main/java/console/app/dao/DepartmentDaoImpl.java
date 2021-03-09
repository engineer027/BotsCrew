package console.app.dao;

import console.app.excention.DataProcessingException;
import console.app.model.Degree;
import console.app.model.Department;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    private final SessionFactory sessionFactory;

    public DepartmentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Department add(Department department) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
            return department;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert department entity " + department, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Map<Degree, Double> getDepartmentStatistic(String departmentName) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session
                    .createQuery("SELECT l.degree, AVG(l.salary) FROM Department d "
                            + "JOIN d.lecturers AS l WHERE d.name = :name GROUP BY l.degree");
            query.setParameter("name", departmentName);
            List<Object[]> list = query.list();
            Map<Degree, Double> mapStatistic = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                mapStatistic.put((Degree) list.get(i)[0], (Double) list.get(i)[1]);
            }
            return mapStatistic;
        } catch (Exception e) {
            throw new DataProcessingException("Can't get " + departmentName
                    + " department statistic.", e);
        }
    }

    @Override
    public Long getCountOfEmployee(String departmentName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Long> query = session.createQuery("SELECT COUNT(l) FROM Department d "
                    + "JOIN d.lecturers AS l WHERE d.name = :name", Long.class);
            query.setParameter("name", departmentName);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get count of employee with department = "
                    + departmentName, e);
        }
    }

    @Override
    public Double getAverageSalaryForDepartment(String departmentName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Double> query = session
                    .createQuery("SELECT AVG(l.salary) FROM Department d JOIN d.lecturers AS l "
                            + "WHERE d.name = :name", Double.class);
            query.setParameter("name", departmentName);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get count of employee with department = "
                    + departmentName, e);
        }
    }

    @Override
    public Optional<Department> findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query<Department> query = session
                    .createQuery("SELECT d FROM Department d "
                            + "WHERE d.name = :name", Department.class);
            query.setParameter("name", name);
            return query.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get Department with name = " + name, e);
        }
    }
}
