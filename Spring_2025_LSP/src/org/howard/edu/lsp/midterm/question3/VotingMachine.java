//The voting machine should support any number of candidates.
//2.	Each vote is recorded for a candidate by their name.
//3.	The system should prevent votes for non-existent candidates. 
//4.	The system should be able to display the total votes per candidate and determine the winner.
//


package org.howard.edu.lsp.midterm.question3;

import java.io.*;
import java.util.*;

public class VotingMachine {
	
	private Map<String, Integer> candidates;
	
	public VotingMachine() {
        candidates = new HashMap<>();
    }
				
	
	//adding and checking candidates
	
	 public void addCandidate(String candidateName) {
	        if (!candidates.containsKey(candidateName)) {
	            candidates.put(candidateName, 0);
	            
	        } else {
	            System.out.println("Candidate " + candidateName + " already exists.");
	        }
	
	 }
	  
	 public boolean castVote(String name) {
	        if (!candidates.containsKey(name)) {
	            return false;
	        }
	        
	        candidates.put(name, candidates.get(name) + 1);
	        System.out.println(candidates);
	        return true;
	    }
	
    
    
    public void displayResults() {
        System.out.println("Election Results:");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
    
    
    public String getWinner() {
        String winner = null;
        int maxVotes = -1;

        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        if (winner == null) {
            return "No winner (no votes cast).";
        }
        return "Winner: " + winner + " with " + maxVotes + " votes.";
    }
    
	

}
