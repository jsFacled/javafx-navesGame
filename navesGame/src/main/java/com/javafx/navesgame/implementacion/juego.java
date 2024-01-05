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

public class juego extends Application {
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
 */
    public void actualizarEstado(){

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
      //  graficos.drawImage(background1,0,0,700,500);
      jugador.pintar(graficos);



    }



/*
    ----------- Gestion de eventos ------------------
 */

    public void gestionEventos() {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent evento) {
                //Capturo el evento de tecla y lo muestro por consola
                System.out.println("Se presionó la tecla: " + evento.getCode());//llama al enum KeyCode

           //Tomo decisiones a partir del evento capturado
                switch (evento.getCode().toString()){
                    case "RIGHT":
                        x +=10;
                        System.out.println(x);
                        break;
                    case "LEFT":
                        break;

                    case "UP":
                        break;

                    case "DOWN":
                        break;

                }
            }
        });// setOnKeyPressed() requiere implementar la interfaz EventHandler

    }


//fin
}