package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * The WordProcessor class processes a sentence and provides functionality 
 * to find all the longest words in the sentence.
 * It contains methods to find and return the longest words in a given sentence.
 * 
 * @author Aaryan
 * @version 1.0
 */
public class WordProcessor {

    /** The sentence to process */
    private String sentence;

    /**
     * Constructs a WordProcessor object with the specified sentence.
     * 
     * @param sentence the sentence to process
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds and returns all the longest words in the sentence.
     * If the sentence is empty or null, returns an empty list.
     * 
     * @return a list of the longest words in the sentence
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();

        // Checking if the sentence is null or empty
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords; 
        }

        // Split sentence into words
        String[] words = sentence.trim().split("\\s+");

        int maxLength = 0;

        // Finding the maximum length of the words
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
