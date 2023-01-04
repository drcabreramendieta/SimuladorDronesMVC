/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author hola
 */
public class Estacion extends Agente{

    public Estacion(int x, int y) {
        setX(x);
        setY(y);
    }
    
    public void CargaDron(Dron d){
        d.setEnergia(100);
    }

    @Override
    public String toString() {
        return "E";
    }
}
