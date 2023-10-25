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
                    createRecord();
                    break;
                case 2:
                    readRecords();
                    break;
                case 3:
                    updateRecord();
                    break;
                case 4:
                    deleteRecord();
                    break;
                case 5:
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
        System.out.println("1. Inserir registro");
        System.out.println("2. Ler registros");
        System.out.println("3. Atualizar registro");
        System.out.println("4. Deletar registro");
        System.out.println("5. Sair");
    }

    private static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escolha uma opcao: ");
        return scanner.nextInt();
    }

    //CRUD (Create, Read, Update, Delete)
    private static void createRecord() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome do autor");
        String nome = scanner.next();
        System.out.println("Digite o sobrenome do autor");
        String sobrenome = scanner.next();
        
        statement = connection.createStatement();
        
        statement.executeUpdate("INSERT INTO authors(firstName, lastName) VALUES ('Autor " + nome + "','Sobrenome " + sobrenome + "')",Statement.RETURN_GENERATED_KEYS);
    }

    private static void readRecords() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM aula12.authors");
        
        // Exibe informações sobre os autores
        while (resultSet.next()) {
            System.out.println("Codigo do autor: " + resultSet.getInt("authorId"));
            System.out.println("Nome do autor: " + resultSet.getString("firstName"));
            System.out.println("Sobrenome do autor: " + resultSet.getString("lastName"));
            System.out.println("_______________________________");
        }
    }

    private static void updateRecord() {
    }

    private static void deleteRecord() {
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

//            Connection connection;
//            String user = "root";
//            String pwd = "1234";
//            String url = "jdbc:mysql://127.0.0.1:3306/aula12"; //?useSSL=true
//            Statement stmt;
//            PreparedStatement rs;
//            
//            Scanner keyboard = new Scanner(System.in);
//
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                connection = DriverManager.getConnection(url, user, pwd);   
//                stmt = connection.createStatement();
//                //1. Inclua mais 4 autores na tabela Authors.
            // Executa quatro vezes para inserir quatro registros de autores
//            for (int i = 0; i < 4; i++) {
//                int rowCount = stmt.executeUpdate(
//                        "INSERT INTO authors(firstName, lastName) VALUES ('Autor" + (i + 1) + "','Sobrenome" + (i + 1) + "')",
//                        Statement.RETURN_GENERATED_KEYS);
//
//                if (rowCount > 0) {
//                    rs = stmt.getGeneratedKeys();
//
//                    while (rs.next()) {
//                        // Exibe informações sobre o novo registro
//                        System.out.println("Novo registro realizado no código: " + rs.getInt(1));
//                    }
//                }
//            }

            //2. Imprima todos os autores na tela
            // Executa uma consulta SQL SELECT para obter os registros da tabela "authors"
//            rs = stmt.executeQuery("SELECT * FROM authors");
//
//            // Exibe informações sobre os autores
//            while (rs.next()) {
//                System.out.println("Código do autor: " + rs.getInt("authorsID"));
//                System.out.println("Nome do autor: " + rs.getString("firstName"));
//                System.out.println("Sobrenome do autor: " + rs.getString("lastName"));
//                System.out.println("_______________________________");
//            }

            //3. Crie a tabela Title com suas colunas.
//            String createTableQuery = "CREATE TABLE titles ("
//                    + "ISBN int not null,"
//                    + "title varchar(255),"
//                    + "editionNumber int not null,"
//                    + "copyright varchar(255)"
//                    + ")";
//            stmt.executeUpdate(createTableQuery);
//            
//            System.out.println("Tabela 'titles' criada com sucesso.");

            //4. Faça a inserção de 10 livros por meio de código no Java.
//            for (int i = 0; i < 10; i++) {
//                int isbn = (i + 1);
//                String title = "title " + (i + 1);
//                int editionNumber = i + 1;
//                String copyright = "copyright " + (i + 1);
//
//                String insert = "INSERT INTO titles(ISBN, title, editionNumber, copyright)"
//                        + "VALUES ('" + isbn + "','" + title + "', " + editionNumber + ", '" + copyright + "')";
//                stmt.executeUpdate(insert);
//            }
//            
//            //5. Imprima todos os livros na tela.           
//            rs = stmt.executeQuery("SELECT * FROM titles");
//
//            // Exibe informações sobre os livros
//            while (rs.next()) {
//                System.out.println("Codigo ISBN: " + rs.getInt("ISBN"));
//                System.out.println("Titulo: " + rs.getString("title"));
//                System.out.println("Edicao: " + rs.getInt("editionNumber"));
//                System.out.println("Copyright: " + rs.getString("copyright"));
//                System.out.println("_______________________________");
//            }
//                //ALTERAR
//                System.out.println("Digite o nome");
//                String nome = keyboard.next();
//                System.out.println("Digite o codigo");
//                int codigo = keyboard.nextInt();
//
//                int retorno;
//                //retorno = stmt.executeUpdate("UPDATE authors SET firstName='"+nome+" " + "' WHERE authorId="+codigo);
//                rs = connection.prepareStatement("UPDATE aula12.authors SET firstName=? WHERE authorId=?");     
//                rs.setString(1, nome);
//                rs.setInt(2, codigo);
//                retorno = rs.executeUpdate();
//                if (retorno > 0){
//                    System.out.println("\nNovo registro alterado:" + codigo + " - " + nome);
//                }
//                else{
//                    System.out.println("Nao foi possível alterar os registros!");
//                }
//
//                //DELETAR
//                System.out.println("Digite o codigo que deseja excluir: ");
//                codigo = keyboard.nextInt();
//
//                //retorno = stmt.executeUpdate("DELETE FROM authors WHERE authorId=" +codigo);
//                rs = connection.prepareStatement("DELETE FROM authors WHERE authorId=?");
//                rs.setInt(1, codigo);
//                retorno = rs.executeUpdate();
//            }
//            catch (ClassNotFoundException e) {
//                System.err.println("MySQL JDBC driver not found. Make sure the MySQL Connector/J JAR is in your classpath.");
//            } 
//            catch (SQLException ex) {
//                System.err.println("SQLException: " + ex.getMessage());
//                System.err.println("SQLState: " + ex.getSQLState());
//                System.err.println("VendorError: " + ex.getErrorCode());
//            }
//
