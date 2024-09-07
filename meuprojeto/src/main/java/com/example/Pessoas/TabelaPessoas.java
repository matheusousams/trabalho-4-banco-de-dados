package com.example.Pessoas;

import java.sql.Statement;

import com.example.FabricaConexao;

import java.sql.Connection;
import java.sql.SQLException;

public class TabelaPessoas {
    
    public static void main(String[] args) throws SQLException{
        Connection connection = FabricaConexao.getConnection();

        String sql="CREATE TABLE IF NOT EXISTS PESSOAS (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOME VARCHAR(50) NOT NULL)";

        Statement stmt = connection.createStatement();
        stmt.execute(sql);

        System.out.println("Tabela Criada!");
        connection.close();
    }
}
