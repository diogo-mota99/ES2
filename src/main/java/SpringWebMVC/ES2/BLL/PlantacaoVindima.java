package SpringWebMVC.ES2.BLL;

import SpringWebMVC.ES2.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PlantacaoVindima {

    private static final EntityManager em = entityManager.getEntityManager();

    public static List<SpringWebMVC.ES2.DAL.PlantacaoVindima> readAllPlantacaoVindimas() {

        List<SpringWebMVC.ES2.DAL.PlantacaoVindima> listaPlantacaoVindimas = new ArrayList<>();

        Query q = em.createNamedQuery("PlantacaoVindima.findAll");
        q.getResultList().forEach(pv -> {
            listaPlantacaoVindimas.add((SpringWebMVC.ES2.DAL.PlantacaoVindima) pv);
        });
        return listaPlantacaoVindimas;
    }

    public static List<Object> readPlantVindimaByFuncAndEmp(int idEmpresa) {
        List<Object> listaPlantVindima = new ArrayList<>();

        Query q = em.createNamedQuery("PlantacaoVindima.findByFuncionarioAndEmpresa");
        q.setParameter("idEmpresa",idEmpresa);
        q.getResultList().forEach(pv -> {
            listaPlantVindima.add(pv);
        });

        return listaPlantVindima;

    }

}
