import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
    
    public static void main(String[] args) throws SQLException{
        
        String stringConexao = "jdbc:sqlite:pessoasEnderecos.db";

        Connection connection = DriverManager.getConnection(stringConexao);

        System.out.println("Conexão efetuada com sucesso!");
        connection.close();
    }

}
