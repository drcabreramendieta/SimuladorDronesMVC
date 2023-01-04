/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

/**
 *
 * @author hola
 */
public class Dron extends Agente{
    private int energia;
    private PropertyChangeSupport pcs;

    public Dron(int x, int y, int maxx, int maxy) {
        this.energia = 100;
        setX(x);
        setY(y);
        setMaxx(maxx);
        setMaxy(maxy);
        pcs = new PropertyChangeSupport(this);
    }
    
    public void mover(){
        if(energia > 0){
            int[]old = new int[2];
            old[0] = getX();
            old[1] = getY();
            Random r = new Random();
            int direccion = r.nextInt(8);
            switch(direccion){
                case 0:
                    setX(getX()-1);
                    setY(getY()-1);
                    break;
                case 1:
                    setY(getY()-1);
                    break;
                case 2:
                    setX(getX()+1);
                    setY(getY()-1);
                    break;
                case 3:
                    setX(getX()-1);
                    break;
                case 4:
                    setX(getX()+1);
                    break;
                case 5:
                    setX(getX()-1);
                    setY(getY()+1);
                    break;
                case 6:
                    setY(getY()+1);
                    break;
                case 7:
                    setX(getX()+1);
                    setY(getY()+1);
                    break;
            }

            if (getX() > getMaxx()){
                setX(getMaxx());
            }
            if (getX() < 0){
                setX(0);
            }

            if (getY() > getMaxy()){
                setY(getMaxy());
            }
            if (getY() < 0){
                setY(0);
            }
            energia = energia - 1;
            int[] nueva = new int[2];
            nueva[0] = getX();
            nueva[1] = getY();
            pcs.firePropertyChange("pos", old, nueva);
        }
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    @Override
    public String toString() {
        return this.energia+"";
    }
    
    public void addListener(PropertyChangeListener pcl){
        pcs.addPropertyChangeListener(pcl);
    }
    
    public void removeListener(PropertyChangeListener pcl){
        pcs.removePropertyChangeListener(pcl);
    }
    
}
