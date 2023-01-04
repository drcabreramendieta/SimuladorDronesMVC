/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import modelos.ModeloMatriz;
import vista.Ventana;
import javax.swing.Timer;

/**
 *
 * @author hola
 */
public class Principal {
    public static void main(String[] args){
        ModeloMatriz m = new ModeloMatriz();
        Ventana v = new Ventana();
        InitListener il = new InitListener(v,m);
        v.addListenerInit(il);
        
        RunListener rl = new RunListener(m);
        Timer timer = new Timer(100, rl);
        
        StartListener sl = new StartListener(timer);
        StopListener stopl = new StopListener(timer);
        v.addListenerRun(sl);
        v.addListenerStop(stopl);
        
        v.addWorldModel(m);
        v.setVisible(true);
    }
}
