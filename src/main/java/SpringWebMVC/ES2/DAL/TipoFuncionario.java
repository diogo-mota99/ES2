/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringWebMVC.ES2.DAL;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author diogo
 */
@Entity
@Table(name = "TIPO_FUNCIONARIO")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "TipoFuncionario.findAll", query = "SELECT t FROM TipoFuncionario t"),
        @NamedQuery(name = "TipoFuncionario.findById", query = "SELECT t FROM TipoFuncionario t WHERE t.id = :id"),
        @NamedQuery(name = "TipoFuncionario.findByCargo", query = "SELECT t FROM TipoFuncionario t WHERE t.cargo = :cargo")})
public class TipoFuncionario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Column(name = "CARGO")
    private String cargo;
    @JsonIgnore
    @OneToMany(mappedBy = "tipoFuncionario")
    private List<Funcionario> funcionarioList;

    public TipoFuncionario() {
    }

    public TipoFuncionario(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public String toString() {
        return "SpringWebMVC.ES2.DAL.TipoFuncionario[ id=" + id + " ]";
    }

}
