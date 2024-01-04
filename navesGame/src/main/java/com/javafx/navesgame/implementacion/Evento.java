package com.javafx.navesgame.implementacion;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Evento implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent keyEvent) {
        //Capturo el evento de tecla y lo muestro por consola
        System.out.println("Se presionó la tecla: "+keyEvent.getCode());//llama al enum KeyCode
    }
}
