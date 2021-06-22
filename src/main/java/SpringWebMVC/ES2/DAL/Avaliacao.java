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
@Table(name = "AVALIACAO")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a"),
        @NamedQuery(name = "Avaliacao.findByIdAvaliacao", query = "SELECT a FROM Avaliacao a WHERE a.idAvaliacao = :idAvaliacao"),
        @NamedQuery(name = "Avaliacao.findByQtdProduzida", query = "SELECT a FROM Avaliacao a WHERE a.qtdProduzida = :qtdProduzida"),
        @NamedQuery(name = "Avaliacao.findByQualidadeVinho", query = "SELECT a FROM Avaliacao a WHERE a.qualidadeVinho = :qualidadeVinho")})
public class Avaliacao implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_AVALIACAO")
    private int idAvaliacao;
    @Column(name = "QTD_PRODUZIDA")
    private float qtdProduzida;
    @Column(name = "QUALIDADE_VINHO")
    private String qualidadeVinho;
    @JsonIgnore
    @JoinColumn(name = "ID_PRODUTO_FINAL", referencedColumnName = "ID_PRODUTO_FINAL")
    @ManyToOne
    private Produtofinal idProdutoFinal;
    @OneToMany(mappedBy = "idAvaliacao")
    private List<Controlo> controloList;

    public Avaliacao() {
    }

    public Avaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public float getQtdProduzida() {
        return qtdProduzida;
    }

    public void setQtdProduzida(float qtdProduzida) {
        this.qtdProduzida = qtdProduzida;
    }

    public String getQualidadeVinho() {
        return qualidadeVinho;
    }

    public void setQualidadeVinho(String qualidadeVinho) {
        this.qualidadeVinho = qualidadeVinho;
    }

    public Produtofinal getIdProdutoFinal() {
        return idProdutoFinal;
    }

    public void setIdProdutoFinal(Produtofinal idProdutoFinal) {
        this.idProdutoFinal = idProdutoFinal;
    }

    @XmlTransient
    public List<Controlo> getControloList() {
        return controloList;
    }

    public void setControloList(List<Controlo> controloList) {
        this.controloList = controloList;
    }


    @Override
    public String toString() {
        return "SpringWebMVC.ES2.DAL.Avaliacao[ idAvaliacao=" + idAvaliacao + " ]";
    }

}
