package SpringWebMVC.ES2.BLL;

import SpringWebMVC.ES2.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private static final EntityManager em = entityManager.getEntityManager();


    public static List<SpringWebMVC.ES2.DAL.Empresa> readAllEmpresas() {

        List<SpringWebMVC.ES2.DAL.Empresa> listaEmpresas = new ArrayList<>();

        Query q = em.createNamedQuery("Empresa.findAll");
        q.getResultList().forEach(e -> {
            listaEmpresas.add((SpringWebMVC.ES2.DAL.Empresa) e);
        });
        return listaEmpresas;
    }

    public static SpringWebMVC.ES2.DAL.Empresa readEmpresaById(int idEmpresa) {
        SpringWebMVC.ES2.DAL.Empresa empresa = new SpringWebMVC.ES2.DAL.Empresa();
        boolean exist = false;

        Query q = em.createNamedQuery("Empresa.findByIdEmpresa");
        q.setParameter("idEmpresa", idEmpresa);

        if (q.getSingleResult() != null) {
            empresa = (SpringWebMVC.ES2.DAL.Empresa) q.getSingleResult();
            exist = true;
        }

        if (exist) {
            return empresa;
        } else {
            return null;
        }

    }
}
