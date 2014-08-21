package facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Revista;


public class RevistaFacade extends AbstractFacade<Revista>{
    
    private EntityManager em;

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

    public RevistaFacade() {
        super(Revista.class);
    }

//     public List<Revista> findAllStartWith(String coluna, String valor) {
//        em = getEntityManager();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery cq = cb.createQuery();
//        Root revista = cq.from(Revista.class);
//        cq.select(cb.equal(revista.get(coluna), valor));
//        Query query = em.createQuery(cq);
//        List<Revista> result = query.getResultList();
//        return result;
//    }
    
}
