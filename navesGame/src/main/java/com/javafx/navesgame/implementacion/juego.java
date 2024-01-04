package com.javafx.navesgame.implementacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class juego extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/javafx/navesgame/juego-view.fxml"));
        Group root = new Group();
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Scene scene = new Scene(root, 700,500);
        Canvas lienzo = new Canvas(200,200);
        root.getChildren().add(lienzo);

        GraphicsContext graficos = lienzo.getGraphicsContext2D();//Dentro de graficos ya puedo pintar o dibujar
       graficos.fillRect(20, 50, 25, 68);//pos x, pos y, ancho, alto
        stage.setScene(scene);
        stage.setTitle("JavaFx-Game!");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
