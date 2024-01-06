package com.javafx.navesgame.models;

import com.javafx.navesgame.implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Fondo extends ObjetoJuego{

    public Fondo(int x, int y, String nombreImagen, int velocidad) {
        super(x, y, nombreImagen, velocidad);
    }

    @Override
    public void pintar(GraphicsContext graficos) {
graficos.drawImage(Juego.imagenes.get(nombreImagen),x,y);
    }

    @Override
    public void mover() {
        if (Juego.derecha) {
            x -= velocidad;
        }

        if (Juego.izquierda) {
            x += velocidad;
        }

        if (Juego.arriba)
            y += velocidad;
        if (Juego.abajo)
            y -= velocidad;

    }
}
