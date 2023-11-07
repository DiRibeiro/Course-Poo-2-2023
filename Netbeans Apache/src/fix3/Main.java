package fix3;

import java.util.Scanner;

public class Main {

    // Menu
    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("-------Autores--------");
        System.out.println("1. Inserir autor");
        System.out.println("2. Ler registro de autor");
        System.out.println("3. Atualizar dados autor");
        System.out.println("4. Deletar registro de autor");
        System.out.println("-------Livros--------");
        System.out.println("5. Inserir Livro");
        System.out.println("6. Ler registro de livro");
        System.out.println("7. Atualizar dados livro");
        System.out.println("8. Deletar registro de livro");
        System.out.println("0. Sair");
    }

    private static int getUserChoice(Scanner scanner) {
        System.out.print("Escolha uma opcao: ");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        AuthorDAO authorDAO = new AuthorDAO();
        TitlesDAO titleDAO = new TitlesDAO();

        while (true) {
            displayMenu();
            int option = getUserChoice(keyboard);

            switch (option) {
                case 1:
                    Author newAuthor = new Author();
                    System.out.println("Digite o nome: ");
                    newAuthor.setFirstName(keyboard.next());
                    System.out.println("Digite o sobrenome: ");
                    newAuthor.setLastName(keyboard.next());
                    int insertResult = authorDAO.insert(newAuthor);
                    if (insertResult > 0) {
                        System.out.println("Autor inserido com sucesso.");
                    } else {
                        System.out.println("Falha ao inserir autor.");
                    }
                    break;
                case 2:
                    System.out.println("Digite o ID do autor a ser lido: ");
                    int authorIdToRead = getUserChoice(keyboard);
                    Author readAuthor = authorDAO.read(authorIdToRead);
                    if (readAuthor != null) {
                        System.out.println("Autor encontrado: " + readAuthor.getFirstName() + " " + readAuthor.getLastName());
                    } else {
                        System.out.println("Autor não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Digite o ID do autor a ser atualizado: ");
                    int authorIdToUpdate = getUserChoice(keyboard);
                    Author updatedAuthor = authorDAO.read(authorIdToUpdate);
                    if (updatedAuthor != null) {
                        System.out.println("Digite o novo nome: ");
                        updatedAuthor.setFirstName(keyboard.next());
                        System.out.println("Digite o novo sobrenome: ");
                        updatedAuthor.setLastName(keyboard.next());
                        int updateResult = authorDAO.update(updatedAuthor);
                        if (updateResult > 0) {
                            System.out.println("Autor atualizado com sucesso.");
                        } else {
                            System.out.println("Falha ao atualizar autor.");
                        }
                    } else {
                        System.out.println("Autor não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o ID do autor a ser deletado: ");
                    int authorIdToDelete = getUserChoice(keyboard);
                    int deleteResult = authorDAO.delete(authorIdToDelete);
                    if (deleteResult > 0) {
                        System.out.println("Autor deletado com sucesso.");
                    } else {
                        System.out.println("Falha ao deletar autor.");
                    }
                    break;
                case 5:
                    Titles newTitles = new Titles();
                    System.out.println("Digite o nome: ");
                    newTitles.setTitle(keyboard.next());
                    System.out.println("Digite a edicao: ");
                    newTitles.setEditionNumber(keyboard.nextInt());
                    int insertResult = titleDAO.insertTitles(newTitles);
                    if (insertResult > 0) {
                        System.out.println("Titulo inserido com sucesso.");
                    } else {
                        System.out.println("Falha ao inserir titulo.");
                    }
                    break;
                case 6:
                    System.out.println("Digite o ID do autor a ser lido: ");
                    int authorIdToRead = getUserChoice(keyboard);
                    Titles readTitles = authorDAO.read(authorIdToRead);
                    if (readAuthor != null) {
                        System.out.println("Autor encontrado: " + readTitles.getFirstName() + " " + readTitles.getLastName());
                    } else {
                        System.out.println("Autor não encontrado.");
                    }
                    break;
                case 7:
                    System.out.println("Digite o ID do autor a ser atualizado: ");
                    int authorIdToUpdate = getUserChoice(keyboard);
                    Titles updatedTitles = authorDAO.read(authorIdToUpdate);
                    if (updatedAuthor != null) {
                        System.out.println("Digite o novo nome: ");
                        updatedTitles.setFirstName(keyboard.next());
                        System.out.println("Digite o novo sobrenome: ");
                        updatedTitles.setLastName(keyboard.next());
                        int updateResult = authorDAO.update(updatedTitles);
                        if (updateResult > 0) {
                            System.out.println("Autor atualizado com sucesso.");
                        } else {
                            System.out.println("Falha ao atualizar autor.");
                        }
                    } else {
                        System.out.println("Autor não encontrado.");
                    }
                    break;
                case 8:
                    System.out.println("Digite o ID do autor a ser deletado: ");
                    int authorIdToDelete = getUserChoice(keyboard);
                    int deleteResult = authorDAO.delete(authorIdToDelete);
                    if (deleteResult > 0) {
                        System.out.println("Autor deletado com sucesso.");
                    } else {
                        System.out.println("Falha ao deletar autor.");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }
}
