package com.example.Enderecos;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


import com.example.FabricaConexao;

public class TabelaEnderecos {
    public static void main(String[] args) throws SQLException{
        Connection connection = FabricaConexao.getConnection();

        String sql="CREATE TABLE IF NOT EXISTS ENDERECOS (ID INTEGER PRIMARY KEY AUTOINCREMENT, ENDERECO VARCHAR(50) NOT NULL, PESSOA_ID INTEGER, FOREIGN KEY (PESSOA_ID) REFERENCES PESSOAS(ID))";

        Statement stmt = connection.createStatement();
        stmt.execute(sql);

        System.out.println("Tabela Criada!");
        connection.close();
    }
}
