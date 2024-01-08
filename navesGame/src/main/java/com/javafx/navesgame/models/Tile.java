package com.javafx.navesgame.models;

import com.javafx.navesgame.implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Tile extends ObjetoJuego {
    private int xImage;
    private int yImage;
    private int tipoTile;

    public Tile(int tipoTile,int x, int y, String nombreImagen, int velocidad,  int ancho, int alto) {
        super(x, y, nombreImagen, velocidad);
        this.xImage = xImage;
        this.yImage = yImage;
        this.ancho=ancho;
        this.alto=alto;

        switch (tipoTile){
            case 1:
                this.xImage=0;
                this.yImage=0;

                break;
            case 2:
                this.xImage=0;
                this.yImage=70;
                break;
            case 3:
                this.xImage=0;
                this.yImage=140;
                break;
            case 4:
                this.xImage=0;
                this.yImage=210;
                break;

                //agrego para probar desde tileset1-700500.png
            case 5:
                this.xImage=310;
                this.yImage=140;
                break;//en este caso es el cielo
            case 6:
                this.xImage=90;
                this.yImage=360;
                break;//en este caso es el cielo
        }
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
