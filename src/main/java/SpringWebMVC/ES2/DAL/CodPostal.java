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
import java.math.BigDecimal;
import java.util.List;

/**
 * @author diogo
 */
@Entity
@Table(name = "COD_POSTAL")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "CodPostal.findAll", query = "SELECT c FROM CodPostal c"),
        @NamedQuery(name = "CodPostal.findByIdCodpostal", query = "SELECT c FROM CodPostal c WHERE c.idCodpostal = :idCodpostal"),
        @NamedQuery(name = "CodPostal.findByCodPostal", query = "SELECT c FROM CodPostal c WHERE c.codPostal = :codPostal")})
public class CodPostal implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cp_sequence")
    @SequenceGenerator(name = "cp_sequence", sequenceName = "COD_POSTAL_SEQ", allocationSize = 1)
    @Column(name = "ID_CODPOSTAL")
    private BigDecimal idCodpostal;
    @Column(name = "COD_POSTAL")
    private String codPostal;
    @JsonIgnore
    @OneToMany(mappedBy = "codPostal")
    private List<Funcionario> funcionarioList;
    @JsonIgnore
    @OneToMany(mappedBy = "idCodpostal")
    private List<Empresa> empresaList;

    public CodPostal() {
    }

    public CodPostal(BigDecimal idCodpostal) {
        this.idCodpostal = idCodpostal;
    }

    public BigDecimal getIdCodpostal() {
        return idCodpostal;
    }

    public void setIdCodpostal(BigDecimal idCodpostal) {
        this.idCodpostal = idCodpostal;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCodpostal != null ? idCodpostal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodPostal)) {
            return false;
        }
        CodPostal other = (CodPostal) object;
        return (this.idCodpostal != null || other.idCodpostal == null) && (this.idCodpostal == null || this.idCodpostal.equals(other.idCodpostal));
    }

    @Override
    public String toString() {
        return "SpringWebMVC.ES2.DAL.CodPostal[ idCodpostal=" + idCodpostal + " ]";
    }

}
