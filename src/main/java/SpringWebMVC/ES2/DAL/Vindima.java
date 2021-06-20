/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringWebMVC.ES2.DAL;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diogo
 */
@Entity
@Table(name = "VINDIMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vindima.findAll", query = "SELECT v FROM Vindima v"),
    @NamedQuery(name = "Vindima.findByIdVindima", query = "SELECT v FROM Vindima v WHERE v.idVindima = :idVindima"),
    @NamedQuery(name = "Vindima.findByDataInicioVindima", query = "SELECT v FROM Vindima v WHERE v.dataInicioVindima = :dataInicioVindima")})
public class Vindima implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_VINDIMA")
    private BigDecimal idVindima;
    @Column(name = "DATA_INICIO_VINDIMA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicioVindima;
    @OneToMany(mappedBy = "idVindima")
    private List<PlantacaoVindima> plantacaoVindimaList;

    public Vindima() {
    }

    public Vindima(BigDecimal idVindima) {
        this.idVindima = idVindima;
    }

    public BigDecimal getIdVindima() {
        return idVindima;
    }

    public void setIdVindima(BigDecimal idVindima) {
        this.idVindima = idVindima;
    }

    public Date getDataInicioVindima() {
        return dataInicioVindima;
    }

    public void setDataInicioVindima(Date dataInicioVindima) {
        this.dataInicioVindima = dataInicioVindima;
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
        hash += (idVindima != null ? idVindima.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vindima)) {
            return false;
        }
        Vindima other = (Vindima) object;
        if ((this.idVindima == null && other.idVindima != null) || (this.idVindima != null && !this.idVindima.equals(other.idVindima))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpringWebMVC.ES2.DAL.Vindima[ idVindima=" + idVindima + " ]";
    }
    
}
