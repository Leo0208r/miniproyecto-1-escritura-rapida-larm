package com.example.escriturarapida.controller;

import com.example.escriturarapida.view.GameStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *  Controller for the start screen of "Escritura Rápida".
 *  <p>
 *      Manages events from the {@code start-view.fxml} view. Its main responsibility
 *      is to close the start screen and open the game window
 *      when the player presses the start button.
 *  </p>
 * @author LEONARDO ROSERO
 * @version 1.0
 * @see com.example.escriturarapida.view.StartStage
 * @see GameStage
 */
public class StartController {
    /**
     * Initialization method called automatically by JavaFX
     * after loading the FXML file.
     * Prints a confirmation message to the console.
     */
    @FXML
    public void initialize(){
        System.out.println("inicio el StartController");
    }

    /**
     * Handles the "Start Game" button event.
     * <p>
     *     Closes the current start window and opens a new instance
     *     of {@link GameStage} to begin the game.
     * </p>
     * @param event The action event triggered by the button.
     * @throws IOException If an error occurs when loading the FXML of the game screen.
     */
    @FXML
    public void onHandleValidate(ActionEvent event) throws IOException {
        Stage currentStage=(Stage)((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        new GameStage();
    }

}
