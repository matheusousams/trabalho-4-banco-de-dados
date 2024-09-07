package com.example.Pessoas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.FabricaConexao;

public class InserirPessoas {
    
    public static void main(String[] args) throws SQLException{
        
        
        Scanner scanner = new Scanner(System.in);
        
        List<Pessoa> pessoas= new ArrayList<>();
        
        System.out.println("Insir nome, ou digite sair");
        while(true) {
            String nome = scanner.nextLine();
            if(nome.equalsIgnoreCase("sair")){
                break;
            }
            pessoas.add(new Pessoa(nome));
        }
        
        String sql = "INSERT INTO PESSOAS (NOME) VALUES (?)";
        Connection connection = FabricaConexao.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        for (Pessoa pessoa: pessoas) {
            stmt.setString(1, pessoa.getNome());
            stmt.executeUpdate();

        }

        System.out.println("Pessoa Incluída!");

        stmt.close();
        connection.close();
        scanner.close();
    }
}
