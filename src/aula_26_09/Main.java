package aula_26_09;

public class Main {
    public static void main(String[] args) {
        // Criar uma instância de IdeiaDAO
        IdeiaDAO ideiaDAO = new IdeiaDAO();

        // Adicionar uma nova ideia
        Ideia novaIdeia = new Ideia(1, "Minha Ideia", "Descrição da minha ideia", 2);

        ideiaDAO.adicionarIdeia(novaIdeia);
        // System.out.println("Nova Ideia adicionada: " + novaIdeia);

        // Recuperar a ideia pelo ID
        int idDaNovaIdeia = novaIdeia.getId();
        Ideia ideiaRecuperada = ideiaDAO.obterIdeiaPorId(idDaNovaIdeia);
        
        // Verificar se a ideia foi recuperada com sucesso
        if (ideiaRecuperada != null) {
        	System.out.println("Ideia recuperada do banco de dados:");
        	System.out.println(ideiaRecuperada);
        } else {
        	System.out.println("Não foi possível recuperar a ideia.");
        }
        
        // ideiaDAO.deletarIdeia(idDaNovaIdeia);
        
    }
}
