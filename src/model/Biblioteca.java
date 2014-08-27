package model;

import facade.AtorFacade;
import facade.AutorFacade;
import facade.CategoriaFacade;
import facade.ExemplarFacade;
import facade.FilmeFacade;
import facade.ItemFacade;
import facade.LivroFacade;
import facade.RevistaFacade;
import facade.SoftwareFacade;
import facade.UsuarioFacade;
import java.util.List;
import view.Login;
import view.Menu;

public class Biblioteca {

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
        createDataSimulation();
//        LivroFacade lf = new LivroFacade();
//        Livro l = lf.find(51L);
//        System.exit(0);
        AutorFacade af = new AutorFacade();
        Autor a = af.findAll().get(0);
        System.exit(0);
        //abrirLogin();

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

    @SuppressWarnings("empty-statement")
    public static void createDataSimulation() {
        
//         *********   Criacao das categorias  *************************
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
//         ************************************************************

//         *********   Criacao dos Usuários  *************************
        UsuarioFacade uf = new UsuarioFacade();
        Usuario charles = new Usuario();
        charles.setNome("Charles");
        charles.setCategoria(cf.find(1L));
        charles.setCPF(12345);
        charles.setEmail("emailCharles");
        charles.setEndereco("enderecoCharles");
        charles.setRG(54321);
        charles.setSenha("ferreira");
        charles.setLogin("charles");
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
        AutorFacade af = new AutorFacade();
        Autor autor1 = new Autor();
        autor1.setNome("autor1");
        Autor autor2 = new Autor();
        autor2.setNome("autor2");

        
        af.create(autor1);
        af.create(autor2);
        // ************************************************************

        //**********  Criação de Atores  ****************************
        AtorFacade atf = new AtorFacade();
        Ator ator1 = new Ator();
        ator1.setNome("ator1");
        Ator ator2 = new Ator();
        ator2.setNome("ator2");
        Ator ator3 = new Ator();
        ator3.setNome("ator3");


        atf.create(ator1);
        atf.create(ator2);
        atf.create(ator3);
        // ************************************************************

        // *********   Criacao dos Itens  *************************
        LivroFacade lf = new LivroFacade();
        RevistaFacade rf = new RevistaFacade();
        FilmeFacade ff = new FilmeFacade();
        SoftwareFacade sf = new SoftwareFacade();
        ItemFacade itf = new ItemFacade();
//        List<Autor> autores = af.findAll();
//        List<Ator> atores = atf.findAll();
        
        Livro livro1 = new Livro();
        livro1.setAno(10);
        livro1.setEdicao(1);
        livro1.setEditora("editoraLivro1");
        Autor a = af.findAll().get(0);
        livro1.addAutor(a);
        Autor b = af.findAll().get(1);
        livro1.addAutor(b);
        
        livro1.setTitulo("livro1");
        
        a.addLivro(livro1);
        b.addLivro(livro1);

        Livro livro2 = new Livro();
        livro2.setAno(20);
        livro2.setEdicao(2);
        livro2.setEditora("editoraLivro2");
        Autor c = af.findAll().get(0);
        livro2.addAutor(c);
        c.addLivro(livro2);
        livro2.setTitulo("livro2");

        Livro livro3 = new Livro();
        livro3.setAno(20);
        livro3.setEdicao(2);
        livro3.setEditora("editoraLivro3");
        Autor d = af.findAll().get(0);
        livro3.addAutor(d);
        d.addLivro(livro3);
        livro3.setTitulo("livro3");

        
        
        lf.edit(livro1);
        lf.edit(livro2);
        lf.edit(livro3);

        Revista revista = new Revista();
        revista.setTitulo("TituloRevista");
        revista.setNumero(1);
        revista.setVolume(10);
        revista.setAno(2000);

        
        rf.edit(revista);

        Filme filme1 = new Filme();
        filme1.setAno(1999);
        filme1.setTitulo("Filme1");
        filme1.setProdutora("prodFilme1");
        ff.create(filme1);
        
        Filme filme2 = new Filme();
        filme2.setAno(2014);
        filme2.setTitulo("Filme2");
        filme2.setProdutora("prodFilme2");
        ff.create(filme2);
        
        
        Ator at1 = atf.findAll().get(0);
        Ator at2 = atf.findAll().get(1);
        Filme f1 = ff.findAll().get(0);
        f1.addAtor(at1);
        f1.addAtor(at2);
        at1.addFilme(f1);
        at2.addFilme(f1);
        ff.edit(f1);
        atf.edit(at1);
        atf.edit(at2);
        
        Ator at11 = atf.findAll().get(0);
        Filme f2 = ff.findAll().get(1);
        f2.addAtor(at11);
        at11.addFilme(f2);
        ff.edit(f2);
        atf.edit(at11);

        Software software = new Software();
        software.setTitulo("TituloSoftware");
        software.setAnoCompra(1988);
        software.setFabricante("facSoftware");
        software.setSistemaOperacional("LINUX");
        software.setVersao(1);

        
        sf.edit(software);
//        // ************************************************************
//
//        // *********   Criacao dos Exemplares  *************************
        
        ExemplarFacade ef = new ExemplarFacade();
//        List<Item> itens = itf.findAll();

        Exemplar e1 = new Exemplar();
        Livro l11 = (Livro) itf.findAll().get(0);
        e1.setItem(l11);
        l11.addExemplar(e1);
        e1.setDisponivel(true);
        ef.edit(e1);

        Exemplar e2 = new Exemplar();
        Livro l12 = (Livro) itf.findAll().get(0);  
        e2.setItem(l12);
        l12.addExemplar(e2);
        e2.setDisponivel(true);
        ef.edit(e2);

        Exemplar e3 = new Exemplar();
        Livro l21 = (Livro) itf.findAll().get(1);
        e3.setItem(l21);
        l21.addExemplar(e3);
        e3.setDisponivel(true);
        ef.edit(e3);

        Exemplar e4 = new Exemplar();
        Livro l22 = (Livro) itf.findAll().get(1);
        e4.setItem(l22);
        l22.addExemplar(e4);
        e4.setDisponivel(true);
        ef.edit(e4);

        Exemplar e5 = new Exemplar();
        Livro l31 = (Livro) itf.findAll().get(2);
        e5.setItem(l31);
        l31.addExemplar(e5);
        e5.setDisponivel(true);
        ef.edit(e5);

        Exemplar e6 = new Exemplar();
        Livro l32 = (Livro) itf.findAll().get(2);
        e6.setItem(l32);
        l32.addExemplar(e6);
        e6.setDisponivel(true);
        ef.edit(e6);

        Exemplar e7 = new Exemplar();
        Revista r = (Revista) itf.findAll().get(3);
        e7.setItem(r);
        r.addExemplar(e7);
        e7.setDisponivel(true);
        ef.edit(e7);

        Exemplar e8 = new Exemplar();
        Revista r1 = (Revista) itf.findAll().get(3);
        e8.setItem(r1);
        r1.addExemplar(e8);
        e8.setDisponivel(true);
        ef.edit(e8);

        Exemplar e9 = new Exemplar();
        Filme fi1 = (Filme) itf.findAll().get(4);
        e9.setItem(fi1);
        fi1.addExemplar(e9);
        e9.setDisponivel(true);
        ef.edit(e9);

        Exemplar e10 = new Exemplar();
        Filme fi2 = (Filme) itf.findAll().get(4);
        e10.setItem(fi2);
        fi2.addExemplar(e10);
        e10.setDisponivel(true);
        ef.edit(e10);

        Exemplar e11 = new Exemplar();
        Software s1 = (Software) itf.findAll().get(6);
        e11.setItem(s1);
        s1.addExemplar(e11);
        e11.setDisponivel(true);
        ef.edit(e11);

        Exemplar e12 = new Exemplar();
        Software s2 = (Software) itf.findAll().get(6);
        e12.setItem(s2);
        s2.addExemplar(e12);
        e12.setDisponivel(true);
        ef.edit(e12);

        // ************************************************************
    }
}
