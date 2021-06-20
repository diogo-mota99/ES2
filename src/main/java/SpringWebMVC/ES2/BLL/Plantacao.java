package SpringWebMVC.ES2.BLL;

import SpringWebMVC.ES2.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Plantacao {

    private static final EntityManager em = entityManager.getEntityManager();

    public static List<Object> readPlantAtivas(int idEmpresa) {
        List<Object> listaPlantAtivas = new ArrayList<>();

        Query q = em.createNamedQuery("PlantacaoVindima.findByFuncionarioAndEmpresa");
        q.setParameter("idEmpresa", idEmpresa);
        q.getResultList().forEach(p -> {
            listaPlantAtivas.add(p);
        });

        return listaPlantAtivas;

    }
}
