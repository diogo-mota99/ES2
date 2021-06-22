package SpringWebMVC.ES2.BLL;

import SpringWebMVC.ES2.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CodPostal {
    private static final EntityManager em = entityManager.getEntityManager();

    public static SpringWebMVC.ES2.DAL.CodPostal readCodPostalById(int idCodPostal) {
        SpringWebMVC.ES2.DAL.CodPostal codPostal;

        Query q = em.createNamedQuery("CodPostal.findByIdCodpostal");
        q.setParameter("idCodpostal", idCodPostal);

        try {
            codPostal = (SpringWebMVC.ES2.DAL.CodPostal) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

        return codPostal;

    }

    public static SpringWebMVC.ES2.DAL.CodPostal readByCodPostal(String codPostal) {

        SpringWebMVC.ES2.DAL.CodPostal cp;

        Query q = em.createNamedQuery("CodPostal.findByCodPostal");
        q.setParameter("codPostal", codPostal);

        try {
            cp = (SpringWebMVC.ES2.DAL.CodPostal) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

        return cp;
    }

    public static boolean adicionarCodPostal(String codPostal) {

        try {
            SpringWebMVC.ES2.DAL.CodPostal cp = new SpringWebMVC.ES2.DAL.CodPostal();
            cp.setCodPostal(codPostal);
            em.getTransaction().begin();
            em.persist(cp);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
