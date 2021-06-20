/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringWebMVC.ES2.BLL;

import SpringWebMVC.ES2.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author diogo
 */
public class Funcionario {

    private static final EntityManager em = entityManager.getEntityManager();

    public static List<SpringWebMVC.ES2.DAL.Funcionario> readAllFuncionarios() {

        List<SpringWebMVC.ES2.DAL.Funcionario> listaFuncionarios = new ArrayList<>();

        Query q = em.createNamedQuery("Funcionario.findAll");
        q.getResultList().forEach(f -> {
            listaFuncionarios.add((SpringWebMVC.ES2.DAL.Funcionario) f);
        });
        return listaFuncionarios;
    }

    public static SpringWebMVC.ES2.DAL.Funcionario funcionarioLogin(String username, String password) {

        SpringWebMVC.ES2.DAL.Funcionario funcionario = new SpringWebMVC.ES2.DAL.Funcionario();
        boolean exist = false;

        Query q = em.createNamedQuery("Funcionario.findByUsernamePw");
        q.setParameter("username", username);
        q.setParameter("pw", password);

        if (q.getSingleResult() != null) {
            funcionario = (SpringWebMVC.ES2.DAL.Funcionario) q.getSingleResult();
            exist = true;
        }

        if (exist) {
            return funcionario;
        } else {
            return null;
        }
    }

    public static List<SpringWebMVC.ES2.DAL.Funcionario> funcionariosByEmpresa(int idEmpresa) {
        List<SpringWebMVC.ES2.DAL.Funcionario> listaFuncionariosByEmpresa = new ArrayList<>();

        Query q = em.createNamedQuery("Funcionario.findByEmpresa");
        q.setParameter("idEmpresa", idEmpresa);
        q.getResultList().forEach(f -> {
            listaFuncionariosByEmpresa.add((SpringWebMVC.ES2.DAL.Funcionario) f);
        });
        return listaFuncionariosByEmpresa;
    }
}
