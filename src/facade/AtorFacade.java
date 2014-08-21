package facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Ator;

public class AtorFacade extends AbstractFacade<Ator> {

    private EntityManager em;

    public AtorFacade(Class<Ator> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
       // if (em != null) {
        //   return em;
        //} else {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaPU");
        em = emf.createEntityManager();
        return em;
        //}
    }

    public AtorFacade() {
        super(Ator.class);
    }

}
