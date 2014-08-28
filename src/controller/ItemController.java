package controller;

import facade.FilmeFacade;
import facade.ItemFacade;
import facade.LivroFacade;
import facade.RevistaFacade;
import facade.SoftwareFacade;

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
