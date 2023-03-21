/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tica_tac_toe;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import jframe.Empate;
import jframe.GanaO;
import jframe.GanaX;
import jframe.PanlTab;

/**
 *
 * @author Alberto
 */
public class Tablero {

    private char[][] tablero;
    private Ficha f;
    private int turno = 0;
    private GanaX x = new GanaX();
    private GanaO o = new GanaO();
    private Empate e = new Empate();
    //private int turno = 0;
    //divisibles de dos O
    //no divisibles de dos X

    public Tablero() {
        this.tablero = new char[3][3];
        this.f = new Ficha();
    }

    public void mostrarTablero() {
        for (int x = 0; x < tablero.length; x++) {
            for (int y = 0; y < tablero[x].length; y++) {
                System.out.print(" | " + tablero[x][y] + " | ");
            }
            System.out.println("\n-------------------------------");

        }
    }

    public int finalizarJuego() {
        //1 X 0 O 2 EMPATE
        if (tablero[0][0] == 'O' && tablero[0][1] == 'O' && tablero[0][2] == 'O' || tablero[0][0] == 'O' && tablero[1][0] == 'O' && tablero[2][0] == 'O') {
            return 0;
        } else if (tablero[0][0] == 'X' && tablero[0][1] == 'X' && tablero[0][2] == 'X' || tablero[0][0] == 'X' && tablero[1][0] == 'X' && tablero[2][0] == 'X') {
            return 1;
        } else if (tablero[1][1] == 'O' && tablero[1][0] == 'O' && tablero[1][2] == 'O' || tablero[1][1] == 'O' && tablero[0][1] == 'O' && tablero[2][1] == 'O') {
            return 0;
        } else if (tablero[1][1] == 'X' && tablero[1][0] == 'X' && tablero[1][2] == 'X' || tablero[1][1] == 'X' && tablero[0][1] == 'X' && tablero[2][1] == 'X') {
            return 1;
        } else if (tablero[2][2] == 'O' && tablero[2][1] == 'O' && tablero[2][0] == 'O' || tablero[2][2] == 'O' && tablero[0][2] == 'O' && tablero[1][2] == 'O') {
            return 0;
        } else if (tablero[2][2] == 'X' && tablero[2][1] == 'X' && tablero[2][0] == 'X' || tablero[2][2] == 'X' && tablero[0][2] == 'X' && tablero[1][2] == 'X') {
            return 1;
        } else if (tablero[0][0] == 'O' && tablero[1][1] == 'O' && tablero[2][2] == 'O' || tablero[0][2] == 'O' && tablero[1][1] == 'O' && tablero[2][0] == 'O') {
            return 0;
        } else if (tablero[0][0] == 'X' && tablero[1][1] == 'X' && tablero[2][2] == 'X' || tablero[0][2] == 'X' && tablero[1][1] == 'X' && tablero[2][0] == 'X') {
            return 1;
        } else if (tablero[0][1] == 'X' && tablero[1][1] == 'X' && tablero[2][1] == 'X') {
            return 1;
        } else if (tablero[0][1] == 'O' && tablero[1][1] == 'O' && tablero[2][1] == 'O') {
            return 0;
        } else if (this.turno == 8) {
            return 2;
        }
        return 3;
    }

    public String peticionUsu() {
        Scanner a = new Scanner(System.in);
        String ficha = a.nextLine();
        return ficha;
    }

    public void limpiar() {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '-';
            }
        }

        mostrarTablero();
        this.o.setVisible(false);
        this.x.setVisible(false);
        this.e.setVisible(false);
        /*PanlTab tab = new PanlTab();
        tab.setVisible(true);*/
    }

    public void rellenarTab(int fila, int col, int turno) {

        System.out.println("Ejemplo de salida. 3-3");
        int filaTab = -5;
        int colTab = -5;
        int tuno = -5;
        /*String ficha="";
        if (filaTab == -5 && colTab == -5 && tuno == -5) {
            ficha = peticionUsu();
        }

        String[] separada = ficha.split("-");
        String pos1 = separada[0];
        String pos2 = separada[1];*/

        //int posicion1 = Integer.parseInt(pos1);
        //int posicion2 = Integer.parseInt(pos2);
        filaTab = fila;
        colTab = col;
        this.turno = turno;

        if ((this.turno % 2) == 0) {
            f.setValorFicha('O');
            //this.tablero[posicion1][posicion2] = f.getValorFicha();
            this.tablero[filaTab][colTab] = f.getValorFicha();
        } else {
            f.setValorFicha('X');
            //this.tablero[posicion1][posicion2] = f.getValorFicha();
            this.tablero[filaTab][colTab] = f.getValorFicha();
        }

        //System.out.println(tablero[posicion1][posicion2]);
        turno++;
        mostrarTablero();
        int fin = finalizarJuego();
        if (fin == 1) {
            System.out.println("El ganador es X");

            x.setVisible(true);
        } else if (fin == 0) {

            o.setBackground(Color.cyan);
            o.setVisible(true);
            System.out.println("El jugaodr es O");
        } else if (fin == 2) {

            e.setBackground(Color.pink);
            e.setVisible(true);
            System.out.println("EMPATE");
        }

    }

}
