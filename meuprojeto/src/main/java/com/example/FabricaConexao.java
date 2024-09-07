package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    
    public static Connection getConnection() {

        try{
            String stringConexao = "jdbc:sqlite:pessoasEnderecos.db";

            return DriverManager.getConnection(stringConexao);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}