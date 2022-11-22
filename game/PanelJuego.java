package com.game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;



public class PanelJuego extends JPanel{
    private int AnchoPelota =20 , AlturaPelota = 20;
    private int alturaRaqueta = 80, anchoRaqueta = 20;
    private Color ColorFondo = new Color(0,0,0);
    private Color ColorBall = new Color(250,250,250);
    public int SpeedGame = 0;
    public Rectangle TamañoPanel = getBounds();
    private int puntajeJ1 = 0, puntajeJ2 = 0;


    
    Raqueta r1 = new Raqueta(2,200-alturaRaqueta, anchoRaqueta, alturaRaqueta,KeyEvent.VK_W,KeyEvent.VK_S);
    Raqueta r2 = new Raqueta(782-anchoRaqueta, 200-alturaRaqueta, anchoRaqueta, alturaRaqueta,KeyEvent.VK_UP, KeyEvent.VK_DOWN);
    Ball pelota = new Ball(0,0,AnchoPelota,AlturaPelota);

    public PanelJuego(){
        setBackground(ColorFondo);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(ColorBall);
        draw(g2);
        refresh();
        Puntuacion();
        VelocidadGame();
    }

    public void draw(Graphics2D g){
        g.fill(pelota.getBall());
        g.fill(r1.getRaqueta());
        g.fill(r2.getRaqueta());
    }

    public void refresh(){
        pelota.mover(getBounds(),r1.getRaqueta(),r2.getRaqueta());
        r1.mover(getBounds());
        r2.mover(getBounds());
    }

    public void VelocidadGame(){
        if((pelota.Colision(r1.getRaqueta()) || pelota.Colision(r2.getRaqueta())) && SpeedGame!=0){
            SpeedGame--;
        }
    }

    public void Puntuacion(){
        if(pelota.PointLeft(getBounds())){
            puntajeJ2++;
        }
        if(pelota.PointRight(getBounds())){
            puntajeJ1++;
        }
        System.out.println("J1: "+ puntajeJ1+ " ||J2: "+puntajeJ2);
    }

}
