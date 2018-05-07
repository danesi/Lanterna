
public class Pilha {

	private Elemento inicio;
	
	public void push(Elemento e) {
		if(this.inicio == null) {
			this.inicio = e;
		}else {
			Elemento el = this.inicio;
			this.inicio = e;
			this.inicio.setProximo(el);			
		}
		
	}
	
	public Elemento pop() {
		if(this.inicio == null) {
			return null;
		}else {
			Elemento e = this.inicio;
			this.inicio = e.getProximo();
			return e;
		}
	}
	
	
	

}
