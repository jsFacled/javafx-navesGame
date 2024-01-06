package com.javafx.navesgame.models;

import com.javafx.navesgame.implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Tile extends ObjetoJuego {
    private int xImage;
    private int yImage;

    public Tile(int x, int y, String nombreImagen, int velocidad, int xImage, int yImage, int ancho, int alto) {
        super(x, y, nombreImagen, velocidad);
        this.xImage = xImage;
        this.yImage = yImage;
        this.ancho=ancho;
        this.alto=alto;
    }


    public int getxImage() {
        return xImage;
    }

    public void setxImage(int xImage) {
        this.xImage = xImage;
    }

    public int getYImage() {
        return yImage;
    }

    public void setYImage(int YImage) {
        this.yImage = YImage;
    }


    @Override
    public void pintar(GraphicsContext graficos) {
graficos.drawImage(Juego.imagenes.get(nombreImagen),xImage,yImage,ancho, alto, x,y,ancho,alto);
    }

    @Override
    public void mover() {
//Implementar
    }
}
