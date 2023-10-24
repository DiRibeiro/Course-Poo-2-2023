package aula_29_08;

import javax.swing.JOptionPane;

public class Estudante {
	String nome;
	String matricula;
	String curso;
	
	public Estudante(String nome, String matricula, String curso) {
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}
	
	public void Info(){
		System.out.println("===== Informações do estudante =====");
		System.out.println("Nome: " + this.nome);
		System.out.println("Matricula: " + this.matricula);
		System.out.println("Curso: " + this.curso);
	}

	public void ModCurso(String NovoCurso){
		this.curso = NovoCurso;
		System.out.println("======= " + "Aluno nº"+ this.matricula);
		System.out.println(" --- Curso alterado para " + this.curso);
	}
	
	public void ModCurso2(){
		this.curso = JOptionPane.showInputDialog("Qual o novo curso do estudante?");
		System.out.println("======= " + "Aluno nº"+ this.matricula);
		System.out.println(" --- Curso alterado para " + this.curso);
	}
}
