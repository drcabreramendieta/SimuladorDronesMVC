/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author hola
 */
public abstract class Agente {
    private int posx;
    private int posy;
    private int maxx;
    private int maxy;
    
    public int getX() {
        return posx;
    }

    public int getY() {
        return posy;
    }

    public void setX(int x) {
        this.posx = x;
    }

    public void setY(int y) {
        this.posy = y;
    }

    public int getMaxx() {
        return maxx;
    }

    public int getMaxy() {
        return maxy;
    }

    public void setMaxx(int maxx) {
        this.maxx = maxx;
    }

    public void setMaxy(int maxy) {
        this.maxy = maxy;
    }
    
    @Override
    public abstract String toString();
}
