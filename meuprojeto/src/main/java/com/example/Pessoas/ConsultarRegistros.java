package com.example.Pessoas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.SQLException;


import com.example.FabricaConexao;

public class ConsultarRegistros {
    public static void main(String[] args) throws SQLException{

        Scanner scanner = new Scanner(System.in);

        Connection connection = FabricaConexao.getConnection();
        String sql = "SELECT * FROM PESSOAS WHERE NOME LIKE ?";

        String entrada = scanner.nextLine();

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, "%" + entrada+ "%");
        ResultSet result= stmt.executeQuery();

        List<Pessoa> pessoas = new ArrayList<>();

        while(result.next()) {
            int id = result.getInt("id");
            String nome = result.getString("nome");
            pessoas.add(new Pessoa(id, nome));
        }

        for(Pessoa p: pessoas){
            System.out.println(p.getId()+"->"+p.getNome());
        }

        stmt.close();
        connection.close();
        scanner.close();

    }
}
