module com.javafx.navesgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.javafx.navesgame to javafx.fxml;
    exports com.javafx.navesgame;
    exports com.javafx.navesgame.implementacion;
    opens com.javafx.navesgame.implementacion to javafx.fxml;
}