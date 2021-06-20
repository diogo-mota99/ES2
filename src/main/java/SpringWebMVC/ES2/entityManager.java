package SpringWebMVC.ES2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class entityManager {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
