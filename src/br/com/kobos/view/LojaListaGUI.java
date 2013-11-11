/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kobos.view;

import br.com.kobos.controller.LojaController;
import br.com.kobos.modelo.Loja;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pee
 */
public class LojaListaGUI extends javax.swing.JFrame {

    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();
    
    public LojaListaGUI() {
        initComponents();
        criaJTable();
        painelRolagem.setViewportView(tabela);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelFundo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txPesquisar = new javax.swing.JTextField();
        painelRolagem = new javax.swing.JScrollPane();
        btInserir = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de usuários");

        painelFundo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa de lojas", 2, 0));

        jLabel1.setText("Nome:");

        txPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPesquisarActionPerformed(evt);
            }
        });

        btInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/add.png"))); // NOI18N
        btInserir.setToolTipText("Inserir");
        btInserir.setContentAreaFilled(false);
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/edit.png"))); // NOI18N
        btAtualizar.setToolTipText("Editar");
        btAtualizar.setContentAreaFilled(false);
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/delete.png"))); // NOI18N
        btDeletar.setToolTipText("Deletar");
        btDeletar.setContentAreaFilled(false);
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelFundoLayout = new javax.swing.GroupLayout(painelFundo);
        painelFundo.setLayout(painelFundoLayout);
        painelFundoLayout.setHorizontalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFundoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                    .addComponent(painelRolagem)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFundoLayout.createSequentialGroup()
                        .addGap(0, 310, Short.MAX_VALUE)
                        .addComponent(btInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        painelFundoLayout.setVerticalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btInserir)
                        .addComponent(btAtualizar))
                    .addComponent(btDeletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelRolagem, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
        LojaInserirGUI li = new LojaInserirGUI(modelo);
        li.setLocationRelativeTo(null);
        li.setVisible(true);
        
    }//GEN-LAST:event_btInserirActionPerformed

    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
        int linhaSelecionada = -1;
        
        linhaSelecionada = tabela.getSelectedRow();
        
        if (linhaSelecionada >= 0){
            int id_loja = (int)tabela.getValueAt(linhaSelecionada, 0);
            
            LojaController lc = new LojaController();
            
            if (lc.remover(id_loja)){
                modelo.removeRow(linhaSelecionada);               
            }
        }else{
            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada.");
        }
    }//GEN-LAST:event_btDeletarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        int linhaSelecionada = -1;
        
        linhaSelecionada = tabela.getSelectedRow();
        
        if(linhaSelecionada >= 0){
            int id_loja = (int)tabela.getValueAt(linhaSelecionada, 0);
            LojaInserirGUI li = new LojaInserirGUI(modelo, linhaSelecionada, id_loja);
            li.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada.");
        }
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void txPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPesquisarActionPerformed
        String nome = txPesquisar.getText();
        LojaController lc = new LojaController();
        modelo.setNumRows(0);
        for(Loja l: lc.listByNome(nome)){
            modelo.addRow(new Object[]{l.getId_loja(), l.getNome(), l.getEndereco(), l.getEndereco(), l.getCep()});
        }
    }//GEN-LAST:event_txPesquisarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btInserir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel painelFundo;
    private javax.swing.JScrollPane painelRolagem;
    private javax.swing.JTextField txPesquisar;
    // End of variables declaration//GEN-END:variables

    private void criaJTable(){
        tabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Telefone");
        modelo.addColumn("Endereço");
        preencherJTable();
    }
    
    private void preencherJTable(){
        LojaController lc = new LojaController();
        for(Loja l: lc.ListAll()){
            modelo.addRow(new Object[]{l.getId_loja(), l.getNome(), l.getTelefone(), l.getEndereco()});
        }
    }
}
