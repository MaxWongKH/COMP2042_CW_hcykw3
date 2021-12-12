package highscore;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class HighScore{

    // An arraylist of the type "score" used to work with the scores inside the class
    private ArrayList<Score> scores;

    // The name of the file where the highscores will be saved
    private static final String HIGHSCOREFILE = "HighScore.dat";

    //Initialising an in and outputStream for working with the file
    ObjectOutputStream output = null;
    ObjectInputStream input = null;

    /***
     * HighScore initialising the scores-arraylist
     */
    public HighScore() {
        scores = new ArrayList<Score>();
    }

    /***
     * getScores retrieves the scores from the highscore file
     * @return scores
     */
    public ArrayList<Score> getScores() {
        loadScoreFile();
        sort();
        return scores;
    }

    /***
     * sort creates a comparotor object to pass into the ScoreCompare class
     */
    private void sort() {
        ScoreCompare comparator = new ScoreCompare();
        Collections.sort(scores, comparator);
    }

    /**
     * addScore loads the highscore file and adds a new score to the file then calls the updateScoreFile method
     * @param name player name
     * @param score player score
     */
    public void addScore(String name, int score) {
        loadScoreFile();
        scores.add(new Score(name, score));
        updateScoreFile();
    }

    /***
     * loadScoreFile loads the highscore file
     */
    public void loadScoreFile() {
        try {
            input = new ObjectInputStream(new FileInputStream(HIGHSCOREFILE));
            scores = (ArrayList<Score>) input.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[Laad] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Laad] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Laad] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (output != null) {
                    output.flush();
                    output.close();
                }
            } catch (IOException e) {
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
        }
    }

    /**
     * updateScoreFile will make the new changes when its called
     */
    public void updateScoreFile() {
        try {
            output = new ObjectOutputStream(new FileOutputStream(HIGHSCOREFILE));
            output.writeObject(scores);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (output != null) {
                    output.flush();
                    output.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }

    /**
     * getHighscoreString returns the text on the highscore file
     * @return highscore string
     */
    public String getHighscoreString() {
        String highScoreString = "";
        int max = 10; //maximum display HighScore

        ArrayList<Score> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highScoreString += (i + 1) + ".\t" + scores.get(i).getNaam() + "\t\t" + scores.get(i).getScore() + "\n";
            i++;
        }
        return highScoreString;
    }

}



