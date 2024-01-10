package com.javafx.navesgame.models;

import com.javafx.navesgame.implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Item extends ObjetoJuego {
    private int cantidadVidas;
    private boolean capturado=false;

    public Item(int x, int y, String nombreImagen, int velocidad, int cantidadVidas) {
        super(x, y, nombreImagen, velocidad);
        this.cantidadVidas = cantidadVidas;
        this.ancho = 50;
        this.alto = 50;
        //this.ancho=(int)Juego.imagenes.get("itemEsfera").getWidth();
        //this.alto=(int)Juego.imagenes.get("itemEsfera").getHeight();
    }

    public int getCantidadVidas() {
        return cantidadVidas;
    }

    public void setCantidadVidas(int cantidadVidas) {
        this.cantidadVidas = cantidadVidas;
    }

    public boolean isCapturado() {
        return capturado;
    }

    public void setCapturado(boolean capturado) {
        this.capturado = capturado;
    }

    public Rectangle obtenerRectangulo(){
        return new Rectangle(x, y, ancho, alto);
    }

    @Override
    public void pintar(GraphicsContext graficos) {
//Si está capturado no lo pinta (o lo borra)
        if (this.capturado) {
            return;
        }else {
            graficos.drawImage(Juego.imagenes.get("itemEsfera"), x, y, 50, 50);
            graficos.setStroke(Color.RED);
            graficos.strokeRect(x, y, ancho, alto);
        }

    }



    @Override
    public void mover() {

    }
}
