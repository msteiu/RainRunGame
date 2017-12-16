import java.io.*;
import java.util.*;

public class Score implements Comparable<Score> {
    
    private String name;
    private int score;

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int compareTo(Score anotherScore) {
        return this.score - anotherScore.score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name.length() < 12 ? name : name.substring(0, 11);
    }

    public String toString() {
        return name + RRConstants.DELIMITER + score;
    }

    public static boolean isValidName(String name) {
        return !name.contains(RRConstants.DELIMITER);
    }

    /** 
     * Will parse score in format 'name#score' and return a score object.
     */
    public static Score parseScore(String text) {
        String[] scoreArray = text.split(RRConstants.DELIMITER);
        String name = scoreArray[0].trim();
        Integer score = Integer.parseInt(scoreArray[1].trim());
        return new Score(name, score);
    }

    /**
     * Will parse a text file of scores, one on each line, and return a 
     * sorted Vector of scores in order received.
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