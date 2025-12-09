/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

/**
 *
 * @author OKS
 */

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.GameJam;
import model.dao.GameJamDAO;

public class TelaGameJam extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaGameJam
     */
    
    GameJam gj = null;
    
    public TelaGameJam() {
        initComponents();
        
        preencherTabela();
    }
    
    public void limpar() {
        txtNomeJam.setText("");
        txtTemaJam.setText("");
        txtDuraJam.setText("");
        txtPremioJam.setText("");
        txtDescJam.setText("");
        txtDataInJam.setText("");
        txtDataFimJam.setText("");
    }

    public void preencherTabela() {
        DefaultTableModel dtm = (DefaultTableModel) tblGameJams.getModel();
        dtm.setRowCount(0);
        GameJamDAO dao = new GameJamDAO();
        
        for(GameJam gj : dao.read()) {
            dtm.addRow(new Object[] {
                gj.getIdGJ(),
                gj.getNomeGJ(),
                gj.getTemaGJ(),
                gj.getDuraGJ(),
                gj.getPremioGJ(),
                gj.getDescGJ(),
                gj.getDataInGJ(),
                gj.getDataFimGJ()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeJam = new javax.swing.JTextField();
        txtTemaJam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDuraJam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPremioJam = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDataInJam = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDataFimJam = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescJam = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGameJams = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        jLabel1.setText("Nome:");

        txtNomeJam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeJamActionPerformed(evt);
            }
        });

        txtTemaJam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTemaJamActionPerformed(evt);
            }
        });

        jLabel3.setText("Tema:");

        txtDuraJam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuraJamActionPerformed(evt);
            }
        });

        jLabel2.setText("Duração:");

        txtPremioJam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPremioJamActionPerformed(evt);
            }
        });

        jLabel4.setText("Prêmio:");

        txtDataInJam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataInJamActionPerformed(evt);
            }
        });

        jLabel5.setText("Início:");

        txtDataFimJam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataFimJamActionPerformed(evt);
            }
        });

        jLabel6.setText("Fim:");

        jScrollPane1.setViewportView(txtDescJam);

        jLabel7.setText("Descrição:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNomeJam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTemaJam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPremioJam)
                            .addComponent(txtDuraJam)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDataInJam, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDataFimJam, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 37, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTemaJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDuraJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPremioJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataInJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataFimJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblGameJams.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Tema", "Duração", "Prêmio", "Início", "Fim", "Descrição"
            }
        ));
        tblGameJams.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGameJamsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblGameJams);

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpar)
                            .addComponent(btnCadastrar)
                            .addComponent(btnEditar)
                            .addComponent(btnExcluir)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeJamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeJamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeJamActionPerformed

    private void txtTemaJamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTemaJamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTemaJamActionPerformed

    private void txtDuraJamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuraJamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuraJamActionPerformed

    private void txtPremioJamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPremioJamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPremioJamActionPerformed

    private void txtDataInJamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataInJamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataInJamActionPerformed

    private void txtDataFimJamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataFimJamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataFimJamActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        gj.setNomeGJ(txtNomeJam.getText());
        gj.setTemaGJ(txtTemaJam.getText());
        gj.setDuraGJ(txtDuraJam.getText());
        gj.setPremioGJ(txtPremioJam.getText());
        gj.setDescGJ(txtDescJam.getText());
        gj.setDataInGJ(txtDataInJam.getText());
        gj.setDataFimGJ(txtDataFimJam.getText());
        
        GameJamDAO dao = new GameJamDAO();
        dao.update(gj);
        
        limpar();
        preencherTabela();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        gj = new GameJam();
        gj.setNomeGJ(txtNomeJam.getText());
        gj.setTemaGJ(txtTemaJam.getText());
        gj.setDuraGJ(txtDuraJam.getText());
        gj.setPremioGJ(txtPremioJam.getText());
        gj.setDescGJ(txtDescJam.getText());
        gj.setDataInGJ(txtDataInJam.getText());
        gj.setDataFimGJ(txtDataFimJam.getText());
        
        // Invocar o método create da classe DAO
        GameJamDAO dao = new GameJamDAO();
        dao.create(gj);
        
        // Limpar os campos e preencher novamente a tabela
        limpar();
        preencherTabela();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        if (gj != null) {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esta GameJam?") == JOptionPane.YES_OPTION) {
                GameJamDAO dao = new GameJamDAO();
                dao.destroy(gj);

                limpar();
                preencherTabela();
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tblGameJamsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGameJamsMouseClicked
        // TODO add your handling code here:
        int linha = tblGameJams.getSelectedRow();
            String id = tblGameJams.getValueAt(linha, 0).toString();

            if(linha != -1) {
                GameJamDAO dao = new GameJamDAO();
                gj = dao.read(Integer.parseInt(id));

                txtNomeJam.setText(gj.getNomeGJ());
                txtTemaJam.setText(gj.getTemaGJ());
                txtDuraJam.setText(gj.getDuraGJ());
                txtPremioJam.setText(gj.getPremioGJ());
                txtDescJam.setText(gj.getDescGJ());
                txtDataInJam.setText(gj.getDataInGJ());
                txtDataFimJam.setText(gj.getDataFimGJ());
            }
    }//GEN-LAST:event_tblGameJamsMouseClicked
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tblGameJams;
    private javax.swing.JTextField txtDataFimJam;
    private javax.swing.JTextField txtDataInJam;
    private javax.swing.JTextPane txtDescJam;
    private javax.swing.JTextField txtDuraJam;
    private javax.swing.JTextField txtNomeJam;
    private javax.swing.JTextField txtPremioJam;
    private javax.swing.JTextField txtTemaJam;
    // End of variables declaration//GEN-END:variables
}
