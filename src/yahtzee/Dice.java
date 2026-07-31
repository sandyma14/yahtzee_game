/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yahtzee;

import java.util.Random;

/**
 *
 * @author sma10
 */
public class Dice {

    //_______________________Variables__________________________
    private final int NUM_DICE;

    //__________________Constructor_________________________
    public Dice() {
        NUM_DICE = 5;
    }

    //____________________________Methods________________________
    public static int[] rollDice(int numDice) {
        Random random = new Random();
        int[] diceRoll = new int[numDice];
        int roll;

        for (int i = 0; i < diceRoll.length; i++) {
            roll = random.nextInt(6) + 1;
            diceRoll[i] = roll;
        }

        return diceRoll;
    }

    public static int[] rerollDice(int[] diceRoll, int[] lockedIndexes) {
        Random random = new Random();
        int[] newDiceRoll = new int[5];
        int roll;
        boolean foundLocked;
        // Loop through to check if the index is locked
        for (int i = 0; i < diceRoll.length; i++) {
            foundLocked = false;
            for (int j = 0; j < lockedIndexes.length; j++) {
                //If the index of diceRoll is locked don't reroll, add to the new array
                if (i == lockedIndexes[j]) {
                    newDiceRoll[i] = diceRoll[i];
                    foundLocked = true;
                    break;
                }
            }
            //If the index is not found in locked indexes reroll
            if (!foundLocked) {
                roll = random.nextInt(6) + 1;
                newDiceRoll[i] = roll;
            }
        }

        return newDiceRoll;
    }
}
