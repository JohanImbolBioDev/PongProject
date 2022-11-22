package com.game;

import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;

public class Ball {
    private  int x;
    private  int y;
    private int Ancho;
    private int Altura;
    private  int dx=1 ,dy = 1;

    public Ball(int x,int y,int AnchoPelota, int AlturaPelota){
        this.x = x;
        this.y = y;
        this.Ancho = AnchoPelota;
        this.Altura = AlturaPelota;
    };

    public Rectangle2D getBall(){
        return new Rectangle2D.Double(x,y,Ancho,Altura);
    }

    public void mover(Rectangle limite,Rectangle2D r1, Rectangle2D r2){
        x+=dx;
        y+=dy;
        if(x>limite.getMaxX() || Colision(r1)){
            dx= -dx;
        }
        
        if(x < 0 || Colision(r2)){
            dx = -dx;
        }
        if(y>limite.getMaxY()){
            dy = -dy;
        }
        if(y < 0){
            dy = -dy;
        }
        Point(limite);
    } 

    public boolean Colision(Rectangle2D objeto){
       return getBall().intersects(objeto);
    }

    public void Point(Rectangle limites){
        if(x>limites.getMaxX()){
            x = 400;
        }
        if(x < 0){
            x = 400;
        }
    }

    public boolean PointLeft(Rectangle limites){
        return x>limites.getMaxX()-1;
    }

    public boolean PointRight(Rectangle limites){
        return x<1;
    }
}
