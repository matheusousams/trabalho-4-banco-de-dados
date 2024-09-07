package com.example.Pessoas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.example.FabricaConexao;

public class AlterarPessoas {
    
    public static void main(String[] args) throws SQLException{
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserir id da pessoa: ");
        int id = scanner.nextInt();

        String sql = "SELECT ID, NOME FROM PESSOAS WHERE ID = ?";
        String update = "UPDATE PESSOAS SET NOME=? WHERE ID=?";
        Connection connection = FabricaConexao.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet r = stmt.executeQuery();

        if(r.next()){
            Pessoa p = new Pessoa(r.getInt(1),r.getString(2));
            System.out.println("Nome atual: " + p.getNome());
            scanner.nextLine();

            System.out.println("Novo nome: ");
            String nomeNovo= scanner.nextLine();

            stmt.close();
            stmt=connection.prepareStatement(update);
            stmt.setString(1, nomeNovo);
            stmt.setInt(2, id);
            stmt.execute();

            System.out.println("Pessoa alterada!");
        }

        connection.close();
        scanner.close();
    }
}
