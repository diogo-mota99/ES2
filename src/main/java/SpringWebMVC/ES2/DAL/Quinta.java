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
@Table(name = "QUINTA")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Quinta.findAll", query = "SELECT q FROM Quinta q"),
        @NamedQuery(name = "Quinta.findByIdQuinta", query = "SELECT q FROM Quinta q WHERE q.idQuinta = :idQuinta"),
        @NamedQuery(name = "Quinta.findByAreaQuinta", query = "SELECT q FROM Quinta q WHERE q.areaQuinta = :areaQuinta"),
        @NamedQuery(name = "Quinta.findByAtiva", query = "SELECT q FROM Quinta q WHERE q.ativa = :ativa"),
        @NamedQuery(name = "Quinta.findByLocalizacao", query = "SELECT q FROM Quinta q WHERE q.localizacao = :localizacao"),
        @NamedQuery(name = "Quinta.findByEmpresa", query = "SELECT q FROM Quinta q WHERE q.idEmpresa.idEmpresa = :idEmpresa"),
        @NamedQuery(name = "Quinta.findByEmpresaByEstado", query = "SELECT q FROM Quinta q WHERE q.idEmpresa.idEmpresa = :idEmpresa AND q.ativa = :ativa")})
public class Quinta implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quinta_sequence")
    @SequenceGenerator(name = "quinta_sequence", sequenceName = "QUINTA_SEQ", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_QUINTA")
    private int idQuinta;
    @Column(name = "AREA_QUINTA")
    private String areaQuinta;
    @Column(name = "ATIVA")
    private int ativa;
    @Column(name = "LOCALIZACAO")
    private String localizacao;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idQuinta")
    private List<Plantacao> plantacaoList;
    @JsonIgnore
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne
    private Empresa idEmpresa;

    public Quinta() {
    }

    public Quinta(int idQuinta) {
        this.idQuinta = idQuinta;
    }

    public int getIdQuinta() {
        return idQuinta;
    }

    public void setIdQuinta(int idQuinta) {
        this.idQuinta = idQuinta;
    }

    public String getAreaQuinta() {
        return areaQuinta;
    }

    public void setAreaQuinta(String areaQuinta) {
        this.areaQuinta = areaQuinta;
    }

    public int getAtiva() {
        return ativa;
    }

    public void setAtiva(int ativa) {
        this.ativa = ativa;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @XmlTransient
    public List<Plantacao> getPlantacaoList() {
        return plantacaoList;
    }

    public void setPlantacaoList(List<Plantacao> plantacaoList) {
        this.plantacaoList = plantacaoList;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return "SpringWebMVC.ES2.DAL.Quinta[ idQuinta=" + idQuinta + " ]";
    }

}
