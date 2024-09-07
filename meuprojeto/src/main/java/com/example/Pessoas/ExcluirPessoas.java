package com.example.Pessoas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.example.FabricaConexao;

public class ExcluirPessoas {
    
    public static void main(String[] args) throws SQLException{
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserir id: ");
        int id =scanner.nextInt();

        Connection connection = FabricaConexao.getConnection();
        String sql="DELETE FROM PESSOAS WHERE ID=?";

        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, id);

        int cont=stmt.executeUpdate();

        if(cont>0){
            System.out.println("Pessoa excluida!");
        }

        System.out.println("Linhas excluidas: " +cont);
        connection.close();
        scanner.close();
    }
}
