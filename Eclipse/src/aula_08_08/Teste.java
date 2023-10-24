package aula_08_08;

public class Teste {
	public static <T> void printVector(T v[]) {
		for(T e : v) System.out.printf(e + " ");
		System.out.println();
	}
	
	public static <T extends Comparable<T>> T bigger(T v[]) {
		T max = v[0];
		for(T e : v) {
			if(e.compareTo(max) > 0) {
				max = e;
			}
		}
		
		return max;
	}
	
	public static void main(String args[]) {
		//Primitivos : byte, long, short, int, float, double, boolean, char
		//Genericos : Byte, long, Short, Integer, Float, Double, Boolean, Character
		
		Double[] arrayDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
		System.out.println("Vector double: ");
		printVector(arrayDouble);
		System.out.println("\nBigger element: " + bigger(arrayDouble));
		
		Integer[] arrayInt = {1, 2, 3, 4, 5, 6};
		System.out.println("\nVector integer: ");
		printVector(arrayInt);
		System.out.println("\nBigger element: " + bigger(arrayInt));
		
		Character[] arrayChar = {'E', 'C', 'O', '0', '3', '0'};
		System.out.println("\nVector char: ");
		printVector(arrayChar);
		System.out.println("\nBigger element: " + bigger(arrayChar));
	}
}
