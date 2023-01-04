/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author hola
 */
public class ListenerDron implements PropertyChangeListener{
    ModeloMatriz mm;

    public ListenerDron(ModeloMatriz mm) {
        this.mm = mm;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        int[]old = (int[])pce.getOldValue();
        int[]nueva = (int[])pce.getNewValue();
        mm.fireTableCellUpdated(old[1], old[0]);
        mm.fireTableCellUpdated(nueva[1], nueva[0]);
    }
    
}
