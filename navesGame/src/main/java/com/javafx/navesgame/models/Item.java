package com.javafx.navesgame.models;

import com.javafx.navesgame.implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Item extends ObjetoJuego {
    private int cantidadPuntos;

    public Item(int x, int y, String nombreImagen, int velocidad, int cantidadPuntos) {
        super(x, y, nombreImagen, velocidad);
        this.cantidadPuntos = cantidadPuntos;
        this.ancho = 50;
        this.alto = 50;
        //this.ancho=(int)Juego.imagenes.get("itemEsfera").getWidth();
        //this.alto=(int)Juego.imagenes.get("itemEsfera").getHeight();
    }

    @Override
    public void pintar(GraphicsContext graficos) {
        graficos.drawImage(Juego.imagenes.get("itemEsfera"), x, y, 50, 50);
        graficos.setStroke(Color.RED);
        graficos.strokeRect(x, y, ancho, alto);

    }

    @Override
    public void mover() {

    }
}
