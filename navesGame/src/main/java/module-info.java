module com.javafx.navesgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.javafx.navesgame to javafx.fxml;
    exports com.javafx.navesgame;
}