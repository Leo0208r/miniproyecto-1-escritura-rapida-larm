package com.example.escriturarapida.model.words;

import java.util.ArrayList;

/**
 * Interface that defines the contract for word operations
 * in the "Escritura Rápida" game.
 * <p>
 *     Any class implementing this interface must be capable of
 *     generating a random word from a given list and validating if
 *     a word entered belongs to that list.
 * </p>
 * @author LEONARDO ROSERO
 * @version 1.0
 * @see Words
 */
public interface IWords {
    /**
     * Selects and returns a random word from the provided list.
     * @param words List of words from which to choose randomly.
     * @return A word randomly selected from {@code words}.
     */
    String generateWord(ArrayList<String> words);

    /**
     * Verifies if the word entered by the player exists in the given list.
     * @param word The word the player wrote.
     * @param words The list of valid words for the current level.
     * @return {@code true} if {@code word} is in {@code words}, {@code false} otherwise.
     */
    Boolean validateWord(String word, ArrayList<String> words);

}
