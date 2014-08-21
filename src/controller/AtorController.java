package controller;

import facade.AtorFacade;
import java.util.List;
import model.Ator;


public class AtorController {
    
    private Ator ator;
    private AtorFacade atorFacade;
    
    public AtorController() {
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public AtorFacade getAtorFacade() {
        return atorFacade;
    }

    public void setAtorFacade(AtorFacade atorFacade) {
        this.atorFacade = atorFacade;
    }

   

    public void create() {
        try {
            atorFacade.create(ator);
        } catch (Exception e) {
            //Não sei o que colocar
        }
    }

    public void update() {
        try {
            atorFacade.edit(ator);
            
        } catch (Exception e) {
           //Não sei o que colocar
        }
    }

    private void destroy() {
        try {
            atorFacade.remove(ator);
            
        } catch (Exception e) {
           
        }
    }

    public Ator getAluno(Long id) {
        return atorFacade.find(id);
    }
    
    public List<Ator> findAll(){
        return atorFacade.findAll();
    }

    
    
}
