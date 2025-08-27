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
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
            e.printStackTrace();
        }
    }
}