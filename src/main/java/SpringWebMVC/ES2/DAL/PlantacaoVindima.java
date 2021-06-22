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
import java.util.Date;
import java.util.List;

/**
 * @author diogo
 */
@Entity
@Table(name = "PLANTACAO_VINDIMA")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "PlantacaoVindima.findAll", query = "SELECT p FROM PlantacaoVindima p"),
        @NamedQuery(name = "PlantacaoVindima.findByIdPlantVindima", query = "SELECT p FROM PlantacaoVindima p WHERE p.idPlantVindima = :idPlantVindima"),
        @NamedQuery(name = "PlantacaoVindima.findByDataFimVindima", query = "SELECT p FROM PlantacaoVindima p WHERE p.dataFimVindima = :dataFimVindima"),
        @NamedQuery(name = "PlantacaoVindima.findByQtdVindimada", query = "SELECT p FROM PlantacaoVindima p WHERE p.qtdVindimada = :qtdVindimada"),
        @NamedQuery(name = "PlantacaoVindima.findByFuncionarioAndEmpresa", query = "SELECT pv, f FROM PlantacaoVindima pv, Funcionario f WHERE f.idEmpresa.idEmpresa = :idEmpresa AND f.idFuncionario = pv.idFuncionario.idFuncionario")
})
public class PlantacaoVindima implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PLANT_VINDIMA")
    private int idPlantVindima;
    @Column(name = "DATA_FIM_VINDIMA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFimVindima;
    @Column(name = "QTD_VINDIMADA")
    private float qtdVindimada;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlantVindima")
    private List<Controlo> controloList;
    @JsonIgnore
    @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")
    @ManyToOne
    private Funcionario idFuncionario;
    @JsonIgnore
    @JoinColumn(name = "ID_PLANTACAO", referencedColumnName = "ID_PLANTACAO")
    @ManyToOne
    private Plantacao idPlantacao;
    @JsonIgnore
    @JoinColumn(name = "ID_VINDIMA", referencedColumnName = "ID_VINDIMA")
    @ManyToOne
    private Vindima idVindima;

    public PlantacaoVindima() {
    }

    public PlantacaoVindima(int idPlantVindima) {
        this.idPlantVindima = idPlantVindima;
    }

    public int getIdPlantVindima() {
        return idPlantVindima;
    }

    public void setIdPlantVindima(int idPlantVindima) {
        this.idPlantVindima = idPlantVindima;
    }

    public Date getDataFimVindima() {
        return dataFimVindima;
    }

    public void setDataFimVindima(Date dataFimVindima) {
        this.dataFimVindima = dataFimVindima;
    }

    public float getQtdVindimada() {
        return qtdVindimada;
    }

    public void setQtdVindimada(float qtdVindimada) {
        this.qtdVindimada = qtdVindimada;
    }

    @XmlTransient
    public List<Controlo> getControloList() {
        return controloList;
    }

    public void setControloList(List<Controlo> controloList) {
        this.controloList = controloList;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Plantacao getIdPlantacao() {
        return idPlantacao;
    }

    public void setIdPlantacao(Plantacao idPlantacao) {
        this.idPlantacao = idPlantacao;
    }

    public Vindima getIdVindima() {
        return idVindima;
    }

    public void setIdVindima(Vindima idVindima) {
        this.idVindima = idVindima;
    }

    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlantVindima != null ? idPlantVindima.hashCode() : 0);
        return hash;
    }*/

    /*@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlantacaoVindima)) {
            return false;
        }
        PlantacaoVindima other = (PlantacaoVindima) object;
        if ((this.idPlantVindima == null && other.idPlantVindima != null) || (this.idPlantVindima != null && !this.idPlantVindima.equals(other.idPlantVindima))) {
            return false;
        }
        return true;
    }*/

    @Override
    public String toString() {
        return "SpringWebMVC.ES2.DAL.PlantacaoVindima[ idPlantVindima=" + idPlantVindima + " ]";
    }

}
