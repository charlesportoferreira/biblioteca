package facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Usuario;

public class UsuarioFacade extends AbstractFacade<Usuario> {

    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaPU");
        em = emf.createEntityManager();
        return em;
      
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }


}
