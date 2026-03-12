package com.example.escriturarapida.model;

public class Level {
    private int level=1;
    public Level(){}
    public int getLevel(){
        return level;
    }
    public int incrementLevel(){
        return level++;
    }
    public int resetLevel(){
        return level=1;
    }
    public int getSecondsForLevel() {
        int initialseconds = 20 - ((level / 5) * 2);
        if (initialseconds < 2) {
            initialseconds = 2;
        }
        return initialseconds;
    }

}
