package com.javafx.navesgame.implementacion;

import com.javafx.navesgame.models.Jugador;
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
    private Jugador jugador;
    public static boolean arriba;
    public static boolean abajo;
    public static boolean izquierda;

    public static boolean derecha;


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

                actualizarEstado();
                pintar();

            }
        };

        animationTimer.start();//Comienza el ciclo de juego

    }

    /*
    ----------- Actualizar Estado ------------------
    ** Se ejecutará 60fps
    */
    public void actualizarEstado(){
        jugador.mover();
    }


/*
    ----------- Inicializar componentes ------------------
 */

    public void inicializarComponentes(){
        jugador = new Jugador(20,40,3,"buldog.png");
        root = new Group();
        scene = new Scene(root, 700,500);
        lienzo = new Canvas(700,500);
        root.getChildren().add(lienzo);
        graficos = lienzo.getGraphicsContext2D();//Dentro de graficos ya puedo pintar o dibujar

    }

/*
    ----------- Pintar ------------------
 */

    public void pintar(){
        Image background1 = new Image("edificioChimenea.png");
      graficos.drawImage(background1,0,0,700,500);
      jugador.pintar(graficos);



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
                        break;
                    case "LEFT":
                        izquierda = true;
                        break;

                    case "UP":
                        arriba = true;
                        break;

                    case "DOWN":
                        abajo = true;
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
                        break;
                    case "LEFT":
                        izquierda = false;
                        break;

                    case "UP":
                        arriba = false;
                        break;

                    case "DOWN":
                        abajo = false;
                        break;

                }
            }
        });// setOnKeyPressed() requiere implementar la interfaz EventHandler


    }


//fin
}