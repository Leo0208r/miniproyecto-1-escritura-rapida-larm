package com.example.escriturarapida;

import com.example.escriturarapida.controller.StartController;
import com.example.escriturarapida.view.StartStage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        new StartStage();

    }
}
