
package br.com.kobos.app;

import br.com.kobos.view.JanelaLogin;

public class Principal {
    public static void mains(String[] args){
        JanelaLogin jl = new JanelaLogin();
        jl.setLocationRelativeTo(null);
        jl.setVisible(true);
    }
}
