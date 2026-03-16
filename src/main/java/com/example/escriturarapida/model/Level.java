package com.example.escriturarapida.model;

/**
 * Model that manages the current level of the "Escritura Rápida" game.
 * <p>
 *     Controls player progress: the current level number,
 *     the increment when completing each word and the dynamic calculation
 *     of available seconds according to the level reached.
 * </p>
 * @author LEONARDO ROSERO
 * @version 1.0
 * @see com.example.escriturarapida.controller.GameController
 */
public class Level {
    /** Current level of the player. Starts at 1. */
    private int level=1;

    /**
     * Default constructor. Creates an instance of {@code Level}
     * with the initial level at 1.
     */
    public Level(){}

    /**
     * Returns the current player level.
     * @return The current level as an integer.
     */
    public int getLevel(){
        return level;
    }

    /**
     * Increments the current level by 1 and returns the value before incrementing.
     * @return The level value before being incremented.
     */
    public int incrementLevel(){
        return level++;
    }

    /**
     * Dynamically calculates the available seconds for the current level.
     * <p>
     *     Difficulty increases progressively: for every 5 completed levels,
     *     2 seconds are reduced from the initial time of 20. The guaranteed
     *     minimum is 2 seconds so the game is always possible.
     * </p>
     * <p>Examples</p>
     * <ul>
     *     <li>Levels 1–4  → 20 seconds</li>
     *     <li>Levels 5–9  → 18 seconds</li>
     *     <li>Levels 10–14 → 16 seconds</li>
     *     <li>Level 50+    → 2 seconds (minimum)</li>
     * </ul>
     * @return Seconds available for the current level (minimum 2).
     */
    public int getSecondsForLevel() {
        int initialseconds = 20 - ((level / 5) * 2);
        if (initialseconds < 2) {
            initialseconds = 2;
        }
        return initialseconds;
    }

}
