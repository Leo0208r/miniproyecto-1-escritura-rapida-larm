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

/**
 * Main controller for the "Escritura Rápida" game screen.
 * <p>
 *     Manages all the logic of the {@code game-view.fxml} view: the timer,
 *     word generation, answer validation, level progression,
 *     and the transition to the results screen when the game ends.
 * </p>
 * @author LEONARDO ROSERO
 * @version 1.0
 * @see com.example.escriturarapida.view.GameStage
 * @see Time
 * @see Level
 * @see Words
 */
public class GameController {
    /** Handles the game timer and the flickering effect. */
    private Time time;
    /** Controls the current level and seconds assigned per level. */
    private Level level;
    /** Provides and validates game words according to the level. */
    private Words words;
    /** Timeline used to hide feedback messages after one second. */
    private Timeline timeline;
    /** Secondary label with an additional message every 5 levels. */
    @FXML
    private Label wordTwoLabel;
    /** Text field where the player writes the word. */
    @FXML
    private TextField wordTextField;
    /** Label that shows the word the player must write. */
    @FXML
    private Label wordLabel;
    /** Label that shows the remaining time of the current level. */
    @FXML
    private Label timeLabel;
    /** Label that shows the current level. */
    @FXML
    private Label levelLabel;
    /** Label that shows feedback of the answer (correct/incorrect). */
    @FXML
    private Label FeedBackLabel;

    /**
     * Initialization method called automatically by JavaFX when loading the FXML.
     * <p>
     *     Instantiates the models, hides initial labels, starts the total time counter,
     *     loads the level timer and the first word,
     *     and registers the listener to validate with the {@code ENTER} key.
     * </p>
     */
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

    /**
     * Handles the "Validate" button event.
     * Delegates the validation logic to the {@link #validateInput()} method.
     * @param event The action event triggered by the button
     */
    @FXML
    public void onHandleValidate(ActionEvent event){
        validateInput();
    }

    /**
     *  Handles the key press event in the text field.
     *  Delegates the validation logic to the {@link #validateInput()} method.
     * @param event The keyboard event captured in the TextField.
     */
    @FXML
    public void onHandleEnter(KeyEvent event){
        validateInput();

    }

    /**
     * Loads a random word into {@code wordLabel} according to the current level.
     * Uses {@link Words#choiceArrayByLevel(int)} to select the correct list
     * and {@link Words#generateWord(java.util.ArrayList)} to choose
     * a word at random.
     */
    public void loadRandomWord(){
        wordLabel.setText(words.generateWord(words.choiceArrayByLevel(level.getLevel())));

    }

    /**
     * Updates the level label with the current value of {@link Level#getLevel()}.
     */
    public void loadLevel(){
        levelLabel.setText(String.valueOf(level.getLevel()));
    }

    /**
     * Restarts and starts the timer for the current level.
     * <p>
     *      Stops any previous timer (main and flickering),
     *      resets the seconds according to {@link Level#getSecondsForLevel()},
     *      updates the time label and starts the new countdown.
     *      When it reaches 0, {@link #validateInput()} is called automatically.
     * </p>
     */
    public void loadTime(){
        time.stopSwitchColor();
        time.stop();
        time.resetSecond(level.getSecondsForLevel());
        timeLabel.setText(String.valueOf(time.getSeconds()));
        time.start(
                ()->timeLabel.setText(String.valueOf(time.getSeconds())),
                ()->validateInput()
        );
        changeColorTime();
    }

    /**
     * Validates the word entered by the player in {@code wordTextField}.
     * <p>
     *     Possible scenarios:
     *     <ul>
     *         <li><b>Correct:</b> removes the used word, increments the level,
     *          shows positive feedback and loads the next level. If all words run out,
     *          ends the game with victory.</li>
     *          <li><b>Time ran out:</b> closes the screen and shows the
     *          results screen with defeat.</li>
     *          <li><b>Incorrect:</b> shows error feedback and clears the field.</li>
     *     </ul>
     * </p>
     */
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

    /**
     * Shows a success message in {@code FeedBackLabel} with green text.
     */
    public void showSuccesMessage(){
        FeedBackLabel.setText("Bien hecho");
        FeedBackLabel.setStyle("-fx-text-fill:#4CAF50;");
        FeedBackLabel.setVisible(true);

    }

    /**
     * Shows an error message in {@code FeedBackLabel} with red text.
     */
    public void showErrorMessage(){
        FeedBackLabel.setText("Incorrecto");
        FeedBackLabel.setStyle("-fx-text-fill:#ff5252;");
        FeedBackLabel.setVisible(true);
    }

    /**
     * Shows {@code wordTwoLabel} when the level is a multiple of 5
     * and the remaining time is greater than 2 seconds.
     * <p>
     *     Used as a motivational or warning message every 5 levels
     * </p>
     * @param level The current game level.
     * @param seconds The remaining seconds in the current level.
     */
    public void showLessTwoSeconds(int level, int seconds){
       if(level%5==0 && seconds>2){
           wordTwoLabel.setVisible(true);
       }
    }

    /**
     *  Hides {@code FeedBackLabel} and {@code wordTwoLabel} after 1 second
     *  using a single-frame {@link Timeline}.
     */
    public void changeVisibleMessage(){
        timeline= new Timeline(
                new KeyFrame(Duration.seconds(1), actionEvent ->{
                    FeedBackLabel.setVisible(false);
                    wordTwoLabel.setVisible(false);
                })
        );
        timeline.play();
    }

    /**
     * Closes the current game window by obtaining the {@link Stage}
     * through any node of the scene.
     */
    private void closeCurrentStage() {
        Stage currentStage = (Stage) wordLabel.getScene().getWindow();
        currentStage.close();
    }

    /**
     * Starts the flickering effect of the timer when time is critical.
     * <p>
     *     Calls {@link Time#switchColor(Runnable, Runnable)} with two styles:
     *     red for the active tick and white for the inactive tick.
     *     The initial style is set to white before starting the flickering.
     * </p>
     */
    public void changeColorTime(){
        time.switchColor(
                ()-> timeLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold; -fx-border-color: #e94560;"),
                ()-> timeLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-border-color: #e94560;")
        );
        timeLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-border-color: #e94560;");

    }
}
