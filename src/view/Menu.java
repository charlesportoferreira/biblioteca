/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FilmeTableModel;
import controller.ItemController;
import controller.ItemTableModel;
import controller.LivroTableModel;
import controller.RevistaTableModel;
import controller.SoftwareTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import model.Biblioteca;
import model.Usuario;

/**
 *
 * @author charleshenriqueportoferreira
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    Usuario usuario;
    ItemTableModel itemModelo;
    LivroTableModel modeloLivro;
    RevistaTableModel modeloRevista;
    FilmeTableModel modeloFilme;
    SoftwareTableModel modeloSoftware;
    JMenuItem menuItemUsuario;
    JMenuItem menuItemCompra;
    JMenuItem menuItemLivro;
    JMenuItem menuItemFilme;
    JMenuItem menuItemRevista;
    JMenuItem menuItemSoftware;
    JMenuItem menuItemPrateleira;
    JMenuItem menuItemCadastroEmprestimo;
    JMenuItem menuItemEmprestimo;
    JMenuItem menuRenovarEmprestimo;

    public Menu(final Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        itemModelo = new ItemTableModel();
        modeloLivro = new LivroTableModel();
        modeloRevista = new RevistaTableModel();
        modeloFilme = new FilmeTableModel();
        modeloSoftware = new SoftwareTableModel();
        tblBusca.setModel(modeloLivro);
        bgSelecaoItem.add(rdFilme);
        bgSelecaoItem.add(rdRevista);
        bgSelecaoItem.add(rdSoftware);
        bgSelecaoItem.add(rdLivro);
        setLocationRelativeTo(null);
        menuItemUsuario = new JMenuItem("Usuario", KeyEvent.VK_U);
        menuItemCompra = new JMenuItem("Compra", KeyEvent.VK_C);
        menuItemLivro = new JMenuItem("Livro", KeyEvent.VK_L);
        menuItemFilme = new JMenuItem("Filme", KeyEvent.VK_F);
        menuItemRevista = new JMenuItem("Revista", KeyEvent.VK_R);
        menuItemSoftware = new JMenuItem("Software", KeyEvent.VK_S);
        menuItemPrateleira = new JMenuItem("Prateleira", KeyEvent.VK_P);
        menuItemCadastroEmprestimo = new JMenuItem("Cadastrar", KeyEvent.VK_C);
        menuItemEmprestimo = new JMenuItem("Visualizar", KeyEvent.VK_V);
        menuRenovarEmprestimo = new JMenuItem("Renovar Emprestimo", KeyEvent.VK_R);
        menuCadastrar.add(menuItemUsuario);
        menuCadastrar.add(menuItemCompra);
        menuCadastrar.add(menuItemLivro);
        menuCadastrar.add(menuItemFilme);
        menuCadastrar.add(menuItemRevista);
        menuCadastrar.add(menuItemSoftware);
        menuCadastrar.add(menuItemPrateleira);
        menuEmprestimo.add(menuItemCadastroEmprestimo);
        menuEmprestimo.add(menuItemEmprestimo);
        menuRenovar.add(menuRenovarEmprestimo);
        if (!usuario.getCategoria().getTipo().equals("Funcionario")) {
            menuCadastrar.setVisible(false);
            menuEmprestimo.setVisible(false);
        } else {
            menuRenovar.setVisible(false);
            btnReservar.setVisible(false);
        }
        lblTipoUsuario.setText(usuario.getCategoria().getTipo() + "(a)");
        lblNomeUsuario.setText(usuario.getNome());

        menuItemCadastroEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmprestimoView(usuario).setVisible(true);
                dispose();
            }
        });

        menuItemEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListaEmprestimo(usuario).setVisible(true);
                dispose();
            }
        });

        menuRenovarEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Renovacao(usuario).setVisible(true);
                dispose();
            }
        });
    }

    public Menu() {
        initComponents();
        itemModelo = new ItemTableModel();
        modeloLivro = new LivroTableModel();
        modeloRevista = new RevistaTableModel();
        modeloFilme = new FilmeTableModel();
        modeloSoftware = new SoftwareTableModel();
        tblBusca.setModel(modeloLivro);
        bgSelecaoItem.add(rdFilme);
        bgSelecaoItem.add(rdRevista);
        bgSelecaoItem.add(rdSoftware);
        bgSelecaoItem.add(rdLivro);
        setLocationRelativeTo(null);
        menuItemUsuario = new JMenuItem("Usuario", KeyEvent.VK_U);
        menuItemCompra = new JMenuItem("Compra", KeyEvent.VK_C);
        menuItemLivro = new JMenuItem("Livro", KeyEvent.VK_L);
        menuItemFilme = new JMenuItem("Filme", KeyEvent.VK_F);
        menuItemRevista = new JMenuItem("Revista", KeyEvent.VK_R);
        menuItemSoftware = new JMenuItem("Software", KeyEvent.VK_S);
        menuItemPrateleira = new JMenuItem("Prateleira", KeyEvent.VK_P);
        menuItemCadastroEmprestimo = new JMenuItem("Cadastrar", KeyEvent.VK_C);
        menuItemEmprestimo = new JMenuItem("Visualizar", KeyEvent.VK_V);
        menuCadastrar.add(menuItemUsuario);
        menuCadastrar.add(menuItemCompra);
        menuCadastrar.add(menuItemLivro);
        menuCadastrar.add(menuItemFilme);
        menuCadastrar.add(menuItemRevista);
        menuCadastrar.add(menuItemSoftware);
        menuCadastrar.add(menuItemPrateleira);
        menuEmprestimo.add(menuItemCadastroEmprestimo);
        menuEmprestimo.add(menuItemEmprestimo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSelecaoItem = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        lblBuscar = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        rdLivro = new javax.swing.JRadioButton();
        rdRevista = new javax.swing.JRadioButton();
        rdFilme = new javax.swing.JRadioButton();
        rdSoftware = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBusca = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        lblNomeUsuario = new javax.swing.JLabel();
        lblLogado = new javax.swing.JLabel();
        btnLogoff = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnReservar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastrar = new javax.swing.JMenu();
        menuRenovar = new javax.swing.JMenu();
        menuEmprestimo = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblBuscar.setText("Buscar");

        btnBuscar.setText("buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        rdLivro.setSelected(true);
        rdLivro.setText("Livro");
        rdLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdLivroActionPerformed(evt);
            }
        });

        rdRevista.setText("Revista");
        rdRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdRevistaActionPerformed(evt);
            }
        });

        rdFilme.setText("Filme");
        rdFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFilmeActionPerformed(evt);
            }
        });

        rdSoftware.setText("Software");
        rdSoftware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSoftwareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(rdLivro)
                        .addGap(18, 18, 18)
                        .addComponent(rdRevista)
                        .addGap(18, 18, 18)
                        .addComponent(rdFilme)
                        .addGap(28, 28, 28)
                        .addComponent(rdSoftware)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscar)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdLivro)
                    .addComponent(rdRevista)
                    .addComponent(rdFilme)
                    .addComponent(rdSoftware))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblBusca);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/livro.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/movie.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/magazine-2.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Software.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Lucida Grande", 3, 25)); // NOI18N
        lblTitulo.setText("Sistema de Gerenciamento de Bibliotecas");

        lblTipoUsuario.setForeground(new java.awt.Color(0, 0, 255));
        lblTipoUsuario.setText("aaaa");

        lblNomeUsuario.setForeground(new java.awt.Color(0, 0, 255));
        lblNomeUsuario.setText("jLabel6");

        lblLogado.setForeground(new java.awt.Color(0, 0, 255));
        lblLogado.setText("logado(a)");

        btnLogoff.setText("logff");
        btnLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTipoUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNomeUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLogado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogoff))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblLogado)
                                .addComponent(lblNomeUsuario)
                                .addComponent(lblTipoUsuario)
                                .addComponent(btnLogoff))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTitulo)
                            .addGap(29, 29, 29))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(37, 37, 37))))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnReservar.setText("Reservar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(btnReservar)
                .addContainerGap(407, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnReservar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        menuCadastrar.setText("Cadastro");
        jMenuBar1.add(menuCadastrar);

        menuRenovar.setText("Renovacao");
        jMenuBar1.add(menuRenovar);

        menuEmprestimo.setText("Emprestimo");
        jMenuBar1.add(menuEmprestimo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ItemController ic = new ItemController();

        if (rdLivro.isSelected()) {
            modeloLivro.limpar();
            modeloLivro.addListaDeLivro(ic.livroFacade.findAllWithValue("titulo", txtBuscar.getText()));
        }
        if (rdRevista.isSelected()) {
            modeloRevista.limpar();
            modeloRevista.addListaDeRvista(ic.revistaFacade.findAllWithValue("titulo", txtBuscar.getText()));
        }
        if (rdFilme.isSelected()) {
            modeloFilme.limpar();
            modeloFilme.addListaDeFilme(ic.filmeFacade.findAllWithValue("titulo", txtBuscar.getText()));
        }
        if (rdSoftware.isSelected()) {
            modeloSoftware.limpar();
            modeloSoftware.addListaDeSoftware(ic.softwareFacade.findAllWithValue("titulo", txtBuscar.getText()));
        }

    }//GEN-LAST:event_btnBuscarActionPerformed


    private void rdLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdLivroActionPerformed
        tblBusca.setModel(modeloLivro);
    }//GEN-LAST:event_rdLivroActionPerformed

    private void rdRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdRevistaActionPerformed
        tblBusca.setModel(modeloRevista);
    }//GEN-LAST:event_rdRevistaActionPerformed

    private void rdFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFilmeActionPerformed
        tblBusca.setModel(modeloFilme);
    }//GEN-LAST:event_rdFilmeActionPerformed

    private void rdSoftwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSoftwareActionPerformed
        tblBusca.setModel(modeloSoftware);
    }//GEN-LAST:event_rdSoftwareActionPerformed

    private void btnLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoffActionPerformed
        this.usuario = null;
        Biblioteca.abrirLogin();
        this.dispose();
    }//GEN-LAST:event_btnLogoffActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSelecaoItem;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLogoff;
    private javax.swing.JButton btnReservar;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblLogado;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenu menuCadastrar;
    private javax.swing.JMenu menuEmprestimo;
    private javax.swing.JMenu menuRenovar;
    private javax.swing.JRadioButton rdFilme;
    private javax.swing.JRadioButton rdLivro;
    private javax.swing.JRadioButton rdRevista;
    private javax.swing.JRadioButton rdSoftware;
    private javax.swing.JTable tblBusca;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
