/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.ModeloMatriz;

/**
 *
 * @author hola
 */
public class RunListener implements ActionListener{
    ModeloMatriz m;

    public RunListener(ModeloMatriz m) {
        this.m = m;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        m.moverDrones();
        m.verificarColisiones();
        m.verificarCarga();
    }
    
}
