package com.javafx.navesgame.implementacion;

import com.javafx.navesgame.models.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class Juego extends Application {
    public static void main(String[] args) {
        launch(args);
    }


//----variables globales ---------
    private GraphicsContext graficos;
    private Group root;
    private Scene scene;
    private Canvas lienzo;
    private int x=0;
    private Fondo fondo;
    //private Jugador jugador;//Lo reemplazamos por JugadorAnimado
    private JugadorAnimado jugadorAnimado;
    private Tile tile;
    public static boolean arriba;
    public static boolean abajo;
    public static boolean izquierda;
    public static boolean derecha;
    public static HashMap<String, Image> imagenes;
    //private int tilemap [] [];
    private ArrayList<Tile> tiles;
    private Item item;

    //inicializamos tilemap
    private int tilemap [][]= {
            { 5,0,5,0,0,0,0,1,0,1 },
            { 0,0,0,0,0,0,0,0,0,0 },
            { 0,0,0,0,0,0,0,0,0,0 },
            { 0,0,0,0,0,0,0,0,0,0 },
            { 0,0,0,0,6,0,0,0,0,0 },
            { 0,0,0,0,0,0,0,0,0,0 },
            { 0,0,0,0,0,0,0,0,0,0 },
            { 0,0,0,0,0,0,0,0,0,0 },
            { 0,0,0,0,0,0,0,0,0,0 },
            { 0,0,0,0,0,0,0,0,0,0 }

    };




//------start------------
    /*
    1-inicializa componentes
    2-pinta
    3-asigna la ventana al stage
    4-agrega titulo
    5-muestra la ventana
     */
//------------------------
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/juego-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        inicializarComponentes();
        gestionEventos();

        stage.setScene(scene);
        stage.setTitle("JavaFx-Game!");

        stage.show();
        cicloJuego();
    }

/*
    ----------- Loop de Juego ------------------
 */

    public void cicloJuego(){
        long tiempoInicial = System.nanoTime();//captura el momento en que inicia el juego
        AnimationTimer animationTimer=new AnimationTimer() {
            @Override
            public void handle(long tiempoActual) {
                double t = (tiempoActual - tiempoInicial)/1000000000.0; //lo paso a segundos
                System.out.println("Time: "+t);

                actualizarEstado(t);
                pintar();
            }
        };
        animationTimer.start();//Comienza el ciclo de juego
    }


    /*
    ----------- Actualizar Estado ------------------
    ** Se ejecutará 60fps dentro de cicloJuego
    */
    public void actualizarEstado(double t){
               //jugador.mover();
        jugadorAnimado.verificarColisionesItem(item);
        jugadorAnimado.calcularFrame(t);
        jugadorAnimado.mover();
        fondo.mover();
    }


/*
    ----------- Inicializar componentes ------------------
 */

    public void inicializarComponentes(){
        cargarImagenes();
        //jugador = new Jugador(0,0,"buldog", 1, 3);
        jugadorAnimado = new JugadorAnimado(0,0,"perroCaminandoYCorriendo",2,3,"descanso");


        fondo = new Fondo(0,0,"plano1","plano1_2",4);
        inicializarTiles();
        item=new Item(300,150,"itemEsfera",0,1);
        //tile=new Tile(0,0,"tileset1-700500",0,310,140,50,50);//El ancho y alto es lo que recorta de la imagen origen y lo muestra con esas medidas.
        root = new Group();
        scene = new Scene(root, 700,500);
        lienzo = new Canvas(700,500);
        root.getChildren().add(lienzo);
        graficos = lienzo.getGraphicsContext2D();//Dentro de graficos ya puedo pintar o dibujar
    }

    public void inicializarTiles(){
        tiles = new ArrayList<Tile>();
        for (int i=0;i<tilemap.length;i++){
            for (int j = 0; j <tilemap[i].length ; j++) {
                if (tilemap[i][j] !=0) {
                    //this.tiles.add(new Tile(tilemap[i][j],j*70, i*70,"tilemap",0,70,70));
                    this.tiles.add(new Tile(tilemap[i][j],j*50, i*50,"tileset1-700500",0,50,50));

                }

            }
        }
    }
