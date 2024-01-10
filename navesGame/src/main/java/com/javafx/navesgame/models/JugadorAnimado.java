package com.javafx.navesgame.models;

import com.javafx.navesgame.implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;

public class JugadorAnimado extends ObjetoJuego {
    private int vidas;
    private HashMap<String,Animacion> animaciones;//aquí se insertarán las distintas animaciones: caminar, correr, saltar, etc.
    private String animacionActual;
    private int direccion=1;//se inicializa hacia la derecha
    // -Coordenadas de la imagen de Origen
    private int xImagen;
    private int yImagen;
    private int anchoImagen;
    private int altoImagen;


    public JugadorAnimado(int x, int y, String nombreImagen, int velocidad, int vidas, String animacionActual) {
        super(x, y, nombreImagen, velocidad);
        this.vidas = vidas;
        this.animacionActual= animacionActual;
        animaciones=new HashMap<String, Animacion>();
        inicializarAnimaicones();
    }

    public void inicializarAnimaicones(){
            // 1- Definir Coordenadas de la Imagen a Extraer
        Rectangle coordenadasCorrer[] ={
                new Rectangle(10,10,80,45),//x,y,tamaño ancho, tamaño alto que tienen en el original
                new Rectangle(100,10,80,45),
                new Rectangle(190,10,80,45),
        };
        Rectangle coordenadasDescanso[] ={
                new Rectangle(10,10,80,45)
        };

            // 2- Instanciar la Animación con las coordenadas
        Animacion animacionCorrer = new Animacion(0.3,coordenadasCorrer);
        Animacion animacionDescanso= new Animacion(0.3,coordenadasDescanso);

            // 3- Insertar las coordenadas al hasmap
        animaciones.put("correr", animacionCorrer);
        animaciones.put("descanso", animacionDescanso);
    }


    /*
        * Método para calcular las coordenadas
        * Se llamará por cada iteración del ciclo de juego.
        * Lo ubicamos en Juego.actualizarEstado()
     */
    public void calcularFrame(double t){
            //- Obtener coordenadas del momento cero (son las de la imagen original)
        Rectangle coordenadas = animaciones.get(animacionActual).calcularFrameActual(t);

            //- luego se la pasamos a los atributos de la clase
        this.xImagen =(int) coordenadas.getX();//casteo int porque retorna double.
        this.yImagen =(int) coordenadas.getY();
        this.anchoImagen =(int) coordenadas.getWidth();
        this.altoImagen =(int) coordenadas.getHeight();
    }


    public Rectangle obtenerRectangulo(){
return new Rectangle(x, y, 64, 40);
    }


    public void verificarColisionesItem(Item item){
        //intersects devuelve true si están colisionando
       if( this.obtenerRectangulo().getBoundsInLocal().intersects(item.obtenerRectangulo().getBoundsInLocal())){
           System.out.println(" * * Estan colisionando * * ");
       }
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public String getAnimacionActual() {
        return animacionActual;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public void setAnimacionActual(String animacionActual) {
        this.animacionActual = animacionActual;
    }

    @Override
    public void pintar(GraphicsContext graficos) {
        /*
        ** Debemos extraer el fragmento de la imagen correspondiente: xInage yImage, anchoImage, altoImage;
         * x,y,ancho,alto son de la clase padre.
         * * x,y se van calculando con el método mover
         * xI,yI,anchoI,altoI son de la clase hija y se calculan dinámicamente.
         * anchoImagen la multiplicamos por 1 o -1 de acuerdo a la dirección
         *
         *
         *
          */
        graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen,yImagen,anchoImagen*direccion,altoImagen, x, y, 64, 40);

        //Pintamos un rectangulo temporal para Colisiones con strokeRect(x,y,ancho,alto)
        graficos.setFill(Color.RED);

        //graficos.strokeRect(xImagen,yImagen,anchoImagen*direccion,altoImagen);
        graficos.strokeRect(x, y, 64, 40);
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
