package facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Software;

public class SoftwareFacade extends AbstractFacade<Software>{
    
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        //if (em != null) {
          //  return em;
        //} else {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaPU");
            em = emf.createEntityManager();
            return em;
        //}
    }

    public SoftwareFacade() {
        super(Software.class);
    }

    
}
