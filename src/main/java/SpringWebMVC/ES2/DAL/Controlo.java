/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringWebMVC.ES2.DAL;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author diogo
 */
@Entity
@Table(name = "CONTROLO")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Controlo.findAll", query = "SELECT c FROM Controlo c"),
        @NamedQuery(name = "Controlo.findByIdControlo", query = "SELECT c FROM Controlo c WHERE c.idControlo = :idControlo"),
        @NamedQuery(name = "Controlo.findByDataHora", query = "SELECT c FROM Controlo c WHERE c.dataHora = :dataHora"),
        @NamedQuery(name = "Controlo.findByQtdAcucar", query = "SELECT c FROM Controlo c WHERE c.qtdAcucar = :qtdAcucar"),
        @NamedQuery(name = "Controlo.findByQualidadeAr", query = "SELECT c FROM Controlo c WHERE c.qualidadeAr = :qualidadeAr"),
        @NamedQuery(name = "Controlo.findByResultado", query = "SELECT c FROM Controlo c WHERE c.resultado = :resultado"),
        @NamedQuery(name = "Controlo.findByTemperatura", query = "SELECT c FROM Controlo c WHERE c.temperatura = :temperatura")})
public class Controlo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CONTROLO")
    private int idControlo;
    @Column(name = "DATA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @Column(name = "QTD_ACUCAR")
    private float qtdAcucar;
    @Column(name = "QUALIDADE_AR")
    private int qualidadeAr;
    @Column(name = "RESULTADO")
    private int resultado;
    @Column(name = "TEMPERATURA")
    private float temperatura;
    @JoinColumn(name = "ID_AVALIACAO", referencedColumnName = "ID_AVALIACAO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Avaliacao idAvaliacao;
    @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Funcionario idFuncionario;
    @JoinColumn(name = "ID_PLANT_VINDIMA", referencedColumnName = "ID_PLANT_VINDIMA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PlantacaoVindima idPlantVindima;

    public Controlo() {
    }

    public Controlo(int idControlo) {
        this.idControlo = idControlo;
    }

    public int getIdControlo() {
        return idControlo;
    }

    public void setIdControlo(int idControlo) {
        this.idControlo = idControlo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public float getQtdAcucar() {
        return qtdAcucar;
    }

    public void setQtdAcucar(float qtdAcucar) {
        this.qtdAcucar = qtdAcucar;
    }

    public int getQualidadeAr() {
        return qualidadeAr;
    }

    public void setQualidadeAr(int qualidadeAr) {
        this.qualidadeAr = qualidadeAr;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public Avaliacao getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Avaliacao idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public PlantacaoVindima getIdPlantVindima() {
        return idPlantVindima;
    }

    public void setIdPlantVindima(PlantacaoVindima idPlantVindima) {
        this.idPlantVindima = idPlantVindima;
    }

    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (idControlo != null ? idControlo.hashCode() : 0);
        return hash;
    }*/
/*
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Controlo)) {
            return false;
        }
        Controlo other = (Controlo) object;
        if ((this.idControlo == null && other.idControlo != null) || (this.idControlo != null && !this.idControlo.equals(other.idControlo))) {
            return false;
        }
        return true;
    }*/

    @Override
    public String toString() {
        return "SpringWebMVC.ES2.DAL.Controlo[ idControlo=" + idControlo + " ]";
    }

}
