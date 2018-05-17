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

/**
 *
 * @author boemo
 */

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Table;
import controle.Conexao;
import controle.ContatosControle;
import java.sql.Connection;

import modelo.Contato;

public class TelaListaContato extends Window{
    private Button botaoSair;

    private Table tblCli;
    private Panel pnlLista;
    private Component[] linha=new Component[4];
   
    private static GUIScreen guiScreen;
    
    public TelaListaContato(GUIScreen gS) {
        super("Listagem de Contatos");
        this.guiScreen=gS;
    init();    
    }
    private void init() {
        Connection conn = Conexao.AbrirConexao();
        ContatosControle ctrl=new ContatosControle(conn);
        setBorder(new Border.Standard());
        pnlLista = new Panel(Panel.Orientation.HORISONTAL);
        pnlLista.setBetweenComponentsPadding(1);      
        tblCli = new Table(4, "Relação de Contatos");
        tblCli.setColumnPaddingSize(1);
        
        tblCli.removeAllRows();
        linha[0] = new Label("Codigo");
        linha[1] = new Label("Nome              ");
        linha[2] = new Label("Celular     ");
        linha[3] = new Label("Fixo        ");
        
        tblCli.addRow(linha);
        linha[0] = new Label("------");
        linha[1] = new Label("------------------");
        linha[2] = new Label("---------------");
        linha[3] = new Label("---------------");
        tblCli.addRow(linha);
        
       for (Contato contatos : ctrl.listarTodosContatos()) {
       
        linha[0] = new Label(""+contatos.getCodigoContato());
        linha[1] = new Label(contatos.getNomeContato());
        linha[2] = new Label(contatos.getNumCelular());
        linha[3] = new Label(contatos.getNumFixo());
        tblCli.addRow(linha);
        }
      
        addComponent(tblCli);
        
        
        botaoSair = new Button("Sair", new Action() {
        @Override
            public void doAction() {
                close();
            }
        });      
     addComponent(botaoSair);
    }
    
    
}