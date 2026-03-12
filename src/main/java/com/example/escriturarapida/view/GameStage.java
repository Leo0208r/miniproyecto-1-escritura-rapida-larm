package com.example.escriturarapida.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GameStage extends Stage {
    public GameStage() throws IOException {
        FXMLLoader loader= new FXMLLoader(
                getClass().getResource("/com/example/escriturarapida/game-view.fxml")
        );
        Parent root=loader.load();
        Scene scene= new Scene(root);
        setScene(scene);
        setTitle("Escritura rapida ");
        getIcons().add( new Image(
                String.valueOf(getClass().getResource("/com/example/escriturarapida/Icons/boton-de-reproduccion.png"))
        ));
        show();

    }
}
