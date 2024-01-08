package com.javafx.navesgame.models;


import com.javafx.navesgame.implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;

public class JugadorAnimado extends ObjetoJuego {
    private int vidas;
    private HashMap<String,Animacion> animaciones;


    public JugadorAnimado(int x, int y, String nombreImagen, int velocidad, int vidas) {
        super(x, y, nombreImagen, velocidad);
        this.vidas = vidas;
        animaciones=new HashMap<String, Animacion>();
    }

    public void inicializarAnimaicones(){
        Rectangle coordenadasCorrer[] ={
                new Rectangle(10,10,80,45),//x,y,tamaño ancho, tamaño alto
                new Rectangle(100,10,80,45),
                new Rectangle(190,10,80,45),

        };

    }


    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }


    @Override
    public void pintar(GraphicsContext graficos) {
        graficos.drawImage(Juego.imagenes.get(nombreImagen), x, y, 43, 64);
    }

    @Override
    public void mover() {
        if (Juego.derecha) {
            x += velocidad;
        }
        if (x > 700) x = -35; //si pasa la pantalla vuelve al inicio un poquitito antes

        if (Juego.izquierda) {
            x -= velocidad;
        }

        if (Juego.arriba)
            y -= velocidad;
        if (Juego.abajo)
            y += velocidad;

    }
}
