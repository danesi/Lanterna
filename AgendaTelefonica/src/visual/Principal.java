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

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;


public class Principal {
    
    public static Terminal terminal;
    public static Screen screen;
    public static GUIScreen guiScreen;
   
    public static void main(String[] args) {
    //
        terminal = TerminalFacade.createTerminal();// indica que vai ter um terminal
        screen = new Screen(terminal);// define o terminal
        guiScreen = new GUIScreen(screen);// cria um objeto de interface grafica, aonde tudo o que é grafico fica aqui

        screen.startScreen();// mostrar a tela grafica
        
        guiScreen.showWindow(new TelaPrincipal(guiScreen));// chama a tela principal
        screen.stopScreen();
    
    
    }
}
