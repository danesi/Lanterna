/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visual;

/**
 *
 * @author boemo
 */
import modelo.Contato;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;

public class TelaPrincipal extends Window{
    // declara 
 private Panel painel01;
 private Button botaoSair;
 private Button botaoIncluir;
 private Button botaoAlteraouExclui;

 private Button botaoListaContato;
 private Button botaoListaTodos;
 private Button botaoListaTodosPDF;
 private Label label01;
 //Contato contato = new Contato();
 private static GUIScreen guitelaprincipal; // SEMPRE INSTANCIAR 
 
    public TelaPrincipal(GUIScreen gS) {
        super("Tela Principal");
        this.guitelaprincipal=gS;
        init();
    }
       private void init() {
        setBorder(new Border.Standard());// SETA A BORDA
        painel01 = new Panel(Panel.Orientation.VERTICAL);// DEFINE UM PAINEL
        painel01.setBetweenComponentsPadding(1);
        label01 = new Label("Menu de opções"); 
        addComponent(label01);
        botaoIncluir = new Button("Incluir Contato", new Action() { // INSTANCIA O BOTÃO E EXECUTA UMA AÇÃO action
            @Override
            public void doAction() {
              guitelaprincipal.showWindow(new TelaIncluirContato(guitelaprincipal));
            }
        });
        
        
        
        
        
        
        
        addComponent(botaoIncluir); // incluir o botão
        botaoAlteraouExclui = new Button("Alterar ou excluir Contatos", new Action() {
            @Override
            public void doAction() {
              guitelaprincipal.showWindow(new TelaBuscaContatos(guitelaprincipal,0));
            }
            
        });
        addComponent(botaoAlteraouExclui);
        
        
        
        
        

        botaoListaContato = new Button("Listar Contato", new Action() {
            @Override
            public void doAction() {
            guitelaprincipal.showWindow(new TelaProcuraNome(guitelaprincipal));
            }
            
        });
        addComponent(botaoListaContato);
        
        
        
        
        
        
        
                botaoListaTodos = new Button("Listagem todos contatos", new Action() {
            @Override
            public void doAction() {
             guitelaprincipal.showWindow(new TelaListarTodosContatos(guitelaprincipal));
            }
            
        });
                addComponent(botaoListaTodos);
                
                
                
                
                
                
                botaoListaTodosPDF = new Button("Gerar relatório", new Action() {
            @Override
            public void doAction() {
             //guitelaprincipal.showWindow(new TelaListarTodosContatos(guitelaprincipal));
            }
            
        });
                
        addComponent(botaoListaTodosPDF);
        
        
        
        
        
        
        
        botaoSair = new Button("Sair", new Action() {
        @Override
            public void doAction() {
                close();
            }
        });      
        addComponent(botaoSair);
 
    }
       
 
}