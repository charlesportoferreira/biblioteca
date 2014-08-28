package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String tipo;
    private int diasEmprestimo;
    private boolean privilegiado;

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDiasEmprestimo() {
        return diasEmprestimo;
    }

    public void setDiasEmprestimo(int diasEmprestimo) {
        this.diasEmprestimo = diasEmprestimo;
    }

    public boolean isPrivilegiado() {
        return privilegiado;
    }

    public void setPrivilegiado(boolean privilegiado) {
        this.privilegiado = privilegiado;
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
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Categoria[ id=" + id + " ]";
    }
    
}
