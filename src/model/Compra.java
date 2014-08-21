package model;

import java.io.Serializable;
import java.util.Date;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;


@Entity
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private double valor;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCompra;
    private String localCompra;
    private String empresaVendedora;
    
    @OneToOne(cascade = ALL, fetch=FetchType.EAGER)
    private Exemplar exemplar;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return dataCompra;
    }

    public void setData(Date data) {
        this.dataCompra = data;
    }

    public String getLocal() {
        return localCompra;
    }

    public void setLocal(String local) {
        this.localCompra = local;
    }

    public String getEmpresaVendedora() {
        return empresaVendedora;
    }

    public void setEmpresaVendedora(String empresaVendedora) {
        this.empresaVendedora = empresaVendedora;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Compra[ id=" + id + " ]";
    }
    
}
