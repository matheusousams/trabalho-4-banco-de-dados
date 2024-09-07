package com.example.Enderecos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.example.FabricaConexao;

public class ExcluirEnderecos {
    
     public static void main(String[] args) throws SQLException{
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserir id: ");
        int id =scanner.nextInt();

        Connection connection = FabricaConexao.getConnection();
        String sql="DELETE FROM ENDERECOS WHERE ID=?";

        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, id);

        int cont=stmt.executeUpdate();

        if(cont>0){
            System.out.println("Endereco excluido!");
        }

        System.out.println("Linhas excluidas: " +cont);
        connection.close();
        scanner.close();
    }
}
