package com.example.escriturarapida;

import com.example.escriturarapida.controller.StartController;
import com.example.escriturarapida.view.StartStage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class of the "Escritura Rápida" application.
 * <p>
 *     Extends {@link Application} from JavaFX and serves as the entry point
 *     of the program. It is responsible for initializing and displaying the start screen.
 * </p>
 * @author LEONARDO ROSERO
 * @version 1.0
 */
public class Main extends Application {

    /**
     * Java main method. Launches the JavaFX application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     *  JavaFX entry point. Runs automatically when the application starts.
     *  Creates and initializes the start screen {@link StartStage}.
     * @param primaryStage The primary stage provided by JavaFX (not used
     *                     directly, since {@link StartStage} creates its own Stage).
     * @throws IOException If an error occurs when loading the FXML file of the start screen.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        new StartStage();

    }
}
