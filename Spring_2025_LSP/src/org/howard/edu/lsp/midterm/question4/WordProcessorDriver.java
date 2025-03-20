package org.howard.edu.lsp.midterm.question4;

import java.util.List;

public class WordProcessorDriver {
    public static void main(String[] args) {
        WordProcessor wp4 = new WordProcessor("This is a test with amazing results, amazing achievements!");
        List<String> longestWords4 = wp4.findLongestWords();
        System.out.println("Test 4 - Longest words: " + longestWords4);  
       


        WordProcessor wp2 = new WordProcessor("Java is a powerful  tool!");
        List<String> longestWords2 = wp2.findLongestWords();
        System.out.println("Test 2 - Longest words: " + longestWords2);  


        // Test case 5: Sentence with single character words
        WordProcessor wp5 = new WordProcessor("A B C D E");
        List<String> longestWords5 = wp5.findLongestWords();
        System.out.println("Test 5 - Longest words: " + longestWords5);  
        // Expected Output: ["A", "B", "C", "D", "E"]

        // Test case 6: Empty string input
        WordProcessor wp6 = new WordProcessor("");
        List<String> longestWords6 = wp6.findLongestWords();
        System.out.println("Test 6 - Longest words: " + longestWords6);  
        // Expected Output: []


     
    }
}