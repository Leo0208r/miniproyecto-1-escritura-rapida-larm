package com.example.escriturarapida.controller;

import com.example.escriturarapida.view.GameStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {
    @FXML
    public void initialize(){
        System.out.println("inicio el StartController");
    }
    @FXML
    public void onHandleValidate(ActionEvent event) throws IOException {
        Stage currentStage=(Stage)((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        new GameStage();
    }

}
