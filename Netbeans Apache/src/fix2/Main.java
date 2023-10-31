package fix2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Diego
 */
public class Main {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static void main(String[] args) throws SQLException {
        initializeDatabaseConnection();

        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> createRecordPeople();
                case 2 -> readRecordsPeople();
                case 3 -> updateRecordPeople();
                case 4 -> deleteRecordPeople();
                case 0 -> {
                    closeDatabaseConnection();
                    System.exit(0);
                }
                default -> System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    private static void initializeDatabaseConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/aula14";
            String user = "root";
            String password = "1234";
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.exit(1);
        }
    }

    //Menu
    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("-------Pessoas--------");
        System.out.println("1. Inserir pessoa");
        System.out.println("2. Ler registro de pessoas");
        System.out.println("3. Atualizar dados pessoa");
        System.out.println("4. Deletar registro de pessoa");
        System.out.println("0. Sair");
    }

    private static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escolha uma opcao: ");
        return scanner.nextInt();
    }

    //CRUD (Create, Read, Update, Delete)
    private static void createRecordPeople() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome");
        String nome = scanner.next();
        System.out.println("Digite a idade");
        int idade = scanner.nextInt();
        
        statement = connection.createStatement();
        
        statement.executeUpdate("INSERT INTO pessoas(nome, idade) VALUES ('" + nome + "','" + idade + "')",Statement.RETURN_GENERATED_KEYS);
    }

    private static void readRecordsPeople() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM pessoas");
        
        // Exibe informações sobre os autores
        while (resultSet.next()) {
            System.out.println("Nome: " + resultSet.getString("nome"));
            System.out.println("Idade: " + resultSet.getInt("idade"));
            System.out.println("_______________________________");
        }
    }

    private static void updateRecordPeople() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM pessoas");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome");
        String nome = scanner.next();
        System.out.println("Digite o codigo");
        int codigo = scanner.nextInt();
        
        int retorno;
        
        preparedStatement = connection.prepareStatement("UPDATE pessoas SET nome=? WHERE id=?");
        preparedStatement.setString(1, nome);
        preparedStatement.setInt(2, codigo);
        retorno = preparedStatement.executeUpdate();
        if (retorno > 0) {
            System.out.println("\nNovo registro alterado:" + codigo + " - " + nome);
        } else {
            System.out.println("Nao foi possivel alterar os registros!");
        }
    }

    private static void deleteRecordPeople() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM pessoas");
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o codigo que deseja excluir: ");
        int codigo = scanner.nextInt();
        
        int retorno;
        preparedStatement = connection.prepareStatement("DELETE FROM pessoas WHERE id=?");
        preparedStatement.setInt(1, codigo);
        retorno = preparedStatement.executeUpdate();
    }
    
    private static void closeDatabaseConnection() {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
        }
    }
}

