
public class Elemento {
	private Dados info;
	private Elemento proximo;	
	
	public Elemento(Dados info) {
		this.info = info;
	}
	public Dados getInfo() {
		return info;
	}
	public void setInfo(Dados info) {
		this.info = info;
	}
	public Elemento getProximo() {
		return proximo;
	}
	public void setProximo(Elemento proximo) {
		this.proximo = proximo;
	}
		
	
}
