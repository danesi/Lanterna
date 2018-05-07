
public class Dados {
	private String nome;
	private int idade;
	private double altura;
	
	public Dados(String nome, int idade, double altura) {	
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
	}
	
	public String toString() {
		return "Dados:\nNome: " + this.nome +"\nIdade:" + this.idade + "\nAltura: " + this.altura;
	}
	
}
