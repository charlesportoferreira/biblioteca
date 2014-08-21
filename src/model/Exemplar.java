/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author charles
 */
@Entity
public class Exemplar implements Serializable {

    private static final long serialVersionUID = 1L;

    //Como o exemplar tem um numero de controle interno da biblioteca, pensei em ser a própria chave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IDBIB;

    @ManyToOne(cascade = ALL, fetch = FetchType.EAGER)
    private Prateleira prateleira;

    @ManyToOne(cascade = ALL, fetch = FetchType.EAGER)
    private Item item;


    private boolean disponivel;

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Long getIDBIB() {
        return IDBIB;
    }

    //public void setIDBIB(Long IDBIB) {
    //  this.IDBIB = IDBIB;
    //}
    public Prateleira getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(Prateleira prateleira) {
        this.prateleira = prateleira;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (IDBIB != null ? IDBIB.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exemplar)) {
            return false;
        }
        Exemplar other = (Exemplar) object;
        if ((this.IDBIB == null && other.IDBIB != null) || (this.IDBIB != null && !this.IDBIB.equals(other.IDBIB))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Exemplar[ id=" + IDBIB + " ]";
    }

}
