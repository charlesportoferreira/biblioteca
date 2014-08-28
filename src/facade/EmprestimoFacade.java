package facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Emprestimo;

public class EmprestimoFacade extends AbstractFacade<Emprestimo> {

    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaPU");
        em = emf.createEntityManager();
        return em;
       
    }

    public EmprestimoFacade() {
        super(Emprestimo.class);
    }

    public List<Emprestimo> findAllWithUsuario(String id, String comandoComplementarSQL) {
        em = getEntityManager();
        Query query = em.createNativeQuery(
                "select * from EMPRESTIMO where usuario_id = " + id + comandoComplementarSQL, Emprestimo.class);
        List<Emprestimo> result = query.getResultList();
        return result;
    }

    public List<Emprestimo> findAllWithItem(String idbib, String comandoComplementarSQL) {
        em = getEntityManager();
        Query query = em.createNativeQuery(
                "select * from EMPRESTIMO where exemplar_idbib = " + idbib + comandoComplementarSQL, Emprestimo.class);
        List<Emprestimo> result = query.getResultList();
        return result;
    }

}
