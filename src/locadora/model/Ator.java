/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.model;

import java.util.ArrayList;
import locadora.dao.AtorDAO;
import locadora.dao.ExceptionDAO;

/**
 *
 * @author Aluisio
 */
public class Ator {
    private Integer codAtor;
    private String name;
    private String nacionalidade;
    private ArrayList<Filme> filme = new ArrayList<Filme>();

    public Ator(){
    }

    public Ator(String name, String nacionalidade) {
        this.name = name;
        this.nacionalidade = nacionalidade;
    }

    public Integer getCodAtor() {
        return codAtor;
    }

    public String getName() {
        return name;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public ArrayList<Filme> getFilme() {
        return filme;
    }

    public void setCodAtor(Integer codAtor) {
        this.codAtor = codAtor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setFilme(ArrayList<Filme> filme) {
        this.filme = filme;
    }
    
    public void cadastrarAtor(Ator ator) throws ExceptionDAO{
        new AtorDAO().cadastrarAtor(ator);
    }    
    
    /*2º) RECEBE a lista de atores buscados/pesquisados no BD. RETORNA a instância do AtorDAO
    com a lista de atores para o CONTROLLER (Regras de Negócio): AtorController.java.*/
    public ArrayList<Ator> listaAtores(String nome) throws ExceptionDAO{
        return new AtorDAO().listarAtores(nome);
    }
    
    public void alterarAtor(Ator ator) throws ExceptionDAO{
        new AtorDAO().alterarAtor(ator);
    }
    
    public void excluirAtor(Ator ator) throws ExceptionDAO{
        new AtorDAO().excluirAtor(ator);
    }
}
