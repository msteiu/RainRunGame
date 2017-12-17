/**
 * FILENAME: Score
 * DESCRIPTION: Class that represents a Score object holding the score and
 * the name of the person who attained that score.
 * @author Angelina Li
 */

import java.io.*;
import java.util.*;

public class Score implements Comparable<Score> {
    
    private String name; // name of person who scored this score
    private int score; // score value

    /**
     * Constructor that initializes a Score object
     * @param String name - name of person who scored this
     * @param int score - value of the score they received
     */
    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Will return the difference between the current score and the score of a
     * given Score object
     * @param Score anotherScore - comparison Score object
     * @return an integer, greater than 1 if this score is larger than the
     * comparison score, equal 0 if this score is equal to the
     * comparison score, and less than 1 if this score is smaller than the
     * comparison score.
     */
    public int compareTo(Score anotherScore) {
        return this.score - anotherScore.score;
    }

    /**
     * Get the score associated with this Score obj
     * @return score associated with this Score obj
     */
    public int getScore() {
        return score;
    }

    /**
     * Will return the name associated with this Score, or a truncated version
     * of the name if this name is too long (greater than 12 chars in length)
     * @return a String representation of this Score's name
     */
    public String getName() {
        return name.length() < 12 ? name : name.substring(0, 11);
    }

    /**
     * Will return a String representation of this object, in the format used
     * to represent Scores inside scores.txt
     * @return String representation of this Score
     */
    public String toString() {
        return name + RRConstants.DELIMITER + score;
    }

    /**
     * Will return whether the given name is a valid name (does not contain the
     * delimiter used to split a Score string in two).
     * @param String name to check
     * @return Whether this name is a valid name
     */
    public static boolean isValidName(String name) {
        return !name.contains(RRConstants.DELIMITER);
    }

    /** 
     * Will parse score in the String format 'name#score' and return a score object.
     * @param String text to parse into a Score objet
     * @return Score object parsed from text
     */
    public static Score parseScore(String text) {
        String[] scoreArray = text.split(RRConstants.DELIMITER);
        String name = scoreArray[0].trim();
        Integer score = Integer.parseInt(scoreArray[1].trim());
        return new Score(name, score);
    }

    /**
     * Will parse a text file of scores, one on each line, and return a 
     * sorted Vector of scores in the order they were read.
     * @param String filepath to read from
     * @return Vector of scores read from this file
     */
    public static Vector<Score> parseScoresFromFile(String filepath) throws FileNotFoundException {
        Vector<Score> scores = new Vector<Score>();
        Scanner fileReader = new Scanner(new File(filepath));

        while(fileReader.hasNext()) {
            scores.add(parseScore(fileReader.nextLine()));
        }

        fileReader.close();
        return scores;
    }
}