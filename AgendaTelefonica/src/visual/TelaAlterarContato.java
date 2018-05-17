
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
public class TelaAlterarContato extends Window{
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
 private String codigo;
        
 
    public TelaAlterarContato(GUIScreen gS,String cod) {
        super("Tela de Alteração de Contato");
        this.guiScreen=gS;
        this.codigo=cod;
        init();
    }
    private void init() {
        
        Connection conn = Conexao.AbrirConexao();
        ContatosControle ctrl=new ContatosControle(conn);
       
        contato=ctrl.consultaContato(Integer.parseInt(codigo));
        setBorder(new Border.Standard());
        painel01 = new Panel(Panel.Orientation.HORISONTAL);
        painel01.setBetweenComponentsPadding(1);
        label01 = new Label("Alteração de Contato  ");
        addComponent(label01);
        lblNome = new Label("Nome do Contato :");
        txtNome = new TextBox(contato.getNomeContato().toString());
        lblCelular = new Label("Telefone Celular:");
        txtCelular = new TextBox(contato.getNumCelular().toString());
        lblFixo = new Label("Telefone fixo:");
        txtFixo = new TextBox(contato.getNumFixo().toString());        
        
        addComponent(lblNome);
        addComponent(txtNome);
        addComponent(lblCelular);
        addComponent(txtCelular);
        addComponent(lblFixo);
        addComponent(txtFixo);  
        
        botaoSalvar = new Button("Alterar", new Action() {
            @Override
            public void doAction() {
             contato.setNomeContato(txtNome.getText());
             contato.setNumCelular(txtCelular.getText());
             contato.setNumFixo(txtFixo.getText());
                         
             MessageBox.showMessageBox(guiScreen, "Contatos",ctrl.AlterarContato(contato));
                 
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
