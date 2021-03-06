/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kobos.view;

import br.com.kobos.controller.UsuarioController;
import br.com.kobos.modelo.Usuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guest01
 */
public class UsuarioInserirGUI extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private int linhaSelecionada;
    /**
     * Creates new form AutorInserirGUI
     */
    public UsuarioInserirGUI(DefaultTableModel modelo) {
        this.modelo = modelo;
        initComponents();
    }
    
    public UsuarioInserirGUI(DefaultTableModel modelo, int linhaSelecionada, int id_usuario){
        this.modelo = modelo;
        this.linhaSelecionada = linhaSelecionada;
        initComponents();
        
        UsuarioController uc = new UsuarioController();
        Usuario u = uc.ListById(id_usuario);
        txCodigo.setText(Integer.toString(u.getId_usuario()));
        txNome.setText(u.getNome_us());
        txUsuario.setText(u.getUsuario_us());
        txSenha.setText(u.getSenha_us());
        cbNivelAcesso.setSelectedItem(u.getNivelAcesso_us());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txCodigo = new javax.swing.JTextField();
        txNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btLimpar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txSenha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbNivelAcesso = new javax.swing.JComboBox();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de usuários");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de usuários", 2, 1, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setText("Código:");

        txCodigo.setEditable(false);
        txCodigo.setBackground(new java.awt.Color(204, 204, 204));
        txCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCodigoActionPerformed(evt);
            }
        });

        txNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomeActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        txUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txUsuarioActionPerformed(evt);
            }
        });

        jLabel4.setText("Usuário");

        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/limpar.png"))); // NOI18N
        btLimpar.setToolTipText("Limpar");
        btLimpar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btLimpar.setBorderPainted(false);
        btLimpar.setContentAreaFilled(false);
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/3.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.setBorderPainted(false);
        btSalvar.setContentAreaFilled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        jLabel5.setText("Senha");

        txSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSenhaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nível de Acesso");

        cbNivelAcesso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Diretor", "Funcionário", "Gerente", " " }));
        cbNivelAcesso.setSelectedIndex(2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbNivelAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btSalvar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txNome)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18)
                        .addComponent(btLimpar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbNivelAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSalvar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btLimpar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCodigoActionPerformed

    private void txNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNomeActionPerformed

    private void txUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txUsuarioActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        txCodigo.setText("");
        txNome.setText("");
        txUsuario.setText("");
        txSenha.setText("");
        cbNivelAcesso.setSelectedIndex(2);
    }//GEN-LAST:event_btLimparActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        Usuario u = new Usuario();
        if (!(txCodigo.getText().equals("")) || (txCodigo.getText().equals(null))){
            u.setId_usuario(Integer.parseInt(txCodigo.getText()));
        }
        
        if (txNome.getText().equals("") || txNome.getText().equals(null)){
            JOptionPane.showMessageDialog(null,"Informe um nome antes de salvar!");
            //btSalvarActionPerformed();
        }
        
        u.setNome_us(txNome.getText());
        u.setSenha_us(txSenha.getText());
        u.setUsuario_us(txUsuario.getText());
        u.setNivelAcesso_us(cbNivelAcesso.getSelectedItem().toString());
        
        UsuarioController uc = new UsuarioController();
        if (u.getId_usuario()== 0){
            int id = uc.salvar(u);
            if(id > 0){
                modelo.addRow(new Object[]{id, u.getNome_us(), u.getUsuario_us(), u.getSenha_us(), u.getNivelAcesso_us()});
                JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso!");
            }
        }else{
                int id = uc.salvar(u);
                if(id > 0){
                    modelo.removeRow(linhaSelecionada);
                    modelo.addRow(new Object[]{id, u.getNome_us(), u.getUsuario_us(), u.getSenha_us(), u.getNivelAcesso_us()});
                    JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
            }
        }
        dispose();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void txSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSenhaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbNivelAcesso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txCodigo;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txSenha;
    private javax.swing.JTextField txUsuario;
    // End of variables declaration//GEN-END:variables
}
