package model;

import facade.AtorFacade;
import facade.AutorFacade;
import facade.CategoriaFacade;
import facade.ExemplarFacade;
import facade.FilmeFacade;
import facade.LivroFacade;
import facade.RevistaFacade;
import facade.SoftwareFacade;
import facade.UsuarioFacade;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import view.Login;
import view.Menu;

public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Date date = new Date();
//        Instant inst = date.toInstant();
//
//        // Get the current time
//        Instant instant = Instant.now();
//        //Instant instant = Instant.ofEpochMilli(new Date().getTime());
//        // Output format is ISO-8601
//        Date newDate1 = Date.from(instant);
//        System.out.println(instant);
//        System.out.println(newDate1);
//        Instant novo = instant.plus(Duration.ofDays(20));
//        System.out.println(novo);
//        Date newDate = Date.from(novo);
//        System.out.println(newDate);
        //System.exit(0);
       // createDataSimulation();
        abrirLogin();

    }

    public static void abrirLogin() {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    public static void abrirMenu(final Usuario usuario) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu(usuario).setVisible(true);
            }
        });
    }

    public static void createDataSimulation() {
        // *********   Criacao das categorias  *************************
        Categoria categoria1 = new Categoria();
        categoria1.setTipo("Funcionario");
        categoria1.setPrivilegiado(true);
        categoria1.setDiasEmprestimo(100);

        Categoria categoria2 = new Categoria();
        categoria2.setTipo("Aluno");
        categoria2.setDiasEmprestimo(5);

        Categoria categoria3 = new Categoria();
        categoria3.setTipo("Professor");
        categoria3.setDiasEmprestimo(30);

        CategoriaFacade cf = new CategoriaFacade();
        cf.create(categoria1);
        cf.create(categoria2);
        cf.create(categoria3);
        // ************************************************************

        // *********   Criacao dos Usuários  *************************
        Usuario charles = new Usuario();
        charles.setNome("Charles");
        charles.setCategoria(cf.find(1L));
        charles.setCPF(12345);
        charles.setEmail("emailCharles");
        charles.setEndereco("enderecoCharles");
        charles.setRG(54321);
        charles.setSenha("ferreira");
        charles.setLogin("charles");
        UsuarioFacade uf = new UsuarioFacade();
        uf.edit(charles);

        Usuario juliana = new Usuario();
        juliana.setNome("Juliana");
        juliana.setCategoria(cf.find(2L));
        juliana.setCPF(12345);
        juliana.setEmail("emailJuliana");
        juliana.setEndereco("enderecoJuliana");
        juliana.setRG(54321);
        juliana.setSenha("calio");
        juliana.setLogin("juliana");
        uf.edit(juliana);

        Usuario aline = new Usuario();
        aline.setNome("Aline");
        aline.setCategoria(cf.find(3L));
        aline.setCPF(12345);
        aline.setEmail("emailAline");
        aline.setEndereco("enderecoAline");
        aline.setRG(54321);
        aline.setSenha("garcia");
        aline.setLogin("aline");
        uf.edit(aline);

        Usuario jessica = new Usuario();
        jessica.setNome("Jessica");
        jessica.setCategoria(cf.find(3L));
        jessica.setCPF(12345);
        jessica.setEmail("emailJessica");
        jessica.setEndereco("enderecoJessica");
        jessica.setRG(54321);
        jessica.setSenha("lima");
        jessica.setLogin("jessica");
        uf.edit(jessica);
        // ************************************************************

        //**********  Criação de Autores  ****************************
        Autor autor1 = new Autor();
        autor1.setNome("autor1");
        Autor autor2 = new Autor();
        autor2.setNome("autor2");

        AutorFacade af = new AutorFacade();
        af.create(autor1);
        af.create(autor2);
        // ************************************************************

        //**********  Criação de Atores  ****************************
        Ator ator1 = new Ator();
        autor1.setNome("ator1");
        Ator ator2 = new Ator();
        autor2.setNome("ator2");

        AtorFacade atf = new AtorFacade();
        atf.create(ator1);
        atf.create(ator2);
        // ************************************************************

        // *********   Criacao dos Itens  *************************
        Livro livro1 = new Livro();
        livro1.setAno(10);
        livro1.setEdicao(1);
        livro1.setEditora("editoraLivro1");
        Autor a = af.find(8L);
        livro1.addAutor(a);
        a.addLivro(livro1);
        Autor b = af.find(9L);
        livro1.addAutor(b);
        b.addLivro(livro1);
        livro1.setTitulo("livro1");

        Livro livro2 = new Livro();
        livro2.setAno(20);
        livro2.setEdicao(2);
        livro2.setEditora("editoraLivro2");
        Autor c = af.find(8L);
        livro2.addAutor(c);
        c.addLivro(livro2);
        livro2.setTitulo("livro2");

        Livro livro3 = new Livro();
        livro3.setAno(20);
        livro3.setEdicao(2);
        livro3.setEditora("editoraLivro3");
        Autor d = af.find(8L);
        livro3.addAutor(d);
        d.addLivro(livro3);
        livro3.setTitulo("livro3");

        LivroFacade lf = new LivroFacade();
        lf.edit(livro1);
        lf.edit(livro2);
        lf.edit(livro3);

        Revista revista = new Revista();
        revista.setTitulo("TituloRevista");
        revista.setNumero(1);
        revista.setVolume(10);
        revista.setAno(2000);

        RevistaFacade rf = new RevistaFacade();
        rf.edit(revista);

        Filme filme = new Filme();
        filme.setAno(1999);
        filme.setTitulo("TituloFilme");
        filme.setProdutora("prodFilme");
        Ator at1 = atf.find(10L);
        Ator at2 = atf.find(11L);
        filme.addAtor(ator1);
        ator1.addFilme(filme);

        FilmeFacade ff = new FilmeFacade();
        ff.edit(filme);

        Software software = new Software();
        software.setTitulo("TituloSoftware");
        software.setAnoCompra(1988);
        software.setFabricante("facSoftware");
        software.setSistemaOperacional("LINUX");
        software.setVersao(1);

        SoftwareFacade sf = new SoftwareFacade();
        sf.edit(software);
        // ************************************************************

        // *********   Criacao dos Exemplares  *************************
        ExemplarFacade ef = new ExemplarFacade();

        Exemplar e1 = new Exemplar();
        Livro l11 = lf.find(12L);
        e1.setItem(l11);
        l11.addExemplar(e1);
        e1.setDisponivel(true);
        ef.edit(e1);

        Livro l12 = lf.find(12L);
        Exemplar e2 = new Exemplar();
        e2.setItem(l12);
        l12.addExemplar(e2);
        e2.setDisponivel(true);
        ef.edit(e2);

        Exemplar e3 = new Exemplar();
        Livro l21 = lf.find(13L);
        e3.setItem(l21);
        l21.addExemplar(e3);
        e3.setDisponivel(true);
        ef.edit(e3);

        Exemplar e4 = new Exemplar();
        Livro l22 = lf.find(13L);
        e4.setItem(l22);
        l22.addExemplar(e4);
        e4.setDisponivel(true);
        ef.edit(e4);

        Exemplar e5 = new Exemplar();
        Livro l31 = lf.find(14L);
        e5.setItem(l31);
        l31.addExemplar(e5);
        e5.setDisponivel(true);
        ef.edit(e5);

        Exemplar e6 = new Exemplar();
        Livro l32 = lf.find(14L);
        e6.setItem(l32);
        l32.addExemplar(e6);
        e6.setDisponivel(true);
        ef.edit(e6);

        Exemplar e7 = new Exemplar();
        Revista r = rf.find(15L);
        e7.setItem(r);
        r.addExemplar(e7);
        e7.setDisponivel(true);
        ef.edit(e7);

        Exemplar e8 = new Exemplar();
        e8.setItem(r);
        r.addExemplar(e8);
        e8.setDisponivel(true);
        ef.edit(e8);

        Exemplar e9 = new Exemplar();
        Filme f1 = ff.find(16L);
        e9.setItem(f1);
        f1.addExemplar(e9);
        e9.setDisponivel(true);
        ef.edit(e9);

        Exemplar e10 = new Exemplar();
        Filme f2 = ff.find(16L);
        e10.setItem(f2);
        f2.addExemplar(e10);
        e10.setDisponivel(true);
        ef.edit(e10);

        Exemplar e11 = new Exemplar();
        Software s1 = sf.find(17L);
        e11.setItem(s1);
        s1.addExemplar(e11);
        e11.setDisponivel(true);
        ef.edit(e11);

        Exemplar e12 = new Exemplar();
        Software s2 = sf.find(17L);
        e12.setItem(s2);
        s2.addExemplar(e12);
        e12.setDisponivel(true);
        ef.edit(e12);

        // ************************************************************
    }
}
