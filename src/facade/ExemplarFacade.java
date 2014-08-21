package facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Exemplar;


public class ExemplarFacade extends AbstractFacade<Exemplar> {
    
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
//        em = null;
//        if (em != null) {
//            return em;
//        } else {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaPU");
            em = emf.createEntityManager();
            return em;
        //}
    }

    public ExemplarFacade() {
        super(Exemplar.class);
    }

    
}
