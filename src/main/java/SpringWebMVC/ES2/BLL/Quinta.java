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
        q.getResultList().forEach(qt -> listaQuintas.add((SpringWebMVC.ES2.DAL.Quinta) qt));
        return listaQuintas;
    }

    public static List<SpringWebMVC.ES2.DAL.Quinta> readQuintaByEmpresaByEstado(int idEmpresa) {
        List<SpringWebMVC.ES2.DAL.Quinta> listaQuintasByEmpresaByEstado = new ArrayList<>();

        Query q = em.createNamedQuery("Quinta.findByEmpresaByEstado");
        q.setParameter("idEmpresa", idEmpresa);
        q.setParameter("ativa", 1);
        q.getResultList().forEach(qt -> listaQuintasByEmpresaByEstado.add((SpringWebMVC.ES2.DAL.Quinta) qt));
        return listaQuintasByEmpresaByEstado;
    }

    public static boolean adicionarQuinta(String area, String localizacao, int idEmpresa) {

        Empresa empresa = SpringWebMVC.ES2.BLL.Empresa.readEmpresaById(idEmpresa);

        if (empresa != null) {
            SpringWebMVC.ES2.DAL.Quinta qt = new SpringWebMVC.ES2.DAL.Quinta();
            qt.setAreaQuinta(area);
            qt.setLocalizacao(localizacao);
            qt.setIdEmpresa(empresa);
            qt.setAtiva(1);

            try {
                em.getTransaction().begin();
                em.persist(qt);
                em.getTransaction().commit();
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

    public static boolean updateQuinta(int idQuinta, String localizacao, String area) {
        SpringWebMVC.ES2.DAL.Quinta quinta = em.find(SpringWebMVC.ES2.DAL.Quinta.class, idQuinta);

        if (quinta != null) {
            try {
                em.getTransaction().begin();
                quinta.setLocalizacao(localizacao);
                quinta.setAreaQuinta(area);
                em.getTransaction().commit();
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

    public static boolean removeQuinta(int idQuinta) {
        SpringWebMVC.ES2.DAL.Quinta quinta = em.find(SpringWebMVC.ES2.DAL.Quinta.class, idQuinta);

        if (quinta != null) {
            try {
                em.getTransaction().begin();
                quinta.setAtiva(0);
                em.getTransaction().commit();
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
}