/*
    ----------- Cargar imagenes al hasMap ------------------
    ** Ingresamos en el hasMap las imagenes
 */
    public void cargarImagenes() {
     imagenes = new HashMap<String, Image>();

     imagenes.put("buldog", new Image("buldog.png"));
     imagenes.put("plano1", new Image("plano1.png"));
     imagenes.put("plano1_2", new Image("plano1_2.png"));
     imagenes.put("tileset2", new Image("tileset2.jpg"));
     imagenes.put("tileset1", new Image("tileset1.png"));
     imagenes.put("tileset1-700500", new Image("tileset1-700500.png"));
     imagenes.put("perroCaminandoYCorriendo", new Image("perroCaminandoYCorriendo.png"));
     imagenes.put("itemEsfera", new Image("itemEsfera.png"));


 }

/*
    ----------- Pintar ------------------
    **
 */

    public void pintar(){
      //  graficos.drawImage(new Image("edificioChimenea.png"),0,0,700,500);
      fondo.pintar(graficos);

        // ** Dibujo un cuadrado solamente, identifico coordenadas dentro de la imagen tileset1
     /* graficos.drawImage(imagenes.get("tileset1"),
              coordenadaImagenX,    // Desde acá ...
              coordenadaImagenY,    //...
              ancho,                //...
              alto,                 //..Hasta acá extraigo el fragmento de la imagen
              coordenadaPintarX,
              coordenadaPintarY,
              anchoPintar,
              altoPintar
              );
              */

        //pinto el cielo
        //tile.pintar(graficos);

        // ** Pintamos usanda ArrayList y tiles
        for (int i = 0; i < tiles.size(); i++) {
            tiles.get(i).pintar(graficos);
        }


        jugadorAnimado.pintar(graficos);
        item.pintar(graficos);
        graficos.fillText("Vidas: "+jugadorAnimado.getVidas(),5,20);


    }



/*
    ----------- Gestion de eventos ------------------
 */

    public void gestionEventos() {

        /*
            ---Capturo la tecla presionada
        */
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent evento) {
                //Capturo el evento de tecla y lo muestro por consola
                System.out.println("Se presionó la tecla: " + evento.getCode());//llama al enum KeyCode

           //Tomo decisiones a partir del evento capturado
                switch (evento.getCode().toString()){
                    case "RIGHT":
                       derecha = true;
                        jugadorAnimado.setDireccion(1);
                       jugadorAnimado.setAnimacionActual("correr");
                        break;
                    case "LEFT":
                        izquierda = true;
                        jugadorAnimado.setDireccion(-1);
                        jugadorAnimado.setAnimacionActual("correr");
                        break;

                    case "UP":
                        arriba = true;
                        break;

                    case "DOWN":
                        abajo = true;
                        break;
                    case "SPACE":
                        //jugador.setVelocidad(15);
                        //jugador.setNombreImagen("buldogCorriendo")
                        jugadorAnimado.setVelocidad(15);

                        break;

                }
            }
        });// setOnKeyPressed() requiere implementar la interfaz EventHandler

        /*
            ---Capturo la tecla al soltarse
        */
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent evento) {
                //Capturo el evento de tecla y lo muestro por consola
                System.out.println("Se presionó la tecla: " + evento.getCode());//llama al enum KeyCode

                //Tomo decisiones a partir del evento capturado
                switch (evento.getCode().toString()){
                    case "RIGHT":
                        derecha = false;

                        jugadorAnimado.setAnimacionActual("descanso");
                        break;
                    case "LEFT":
                        izquierda = false;
                        jugadorAnimado.setAnimacionActual("descanso");
                        break;

                    case "UP":
                        arriba = false;
                        break;

                    case "DOWN":
                        abajo = false;
                        break;
                    case "SPACE":
                        jugadorAnimado.setVelocidad(15);

                        break;

                }
            }
        });// setOnKeyPressed() requiere implementar la interfaz EventHandler


    }


//fin
}