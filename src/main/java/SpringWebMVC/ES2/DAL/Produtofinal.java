/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringWebMVC.ES2.DAL;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * @author diogo
 */
@Entity
@Table(name = "PRODUTOFINAL")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Produtofinal.findAll", query = "SELECT p FROM Produtofinal p"),
        @NamedQuery(name = "Produtofinal.findByIdProdutoFinal", query = "SELECT p FROM Produtofinal p WHERE p.idProdutoFinal = :idProdutoFinal"),
        @NamedQuery(name = "Produtofinal.findByDataEmb", query = "SELECT p FROM Produtofinal p WHERE p.dataEmb = :dataEmb"),
        @NamedQuery(name = "Produtofinal.findByQtdCaixas", query = "SELECT p FROM Produtofinal p WHERE p.qtdCaixas = :qtdCaixas"),
        @NamedQuery(name = "Produtofinal.findByTipoVinho", query = "SELECT p FROM Produtofinal p WHERE p.tipoVinho = :tipoVinho"),
        @NamedQuery(name = "Produtofinal.findByEmpresa", query = "SELECT e FROM Funcionario f, Controlo c, Avaliacao a, Produtofinal e WHERE e.idProdutoFinal = a.idProdutoFinal.idProdutoFinal AND a.idAvaliacao = c.idAvaliacao.idAvaliacao AND c.idFuncionario.idFuncionario = f.idFuncionario AND f.idEmpresa.idEmpresa = :idEmpresa")})
public class Produtofinal implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRODUTO_FINAL")
    private BigDecimal idProdutoFinal;
    @Column(name = "DATA_EMB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmb;
    @Column(name = "QTD_CAIXAS")
    private BigInteger qtdCaixas;
    @Column(name = "TIPO_VINHO")
    private String tipoVinho;
    @OneToMany(mappedBy = "idProdutoFinal")
    private List<Avaliacao> avaliacaoList;

    public Produtofinal() {
    }

    public Produtofinal(BigDecimal idProdutoFinal) {
        this.idProdutoFinal = idProdutoFinal;
    }

    public BigDecimal getIdProdutoFinal() {
        return idProdutoFinal;
    }

    public void setIdProdutoFinal(BigDecimal idProdutoFinal) {
        this.idProdutoFinal = idProdutoFinal;
    }

    public Date getDataEmb() {
        return dataEmb;
    }

    public void setDataEmb(Date dataEmb) {
        this.dataEmb = dataEmb;
    }

    public BigInteger getQtdCaixas() {
        return qtdCaixas;
    }

    public void setQtdCaixas(BigInteger qtdCaixas) {
        this.qtdCaixas = qtdCaixas;
    }

    public String getTipoVinho() {
        return tipoVinho;
    }

    public void setTipoVinho(String tipoVinho) {
        this.tipoVinho = tipoVinho;
    }

    @XmlTransient
    public List<Avaliacao> getAvaliacaoList() {
        return avaliacaoList;
    }

    public void setAvaliacaoList(List<Avaliacao> avaliacaoList) {
        this.avaliacaoList = avaliacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdutoFinal != null ? idProdutoFinal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtofinal)) {
            return false;
        }
        Produtofinal other = (Produtofinal) object;
        if ((this.idProdutoFinal == null && other.idProdutoFinal != null) || (this.idProdutoFinal != null && !this.idProdutoFinal.equals(other.idProdutoFinal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpringWebMVC.ES2.DAL.Produtofinal[ idProdutoFinal=" + idProdutoFinal + " ]";
    }

}
