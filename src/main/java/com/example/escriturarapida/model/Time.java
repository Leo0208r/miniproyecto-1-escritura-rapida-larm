package com.example.escriturarapida.model;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Model that manages all the timers in the game "EscrituraRapida"
 * <p>
 *     Controls three {@TimeLine} independents:
 *     <ul>
 *         <li>The countdown to the current level</li>
 *         <li>The total count of seconds played in the game</li>
 *         <li>The alert flashing effect when time is critical (<=5 seconds)</li>
 *     </ul>
 * </p>
 * @author LEONARDO ROSERO
 * @version 1.0
 * @see com.example.escriturarapida.controller.GameController
 */
public class Time {
    /**Remaining seconds in the current level. Initial value: 20.*/
    private int seconds=20;
    /**Total seconds elapsed during the entire match*/
    private int totalSeconds=0;
    /**Timeline of the level countdown.*/
    private Timeline timeline;
    /**Timeline of the total match count*/
    private Timeline totaltime;
    /**Timeline of the alert flickering effect*/
    private Timeline colortime;
    /** Flag that alternates the flicker state (active/inactive). */
    private boolean flickerActive= false;

    /**
     * Default constructor. Creates an instance of {@code Time}
     * with 20 initial seconds and counters at zero.
     */
    public Time(){}

    /**
     * Returns the remaining seconds of the current level.
     * @return Remaining seconds as an integer.
     */
    public int getSeconds(){
        return seconds;
    }

    /**
     * Starts the countdown of the current level.
     * <p>
     *     Decrements {@code seconds} each second. On each tick executes
     *     {@code onTick} to update the view. When it reaches 0,
     *     stops the timeline and executes {@code onTimeOut}.
     * </p>
     * @param onTick Runnable executed each second (e.g.: update the label).
     * @param onTimeOut Runnable executed when time reaches 0 (e.g.: validate input).
     */
    public void start(Runnable onTick, Runnable onTimeOut) {
        timeline=new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    seconds--;
                    onTick.run();
                    if (seconds == 0) {
                        timeline.stop();
                        onTimeOut.run();
                    }
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Resets the level seconds to the indicated value.
     * Used before starting each new level.
     * @param seconds Amount of seconds to assign for the new level.
     */
    public void resetSecond(int seconds) {
        this.seconds=seconds;
    }

    /**
     * Stops the level countdown if it is running.
     */
    public void stop(){
        if(timeline != null){
            timeline.stop();
        }
    }

    /**
     * Starts the total count of seconds for the match.
     * <p>
     *     Increments {@code totalSeconds} each second from the start
     *     of the match until {@link #stopTotalSeconds()} is called.
     * </p>
     */
    public void totalSeconds(){
        totaltime=new Timeline(
                new KeyFrame(
                        Duration.seconds(1),
                        actionEvent -> totalSeconds++
                )
        );
        totaltime.setCycleCount(Timeline.INDEFINITE);
        totaltime.play();
    }

    /**
     * Stops the total match count if it is running.
     */
    public void stopTotalSeconds() {
        if (totaltime != null) totaltime.stop();
    }

    /**
     * Returns the total seconds elapsed during the match.
     * @return Total seconds played as an integer.
     */
    public int getTotalSeconds(){
        return totalSeconds;
    }

    /**
     *Starts the timer flicker animation when time is critical.
     * <p>
     *     Activates only when {@code seconds} is less than or equal to 5.
     *     Alternates between {@code onRed} and {@code onWhite} every 300ms using the flag
     *     {@code flickerActive}, generating a visual effect of urgency.
     * </p>
     * @param onRed  Runnable executed on "active" frames (e.g.: set text to red).
     * @param onWhite Runnable executed on "inactive" frames (e.g.: set text to white).
     */
    public void switchColor(Runnable onRed, Runnable onWhite){
        colortime= new Timeline(new KeyFrame(
                Duration.millis(300),
                actionEvent ->{
                    if (seconds<=5){
                        if (flickerActive){
                            onRed.run();
                        }else{
                            onWhite.run();
                        }
                        flickerActive= !flickerActive;
                    }
                }
        ));
        colortime.setCycleCount(timeline.INDEFINITE);
        colortime.play();
    }

    /**
     * Stops the timer flicker animation if it is running.
     */
    public void stopSwitchColor() {
        if (colortime != null) colortime.stop();
    }



}




