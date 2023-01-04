/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Ventana;
import modelos.ModeloMatriz;

/**
 *
 * @author hola
 */
public class InitListener implements ActionListener{
    Ventana v;
    ModeloMatriz m;

    public InitListener(Ventana v, ModeloMatriz m) {
        this.v = v;
        this.m = m;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        int nDrones = v.getDrones();
        int nEstaciones = v.getEstaciones();
        m.agregarDrones(nDrones);
        m.agregarEstaciones(nEstaciones);
    }
    
}
