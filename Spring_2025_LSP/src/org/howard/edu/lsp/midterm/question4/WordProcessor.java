package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

public class WordProcessor {
	

    private String sentence; 
    
    

    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    // Method to find all longest words in the sentence
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        
        //checking if sentence is null. 
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords; 
        }

        
        
        String[] words = sentence.trim().split("\\s+");

        int maxLength = 0;

        
        //finding the maximum length
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        // Collect all words with the maximum length
        for (String word : words) {
            if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }

        return longestWords;
    }
}
