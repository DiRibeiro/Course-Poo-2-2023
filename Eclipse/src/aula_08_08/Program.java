package aula_08_08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Ex 1 - Insert
//		PrintService<Integer> ps = new PrintService<>();
//			System.out.print("Quantos valores? ");
//			int n = sc.nextInt();
//			
//		for(int i = 0; i < n; i++) {
//			Integer value = sc.nextInt();
//			ps.addValue(value);
//		}
//		
//		ps.print();
//		Integer x = ps.first();
//		System.out.println("\nFirst: " + x);
//		sc.close();
		
		//Ex 2 - Read
		Map<String, Integer> votes = new LinkedHashMap<>();
		
		System.out.print("Insert url file: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int count = Integer.parseInt(fields[1]);
				
				if(votes.containsKey(name)) {
					int voteSoFar = votes.get(name);
					votes.put(name, count + voteSoFar);
				} else {
					votes.put(name, count);
				}
				
				line = br.readLine();
			}
			
			for(String key : votes.keySet()) {
				System.out.println(key + ": " + votes.get(key));
			}
		} catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
