/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kobos.view;

import br.com.kobos.controller.UsuarioController;
import javax.swing.JOptionPane;

/**
 *
 * @author guest01
 */
public class TelaLoginGUI extends javax.swing.JFrame {

    /**
     * Creates new form TelaLoginGUI
     */
    public TelaLoginGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Validação de usuário");
        setMaximumSize(new java.awt.Dimension(395, 238));
        setMinimumSize(new java.awt.Dimension(395, 238));
        getContentPane().setLayout(null);

        jLabel2.setText("Usuário:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 40, 50, 14);
        getContentPane().add(txUsuario);
        txUsuario.setBounds(110, 60, 200, 20);

        jLabel3.setText("Senha:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(110, 90, 50, 14);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/okapplyicon.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(260, 140, 40, 30);
        getContentPane().add(txSenha);
        txSenha.setBounds(110, 110, 200, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensBg/telaLogin.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 394, 200);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        validaUsuario();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txSenha;
    private javax.swing.JTextField txUsuario;
    // End of variables declaration//GEN-END:variables

    public void validaUsuario() {
        UsuarioController uc = new UsuarioController();
        JanelaPrincipal jp = new JanelaPrincipal();

        String login = txUsuario.getText();
        String senha = txSenha.getText();
        if (txSenha.getText().equals("") || txUsuario.getText().equals("")) {
           JOptionPane.showMessageDialog(null, "Todos os campos precisam ser preenchidos!");
        } else {


            boolean resposta = uc.ValidaUsuario(login, senha);

            if (resposta == true) {
                jp.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.");
            }
        }
    }
}