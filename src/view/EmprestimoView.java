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
import controller.UsuarioController;
import controller.UsuarioTableModel;
import facade.EmprestimoFacade;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import model.Biblioteca;
import model.Emprestimo;
import model.Exemplar;
import model.Filme;
import model.Livro;
import model.Revista;
import model.Software;
import model.Usuario;

/**
 *
 * @author charleshenriqueportoferreira
 */
public class EmprestimoView extends javax.swing.JFrame {

    ItemTableModel modelItem;
    UsuarioTableModel modelUsuario;
    LivroTableModel modeloLivro;
    RevistaTableModel modeloRevista;
    FilmeTableModel modeloFilme;
    SoftwareTableModel modeloSoftware;
    JMenuItem menuItemMenu;
    Usuario usuario;

    /**
     * Creates new form Emprestimo
     *
     * @param usuario
     */
    public EmprestimoView(final Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        setLocationRelativeTo(null);
        modelItem = new ItemTableModel();
        modelUsuario = new UsuarioTableModel();
        tblItem.setModel(modelItem);
        tblUsuario.setModel(modelUsuario);
        modeloLivro = new LivroTableModel();
        modeloRevista = new RevistaTableModel();
        modeloFilme = new FilmeTableModel();
        modeloSoftware = new SoftwareTableModel();
        bgItens.add(rdLivro);
        bgItens.add(rdFilme);
        bgItens.add(rdSoftware);
        bgItens.add(rdRevista);
        tblItem.setModel(modeloLivro);
        menuItemMenu = new JMenuItem("Menu", KeyEvent.VK_M);
        menuMenu.add(menuItemMenu);
        lblTipoUsuario.setText(usuario.getCategoria().getTipo() + "(a)");
        lblNomeUsuarioLogado.setText(usuario.getNome());
        menuItemMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu(usuario).setVisible(true);
                dispose();
            }

        });
    }

    public EmprestimoView() {
        initComponents();
        setLocationRelativeTo(null);
        modelItem = new ItemTableModel();
        modelUsuario = new UsuarioTableModel();
        tblItem.setModel(modelItem);
        tblUsuario.setModel(modelUsuario);
        modeloLivro = new LivroTableModel();
        modeloRevista = new RevistaTableModel();
        modeloFilme = new FilmeTableModel();
        modeloSoftware = new SoftwareTableModel();
        bgItens.add(rdLivro);
        bgItens.add(rdFilme);
        bgItens.add(rdSoftware);
        bgItens.add(rdRevista);
        tblItem.setModel(modeloLivro);
        menuItemMenu = new JMenuItem("Menu", KeyEvent.VK_M);
        menuMenu.add(menuItemMenu);

        menuItemMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu(usuario).setVisible(true);
                dispose();
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgItens = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        txtBuscarUsuario = new javax.swing.JTextField();
        lblBuscarUsuario = new javax.swing.JLabel();
        btnBuscarUsuario = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        rdLivro = new javax.swing.JRadioButton();
        rdRevista = new javax.swing.JRadioButton();
        rdFilme = new javax.swing.JRadioButton();
        rdSoftware = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();
        txtBuscarItem = new javax.swing.JTextField();
        lblBuscarItem = new javax.swing.JLabel();
        btnBuscarItem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnEmprestrar = new javax.swing.JButton();
        lblEmprestimo = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        lblNomeUsuarioLogado = new javax.swing.JLabel();
        lblLogado = new javax.swing.JLabel();
        btnLogoff = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        tblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblUsuarioMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuarioMouseClicked(evt);
            }
        });
        tblUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblUsuarioKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuario);

        lblBuscarUsuario.setText("Buscar Usuario");

        btnBuscarUsuario.setText("Buscar");
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lblBuscarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarUsuario)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscarUsuario)
                    .addComponent(btnBuscarUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        tblItem.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblItem);

        lblBuscarItem.setText("Buscar Item");

        btnBuscarItem.setText("Buscar");
        btnBuscarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(rdLivro)
                        .addGap(27, 27, 27)
                        .addComponent(rdRevista)
                        .addGap(26, 26, 26)
                        .addComponent(rdFilme)
                        .addGap(26, 26, 26)
                        .addComponent(rdSoftware))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(lblBuscarItem)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarItem)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscarItem)
                    .addComponent(btnBuscarItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdLivro)
                    .addComponent(rdRevista)
                    .addComponent(rdFilme)
                    .addComponent(rdSoftware))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnEmprestrar.setText("Emprestar");
        btnEmprestrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprestrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(btnEmprestrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(btnEmprestrar)
                .addGap(16, 16, 16))
        );

        lblEmprestimo.setFont(new java.awt.Font("Lucida Grande", 3, 25)); // NOI18N
        lblEmprestimo.setText("Emprestimo");

        lblTipoUsuario.setForeground(new java.awt.Color(0, 0, 255));
        lblTipoUsuario.setText("aaaa");

        lblNomeUsuarioLogado.setForeground(new java.awt.Color(0, 0, 255));
        lblNomeUsuarioLogado.setText("jLabel6");

        lblLogado.setForeground(new java.awt.Color(0, 0, 255));
        lblLogado.setText("logado(a)");

        btnLogoff.setText("logoff");
        btnLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoffActionPerformed(evt);
            }
        });

        menuMenu.setText("Menu");
        jMenuBar1.add(menuMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(lblEmprestimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTipoUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNomeUsuarioLogado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLogado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogoff))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblEmprestimo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLogado)
                            .addComponent(lblNomeUsuarioLogado)
                            .addComponent(lblTipoUsuario)
                            .addComponent(btnLogoff))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarItemActionPerformed

        ItemController ic = new ItemController();

        if (rdLivro.isSelected()) {
            modeloLivro.limpar();
            modeloLivro.addListaDeLivro(ic.livroFacade.findAllWithValue("titulo", txtBuscarItem.getText()));
        }
        if (rdRevista.isSelected()) {
            modeloRevista.limpar();
            modeloRevista.addListaDeRvista(ic.revistaFacade.findAllWithValue("titulo", txtBuscarItem.getText()));
        }
        if (rdFilme.isSelected()) {
            modeloFilme.limpar();
            modeloFilme.addListaDeFilme(ic.filmeFacade.findAllWithValue("titulo", txtBuscarItem.getText()));
        }
        if (rdSoftware.isSelected()) {
            modeloSoftware.limpar();
            modeloSoftware.addListaDeSoftware(ic.softwareFacade.findAllWithValue("titulo", txtBuscarItem.getText()));
        }

    }//GEN-LAST:event_btnBuscarItemActionPerformed

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed
        UsuarioController uc = new UsuarioController();
        modelUsuario.limpar();
        modelUsuario.addListaDeUsuario(uc.usuarioFacade.findAllWithValue("nome", txtBuscarUsuario.getText()));
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed

    private void rdLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdLivroActionPerformed
        tblItem.setModel(modeloLivro);
    }//GEN-LAST:event_rdLivroActionPerformed

    private void rdRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdRevistaActionPerformed
        tblItem.setModel(modeloRevista);
    }//GEN-LAST:event_rdRevistaActionPerformed

    private void rdFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFilmeActionPerformed
        tblItem.setModel(modeloFilme);
    }//GEN-LAST:event_rdFilmeActionPerformed

    private void rdSoftwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSoftwareActionPerformed
        tblItem.setModel(modeloSoftware);
    }//GEN-LAST:event_rdSoftwareActionPerformed

    private void btnLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoffActionPerformed
        this.usuario = null;
        Biblioteca.abrirLogin();
        this.dispose();
    }//GEN-LAST:event_btnLogoffActionPerformed

    private void btnEmprestrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprestrarActionPerformed
        Exemplar exemplar = new Exemplar();
        
        int rowItem = tblItem.getSelectedRow();
        if (rowItem == -1) {
            JOptionPane.showMessageDialog(rootPane, "Selectione um item da tabela para ser emprestado");
            return;
        }
        if (rdLivro.isSelected()) {
            LivroTableModel livroModel = (LivroTableModel) tblItem.getModel();
            Livro livro = livroModel.getLivro(rowItem);
            exemplar = livro.getExemplarDisponivel();
        }
        if (rdRevista.isSelected()) {
            RevistaTableModel revistaModel = (RevistaTableModel) tblItem.getModel();
            Revista revista = revistaModel.getRevista(rowItem);
            exemplar = revista.getExemplarDisponivel();
        }
        if (rdFilme.isSelected()) {
            FilmeTableModel filmeModel = (FilmeTableModel) tblItem.getModel();
            Filme filme = filmeModel.getFilme(rowItem);
            exemplar = filme.getExemplarDisponivel();
        }
        if (rdSoftware.isSelected()) {
            SoftwareTableModel softwareModel = (SoftwareTableModel) tblItem.getModel();
            Software software = softwareModel.getSoftware(rowItem);
            exemplar = software.getExemplarDisponivel();
        }

        if (exemplar == null) {
            JOptionPane.showMessageDialog(rootPane, "Não existem exemplares disponiveis");
            return;
        }

        int rowUsuario = tblUsuario.getSelectedRow();
        if (rowUsuario == -1) {
            JOptionPane.showMessageDialog(rootPane, "Selectione um usuário da tabela para ser feito o emprestimo");
            return;
        }
        UsuarioTableModel usuarioModel = (UsuarioTableModel) tblUsuario.getModel();
        Usuario usuarioSelecionado = usuarioModel.getUsuario(rowUsuario);
        

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setExemplar(exemplar);
        emprestimo.setMulta(0);
        emprestimo.setUsuario(usuarioSelecionado);
        emprestimo.setQtdRenovacoes(0);

        emprestimo.setDataEmprestimo(Date.from(Instant.now()));
        exemplar.setDisponivel(false);
        Instant instant = Instant.now();
        Instant dataLimite = instant.plus(Duration.ofDays(usuarioSelecionado.getCategoria().getDiasEmprestimo()));
        emprestimo.setDataLimite(Date.from(dataLimite));

        EmprestimoFacade ef = new EmprestimoFacade();
        ef.edit(emprestimo);

        JOptionPane.showMessageDialog(rootPane, "Emprestimo efetuado para\n" + usuarioSelecionado.getNome() + "\n"
                + "do item: " + exemplar.getItem().getTitulo() + "");
        btnBuscarItem.doClick();

    }//GEN-LAST:event_btnEmprestrarActionPerformed

    private void tblUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblUsuarioKeyPressed

    }//GEN-LAST:event_tblUsuarioKeyPressed

    private void tblUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuarioMouseClicked

    }//GEN-LAST:event_tblUsuarioMouseClicked

    private void tblUsuarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuarioMouseReleased

    }//GEN-LAST:event_tblUsuarioMouseReleased

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
            java.util.logging.Logger.getLogger(EmprestimoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmprestimoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmprestimoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmprestimoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmprestimoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgItens;
    private javax.swing.JButton btnBuscarItem;
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnEmprestrar;
    private javax.swing.JButton btnLogoff;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBuscarItem;
    private javax.swing.JLabel lblBuscarUsuario;
    private javax.swing.JLabel lblEmprestimo;
    private javax.swing.JLabel lblLogado;
    private javax.swing.JLabel lblNomeUsuarioLogado;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JMenu menuMenu;
    private javax.swing.JRadioButton rdFilme;
    private javax.swing.JRadioButton rdLivro;
    private javax.swing.JRadioButton rdRevista;
    private javax.swing.JRadioButton rdSoftware;
    private javax.swing.JTable tblItem;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtBuscarItem;
    private javax.swing.JTextField txtBuscarUsuario;
    // End of variables declaration//GEN-END:variables
}
