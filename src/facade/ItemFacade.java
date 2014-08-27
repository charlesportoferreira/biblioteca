package facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Item;


public class ItemFacade extends AbstractFacade<Item> {

    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaPU");
            em = emf.createEntityManager();
            return em;
        
    }

    public ItemFacade() {
        super(Item.class);
    }

   
}
