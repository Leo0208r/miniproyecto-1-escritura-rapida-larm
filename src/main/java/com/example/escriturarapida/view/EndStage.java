package com.example.escriturarapida.view;

import com.example.escriturarapida.controller.EndController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *  Results window at the end of the "Escritura Rápida" game.
 *  <p>
 *      Extends {@link Stage} and loads the end game screen from the FXML file
 *      {@code end-view.fxml}. Receives the match data (completed levels,
 *      total time and result) and passes it to the {@link EndController} to display them.
 *  </p>
 * @author LEONARDO ROSERO
 * @version 1.0
 * @see EndController
 */
public class EndStage extends Stage {
    /**
     * Constructor that loads the FXML of the end screen, injects the match data
     * into the controller and displays the window to the user.
     * @param levelsCompleted Number of levels completed during the match
     * @param totalSeconds  Total time elapsed in seconds during the match.
     * @param result  {@code true} if the player won, {@code false} if lost.
     */
    public EndStage(int levelsCompleted, int totalSeconds, boolean result) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/escriturarapida/end-view.fxml")
            );
            Parent root = loader.load();

            EndController controller = loader.getController();
            controller.setData(levelsCompleted, totalSeconds, result);

            Scene scene = new Scene(root);
            setScene(scene);
            setTitle("Escritura rapida");
            getIcons().add( new Image(
                    String.valueOf(getClass().getResource("/com/example/escriturarapida/Icons/como.png"))
            ));
            show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

