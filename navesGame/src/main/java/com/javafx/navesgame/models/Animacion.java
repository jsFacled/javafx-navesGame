package com.javafx.navesgame.models;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Animacion {
    private double duracion;
    //usamos la clase rectangle de javafx que sirve para almacenar 4 valores:x,y,ancho y alto.
    private Rectangle coordenadas[];

    public Animacion(double duracion, Rectangle coordenadas[]) {
        this.duracion = duracion;
        this.coordenadas = coordenadas;
    }

    public double getDuracion() {
       return duracion;

    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Rectangle[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Rectangle[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Rectangle calcularFrameActual(double t){
        int cantidadFrames = coordenadas.length;
        int indiceFrameActual =(int) (t%(cantidadFrames*duracion)/duracion);//t es double, casteamos a int
        return coordenadas[indiceFrameActual];
    }
}
