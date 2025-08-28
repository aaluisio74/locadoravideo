/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.model;

import java.util.ArrayList;

/**
 *
 * @author Aluisio
 */
public class Filme {
    private Integer codFilme;
    private String titulo;
    private String genero;
    private String sinopse;
    private Integer duracao;
    private ArrayList<Item> itens = new ArrayList<Item>();
    private ArrayList<Ator> atores = new ArrayList<Ator>();

}
