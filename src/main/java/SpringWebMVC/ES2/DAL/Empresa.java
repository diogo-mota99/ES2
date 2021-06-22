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
import java.io.Serializable;
import java.util.List;

/**
 * @author diogo
 */
@Entity
@Table(name = "EMPRESA")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
        @NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa"),
        @NamedQuery(name = "Empresa.findByCae", query = "SELECT e FROM Empresa e WHERE e.cae = :cae"),
        @NamedQuery(name = "Empresa.findByNif", query = "SELECT e FROM Empresa e WHERE e.nif = :nif"),
        @NamedQuery(name = "Empresa.findByNomeEmpresa", query = "SELECT e FROM Empresa e WHERE e.nomeEmpresa = :nomeEmpresa"),
        @NamedQuery(name = "Empresa.findByNporta", query = "SELECT e FROM Empresa e WHERE e.nporta = :nporta"),
        @NamedQuery(name = "Empresa.findByPassword", query = "SELECT e FROM Empresa e WHERE e.password = :password"),
        @NamedQuery(name = "Empresa.findByRua", query = "SELECT e FROM Empresa e WHERE e.rua = :rua")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_EMPRESA")
    private int idEmpresa;
    @Column(name = "CAE")
    private int cae;
    @Column(name = "NIF")
    private int nif;
    @Column(name = "NOME_EMPRESA")
    private String nomeEmpresa;
    @Column(name = "NPORTA")
    private int nporta;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "RUA")
    private String rua;
    @JsonIgnore
    @OneToMany(mappedBy = "idEmpresa")
    private List<Funcionario> funcionarioList;
    @JsonIgnore
    @JoinColumn(name = "ID_CODPOSTAL", referencedColumnName = "ID_CODPOSTAL")
    @ManyToOne
    private CodPostal idCodpostal;
    @JsonIgnore
    @OneToMany(mappedBy = "idEmpresa")
    private List<Quinta> quintaList;

    public Empresa() {
    }

    public Empresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getCae() {
        return cae;
    }

    public void setCae(int cae) {
        this.cae = cae;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public int getNporta() {
        return nporta;
    }

    public void setNporta(int nporta) {
        this.nporta = nporta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    public CodPostal getIdCodpostal() {
        return idCodpostal;
    }

    public void setIdCodpostal(CodPostal idCodpostal) {
        this.idCodpostal = idCodpostal;
    }

    @XmlTransient
    public List<Quinta> getQuintaList() {
        return quintaList;
    }

    public void setQuintaList(List<Quinta> quintaList) {
        this.quintaList = quintaList;
    }

    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }*/

  /*  @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }*/

    @Override
    public String toString() {
        return "SpringWebMVC.ES2.DAL.Empresa[ idEmpresa=" + idEmpresa + " ]";
    }

}
