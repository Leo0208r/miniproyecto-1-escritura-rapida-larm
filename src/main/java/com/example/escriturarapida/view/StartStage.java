package com.example.escriturarapida.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Start window of the "Escritura Rápida" application.
 * <p>
 *      Extends {@link Stage} and is responsible for loading and displaying the welcome
 *      screen from the FXML file {@code start-view.fxml}.
 *      Upon instantiation, it configures the title, icon and shows the window automatically.
 * </p>
 * @author LEONARDO ROSERO
 * @version 1.0
 * @see com.example.escriturarapida.controller.StartController
 */
public class StartStage extends Stage {
    /**
     * Constructor that loads the FXML, configures the scene, title,
     * window icon and displays it to the user.
     * @throws IOException If an error occurs when loading the FXML file
     *                     {@code start-view.fxml}.
     */
    public StartStage() throws IOException {
        FXMLLoader loader= new FXMLLoader(
                getClass().getResource("/com/example/escriturarapida/start-view.fxml")
        );
        Parent root= loader.load();
        Scene scene= new Scene(root);
        setScene(scene);
        setTitle("Escritura rapida");
        getIcons().add(new Image(
                String.valueOf(getClass().getResource("/com/example/escriturarapida/Icons/teclado.png"))
        ));
        show();

    }
}
