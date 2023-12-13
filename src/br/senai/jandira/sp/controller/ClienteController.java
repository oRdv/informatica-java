package br.senai.jandira.sp.controller;

import br.senai.jandira.sp.model.Cliente;
import br.senai.jandira.sp.model.Conexao;
import br.senai.jandira.sp.model.Usuario;

import javax.swing.undo.UndoableEditSupport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    Conexao conexao = new Conexao();
    Connection connection = conexao.getConnection();
    public void listaClientes() throws SQLException {
        Statement statement = connection.createStatement();

        String queryList = "SELECT * FROM usuario";

        ResultSet resultSet = statement.executeQuery(queryList);

        Usuario usuario = new Usuario();

        while (resultSet.next()) {
            usuario.setId_usuarios(resultSet.getInt("ID"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setTelefone(resultSet.getLong("telefone"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setEndereco(resultSet.getString("endereco"));

            System.out.println(usuario.getIdCliente());
            System.out.println(usuario.getNome());
            System.out.println(usuario.getTelefone());
            System.out.println(usuario.getEmail());
            System.out.println(usuario.getEndereco());

            System.out.println("-----------------------");
        }
    }
    public void consultarCliente(String nome) throws SQLException {
        Statement statement = connection.createStatement();

        String queryConsulta = "SELECT * FROM usuario WHERE usuario.nome = " + nome + ";";
        ResultSet resultSet = statement.executeQuery(queryConsulta);

        List<Usuario> listConsultaUsuario = new ArrayList<>();

        while (resultSet.next()){
            Usuario usuario = new Usuario();

            usuario.setId_usuarios(resultSet.getInt("ID"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setTelefone(resultSet.getLong("telefone"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setEndereco(resultSet.getString("endereco"));
            listConsultaUsuario.add(usuario);

        }

        for (Usuario usuario : listConsultaUsuario){
            System.out.println(usuario.getIdCliente());
            System.out.println(usuario.getNome());
            System.out.println(usuario.getTelefone());
            System.out.println(usuario.getEmail());
            System.out.println(usuario.getEndereco());
            System.out.println("-----------------------");

        }
    }
    public void cadastrarUsuario(Usuario usuario) throws SQLException {

        Statement statement = connection.createStatement();

        String queryCadastro = "INSERT INTO usuario (nome, telefone, email, endereco) values (" +
                usuario.getIdCliente() + ",'" + usuario.getNome() + "','" + usuario.getTelefone() + "'," + usuario.getEmail() + "'," + usuario.getEndereco() + ")";

        statement.executeUpdate(queryCadastro);

        System.out.println("Usuario: " + usuario.getNome() + " Cadastrado com sucesso!");

    }

}
