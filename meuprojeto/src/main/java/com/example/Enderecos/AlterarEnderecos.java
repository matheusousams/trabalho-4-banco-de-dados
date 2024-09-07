package com.example.Enderecos;

import com.example.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarEnderecos {
    
    public static void main(String[] args) throws SQLException{
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserir id do endereco: ");
        int id = scanner.nextInt();

        String sql = "SELECT ID, NOME FROM ENDERECOS WHERE ID = ?";
        String update = "UPDATE ENDERECOS SET ENDERECO=? WHERE ID=?";
        Connection connection = FabricaConexao.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet r = stmt.executeQuery();

        if(r.next()){
            String enderecoAtual = r.getString("ENDERECO");
            System.out.println("Endereço atual: " + enderecoAtual);
            scanner.nextLine();

            System.out.println("Novo endereço: ");
            String enderecoNovo = scanner.nextLine();

            stmt.close();
            stmt = connection.prepareStatement(update);
            stmt.setString(1, enderecoNovo);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            System.out.println("Endereço alterado!");
        }

        connection.close();
        scanner.close();
    }
}
