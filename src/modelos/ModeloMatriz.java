/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hola
 */
public class ModeloMatriz extends AbstractTableModel{
    ArrayList<Agente> agentes;
    private ListenerDron ld;

    public ModeloMatriz() {
        agentes = new ArrayList<>();
        ld = new ListenerDron(this);
    }
    
    
    
    @Override
    public int getRowCount() {
        return 100;
    }

    @Override
    public int getColumnCount() {
        return 100;
    }

    @Override
    public Object getValueAt(int i, int j) {
        for(Agente agente:agentes){
            if (agente.getX() == j && agente.getY() == i){
                return agente;
            }
        }
        return "";
    }
    
    public void agregarDrones(int nDrones){
        int i = 0;
        Random r = new Random();
        while(i < nDrones){
            int x = r.nextInt(100);
            int y = r.nextInt(100);
            boolean noSirve = false;
            for(Agente agente:agentes){
                if(agente.getClass().getName().equals("modelos.Dron") 
                        && agente.getX() == x 
                        && agente.getY() == y){
                    noSirve = true;
                    break;
                }
            }
            if (noSirve == false){
                Dron d = new Dron(x,y,100,100);
                d.addListener(ld);
                agentes.add(d);
                fireTableCellUpdated(y,x);
                i++;
            }
        }
    }
    
    public void agregarEstaciones(int nEstaciones){
        int i = 0;
        Random r = new Random();
        while(i < nEstaciones){
            int x = r.nextInt(100);
            int y = r.nextInt(100);
            boolean noSirve = false;
            for(Agente agente:agentes){
                System.out.println(agente.getClass().getName());
                if(agente.getClass().getName().equals("modelos.Estacion") 
                        && agente.getX() == x 
                        && agente.getY() == y){
                    noSirve = true;
                    break;
                }
            }
            if (noSirve == false){
                Estacion d = new Estacion(x,y);
                agentes.add(d);
                fireTableCellUpdated(y,x);
                i++;
            }
        }
    }
    
    public void moverDrones(){
        for(Agente agente:agentes){
            if(agente.getClass().getName().equals("modelos.Dron")){
                ((Dron)agente).mover();
            }
        }
    }
    
    public void verificarColisiones(){
        ArrayList<Dron> deleteDrones = new ArrayList<>(); 
        for(int i = 0; i < agentes.size(); i++){
            if(agentes.get(i).getClass().getName().equals("modelos.Dron")){
                Dron d1 = (Dron) agentes.get(i);
                for (int j = i+1; j < agentes.size();j++)
                {
                    if(agentes.get(j).getClass().getName().equals("modelos.Dron")){
                        Dron d2 = (Dron) agentes.get(j);
                        if(d1.getX() == d2.getX() && d1.getY() == d2.getY()){
                            for(Dron d:deleteDrones){
                                if(d1.equals(d) || d2.equals(d)){
                                    break;
                                }
                                deleteDrones.add(d);
                            }
                        }
                    }
                }
            }
        }
        for(Dron d:deleteDrones){
            int x = d.getX();
            int y = d.getY();
            agentes.remove(d);
            d = null;
            fireTableCellUpdated(y,x);
        }
    }
    
    public void verificarCarga(){
        for(int i = 0; i < agentes.size(); i++){
            if(agentes.get(i).getClass().getName().equals("modelos.Estacion")){
                Estacion d1 = (Estacion) agentes.get(i);
                for (int j = 0; j < agentes.size();j++)
                {
                    if(agentes.get(j).getClass().getName().equals("modelos.Dron")){
                        Dron d2 = (Dron) agentes.get(j);
                        if(d1.getX() == d2.getX() && d1.getY() == d2.getY()){
                            d1.CargaDron(d2);
                        }
                    }
                }
            }
        }
    }
}
