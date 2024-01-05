package com.javafx.navesgame.models;

import com.javafx.navesgame.implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Jugador {

    private int x;
    private int y;
    private int vidas;
    private String nombreImagen;
    private int velocidad=30;

    public Jugador(int x, int y, int vidas, String nombreImagen) {
        this.x = x;
        this.y = y;
        this.vidas = vidas;
        this.nombreImagen = nombreImagen;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    //defino método pintar para cada jugador
    public void pintar(GraphicsContext graficos) {
        graficos.drawImage(new Image(nombreImagen), x, y, 43, 64);
    }

    public void mover() {

        if (Juego.derecha)
            x += velocidad;

        if (Juego.izquierda)
            x -= velocidad;
        if (Juego.arriba)
            y -= velocidad;
        if (Juego.abajo)
            y += velocidad;

    }
}
