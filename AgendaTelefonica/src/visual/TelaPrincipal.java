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
 private Panel painel01;
 private Button botaoSair;
 private Button botaoIncluir;
 private Button botaoAlteraouExclui;

 private Button botaoListaContato;
 private Button botaoListaTodos;
 private Label label01;
 //Contato contato = new Contato();
 private static GUIScreen guitelaprincipal;
 
    public TelaPrincipal(GUIScreen gS) {
        super("Tela Principal");
        this.guitelaprincipal=gS;
        init();
    }
       private void init() {
        setBorder(new Border.Standard());
        painel01 = new Panel(Panel.Orientation.VERTICAL);
        painel01.setBetweenComponentsPadding(1);
        label01 = new Label("Menu de opções");
        addComponent(label01);
        botaoIncluir = new Button("Incluir Contato", new Action() {
            @Override
            public void doAction() {
              guitelaprincipal.showWindow(new TelaIncluirContato(guitelaprincipal));
            }
            
        });
        addComponent(botaoIncluir);
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
            // guitelaprincipal.showWindow(new TelaBuscaContatos(guitelaprincipal));
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
        botaoSair = new Button("Sair", new Action() {
        @Override
            public void doAction() {
                close();
            }
        });      
        addComponent(botaoSair);
 
    }
       
 
}