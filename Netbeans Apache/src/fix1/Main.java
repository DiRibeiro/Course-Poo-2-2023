package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
                case 1:
                    createRecordAuthor();
                    break;
                case 2:
                    readRecordsAuthor();
                    break;
                case 3:
                    updateRecordAuthor();
                    break;
                case 4:
                    deleteRecordAuthor();
                    break;
                case 5:
                    createRecordTitle();
                    break;
                case 6:
                    readRecordsTitle();
                    break;
                case 7:
                    updateRecordTitle();
                    break;
                case 8:
                    deleteRecordTitle();
                    break;
                case 0:
                    closeDatabaseConnection();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    private static void initializeDatabaseConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/aula12";
            String user = "root";
            String password = "1234";
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    //Menu
    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("-------Autores--------");
        System.out.println("1. Inserir registro");
        System.out.println("2. Ler registros");
        System.out.println("3. Atualizar registro");
        System.out.println("4. Deletar registro");
        System.out.println("-------Livros--------");
        System.out.println("5. Inserir novo livro");
        System.out.println("6. Listar livros");
        System.out.println("7. Atualizar livros");
        System.out.println("8. Deletar livros");
        System.out.println("0. Sair");
    }

    private static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escolha uma opcao: ");
        return scanner.nextInt();
    }

    //CRUD (Create, Read, Update, Delete)
    private static void createRecordAuthor() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome do autor");
        String nome = scanner.next();
        System.out.println("Digite o sobrenome do autor");
        String sobrenome = scanner.next();
        
        statement = connection.createStatement();
        
        statement.executeUpdate("INSERT INTO authors(firstName, lastName) VALUES ('Autor " + nome + "','Sobrenome " + sobrenome + "')",Statement.RETURN_GENERATED_KEYS);
    }
    
    private static void createRecordTitle() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome do livro");
        String titulo = scanner.next();
        System.out.println("Digite a edicao");
        int numeroEdicao = scanner.nextInt();
        System.out.println("Digite copyright");
        String copyright = scanner.next();
        
        int retorno;
        
        preparedStatement = connection.prepareStatement("INSERT INTO titles(title, editionNumber, copyright) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, titulo);
        preparedStatement.setInt(2, numeroEdicao);
        preparedStatement.setString(3, copyright);
        
        retorno = preparedStatement.executeUpdate();
        if (retorno > 0) {
            System.out.println("\nNovo registro realizado:" + titulo + " - " + numeroEdicao + " - " + copyright);
        } else {
            System.out.println("Nao foi possivel criar um novo registro!");
        }
    }

    private static void readRecordsAuthor() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM authors");
        
        // Exibe informações sobre os autores
        while (resultSet.next()) {
            System.out.println("Codigo do autor: " + resultSet.getInt("authorsID"));
            System.out.println("Nome do autor: " + resultSet.getString("firstName"));
            System.out.println("Sobrenome do autor: " + resultSet.getString("lastName"));
            System.out.println("_______________________________");
        }
    }
    
    private static void readRecordsTitle() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM titles");
        
        // Exibe informações sobre os autores
        while (resultSet.next()) {
            System.out.println("ISBN: " + resultSet.getInt("ISBN"));
            System.out.println("Titulo: " + resultSet.getString("title"));
            System.out.println("Numero de edicao: " + resultSet.getInt("editionNumber"));
            System.out.println("Copyright: " + resultSet.getString("copyright"));
            System.out.println("_______________________________");
        }
    }

    private static void updateRecordAuthor() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM authors");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do autor");
        String nome = scanner.next();
        System.out.println("Digite o codigo do autor");
        int codigo = scanner.nextInt();
        
        int retorno;
        
        preparedStatement = connection.prepareStatement("UPDATE authors SET firstName=? WHERE authorsID=?");
        preparedStatement.setString(1, nome);
        preparedStatement.setInt(2, codigo);
        retorno = preparedStatement.executeUpdate();
        if (retorno > 0) {
            System.out.println("\nNovo registro alterado:" + codigo + " - " + nome);
        } else {
            System.out.println("Nao foi possivel alterar os registros!");
        }
    }
    
    private static void updateRecordTitle() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM titles");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do livro: ");
        String nome = scanner.next();
        System.out.println("Digite o codigo: ");
        int codigo = scanner.nextInt();
        System.out.println("Digite o número da edição: ");
        int edicao = scanner.nextInt();
        System.out.println("Digite a editora do livro: ");
        String editora = scanner.next();
        
        int retorno;
        
        preparedStatement = connection.prepareStatement("UPDATE titles SET title=?, editionNumber=?, copyright=? WHERE ISBN=?");
        preparedStatement.setString(1, nome);
        preparedStatement.setInt(2, codigo);
        preparedStatement.setInt(3, edicao);
        preparedStatement.setString(4, editora);
        retorno = preparedStatement.executeUpdate();
        if (retorno > 0) {
            System.out.println("\nNovo registro alterado:" + codigo + " - " + nome);
        } else {
            System.out.println("Nao foi possivel alterar os registros!");
        }
    }

    private static void deleteRecordAuthor() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM authors");
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o codigo que deseja excluir: ");
        int codigo = scanner.nextInt();
        
        int retorno;
        preparedStatement = connection.prepareStatement("DELETE FROM authors WHERE authorsID=?");
        preparedStatement.setInt(1, codigo);
        retorno = preparedStatement.executeUpdate();
    }
    
    private static void deleteRecordTitle() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM titles");
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o codigo que deseja excluir: ");
        int codigo = scanner.nextInt();
        
        int retorno;
        preparedStatement = connection.prepareStatement("DELETE FROM titles WHERE ISBN=?");
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
            e.printStackTrace();
        }
    }
}
