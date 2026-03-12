package com.example.escriturarapida.model.words;

import java.util.ArrayList;
import java.util.Random;

public class Words implements IWords {
    private final ArrayList<String>lowLevelWords= new ArrayList<>();
    private final ArrayList<String>mediumLevelWords= new ArrayList<>();
    private final ArrayList<String>hardLevelWords= new ArrayList<>();

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
        hardLevelWords.add("¡Electroencefalografista!");
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
        hardLevelWords.add("Desoxirribonucleotido");
        hardLevelWords.add("Paralelepípedo");
    }
    public ArrayList<String> getLowLevelWords(){
        return lowLevelWords;
    }
    public ArrayList<String> getMediumLevelWords(){
        return mediumLevelWords;
    }
    public ArrayList<String> getHardLevelWords(){
        return hardLevelWords;
    }

    @Override
    public String generateWord(ArrayList<String> words) {

        Random random= new Random();
        String word=words.get(random.nextInt(words.size()));
        return word;
    }

    @Override
    public Boolean validateWord(String word, ArrayList<String> words) {
        return words.contains(word);
    }
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
    public void removeWord(String word, ArrayList<String> words){
        words.remove(words.indexOf(word));
    }
}
