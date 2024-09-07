package com.example.Enderecos;

import com.example.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InserirEnderecos {
    
    public static void main(String[] args) throws SQLException{
        
        
        Scanner scanner = new Scanner(System.in);
        
        List<Enderecos> enderecos= new ArrayList<>();
        
        while(true) {
            System.out.println("Inserir endereco, ou digite sair");
            String endereco = scanner.nextLine();
            if(endereco.equalsIgnoreCase("sair")){
                break;
            }

            System.out.println("Insira o id da pessoa pertencente ao endereco:");
            int id_pessoa = scanner.nextInt();
            scanner.nextLine();

            enderecos.add(new Enderecos(endereco, id_pessoa));
        }
        
        String sql = "INSERT INTO ENDERECOS (ENDERECO, PESSOA_ID) VALUES (?, ?)";
        Connection connection = FabricaConexao.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        for (Enderecos e: enderecos) {
            stmt.setString(1, e.getEndereco());
            stmt.setInt(2, e.getIdPessoas());
            stmt.executeUpdate();

        }

        System.out.println("Endereco Incluído!");

        stmt.close();
        connection.close();
        scanner.close();
    }
}
