package com.example.Enderecos;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.FabricaConexao;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

public class ConsultarEnderecos {
    
    public static void main(String[] args) throws SQLException{
        Connection connection = FabricaConexao.getConnection();
        String sql = "SELECT * FROM ENDERECOS";

        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery(sql);

        List<Enderecos> enderecos = new ArrayList<>();

        while(result.next()) {
            int id = result.getInt("id");
            String endereco = result.getString("endereco");
            int id_pessoas=result.getInt("id_pessoas");
            enderecos.add(new Enderecos(id, endereco, id_pessoas));
        }

        for(Enderecos e: enderecos){
            System.out.println(e.getId()+"->"+e.getEndereco() + "(Pessoa id: )" + e.getIdPessoas()+")");
        }

        stmt.close();
        connection.close();

    }
}
