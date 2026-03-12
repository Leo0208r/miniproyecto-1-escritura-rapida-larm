package com.example.escriturarapida.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Time {
    private int seconds=20;
    private int totalSeconds=0;
    private Timeline timeline;
    private Timeline totaltime;
    public Time(){}
    public int getSeconds(){
        return seconds;
    }
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
    public void resetSecond(int seconds) {
        this.seconds=seconds;
    }
    public void stop(){
        if(timeline != null){
            timeline.stop();
        }
    }
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
    public void stopTotalSeconds() {
        if (totaltime != null) totaltime.stop();
    }
    public int getTotalSeconds(){
        return totalSeconds;
    }

}




