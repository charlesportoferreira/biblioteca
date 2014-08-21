/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.FilmeFacade;
import facade.ItemFacade;
import facade.LivroFacade;
import facade.RevistaFacade;
import facade.SoftwareFacade;

/**
 *
 * @author charleshenriqueportoferreira
 */
public class ItemController {

    public LivroFacade livroFacade;
    public RevistaFacade revistaFacade;
    public FilmeFacade filmeFacade;
    public SoftwareFacade softwareFacade;
    public ItemFacade itemFacade;

    public ItemController() {
        livroFacade = new LivroFacade();
        itemFacade = new ItemFacade();
        softwareFacade = new SoftwareFacade();
        filmeFacade = new FilmeFacade();
        revistaFacade = new RevistaFacade();
    }

}
