
public class Main {

	public static void main(String[] args) {
		
		System.out.println("Iniciou");
		
		Pilha p = new Pilha();
		
		p.push(new Elemento(new Dados("Gustavo", 30, 1.65)));
		p.push(new Elemento(new Dados("Lilica", 8, 0.20)));
		p.push(new Elemento(new Dados("Nescau", 7, 0.50)));
		
		Elemento e = p.pop();
		System.out.println(e.getInfo().toString());
		
		
		e = p.pop();
		System.out.println(e.getInfo().toString());
		
		
		e = p.pop();
		System.out.println(e.getInfo().toString());
		
	}

}
