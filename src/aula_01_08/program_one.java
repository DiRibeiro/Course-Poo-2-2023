package aula_01_08;

import javax.swing.JOptionPane;

public class program_one {

	public static void main(String[] args) {
		String name = "";
		String phone = "";
		String mail = "";
		String years = "";
		
		//Ex 01
		System.out.println("Meu Super Programa!");
		JOptionPane.showMessageDialog(null, "Meu Super Programa!");
		
		name = JOptionPane.showInputDialog("Insert name:");
		phone = JOptionPane.showInputDialog("Insert phone:");
		years = JOptionPane.showInputDialog("Insert years:");
		mail = JOptionPane.showInputDialog("Insert mail:");
		JOptionPane.showMessageDialog(null, "Name: " + name + "\nPhone: " + phone + "\nMail: " + mail + "\nYears old: " + years);
	}

}
