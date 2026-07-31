/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yahtzee;

/**
 *
 * @author sma10
 */
public class Player {

    //_______________Vairables____________________
    private final int MAX_NUM_ROLL;
    private int numRollLeft;
    ScoreBoard scoreBoard;
    private static int numPlayer;
    private int tempScore;
    private String scoreType;
    private String playerName;

    //_____________Constructor________________
    public Player(String name, int numRollLeft, ScoreBoard scoreBoard) {
        this.numRollLeft = numRollLeft;
        this.scoreBoard = scoreBoard;
        this.MAX_NUM_ROLL = 3;
        this.tempScore = -1;
        this.scoreType = null;
        this.playerName = name;
        numPlayer++;
    }

    //___________Methods________________________
    //Getters
    public int getMAX_NUM_ROLL() {
        return MAX_NUM_ROLL;
    }

    public int getNumRollLeft() {
        return numRollLeft;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public static int getNumPlayer() {
        return numPlayer;
    }

    public int getTempScore() {
        return tempScore;
    }

    public String getScoreType() {
        return scoreType;
    }

    public String getPlayerName() {
        return playerName;
    }

    //Setters
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setTempScore(int tempScore) {
        this.tempScore = tempScore;
    }

    public void setNumRollLeft(int numRollLeft) {
        this.numRollLeft = numRollLeft;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }

    public static void setNumPlayer(int numPlayer) {
        Player.numPlayer = numPlayer;
    }

}
