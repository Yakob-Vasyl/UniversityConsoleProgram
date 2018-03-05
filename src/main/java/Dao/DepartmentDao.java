package Dao;

import Entity.Lector;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class DepartmentDao {

    private EntityManager entityManager = Persistence
            .createEntityManagerFactory("primary")
            .createEntityManager();

    public String getTheHeadOfTheDepartment(String department) {
        return entityManager.createQuery("SELECT d.headOfDepartment FROM Department d where d.name =:name", String.class)
                .setParameter("name", department)
                .getSingleResult();
    }

    public List<Lector> getAllLectors(String department) {
        return (List<Lector>) entityManager.createQuery("SELECT d.lectors FROM Department d where d.name=:name")
                .setParameter("name", department)
                .getResultList();
    }


}
