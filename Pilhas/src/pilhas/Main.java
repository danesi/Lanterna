
package pilhas;

public class Main {

    public static void main(String[] args) {
       Pilha p = new Pilha();
       p.empilhar("Daniel");
       p.empilhar("maria");
       p.empilhar("Jose");
       p.empilhar("Marcos");
       p.empilhar("Paulo");
       p.empilhar("Marcia");
       
       String topo = p.desempilhar();
        System.out.println("Elemento Removido: " + topo);
        
       topo = p.desempilhar();
        System.out.println("Elemento Removido: " + topo);
    }
}
