package com.example.Pessoas;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.FabricaConexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultarPessoas {
    
    public static void main(String[] args) throws SQLException{
        Connection connection = FabricaConexao.getConnection();
        String sql = "SELECT * FROM PESSOAS";

        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery(sql);

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

    }
}
