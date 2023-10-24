package aula_29_08;

public class Carro {
	String fabricante;
	String placa;
	String modelo;
	String dono;
	double posx;
	double posy;
	
	public Carro (String fab, String mod) {
		this.fabricante = fab;
		this.modelo = mod;
	}
	
	public void compra (String nome) {
		this.dono = nome;
	}
	
	public void deslocamento() {}
	
	public void emplacamento() {}
}
