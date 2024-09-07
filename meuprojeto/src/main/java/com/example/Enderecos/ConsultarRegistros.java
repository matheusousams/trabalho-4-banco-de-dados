package com.example.Enderecos;

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
        String sql = "SELECT * FROM ENDERECOS WHERE endereco LIKE ?";

        String entrada = scanner.nextLine();

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, "%" + entrada+ "%");
        ResultSet result= stmt.executeQuery();

        List<Enderecos> endereco = new ArrayList<>();

        while(result.next()) {
            int id = result.getInt("id");
            String enderecos = result.getString("endereco");
            int id_pessoas=result.getInt("pessoa_id");
            endereco.add(new Enderecos(id, enderecos, id_pessoas));
        }

        for(Enderecos e: endereco){
            System.out.println(e.getId()+"->"+e.getEndereco());
        }

        stmt.close();
        connection.close();
        scanner.close();

    }
}
