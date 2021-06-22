package SpringWebMVC.ES2.BLL;

import SpringWebMVC.ES2.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Casta {

    private static final EntityManager em = entityManager.getEntityManager();

    public static List<SpringWebMVC.ES2.DAL.Casta> readAllCastas() {
        List<SpringWebMVC.ES2.DAL.Casta> listaCastas = new ArrayList<>();

        Query q = em.createNamedQuery("Casta.findAll");
        q.getResultList().forEach(c -> listaCastas.add((SpringWebMVC.ES2.DAL.Casta) c));

        return listaCastas;

    }
}
