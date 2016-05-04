/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallertriqui.modelo;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

/**
 *
 * @author ener2
 */
public class TableroTriqui {
    
    private Integer numeroCeldas;
    private boolean turno;
    private List<Celda> celdas; 
    
    public TableroTriqui(Integer numCeldas){
        this.numeroCeldas = numCeldas;
        this.celdas = new ArrayList<>();
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public List<Celda> getCeldas() {
        return celdas;
    }

    public void setCeldas(List<Celda> celdas) {
        this.celdas = celdas;
    }

    /**
     * Este metodo se encarga de validar el turno y asignar la celda que
     * corresponde
     * @param celda la celda a jugar
     * @return true si el turno es de 'O' o false si es turno de 'X'
     */
    public boolean jugarCelda(Celda celda){
        
        if(this.turno) {
            return celda.asignarX();
        } else {
            return celda.asignarO();
        }
        
    }
    /**
     * Metodo encargado de validar el ganador recorriendo la lista de celdas
     * guardadas
     * @return 'X' o 'O' que indica el ganador
     */
    public char validarGanador(){
        if (celdas.size() >= 5) {
            char a = 'a';
            char b = 'b';
            char c = 'c';
            char d = 'd';
            char e = 'e';
            char f = 'f';
            char g = 'g';
            char h = 'h';
            char i = 'i';

            for (Celda celda : celdas) {

                if (celda.getPosicionHorizontal() == 1 && celda.getPosicionVertical() == 1) {
                    a = celda.getValor();
                }
                if (celda.getPosicionHorizontal() == 1 && celda.getPosicionVertical() == 2) {
                    b = celda.getValor();
                }
                if (celda.getPosicionHorizontal() == 1 && celda.getPosicionVertical() == 3) {
                    c = celda.getValor();
                }
                if (celda.getPosicionHorizontal() == 2 && celda.getPosicionVertical() == 1) {
                    d = celda.getValor();
                }
                if (celda.getPosicionHorizontal() == 2 && celda.getPosicionVertical() == 2) {
                    e = celda.getValor();
                }
                if (celda.getPosicionHorizontal() == 2 && celda.getPosicionVertical() == 3) {
                    f = celda.getValor();
                }
                if (celda.getPosicionHorizontal() == 3 && celda.getPosicionVertical() == 1) {
                    g = celda.getValor();
                }
                if (celda.getPosicionHorizontal() == 3 && celda.getPosicionVertical() == 2) {
                    h = celda.getValor();
                }
                if (celda.getPosicionHorizontal() == 3 && celda.getPosicionVertical() == 3) {
                    i = celda.getValor();
                }
            }

            if ((a == 'O' && a == b && b == c) ||
                    (d == 'O' && d == e && e == f) ||
                    (g == 'O' && g == h && h == i) ||
                    (a == 'O' && a == d && d == g) ||
                    (b == 'O' && b == e && e == h) ||
                    (c == 'O' && c == f && f == i) ||
                    (a == 'O' && a == e && e == i) ||
                    (c == 'O' && c == e && e == g)) {
                System.out.println("Gano 'O' felicitaciones!");
                return 'O';
            }

            if ((a == 'X' && a == b && b == c) ||
                    (d == 'X' && d == e && e == f) ||
                    (g == 'X' && g == h && h == i) ||
                    (a == 'X' && a == d && d == g) ||
                    (b == 'X' && b == e && e == h) ||
                    (c == 'X' && c == f && f == i) ||
                    (a == 'X' && a == e && e == i) ||
                    (c == 'X' && c == e && e == g)) {
                System.out.println("Gano 'X' felicitaciones!");
                return 'X';
            }
        }
        
        return '-';
        
    }
    
    /**
     * Lista las celdas libres en la consola y asigna un efecto en la parte
     * visual que indica que celdas estan libres
     * @param botones lista de los botones del tablero
     */
    public void listarCeldasLibres(List<Button> botones){
        if(!botones.isEmpty()){
            System.out.println("Celdas Libres:");
            for(Button boton : botones) {
                if(boton.getText().trim().isEmpty()){
                    DropShadow ds = new DropShadow(10, Color.RED);
                    boton.setEffect(ds);
                    System.out.println(boton.getUserData()+"");
                }
            }
        }
    }
    
    public void imprimirTablero(){
        
    }

}
