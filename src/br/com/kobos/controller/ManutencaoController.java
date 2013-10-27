
package br.com.kobos.controller;

import br.com.kobos.model.persistencia.ManutencaoDAOImplements;
import br.com.kobos.model.persistencia.dao.ManutencaoDAO;
import br.com.kobos.modelo.Manutencao;
import java.util.List;

public class ManutencaoController {
    public int salvar(Manutencao m){
        ManutencaoDAO dao = new ManutencaoDAOImplements();
        return dao.salvar(m);
    }
    
    public List<Manutencao> listAll(){
        ManutencaoDAO dao = new ManutencaoDAOImplements();
        return dao.listAll();
    }
    
    public Manutencao listById(int id_manutencao){
        ManutencaoDAO dao = new ManutencaoDAOImplements();
        return dao.listById(id_manutencao);
    }
    
    public List<Manutencao> listByNome(String nome){
        ManutencaoDAO dao = new ManutencaoDAOImplements();
        return dao.ListByNome(nome);
    }
    
    public boolean remover(int id_manutencao){
        ManutencaoDAO dao = new ManutencaoDAOImplements();
        return dao.remove(id_manutencao);
    }
}
