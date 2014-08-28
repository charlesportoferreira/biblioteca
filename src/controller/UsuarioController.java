/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.UsuarioFacade;

public class UsuarioController {

    public UsuarioFacade usuarioFacade;

    public UsuarioController() {
        this.usuarioFacade = new UsuarioFacade();
    }

}
