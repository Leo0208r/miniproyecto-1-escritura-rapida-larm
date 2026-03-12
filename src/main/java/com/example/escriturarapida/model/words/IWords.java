package com.example.escriturarapida.model.words;

import java.util.ArrayList;

public interface IWords {
    String generateWord(ArrayList<String> words);
    Boolean validateWord(String word, ArrayList<String> words);

}
