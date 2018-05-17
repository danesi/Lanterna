/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visual;
import modelo.Contato;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import controle.Conexao;
import controle.ContatosControle;
import java.sql.Connection;
/**
 *
 * @author boemo
 */
public class TelaIncluirContato extends Window{
 private Panel painel01;
 private Button botaoSair;
 private Button botaoSalvar;
 private Label label01;
 private Label lblNome;
 private TextBox txtNome;
 private Label lblCelular;
 private TextBox txtCelular;
  private Label lblFixo;
 private TextBox txtFixo;
 Contato contato = new Contato();
 private static GUIScreen guiScreen;
 
    public TelaIncluirContato(GUIScreen gS) {
        super("Tela de Inclusão de Contato");
        this.guiScreen=gS;
        init();
    }
    private void init() {
        
        Connection conn = Conexao.AbrirConexao();
        ContatosControle ctrl=new ContatosControle(conn);
        
        setBorder(new Border.Standard());
        painel01 = new Panel(Panel.Orientation.HORISONTAL);
        painel01.setBetweenComponentsPadding(1);
        label01 = new Label("Inclusão de Contato  ");
        addComponent(label01);
        lblNome = new Label("Nome do Contato :");
        txtNome = new TextBox();
        lblCelular = new Label("Telefone Celular:");
        txtCelular = new TextBox();
        lblFixo = new Label("Telefone fixo:");
        txtFixo = new TextBox();        
        
        addComponent(lblNome);
        addComponent(txtNome);
        addComponent(lblCelular);
        addComponent(txtCelular);
        addComponent(lblFixo);
        addComponent(txtFixo);  
        
        botaoSalvar = new Button("Incluir", new Action() {
            @Override
            public void doAction() {
             contato.setNomeContato(txtNome.getText());
             contato.setNumCelular(txtCelular.getText());
             contato.setNumFixo(txtFixo.getText());
             MessageBox.showMessageBox(guiScreen, "Contatos",ctrl.InserirContato(contato));
                 
                close();
            }
            
        });
        addComponent(botaoSalvar);
        botaoSair = new Button("Sair", new Action() {
        @Override
            public void doAction() {
                close();
            }
        });      
        addComponent(botaoSair);


}
    
}
