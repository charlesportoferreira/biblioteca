package facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Emprestimo;
import model.Usuario;

public class EmprestimoFacade extends AbstractFacade<Emprestimo> {

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
