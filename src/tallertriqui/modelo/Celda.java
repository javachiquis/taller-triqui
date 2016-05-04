/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallertriqui.modelo;

/**
 *
 * @author ener2
 */
public class Celda {

    private  char valor;
    private  Integer posicionHorizontal;
    private  Integer posicionVertical;

    /**
     * Metodo Constructor
     * @param valor el valor asignado a la celda (por defecto es '-')
     * @param pHorizontal indica la coordenada horizontal de la celda
     * @param pVertical indica la coordenada vertical de la celda
     */
    public Celda(char valor, Integer pHorizontal, Integer pVertical) {
        this.valor = valor;
        this.posicionHorizontal = pHorizontal;
        this.posicionVertical = pVertical;
    }
    
    /**
     * Asigna el valor de 'X' a la celda
     * @return siempre true, porque el turno ahora sera de 'O'
     */
    public boolean asignarX(){
        this.valor = 'X';
        return true;
    }
    
    /**
     * Asigna el valor de 'O' a la celda
     * @return siempre false, porque el turno ahora sera de 'X'
     */
    public boolean asignarO(){
        this.valor = 'O';
        return false;
    }

    public char getValor() {
        return valor;
    }

    public void setValor(char valor) {
        this.valor = valor;
    }

    public Integer getPosicionHorizontal() {
        return posicionHorizontal;
    }

    public void setPosicionHorizontal(Integer posicionHorizontal) {
        this.posicionHorizontal = posicionHorizontal;
    }

    public Integer getPosicionVertical() {
        return posicionVertical;
    }

    public void setPosicionVertical(Integer posicionVertical) {
        this.posicionVertical = posicionVertical;
    }
    
}
