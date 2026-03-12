package com.example.escriturarapida.controller;

import com.example.escriturarapida.view.GameStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class EndController {
    @FXML
    private Label resultLabel;
    @FXML
    private Label levelsCompletedLabel;
    @FXML
    private Label secondsCompletedLabel;
    @FXML
    public void onHandleRestart(ActionEvent event) throws IOException {
        Stage currentStage=(Stage)((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        new GameStage();
    }
    public void onHandleExit(ActionEvent event){
        Stage currentStage=(Stage)((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
    public void setData(int levelsCompleted, int totalSeconds, boolean result){
        if (result== true){
            resultLabel.setText("¡GANASTE GG!");
        }else{
            resultLabel.setText("¡PERDISTE! :(");
        }
        levelsCompletedLabel.setText(String.valueOf(levelsCompleted));
        secondsCompletedLabel.setText(String.valueOf(totalSeconds));
    }


}
