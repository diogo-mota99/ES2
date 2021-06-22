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
@Table(name = "FUNCIONARIO")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
        @NamedQuery(name = "Funcionario.findByIdFuncionario", query = "SELECT f FROM Funcionario f WHERE f.idFuncionario = :idFuncionario"),
        @NamedQuery(name = "Funcionario.findByEmail", query = "SELECT f FROM Funcionario f WHERE f.email = :email"),
        @NamedQuery(name = "Funcionario.findByEstado", query = "SELECT f FROM Funcionario f WHERE f.estado = :estado"),
        @NamedQuery(name = "Funcionario.findByNome", query = "SELECT f FROM Funcionario f WHERE f.nome = :nome"),
        @NamedQuery(name = "Funcionario.findByNporta", query = "SELECT f FROM Funcionario f WHERE f.nporta = :nporta"),
        @NamedQuery(name = "Funcionario.findByPw", query = "SELECT f FROM Funcionario f WHERE f.pw = :pw"),
        @NamedQuery(name = "Funcionario.findByRua", query = "SELECT f FROM Funcionario f WHERE f.rua = :rua"),
        @NamedQuery(name = "Funcionario.findByTlm", query = "SELECT f FROM Funcionario f WHERE f.tlm = :tlm"),
        @NamedQuery(name = "Funcionario.findByUsername", query = "SELECT f FROM Funcionario f WHERE f.username = :username"),
        @NamedQuery(name = "Funcionario.findByUsernamePw", query = "SELECT f FROM Funcionario f WHERE f.username = :username AND f.pw = :pw"),
        @NamedQuery(name = "Funcionario.findByEmpresa", query = "SELECT f FROM Funcionario f WHERE f.idEmpresa.idEmpresa = :idEmpresa"),
        @NamedQuery(name = "Funcionario.findByEmpresaByEstado", query = "SELECT f FROM Funcionario f WHERE f.idEmpresa.idEmpresa = :idEmpresa and f.estado = :estado"),
})
public class Funcionario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_sequence")
    @SequenceGenerator(name = "funcionario_sequence", sequenceName = "FUNCIONARIO_SEQ", allocationSize = 1)
    @Column(name = "ID_FUNCIONARIO")
    private int idFuncionario;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ESTADO")
    private int estado;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "NPORTA")
    private int nporta;
    @Column(name = "PW")
    private String pw;
    @Column(name = "RUA")
    private String rua;
    @Column(name = "TLM")
    private String tlm;
    @Column(name = "USERNAME")
    private String username;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionario")
    private List<Plantacao> plantacaoList;
    @JoinColumn(name = "COD_POSTAL", referencedColumnName = "ID_CODPOSTAL")
    @ManyToOne
    private CodPostal codPostal;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne
    private Empresa idEmpresa;
    @JoinColumn(name = "TIPO_FUNCIONARIO", referencedColumnName = "ID")
    @ManyToOne
    private TipoFuncionario tipoFuncionario;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionario")
    private List<Controlo> controloList;
    @JsonIgnore
    @OneToMany(mappedBy = "idFuncionario")
    private List<PlantacaoVindima> plantacaoVindimaList;

    public Funcionario() {
    }

    public Funcionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNporta() {
        return nporta;
    }

    public void setNporta(int nporta) {
        this.nporta = nporta;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getTlm() {
        return tlm;
    }

    public void setTlm(String tlm) {
        this.tlm = tlm;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlTransient
    public List<Plantacao> getPlantacaoList() {
        return plantacaoList;
    }

    public void setPlantacaoList(List<Plantacao> plantacaoList) {
        this.plantacaoList = plantacaoList;
    }

    public CodPostal getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(CodPostal codPostal) {
        this.codPostal = codPostal;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    @XmlTransient
    public List<Controlo> getControloList() {
        return controloList;
    }

    public void setControloList(List<Controlo> controloList) {
        this.controloList = controloList;
    }

    @XmlTransient
    public List<PlantacaoVindima> getPlantacaoVindimaList() {
        return plantacaoVindimaList;
    }

    public void setPlantacaoVindimaList(List<PlantacaoVindima> plantacaoVindimaList) {
        this.plantacaoVindimaList = plantacaoVindimaList;
    }

   /* @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }*/

    /*@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }*/

    @Override
    public String toString() {
        return "SpringWebMVC.ES2.DAL.Funcionario[ idFuncionario=" + idFuncionario + " ]";
    }

}
