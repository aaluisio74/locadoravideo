/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.controller;

import java.util.ArrayList;
import locadora.dao.ExceptionDAO;
import locadora.model.Ator;

/**
 *
 * @author Aluisio
 */
public class AtorController {
    
    public boolean cadastrarAtor(String nome, String nacionalidade) throws ExceptionDAO{
        if (nome != null && nome.length()>0 && nacionalidade != null && nacionalidade.length()>0) {
            Ator ator = new Ator(nome, nacionalidade);
            ator.cadastrarAtor(ator);
            return true;
        }
        return false;
    }
    
    /*3º) RECEBE a lista de atores buscados/pesquisados no BD pelo DAO/Classe de Conexão.
    RETORNA a Instância do Ator (MODEL) com a lista de atores para o CONTROLLER (Regras
    de Negócio): AtorController.java.*/
    public ArrayList<Ator> listarAtores(String nome) throws ExceptionDAO{
        return new Ator().listaAtores(nome);
    }
    
    public boolean alterarAtor(int codAtor, String nome, String nacionalidade) throws ExceptionDAO{
        if (nome != null && nome.length() > 0 && nacionalidade != null && nacionalidade.length() > 0) {
            Ator ator = new Ator(nome, nacionalidade);
            ator.setCodAtor(codAtor);
            ator.alterarAtor(ator);
            return true;
        }
        return false;
    }
    
    public boolean excluirAtor(int codAtor) throws ExceptionDAO{
        if (codAtor == 0)
            return false;
        else {
            Ator ator = new Ator();
            ator.setCodAtor(codAtor);
            ator.excluirAtor(ator);                                
            return true;
        }
    }
}
