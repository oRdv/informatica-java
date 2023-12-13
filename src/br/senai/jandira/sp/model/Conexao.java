package br.senai.jandira.sp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    String banco, servidor,senha, usuario;
    public Connection conexao;
    public Conexao(){
       this.servidor = "localhost";
       this.banco =  "banco_pizzaria";
       this.usuario = "root";
       this.senha = "bcd127";
    }

    public void connectionDiver() {
        try {
            this.conexao = DriverManager.getConnection("jdbc:mysql://" + this.servidor + "/" + this.banco, this.usuario, this.senha);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Connection getConnection() {
        connectionDiver();
        return conexao;
    }
}
