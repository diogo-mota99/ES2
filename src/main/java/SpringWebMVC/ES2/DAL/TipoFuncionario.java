/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringWebMVC.ES2.DAL;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
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

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CARGO")
    private String cargo;
    @OneToMany(mappedBy = "tipoFuncionario")
    private List<Funcionario> funcionarioList;

    public TipoFuncionario() {
    }

    public TipoFuncionario(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoFuncionario)) {
            return false;
        }
        TipoFuncionario other = (TipoFuncionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpringWebMVC.ES2.DAL.TipoFuncionario[ id=" + id + " ]";
    }
    
}
