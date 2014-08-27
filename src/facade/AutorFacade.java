package facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Autor;

public class AutorFacade extends AbstractFacade<Autor> {

    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaPU");
        em = emf.createEntityManager();
        return em;

    }

    public AutorFacade() {
        super(Autor.class);
    }

}
