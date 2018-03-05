package Dao;

import Entity.Lector;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class LectorDao {


    private EntityManager entityManager = Persistence
            .createEntityManagerFactory("primary")
            .createEntityManager();

    public List<Lector> searchLectorsByString(String searchString) {
        return entityManager.createQuery("SELECT l FROM Lector l where l.name like :name").setParameter("name","%"+searchString+"%").getResultList();
    }
}
