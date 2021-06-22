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
        q.getResultList().forEach(f -> listaFuncionarios.add((SpringWebMVC.ES2.DAL.Funcionario) f));
        return listaFuncionarios;
    }

    public static SpringWebMVC.ES2.DAL.Funcionario funcionarioLogin(String username, String password) {

        SpringWebMVC.ES2.DAL.Funcionario funcionario;

        Query q = em.createNamedQuery("Funcionario.findByUsernamePw");
        q.setParameter("username", username);
        q.setParameter("pw", password);

        try {
            funcionario = (SpringWebMVC.ES2.DAL.Funcionario) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

        return funcionario;
    }

    public static List<SpringWebMVC.ES2.DAL.Funcionario> funcionariosByEmpresa(int idEmpresa) {
        List<SpringWebMVC.ES2.DAL.Funcionario> listaFuncionariosByEmpresa = new ArrayList<>();

        Query q = em.createNamedQuery("Funcionario.findByEmpresa");
        q.setParameter("idEmpresa", idEmpresa);
        q.getResultList().forEach(f -> listaFuncionariosByEmpresa.add((SpringWebMVC.ES2.DAL.Funcionario) f));
        return listaFuncionariosByEmpresa;
    }

    public static SpringWebMVC.ES2.DAL.Funcionario funcionarioByUsername(String username) {
        SpringWebMVC.ES2.DAL.Funcionario funcionario;

        Query q = em.createNamedQuery("Funcionario.findByUsername");
        q.setParameter("username", username);

        try {
            funcionario = (SpringWebMVC.ES2.DAL.Funcionario) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

        return funcionario;
    }

    public static boolean adicionarFuncionario(int idEmpresa, int cargo, String username, String pw, String nome, String email, String tlm, String rua, int porta, String cp) {

        System.out.println(username);

        SpringWebMVC.ES2.DAL.Funcionario func = SpringWebMVC.ES2.BLL.Funcionario.funcionarioByUsername(username);

        if (func == null) {
            SpringWebMVC.ES2.DAL.Empresa empresa = SpringWebMVC.ES2.BLL.Empresa.readEmpresaById(idEmpresa);
            SpringWebMVC.ES2.DAL.TipoFuncionario tipoFuncionario = SpringWebMVC.ES2.BLL.TipoFuncionario.readTipoFuncionarioById(cargo);
            SpringWebMVC.ES2.DAL.CodPostal codPostal = SpringWebMVC.ES2.BLL.CodPostal.readByCodPostal(cp);

            if (codPostal == null) {
                try {
                    SpringWebMVC.ES2.BLL.CodPostal.adicionarCodPostal(cp);
                } catch (Exception e) {
                    return false;
                }

                SpringWebMVC.ES2.DAL.CodPostal newCodPostal = SpringWebMVC.ES2.BLL.CodPostal.readByCodPostal(cp);

                if (newCodPostal != null) {
                    try {
                        funcionarioAdd(username, pw, nome, email, tlm, rua, porta, empresa, tipoFuncionario, newCodPostal);
                    } catch (Exception e) {
                        return false;
                    }
                }
            } else {
                try {
                    funcionarioAdd(username, pw, nome, email, tlm, rua, porta, empresa, tipoFuncionario, codPostal);
                } catch (Exception e) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

    public static boolean updateFuncionario(int idFuncionario, int cargo, String pw, String nome, String email, String tlm, String rua, int porta, String cp) {

        SpringWebMVC.ES2.DAL.TipoFuncionario tipoFuncionario = SpringWebMVC.ES2.BLL.TipoFuncionario.readTipoFuncionarioById(cargo);
        SpringWebMVC.ES2.DAL.CodPostal codPostal = SpringWebMVC.ES2.BLL.CodPostal.readByCodPostal(cp);
        SpringWebMVC.ES2.DAL.Funcionario f = em.find(SpringWebMVC.ES2.DAL.Funcionario.class, idFuncionario);


        if (codPostal == null && f != null) {
            try {
                SpringWebMVC.ES2.BLL.CodPostal.adicionarCodPostal(cp);
            } catch (Exception e) {
                return false;
            }
            SpringWebMVC.ES2.DAL.CodPostal newCodPostal = SpringWebMVC.ES2.BLL.CodPostal.readByCodPostal(cp);
            if (newCodPostal != null) {
                try {
                    funcionarioUpdate(f, pw, nome, email, tlm, rua, porta, tipoFuncionario, newCodPostal);
                } catch (Exception e) {
                    return false;
                }
            }
        } else if (f != null) {
            try {
                funcionarioUpdate(f, pw, nome, email, tlm, rua, porta, tipoFuncionario, codPostal);
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }

    private static void funcionarioUpdate(SpringWebMVC.ES2.DAL.Funcionario f, String pw, String nome, String email, String tlm, String rua, int porta, SpringWebMVC.ES2.DAL.TipoFuncionario tipoFuncionario, SpringWebMVC.ES2.DAL.CodPostal newCodPostal) {
        f.setTipoFuncionario(tipoFuncionario);
        f.setCodPostal(newCodPostal);
        f.setEstado(1);
        f.setPw(pw);
        f.setNome(nome);
        f.setEmail(email);
        f.setTlm(tlm);
        f.setRua(rua);
        f.setNporta(porta);

        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
    }

    private static void funcionarioAdd(String username, String pw, String nome, String email, String tlm, String rua, int porta, SpringWebMVC.ES2.DAL.Empresa empresa, SpringWebMVC.ES2.DAL.TipoFuncionario tipoFuncionario, SpringWebMVC.ES2.DAL.CodPostal newCodPostal) {
        SpringWebMVC.ES2.DAL.Funcionario f = new SpringWebMVC.ES2.DAL.Funcionario();
        f.setIdEmpresa(empresa);
        f.setTipoFuncionario(tipoFuncionario);
        f.setCodPostal(newCodPostal);
        f.setEstado(1);
        f.setUsername(username);
        f.setPw(pw);
        f.setNome(nome);
        f.setEmail(email);
        f.setTlm(tlm);
        f.setRua(rua);
        f.setNporta(porta);

        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
    }


    public static boolean removeFuncionario(int idFuncionario) {
        SpringWebMVC.ES2.DAL.Funcionario funcionario = em.find(SpringWebMVC.ES2.DAL.Funcionario.class, idFuncionario);

        if (funcionario != null) {
            try {
                em.getTransaction().begin();
                funcionario.setEstado(0);
                em.getTransaction().commit();
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}
