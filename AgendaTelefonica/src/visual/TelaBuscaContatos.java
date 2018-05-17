
package visual;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Table;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import controle.Conexao;
import controle.ContatosControle;
import java.sql.Connection;
import modelo.Contato;

public class TelaBuscaContatos extends Window{
    private Button botaoSair;
    private Table tblCli;
    private Panel pnlLista;
    private Component[] linha=new Component[4];
    private static GUIScreen guiScreen;
    private int PrimReg = 0; 
   
    public TelaBuscaContatos(GUIScreen gS,int primreg) {
        super("Listagem de todos os Contatos");
        this.guiScreen=gS;
        this.PrimReg=primreg;
    init();    
    }
    private void init() {
        Connection conn = Conexao.AbrirConexao();
        ContatosControle ctrl=new ContatosControle(conn);
        setBorder(new Border.Standard());
        pnlLista = new Panel(Panel.Orientation.HORISONTAL);
        pnlLista.setBetweenComponentsPadding(1);    
        tblCli = new Table(5, "Relação de Contatos");
        tblCli.setColumnPaddingSize(1);
        //coisas para gerar paginação
        int totreg=ctrl.NumeroTotalRegistros();
        int RegPag = 12;
       // int paginas = totreg/RegPag;
        String [][]ArrayContatos =new String[totreg][2];

        int cont=0;
        for (Contato contatos : ctrl.listarTodosContatos()) {
        ArrayContatos[cont][0]=""+contatos.getCodigoContato();
        ArrayContatos[cont][1]=contatos.getNomeContato();
        cont++;
        }
      
        addComponent(DesenhaTabela(ArrayContatos,PrimReg,RegPag,tblCli));
        botaoSair = new Button("Sair", new Action() {
        @Override
            public void doAction() {
                close();
            }
        });      
     addComponent(botaoSair);
    }
    public Table DesenhaTabela(String[][] ArrayContatos, int PrimRegaux, int RegPag, Table tblCli) {
        Component[] linha = new Component[4];
        int numaux;
        tblCli.removeAllRows();
        linha[0] = new Label("Codigo");
        linha[1] = new Label("Nome              ");
        linha[2] = new Label("Edição      ");
        linha[3] = new Label("            ");
        tblCli.addRow(linha);
        linha[0] = new Label("------");
        linha[1] = new Label("------------------");
        linha[2] = new Label("---------------");
        linha[3] = new Label("---------------");
        tblCli.addRow(linha);
       
        int arraytam =ArrayContatos.length;
        for (int i = PrimRegaux; i <= (RegPag + PrimRegaux) - 1; i++) {
                if (i<arraytam) {
                //System.out.println(i + " " + ArrayContatos[i][0] + " "+((RegPag + PrimRegaux) - 1)+" "+arraytam);
                linha[0] = new Label(ArrayContatos[i][0]);
                final String numauxarray=ArrayContatos[i][0];
                linha[1] = new Label(ArrayContatos[i][1]);
                linha[2] = new Button("Alterar", new Action() {
                    @Override
                    public void doAction() {

                        MessageBox.showMessageBox(guiScreen, "Alteração", "Alteração item código "+numauxarray);
                        //guiScreen.showWindow(new TelaAlterarContato(guiScreen));
                    }
                });
                linha[3] = new Button("Excluir", new Action() {
                    @Override
                    public void doAction() {

                        MessageBox.showMessageBox(guiScreen, "Exclusão", "Exclusão de item código "+numauxarray);
                        //guiScreen.showWindow(new TelaExcluirContato(guiScreen));
                    }
                });
                tblCli.addRow(linha);
             
            }

        }

        linha[0] = new Button("Próximo", new Action() {
            @Override
            public void doAction() {

                int numaux = ((PrimRegaux + RegPag));
                if (numaux >= ArrayContatos.length) {
                    numaux = 0;
                }
               
                close();
                guiScreen.showWindow(new TelaBuscaContatos(guiScreen, numaux));
            }
        });
        linha[1] = new Label("------------------");
        linha[2] = new Label("---------------");
        linha[3] = new Button("Anterior", new Action() {
            @Override
            public void doAction() {
                int numaux = ((PrimRegaux - RegPag));
                if (numaux < 0) {
                    numaux = 0;
                }
                close();
               guiScreen.showWindow(new TelaBuscaContatos(guiScreen, numaux));
            }
        });
        tblCli.addRow(linha);
        return tblCli;

    }
}
