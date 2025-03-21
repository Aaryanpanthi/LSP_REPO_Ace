/**
 * The VotingMachine class simulates a voting system that supports any number of candidates.
 * It allows adding candidates, casting votes, displaying election results, and determining the winner.
 */
package org.howard.edu.lsp.midterm.question3;

import java.util.*;

public class VotingMachine {

    private Map<String, Integer> candidates;

    /**
     * Constructs a new VotingMachine with an empty list of candidates.
     */
    public VotingMachine() {
        candidates = new HashMap<>();
    }

    /**
     * Adds a candidate to the voting system if they do not already exist.
     *
     * @param candidateName The name of the candidate to add.
     */
    public void addCandidate(String candidateName) {
        if (!candidates.containsKey(candidateName)) {
            candidates.put(candidateName, 0);
        } else {
            System.out.println("Candidate " + candidateName + " already exists.");
        }
    }

    /**
     * Casts a vote for a candidate if they exist in the system.
     *
     * @param name The name of the candidate to vote for.
     * @return true if the vote was successfully cast, false if the candidate does not exist.
     */
    public boolean castVote(String name) {
        if (!candidates.containsKey(name)) {
            return false;
        }
        candidates.put(name, candidates.get(name) + 1);
        return true;
    }

    /**
     * Displays the results of the election, showing the number of votes each candidate received.
     */
    public void displayResults() {
        System.out.println("Election Results:");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    /**
     * Determines the winner of the election based on the candidate with the most votes.
     *
     * @return A string indicating the winner and their vote count, or a message if no votes were cast.
     */
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
        return winner + " with " + maxVotes + " votes.";
    }
}