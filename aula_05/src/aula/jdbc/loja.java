//ATIVIDADE JDBC 30/08/23
package aula.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class loja{
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432";
        String user = "postgres";
        String password = "senhapgadmin";

        String createDatabaseSQL = "CREATE DATABASE Loja";

        String createTableSQL = "CREATE TABLE IF NOT EXISTS Produto (codProduto SERIAL PRIMARY KEY, produto VARCHAR(50))";

        // Inserindo na tabela produto
        String insertDataSQL1 = "INSERT INTO Produto (produto) VALUES ('Arroz')";
        String insertDataSQL2 = "INSERT INTO Produto (produto) VALUES ('Feijão')";
        String insertDataSQL3 = "INSERT INTO Produto (produto) VALUES ('Macarrão')";

        try {
            // Conectar ao Postgree
            Connection connection = DriverManager.getConnection(url, user, password);

            // Criando o base de dados "Loja"
            Statement statement = connection.createStatement();
            statement.executeUpdate(createDatabaseSQL);
            statement.close();

            // Conectando ao banco de dados "Loja"
            String urlLoja = "jdbc:postgresql://localhost:5432/Loja";
            Connection connectionLoja = DriverManager.getConnection(urlLoja, user, password);

            // Criando a tabela "Produto"
            Statement statementLoja = connectionLoja.createStatement();
            statementLoja.executeUpdate(createTableSQL);

            // Inserindo dados na tabela Produto
            statementLoja.executeUpdate(insertDataSQL1);
            statementLoja.executeUpdate(insertDataSQL2);
            statementLoja.executeUpdate(insertDataSQL3);

            // Fechando as conexões
            statementLoja.close();
            connectionLoja.close();
            connection.close();

            System.out.println("Banco de dados e tabela criados com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

