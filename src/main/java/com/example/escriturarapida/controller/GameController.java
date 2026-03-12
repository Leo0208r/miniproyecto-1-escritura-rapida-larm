package com.example.escriturarapida.controller;

import com.example.escriturarapida.model.Level;
import com.example.escriturarapida.model.Time;
import com.example.escriturarapida.model.words.Words;
import com.example.escriturarapida.view.EndStage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;




public class GameController {
    private Time time;
    private Level level;
    private Words words;
    private Timeline timeline;
    @FXML
    private Label wordTwoLabel;
    @FXML
    private TextField wordTextField;
    @FXML
    private Label wordLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private Label FeedBackLabel;
    @FXML
    public void initialize(){
        time= new Time();
        words= new Words();
        level=new Level();
        wordTwoLabel.setVisible(false);
        FeedBackLabel.setVisible(false);
        time.totalSeconds();
        loadTime();
        loadRandomWord();
        wordTextField.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                validateInput();
                event.consume();
            }
        });
    }
    @FXML
    public void onHandleValidate(ActionEvent event){
        validateInput();

    }
    @FXML
    public void onHandleEnter(KeyEvent event){
        validateInput();

    }
    public void loadRandomWord(){
        wordLabel.setText(words.generateWord(words.choiceArrayByLevel(level.getLevel())));

    }
    public void loadLevel(){
        levelLabel.setText(String.valueOf(level.getLevel()));
    }
    public void loadTime(){
        time.stop();
        time.resetSecond(level.getSecondsForLevel());
        timeLabel.setText(String.valueOf(time.getSeconds()));
        time.start(
                ()->timeLabel.setText(String.valueOf(time.getSeconds())),
                ()->validateInput()
        );
    }
    public void validateInput()  {
        String word=wordTextField.getText();
        if (words.validateWord(word,words.choiceArrayByLevel(level.getLevel()))==true){
            words.removeWord(word,words.choiceArrayByLevel(level.getLevel()));
            if (words.getLowLevelWords().isEmpty()) {
                closeCurrentStage();
                time.stopTotalSeconds();
                time.stop();
                new EndStage(level.getLevel(), time.getTotalSeconds(), true);
                return;
            }
            level.incrementLevel();
            loadLevel();
            showLessTwoSeconds(level.getLevel(), time.getSeconds());
            changeVisibleMessage();
            showSuccesMessage();
            changeVisibleMessage();
            wordTextField.clear();
            loadTime();
            loadRandomWord();
        }
        else if(time.getSeconds()==0){
            wordTextField.setPromptText("Se acabo el tiempo");
            wordTextField.clear();
            //loadTime();
            //levelLabel.setText(String.valueOf(level.resetLevel()));
            //loadRandomWord();
            closeCurrentStage();
            time.stopTotalSeconds();
            time.stop();
            new EndStage(level.getLevel(), time.getTotalSeconds(), false);
        }
        else{
            showErrorMessage();
            changeVisibleMessage();
            wordTextField.clear();
        }
    }
    public void showSuccesMessage(){
        FeedBackLabel.setText("¡CORRECTO!");
        FeedBackLabel.setStyle("-fx-text-fill:#4CAF50;");
        FeedBackLabel.setVisible(true);

    }
    public void showErrorMessage(){
        FeedBackLabel.setText("¡INCORRECTO!");
        FeedBackLabel.setStyle("-fx-text-fill:#ff5252;");
        FeedBackLabel.setVisible(true);
    }
    public void showLessTwoSeconds(int level, int seconds){
       if(level%5==0 && seconds>2){
           wordTwoLabel.setVisible(true);
       }
    }
    public void changeVisibleMessage(){
        timeline= new Timeline(
                new KeyFrame(Duration.seconds(1), actionEvent ->{
                    FeedBackLabel.setVisible(false);
                    wordTwoLabel.setVisible(false);
                })
        );
        timeline.play();
    }
    private void closeCurrentStage() {
        Stage currentStage = (Stage) wordLabel.getScene().getWindow();
        currentStage.close();
    }
}
