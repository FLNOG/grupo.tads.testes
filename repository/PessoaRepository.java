package repository;

import model.Pessoa;
import util.ConnectionFactory;

import java.sql.*;

public class PessoaRepository {

    public void cadastraPesssoa(Pessoa pessoa) {
        String sql =  "INSERT INTO cadastro_pessoa (name, age) VALUES (?, ?)";

        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());

            int sucesso = stmt.executeUpdate();
            if (sucesso > 0) System.out.println("Sucesso ao cadastrar Pessoa");

            ConnectionFactory.closeConnection(connection);

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar Pessoa: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listarPessoa() {
        String sql = "SELECT * FROM cadastro_pessoa";

        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.println("=== Lista de Pessoas Cadastradas ===");

            boolean encontrou = false;
            while (rs.next()) {
                encontrou = true;
                int id = rs.getInt("id");
                String nome = rs.getString("name");
                int idade = rs.getInt("age");

                System.out.println("ID: " + id + " | Nome: " + nome + " | Idade: " + idade);
            }

            if (!encontrou) {
                System.out.println("Nenhuma pessoa encontrada no banco de dados.");
            }
            ConnectionFactory.closeConnection(connection);

        } catch (SQLException e) {
            System.err.println("Erro ao listar Pessoas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}