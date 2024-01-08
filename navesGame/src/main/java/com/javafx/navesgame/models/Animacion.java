package com.javafx.navesgame.models;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Animacion {
    private int duracion;
    //usamos la clase rectangle de javafx
    private ArrayList<Rectangle> coordenadas;

    public Animacion(int duracion, ArrayList<Rectangle> coordenadas) {
        this.duracion = duracion;
        this.coordenadas = coordenadas;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public ArrayList<Rectangle> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<Rectangle> coordenadas) {
        this.coordenadas = coordenadas;
    }
}
