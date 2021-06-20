package SpringWebMVC.ES2.BLL;

import SpringWebMVC.ES2.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Controlo {

    private static final EntityManager em = entityManager.getEntityManager();

    public static List<SpringWebMVC.ES2.DAL.Controlo> readAllControlos() {

        List<SpringWebMVC.ES2.DAL.Controlo> listaControlos = new ArrayList<>();

        Query q = em.createNamedQuery("Controlo.findAll");
        q.getResultList().forEach(c -> {
            listaControlos.add((SpringWebMVC.ES2.DAL.Controlo) c);
        });
        return listaControlos;
    }

    public static List<SpringWebMVC.ES2.DAL.Controlo> readControlosByResultado(int resultado) {
        List<SpringWebMVC.ES2.DAL.Controlo> listaControlosByResultado = new ArrayList<>();

        Query q = em.createNamedQuery("Controlo.findByResultado");
        q.setParameter("resultado",resultado);
        q.getResultList().forEach(c -> {
            listaControlosByResultado.add((SpringWebMVC.ES2.DAL.Controlo) c);
        });

        return listaControlosByResultado;
    }

    public static float percControlosBemSucedidos(int totControlos, int ControlosBemSucedidos) {
        return (float) ((ControlosBemSucedidos * 100)/totControlos);
    }
}
