package highscore;

import java.io.Serializable;

public class Score implements Serializable {
    private int score;
    private String naam;

    /**
     * getScore will get the score
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * getNaam will get the player name
     * @return
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Score takes in the name and score and stores it into a local variable to be used when the getters are called
     * @param naam
     * @param score
     */
    public Score(String naam, int score) {
        this.score = score;
        this.naam = naam;
    }
}
