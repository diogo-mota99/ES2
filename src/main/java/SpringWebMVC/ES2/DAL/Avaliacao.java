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
@Table(name = "AVALIACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a"),
    @NamedQuery(name = "Avaliacao.findByIdAvaliacao", query = "SELECT a FROM Avaliacao a WHERE a.idAvaliacao = :idAvaliacao"),
    @NamedQuery(name = "Avaliacao.findByQtdProduzida", query = "SELECT a FROM Avaliacao a WHERE a.qtdProduzida = :qtdProduzida"),
    @NamedQuery(name = "Avaliacao.findByQualidadeVinho", query = "SELECT a FROM Avaliacao a WHERE a.qualidadeVinho = :qualidadeVinho")})
public class Avaliacao implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_AVALIACAO")
    private BigDecimal idAvaliacao;
    @Column(name = "QTD_PRODUZIDA")
    private BigInteger qtdProduzida;
    @Column(name = "QUALIDADE_VINHO")
    private String qualidadeVinho;
    @JoinColumn(name = "ID_PRODUTO_FINAL", referencedColumnName = "ID_PRODUTO_FINAL")
    @ManyToOne
    private Produtofinal idProdutoFinal;
    @OneToMany(mappedBy = "idAvaliacao")
    private List<Controlo> controloList;

    public Avaliacao() {
    }

    public Avaliacao(BigDecimal idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public BigDecimal getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(BigDecimal idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public BigInteger getQtdProduzida() {
        return qtdProduzida;
    }

    public void setQtdProduzida(BigInteger qtdProduzida) {
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
    public int hashCode() {
        int hash = 0;
        hash += (idAvaliacao != null ? idAvaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.idAvaliacao == null && other.idAvaliacao != null) || (this.idAvaliacao != null && !this.idAvaliacao.equals(other.idAvaliacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpringWebMVC.ES2.DAL.Avaliacao[ idAvaliacao=" + idAvaliacao + " ]";
    }
    
}
