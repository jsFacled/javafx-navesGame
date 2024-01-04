package com.javafx.navesgame.implementacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class juego extends Application {
    public static void main(String[] args) {
        launch(args);
    }

//----variables globales ---------

    GraphicsContext graficos;
    Group root;
    Scene scene;
    Canvas lienzo;

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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/javafx/navesgame/juego-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        inicializarComponentes();
        pintar();
        stage.setScene(scene);
        stage.setTitle("JavaFx-Game!");


        stage.show();
    }



/*
    ----------- Inicializar componentes ------------------
 */

    public void inicializarComponentes(){
        root = new Group();
        scene = new Scene(root, 700,500);
        lienzo = new Canvas(200,200);
        root.getChildren().add(lienzo);
        graficos = lienzo.getGraphicsContext2D();//Dentro de graficos ya puedo pintar o dibujar

    }

/*
    ----------- Pintar ------------------
 */

    public void pintar(){
        graficos.fillRect(20, 50, 25, 68);//pos x, pos y, ancho, alto
    }


//fin
}