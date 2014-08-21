package facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Prateleira;

public class PrateleiraFacade extends AbstractFacade<Prateleira>{
    
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
      //  if (em != null) {
        //    return em;
        //} else {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaPU");
            em = emf.createEntityManager();
            return em;
        //}
    }

    public PrateleiraFacade() {
        super(Prateleira.class);
    }

    
}
