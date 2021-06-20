/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringWebMVC.ES2.DAL;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PLANTACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plantacao.findAll", query = "SELECT p FROM Plantacao p"),
    @NamedQuery(name = "Plantacao.findByIdPlantacao", query = "SELECT p FROM Plantacao p WHERE p.idPlantacao = :idPlantacao"),
    @NamedQuery(name = "Plantacao.findByAreaCasta", query = "SELECT p FROM Plantacao p WHERE p.areaCasta = :areaCasta"),
    @NamedQuery(name = "Plantacao.findByEstado", query = "SELECT p FROM Plantacao p WHERE p.estado = :estado"),
    @NamedQuery(name = "Plantacao.findByEmpresaByEstado", query = "SELECT p, f FROM Plantacao p, Funcionario f WHERE f.idEmpresa.idEmpresa = :idEmpresa AND f.idFuncionario = p.idFuncionario.idFuncionario AND p.estado = 1")})
public class Plantacao implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PLANTACAO")
    private BigDecimal idPlantacao;
    @Column(name = "AREA_CASTA")
    private String areaCasta;
    @Column(name = "ESTADO")
    private BigInteger estado;
    @JoinColumn(name = "ID_CASTA", referencedColumnName = "ID_CASTA")
    @ManyToOne(optional = false)
    private Casta idCasta;
    @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;
    @JoinColumn(name = "ID_QUINTA", referencedColumnName = "ID_QUINTA")
    @ManyToOne(optional = false)
    private Quinta idQuinta;
    @OneToMany(mappedBy = "idPlantacao")
    private List<PlantacaoVindima> plantacaoVindimaList;

    public Plantacao() {
    }

    public Plantacao(BigDecimal idPlantacao) {
        this.idPlantacao = idPlantacao;
    }

    public BigDecimal getIdPlantacao() {
        return idPlantacao;
    }

    public void setIdPlantacao(BigDecimal idPlantacao) {
        this.idPlantacao = idPlantacao;
    }

    public String getAreaCasta() {
        return areaCasta;
    }

    public void setAreaCasta(String areaCasta) {
        this.areaCasta = areaCasta;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public Casta getIdCasta() {
        return idCasta;
    }

    public void setIdCasta(Casta idCasta) {
        this.idCasta = idCasta;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Quinta getIdQuinta() {
        return idQuinta;
    }

    public void setIdQuinta(Quinta idQuinta) {
        this.idQuinta = idQuinta;
    }

    @XmlTransient
    public List<PlantacaoVindima> getPlantacaoVindimaList() {
        return plantacaoVindimaList;
    }

    public void setPlantacaoVindimaList(List<PlantacaoVindima> plantacaoVindimaList) {
        this.plantacaoVindimaList = plantacaoVindimaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlantacao != null ? idPlantacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plantacao)) {
            return false;
        }
        Plantacao other = (Plantacao) object;
        if ((this.idPlantacao == null && other.idPlantacao != null) || (this.idPlantacao != null && !this.idPlantacao.equals(other.idPlantacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpringWebMVC.ES2.DAL.Plantacao[ idPlantacao=" + idPlantacao + " ]";
    }
    
}
