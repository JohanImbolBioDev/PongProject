package com.game;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;



public class Raqueta {
    private int x, y, ancho, altura, Barriba, Babajo;
    private boolean PressArriba, PressAbajo;

    Raqueta(int x, int y, int ancho, int altura, int Arriba, int Abajo){
        this.x = x;
        this.y = y;
        this.altura = altura;
        this.ancho = ancho;
        this.Barriba = Arriba;
        this.Babajo = Abajo;
    }

    public void ComprobarBottom(){
        if(Barriba==EventosKey.idPress && y>0){
            PressArriba = true;
            PressAbajo = false;
        }
        
        if(Babajo==EventosKey.idPress && y>0){
            PressAbajo = true;
            PressArriba = false;
        }

    }

    public Rectangle2D getRaqueta(){
        return new Rectangle2D.Double(x,y,ancho,altura);
    }

    public void mover(Rectangle limites){
        ComprobarBottom();
        if(PressArriba && y>1){
            y--;
        }
        if(PressAbajo && y<(limites.getMaxY()-altura)){
            y++;
        }
    }


}
