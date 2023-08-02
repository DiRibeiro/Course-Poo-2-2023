package aula_01_08;

import javax.swing.JOptionPane;

public class program_two {

	public static void main(String[] args) {
		String name = "";
		String phone = "";
		String mail = "";
		int years = 29;
		
		//Ex 01
		name = JOptionPane.showInputDialog("Insert name:");
		phone = JOptionPane.showInputDialog("Insert phone:");
		mail = JOptionPane.showInputDialog("Insert mail:");
		
		//Sysout
		System.out.println("Name: " + name);
		System.out.println("Phone: " + phone);
		System.out.println("Years old: " + years);
		System.out.println("Mail: " + mail);
	}

}
