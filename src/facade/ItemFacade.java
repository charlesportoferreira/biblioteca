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
import model.Item;
import model.Livro;

/**
 *
 * @author charleshenriqueportoferreira
 */
public class ItemFacade extends AbstractFacade<Item> {

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

    public ItemFacade() {
        super(Item.class);
    }

   
}
