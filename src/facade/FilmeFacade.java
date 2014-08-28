package facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Filme;

public class FilmeFacade extends AbstractFacade<Filme> {

    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaPU");
        em = emf.createEntityManager();
        return em;

    }

    public FilmeFacade() {
        super(Filme.class);
    }

}
