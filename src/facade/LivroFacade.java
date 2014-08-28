package facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Livro;

public class LivroFacade extends AbstractFacade<Livro> {

    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
       
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaPU");
            em = emf.createEntityManager();
            return em;
        
    }

    public LivroFacade() {
        super(Livro.class);
    }

//    public List<Livro> findAllStartWith(String coluna, String valor) {
//        em = getEntityManager();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery cq = cb.createQuery();
//        Root livro = cq.from(Livro.class);
//        cq.select(livro).where(cb.like(livro.get(coluna), valor + "%"));
//        Query query = em.createQuery(cq);
//        List<Livro> result = query.getResultList();
//        return result;
//    }

}
