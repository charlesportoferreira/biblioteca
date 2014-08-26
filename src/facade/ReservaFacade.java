package facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Emprestimo;
import model.Reserva;


public class ReservaFacade extends AbstractFacade<Reserva>{
    
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

    public ReservaFacade() {
        super(Reserva.class);
    }

    
    public List<Reserva> findAllWithItem(String id, String comandoComplementarSQL) {
        em = getEntityManager();
        Query query = em.createNativeQuery(
                "select * from RESERVA where item_id = " + id + comandoComplementarSQL, Reserva.class);
        List<Reserva> result = query.getResultList();
        return result;
    }
    
}
