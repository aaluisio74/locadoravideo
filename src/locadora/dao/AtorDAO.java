/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import locadora.model.Ator;

/**
 *
 * @author Aluisio
 */
public class AtorDAO {
    
    public void cadastrarAtor(Ator ator) throws ExceptionDAO{
        String sql = "INSERT INTO ator (nome, nacionalidade) values (?,?)";
        PreparedStatement ps = null;
        Connection connection = null;
        
        try {
            
            connection = new ConnectionMVC().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, ator.getName());
            ps.setString(2, ator.getNacionalidade());
            ps.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao cadastrar Ator: " + e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
            }
            
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
    }
    /*1º) ACESSO ao BD pela classe de conexão para buscar os atores pesquisados pelo nome ou parte dele.
    RETORNA o resultado (lista de atores) desse método para o MODEL: Ator.java.*/
    public ArrayList<Ator> listarAtores(String nome) throws ExceptionDAO{
        String sql = "SELECT * FROM ator WHERE nome LIKE '%" + nome + "%' order by nome";
        
        Connection connection = null;
        PreparedStatement ps = null;
        ArrayList<Ator> atores = null;
        
        try {
            connection = new ConnectionMVC().getConnection();
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            
            if (rs!=null) {
                atores = new ArrayList<>();
                while (rs.next()) {
                    Ator ator = new Ator();
                    ator.setCodAtor(rs.getInt("codAtor"));
                    ator.setName(rs.getString("nome"));
                    ator.setNacionalidade(rs.getString("nacionalidade"));
                    atores.add(ator);                    
                }
            }            
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar atores: " + e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                throw new ExceptionDAO("Erro ao fechar o ps (Prepare Statement): " + e);
            }
            
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
        
        return atores;        
    }
    
    public void alterarAtor(Ator ator) throws ExceptionDAO{
        String sql = "UPDATE ator SET nome = ?, nacionalidade = ? WHERE codAtor = ?";
        PreparedStatement ps = null;
        Connection connection = null;
        
        try {
            
            connection = new ConnectionMVC().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, ator.getName());
            ps.setString(2, ator.getNacionalidade());
            ps.setInt(3, ator.getCodAtor());
            ps.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao alterar Ator: " + e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
            }
            
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
    }
    
    public void excluirAtor(Ator ator) throws ExceptionDAO{
        String sql = "DELETE FROM ator WHERE codAtor = ?";
        PreparedStatement ps = null;
        Connection connection = null;
        
        try {
            
            connection = new ConnectionMVC().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, ator.getCodAtor());
            ps.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao apagar Ator: " + e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
            }
            
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
    }
}
