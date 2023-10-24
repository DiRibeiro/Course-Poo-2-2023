package aula_08_08;

public class Pilha<T> {
	private int max, top;
	private T[] elements;
	
	public Pilha(int max) {
		top = -1;
		this.max = max;
		elements = (T[]) new Object[max];
	}
	
	public void push(T e) throws Error{
		if(top < (max-1)) elements[++top] = e;
		else throw new Error();
	}
	
	public T pop() throws Error{
		if(top >= 0) return elements[top--];
		else throw new Error();
	}

}
