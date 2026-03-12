package com.example.escriturarapida.view;

import com.example.escriturarapida.controller.EndController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
public class EndStage extends Stage {
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

