/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Filme;
import model.Livro;
import model.Revista;

/**
 *
 * @author Juliana
 */
public class FilmeFacade extends AbstractFacade<Filme>{
    
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

    public FilmeFacade() {
        super(Filme.class);
    }

   
}
