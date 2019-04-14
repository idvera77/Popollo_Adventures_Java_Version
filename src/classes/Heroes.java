/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author Mystra77
 */
public class Heroes extends Personajes{
    private ArrayList<Objetos> objetosArray;
    private TipoConducta moral;
      
    private enum TipoConducta{
        LEGAL,
        BUENO,
        NEUTRAL,
        MALO,
        CAOTICO
    }   

    public Heroes(String nombre, String descripcion, int saludMaxima, int salud, int fuerza, 
        int magia, int agilidad, int defensa, ArrayList<Habilidades> habilidadesArray, ArrayList<Objetos> objetosArray) {
        super(nombre, descripcion, saludMaxima, salud, fuerza, magia, agilidad, defensa, habilidadesArray);
        this.objetosArray = objetosArray;
        this.moral = moral;
    }

    public ArrayList<Objetos> getObjetosArray() {
        return objetosArray;
    }

    public void setObjetosArray(ArrayList<Objetos> objetosArray) {
        this.objetosArray = objetosArray;
    }

    public TipoConducta getMoral() {
        return moral;
    }

    public void setMoral(TipoConducta moral) {
        this.moral = moral;
    }
}
