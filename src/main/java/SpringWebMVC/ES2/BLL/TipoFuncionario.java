package SpringWebMVC.ES2.BLL;

import SpringWebMVC.ES2.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class TipoFuncionario {

    private static final EntityManager em = entityManager.getEntityManager();

    public static SpringWebMVC.ES2.DAL.TipoFuncionario readTipoFuncionarioById(int idCargo) {
        SpringWebMVC.ES2.DAL.TipoFuncionario tipoFuncionario;

        Query q = em.createNamedQuery("TipoFuncionario.findById");
        q.setParameter("id", idCargo);

        try {
            tipoFuncionario = (SpringWebMVC.ES2.DAL.TipoFuncionario) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

        return tipoFuncionario;

    }

    public static List<SpringWebMVC.ES2.DAL.TipoFuncionario> readAllTipoFuncionario() {
        List<SpringWebMVC.ES2.DAL.TipoFuncionario> listaTipoFuncionario = new ArrayList<>();

        Query q = em.createNamedQuery("TipoFuncionario.findAll");
        q.getResultList().forEach(tf -> listaTipoFuncionario.add((SpringWebMVC.ES2.DAL.TipoFuncionario) tf));
        return listaTipoFuncionario;
    }
}
