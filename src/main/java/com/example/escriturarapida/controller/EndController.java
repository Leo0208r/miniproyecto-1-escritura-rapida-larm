package com.example.escriturarapida.controller;

import com.example.escriturarapida.view.GameStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the results screen of "Escritura Rápida".
 * <p>
 *     Manages events and information displayed in {@code end-view.fxml}.
 *     Shows the final result of the match (victory or defeat), completed levels
 *     and total time played. Allows restarting the match or exiting.
 * </p>
 * @author LEONARDO ROSERO
 * @version 1.0
 * @see com.example.escriturarapida.view.EndStage
 */
public class EndController {
    /** Label that shows the result of the match ("You won :)" or "You lost :("). */
    @FXML
    private Label resultLabel;
    /** Label that shows the number of completed levels. */
    @FXML
    private Label levelsCompletedLabel;
    /** Label that shows the total time elapsed in seconds. */
    @FXML
    private Label secondsCompletedLabel;

    /**
     * Handles the "Restart" button event.
     * <p>
     *     Closes the results window and opens a new instance of
     *     {@link GameStage} to start a match from the beginning.
     * </p>
     * @param event The action event triggered by the button.
     * @throws IOException  If an error occurs when loading the FXML of the game screen.
     */
    @FXML
    public void onHandleRestart(ActionEvent event) throws IOException {
        Stage currentStage=(Stage)((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        new GameStage();
    }

    /**
     * Handles the "Exit" button event.
     * Closes the results window and ends the game session.
     * @param event The action event triggered by the button.
     */
    public void onHandleExit(ActionEvent event){
        Stage currentStage=(Stage)((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    /**
     * Receives and injects the completed match data into the view.
     * <p>
     *     Updates the labels with the result, completed levels and
     *     total time. If {@code result} is {@code true} displays "You won :)",
     *     otherwise displays "You lost :(".
     * </p>
     * @param levelsCompleted Number of levels the player completed.
     * @param totalSeconds  Total time of the match in seconds.
     * @param result {@code true} if the player won, {@code false} if lost.
     */
    public void setData(int levelsCompleted, int totalSeconds, boolean result){
        if (result== true){
            resultLabel.setText("Ganaste :)");
        }else{
            resultLabel.setText("Perdiste :(");
        }
        levelsCompletedLabel.setText(String.valueOf(levelsCompleted));
        secondsCompletedLabel.setText(String.valueOf(totalSeconds));
    }

}
