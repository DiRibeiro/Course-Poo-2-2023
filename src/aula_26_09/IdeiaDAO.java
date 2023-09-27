package aula_26_09;

import java.sql.*;

public class IdeiaDAO {
    private Connection connection;
    private final String url = "jdbc:mysql://127.0.0.1:3306/ideia?useSSL=false";
    private final String usuario = "root";
    private final String senha = "1234";

    public IdeiaDAO() {
        try {
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    public void adicionarIdeia(Ideia ideia) {
        String sql = "INSERT INTO Ideia (titulo, descricao, urgencia) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, ideia.getTitulo());
            preparedStatement.setString(2, ideia.getDescricao());
            preparedStatement.setInt(3, ideia.getUrgencia());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    public Ideia obterIdeiaPorId(int id) {
        String sql = "SELECT * FROM Ideia WHERE id = ?";
        // System.out.println("SQL: " + sql);  // Imprime a consulta SQL

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet != null && resultSet.next()) {
                return new Ideia(
                        resultSet.getInt("id"),
                        resultSet.getString("titulo"),
                        resultSet.getString("descricao"),
                        resultSet.getInt("urgencia")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // System.out.println("Não foi possível recuperar a ideia.");  // Adiciona log de erro
        return null;
    }
    
    public void deletarIdeia(int id) {
        String sql = "DELETE FROM Ideia WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Ideia deletada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao deletar a ideia.");
        }
    }
}
