package aula_01_08;

import javax.swing.JOptionPane;

public class program_one {

	public static void main(String[] args) {
		String name = "";
		String phone = "";
		String mail = "";
		String years = "";
		
		//Ex 01
		name = JOptionPane.showInputDialog("Insert name:");
		JOptionPane.showMessageDialog(null, "Name: " + name);
		phone = JOptionPane.showInputDialog("Insert phone:");
		JOptionPane.showMessageDialog(null, "Phone: " + phone);
		mail = JOptionPane.showInputDialog("Insert mail:");
		JOptionPane.showMessageDialog(null, "Mail: " + mail);
		years = JOptionPane.showInputDialog("Insert years:");
		JOptionPane.showMessageDialog(null, "Years old: " + years);
	}

}
