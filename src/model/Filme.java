package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("Filme")
public class Filme extends Item implements Serializable {

    private static final long serialVersionUID = 1L;

    private String categoria;
    private String produtora;

    @ManyToMany(cascade = ALL, fetch = FetchType.EAGER)
    private List<Ator> atores;

    public void addAtor(Ator ator) {
        if (atores == null) {
            atores = new ArrayList<>();
        }
        atores.add(ator);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.getId() != null ? super.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filme)) {
            return false;
        }
        Filme other = (Filme) object;
        if ((super.getId() == null && other.getId() != null) || (super.getId() != null && !super.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Filme[ id=" + super.getId() + " ]";
    }

}
