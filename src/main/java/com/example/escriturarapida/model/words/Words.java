package com.example.escriturarapida.model.words;

import java.util.ArrayList;
import java.util.Random;

/**
 * Implementation of {@link IWords} that manages all words in the game
 * "Escritura Rápida".
 * <p>
 *     Stores three lists of words classified by difficulty:
 *     low, medium and high. Provides methods to generate random words,
 *     validate answers, remove used words and select the correct list
 *     according to the player's level.
 * </p>
 * <p>Level distribution </p>
 * <ul>
 *     <li>Levels 1–14  → Hard words ({@code hardLevelWords})</li>
 *     <li>Levels 15–25 → Medium words ({@code mediumLevelWords})</li>
 *     <li>Levels 26+   → Easy words ({@code lowLevelWords})</li
 * </ul>
 * @author LEONARDO ROSERO
 * @version 1.0
 * @see IWords
 * @see com.example.escriturarapida.controller.GameController
 */
public class Words implements IWords {
    /** List of low difficulty words (short and common words). */
    private final ArrayList<String>lowLevelWords= new ArrayList<>();
    /** List of medium difficulty words (moderate length words). */
    private final ArrayList<String>mediumLevelWords= new ArrayList<>();
    /** List of high difficulty words (long or compound words). */

    private final ArrayList<String>hardLevelWords= new ArrayList<>();

    /**
     * Constructor that initializes the three word lists with their
     * predefined content for each difficulty level.
     */
    public Words(){
        lowLevelWords.add("carro");
        lowLevelWords.add("perro");
        lowLevelWords.add("casa");
        lowLevelWords.add("sol");
        lowLevelWords.add("mesa");
        lowLevelWords.add("luna");
        lowLevelWords.add("gato");
        lowLevelWords.add("vaca");
        lowLevelWords.add("nube");
        lowLevelWords.add("flor");
        lowLevelWords.add("planeta");
        lowLevelWords.add("mano");
        lowLevelWords.add("cielo");
        lowLevelWords.add("correr");
        lowLevelWords.add("tren");
        lowLevelWords.add("foto");
        lowLevelWords.add("libro");
        lowLevelWords.add("rama");
        lowLevelWords.add("silla");
        lowLevelWords.add("arroz");
        lowLevelWords.add("sopa");
        lowLevelWords.add("miel");
        lowLevelWords.add("pera");
        lowLevelWords.add("leche");
        lowLevelWords.add("rojo");
        lowLevelWords.add("azul");
        lowLevelWords.add("pie");
        lowLevelWords.add("bola");
        lowLevelWords.add("boca");
        lowLevelWords.add("cara");
        lowLevelWords.add("gris");
        lowLevelWords.add("pelo");
        lowLevelWords.add("llave");
        lowLevelWords.add("chico");
        lowLevelWords.add("choco");
        lowLevelWords.add("cali");
        lowLevelWords.add("isla");
        lowLevelWords.add("rio");

        mediumLevelWords.add("ventana");
        mediumLevelWords.add("camino");
        mediumLevelWords.add("escuela");
        mediumLevelWords.add("cuaderno");
        mediumLevelWords.add("persona");
        mediumLevelWords.add("montana");
        mediumLevelWords.add("sonrisa");
        mediumLevelWords.add("mercado");
        mediumLevelWords.add("viajero");
        mediumLevelWords.add("pintura");
        mediumLevelWords.add("cocina");
        mediumLevelWords.add("ciudad");
        mediumLevelWords.add("familia");
        mediumLevelWords.add("pelota");
        mediumLevelWords.add("puerta");
        mediumLevelWords.add("madera");
        mediumLevelWords.add("historia");
        mediumLevelWords.add("GameOver");
        mediumLevelWords.add("teclado");
        mediumLevelWords.add("reloj");
        mediumLevelWords.add("SceneBuilder");
        mediumLevelWords.add("intelliJ IDEA");

        hardLevelWords.add("computadora");
        hardLevelWords.add("programacion");
        hardLevelWords.add("desarrollo");
        hardLevelWords.add("arquitectura");
        hardLevelWords.add("administracion");
        hardLevelWords.add("responsable");
        hardLevelWords.add("matematica");
        hardLevelWords.add("electricidad");
        hardLevelWords.add("universidad");
        hardLevelWords.add("laboratorio");
        hardLevelWords.add("extraordinario");
        hardLevelWords.add("caracteristica");
        hardLevelWords.add("documentacion");
        hardLevelWords.add("investigacion");
        hardLevelWords.add("internacional");
        hardLevelWords.add("organizacion");
        hardLevelWords.add("comunicacion");
        hardLevelWords.add("probabilidad");
        hardLevelWords.add("estadistica");
        hardLevelWords.add("representacion");
        hardLevelWords.add("Paralelepípedo");
    }

    /**
     * Returns the list of low difficulty words.
     * @return {@code ArrayList} with the easy words.
     */
    public ArrayList<String> getLowLevelWords(){
        return lowLevelWords;
    }

    /**
     * Returns the list of medium difficulty words.
     * @return {@code ArrayList} with the medium difficulty words.
     */
    public ArrayList<String> getMediumLevelWords(){
        return mediumLevelWords;
    }

    /**
     * Returns the list of high difficulty words.
     * @return {@code ArrayList} with the difficult words.
     */
    public ArrayList<String> getHardLevelWords(){
        return hardLevelWords;
    }

    /**
     * Selects and returns a random word from the provided list.
     * @param words List of words from which to choose randomly.
     * @return A randomly chosen word.
     */
    @Override
    public String generateWord(ArrayList<String> words) {

        Random random= new Random();
        String word=words.get(random.nextInt(words.size()));
        return word;
    }

    /**
     * Verifies if the entered word exists in the given list.
     * @param word The word written by the player.
     * @param words The list of valid words for the current level.
     * @return {@code true} if the word is in the list, {@code false} otherwise.
     */
    @Override
    public Boolean validateWord(String word, ArrayList<String> words) {
        return words.contains(word);
    }

    /**
     * Selects and returns the list of words corresponding to the given level.
     * <p>
     *     The selection logic is inverse to the expected difficulty: the first
     *     levels use difficult words and the last levels use easy words,
     *     which increases the pressure at the beginning of the match.
     * </p>
     * @param level The current player level.
     * @return The word list assigned to the level range:
     *         hard (1–14), medium (15–25) or easy (26+).
     */
    public ArrayList<String> choiceArrayByLevel(int level){
        ArrayList<String>levelArray= new ArrayList<>();
        if (level<=14){
            levelArray=hardLevelWords;
        }
        else if (level>14 && level<=25){
            levelArray=mediumLevelWords;
        }
        else if (level>25){
            levelArray=lowLevelWords;
        }
        return levelArray;
    }

    /**
     * Removes the indicated word from the given list after being used correctly.
     * <p>This prevents the same word from appearing twice in the same match.</p>
     * @param word The word to remove.
     * @param words The list from which the word will be removed.
     */
    public void removeWord(String word, ArrayList<String> words){
        words.remove(words.indexOf(word));
    }
}
