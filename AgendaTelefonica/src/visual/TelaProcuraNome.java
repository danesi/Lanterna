
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
public class TelaProcuraNome extends Window{
 private Panel painel01;
 private Button botaoSair;
 private Button botaoBuscar;
 private Label label01;
 private Label lblNome;
 private TextBox txtNome;
 private static GUIScreen guiScreen;
 
    public TelaProcuraNome(GUIScreen gS) {
        super("Procura Contato:");
        this.guiScreen=gS;
        init();
    }
    private void init() {
        
        setBorder(new Border.Standard());
        painel01 = new Panel(Panel.Orientation.HORISONTAL);
        painel01.setBetweenComponentsPadding(1);
        label01 = new Label("Digite o Nome do Contato:");
        addComponent(label01);
        lblNome = new Label("Contato");
        txtNome = new TextBox();        
        
        addComponent(lblNome);
        addComponent(txtNome);
        
        botaoBuscar = new Button("Buscar", new Action() {
            @Override
            public void doAction() {
                guiScreen.showWindow(new TelaListaContato(guiScreen, txtNome.getText()));
                close();
            }
            
        });
        addComponent(botaoBuscar);
        botaoSair = new Button("Sair", new Action() {
        @Override
            public void doAction() {
                close();
            }
        });      
        addComponent(botaoSair);


}
    
}
