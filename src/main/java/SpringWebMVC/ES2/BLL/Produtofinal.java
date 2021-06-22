package SpringWebMVC.ES2.BLL;

import SpringWebMVC.ES2.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Produtofinal {

    private static final EntityManager em = entityManager.getEntityManager();

    public static SpringWebMVC.ES2.DAL.Produtofinal readProdutoFinalByEmpresa(int idEmpresa) {
        SpringWebMVC.ES2.DAL.Produtofinal produtoFinal;

        Query q = em.createNamedQuery("Produtofinal.findByEmpresa");
        q.setParameter("idEmpresa", idEmpresa);

        try {
            produtoFinal = (SpringWebMVC.ES2.DAL.Produtofinal) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

        return produtoFinal;

    }

}
