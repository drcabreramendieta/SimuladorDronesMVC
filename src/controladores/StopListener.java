/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author hola
 */
public class StopListener implements ActionListener{
    Timer tm;

    public StopListener(Timer tm) {
        this.tm = tm;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        tm.stop();
    }
    
}
