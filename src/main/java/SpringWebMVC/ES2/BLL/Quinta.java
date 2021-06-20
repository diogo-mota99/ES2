package SpringWebMVC.ES2.BLL;

import SpringWebMVC.ES2.DAL.Empresa;
import SpringWebMVC.ES2.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Quinta {

    private static final EntityManager em = entityManager.getEntityManager();

    public static List<SpringWebMVC.ES2.DAL.Quinta> readAllQuintas() {

        List<SpringWebMVC.ES2.DAL.Quinta> listaQuintas = new ArrayList<>();

        Query q = em.createNamedQuery("Quinta.findAll");
        q.getResultList().forEach(qt -> {
            listaQuintas.add((SpringWebMVC.ES2.DAL.Quinta) qt);
        });
        return listaQuintas;
    }

    public static void adicionarQuinta(String area, String localizacao, int idEmpresa) {

        Empresa empresa = SpringWebMVC.ES2.BLL.Empresa.readEmpresaById(idEmpresa);

        SpringWebMVC.ES2.DAL.Quinta qt = new SpringWebMVC.ES2.DAL.Quinta();
        qt.setAreaQuinta(area);
        qt.setLocalizacao(localizacao);
        qt.setIdEmpresa(empresa);
        qt.setAtiva(1);

        em.getTransaction().begin();
        em.persist(qt);
        em.getTransaction().commit();
    }
}
