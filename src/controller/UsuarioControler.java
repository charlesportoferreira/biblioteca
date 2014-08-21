package controller;

import facade.UsuarioFacade;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioControler {

    private Usuario usuario;
    private UsuarioFacade usuarioFacade;

    public UsuarioControler() {
        usuarioFacade = new UsuarioFacade();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public void create() {
        try {
            usuarioFacade.create(usuario);
        } catch (Exception e) {
            //Não sei o que colocar
        }
    }

    public void update() {
        try {
            usuarioFacade.edit(usuario);

        } catch (Exception e) {
            //Não sei o que colocar
        }
    }

    private void destroy() {
        try {
            usuarioFacade.remove(usuario);

        } catch (Exception e) {

        }
    }

    public Usuario getUsuario(Long id) {
        return usuarioFacade.find(id);
    }

    public List<Usuario> findAll() {
        return usuarioFacade.findAll();
    }

    public static String convertStringToMd5(String valor) {
        MessageDigest mDigest;
        try {
            mDigest = MessageDigest.getInstance("MD5"); //Convert a String valor para um array de bytes em MD5 
            byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8")); //Convertemos os bytes para hexadecimal, assim podemos salvar 
            //no banco para posterior comparação se senhas 
            StringBuilder sb = new StringBuilder();
            for (byte b : valorMD5) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public boolean fazLogin(String login, String senha) {

        List<Usuario> usuarios = new ArrayList<>();
        usuarios = usuarioFacade.findAllWithValue("login", login, "senha", convertStringToMd5(senha));

        if (!usuarios.isEmpty()) {
            usuario = usuarios.get(0);
            return true;
        } else {
            return false;
        }
    }

}
