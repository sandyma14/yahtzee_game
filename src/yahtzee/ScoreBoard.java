/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yahtzee;

/**
 *
 * @author sma10
 */
public class ScoreBoard {

    //_______________________________________Variables_________________________________
    private int onesValue, twosValue, threesValue, foursValue, fivesValue, sixsValue;
    private int threeOfAKindValue, fourOfAKindValue, fullHouseValue, smallSeqValue, largeSeqValue, yahtzeeValue, chanceValue;
    private int totalUpperSection;
    private int grandTotal;
    private int numYahtzee;
    private boolean upperBonusAwarded;

    //_______________________________Constructors____________________
    public ScoreBoard() {
        //Set all values to -1 for default
        onesValue = -1;
        twosValue = -1;
        threesValue = -1;
        foursValue = -1;
        fivesValue = -1;
        sixsValue = -1;
        threeOfAKindValue = -1;
        fourOfAKindValue = -1;
        fullHouseValue = -1;
        smallSeqValue = -1;
        largeSeqValue = -1;
        yahtzeeValue = -1;
        chanceValue = -1;
        totalUpperSection = 0;
        grandTotal = 0;
        numYahtzee = 0;
        upperBonusAwarded = false;
    }

    //_______________________________Methods___________________________
    //-------------------------Getters-----------------------------
    public int getOnesValue() {
        return onesValue;
    }

    public int getTwosValue() {
        return twosValue;
    }

    public int getThreesValue() {
        return threesValue;
    }

    public int getFoursValue() {
        return foursValue;
    }

    public int getFivesValue() {
        return fivesValue;
    }

    public int getSixsValue() {
        return sixsValue;
    }

    public int getThreeOfAKindValue() {
        return threeOfAKindValue;
    }

    public int getFourOfAKindValue() {
        return fourOfAKindValue;
    }

    public int getFullHouseValue() {
        return fullHouseValue;
    }

    public int getSmallSeqValue() {
        return smallSeqValue;
    }

    public int getLargeSeqValue() {
        return largeSeqValue;
    }

    public int getYahtzeeValue() {
        return yahtzeeValue;
    }

    public int getChanceValue() {
        return chanceValue;
    }

    public int getTotalUpperSection() {
        return totalUpperSection;
    }

    public int getGrandTotal() {
        return grandTotal;
    }

    public int getNumYahtzee() {
        return numYahtzee;
    }

    public boolean isUpperBonusAwarded() {
        return upperBonusAwarded;
    }

    //----------------------Setters----------------
    public void setOnesValue(int onesValue) {
        this.onesValue = onesValue;
        if (onesValue != -1) { // Only add the score to total if the value is not -1 
            // This is to handle the scenerio where the score was loaded from the txt file
            this.totalUpperSection += this.onesValue;
            this.grandTotal += this.onesValue;
        }
        checkUpperBonus(); // Check for bonus
    }

    public void setTwosValue(int twosValue) {
        this.twosValue = twosValue;
        if (twosValue != -1) {
            this.totalUpperSection += this.twosValue;
            this.grandTotal += this.twosValue;
        }
        checkUpperBonus(); // Check for bonus
    }

    public void setThreesValue(int threesValue) {
        this.threesValue = threesValue;
        if (threesValue != -1) {
            this.totalUpperSection += this.threesValue;
            this.grandTotal += this.threesValue;
        }
        checkUpperBonus(); // Check for bonus
    }

    public void setFoursValue(int foursValue) {
        this.foursValue = foursValue;
        if (foursValue != -1) {
            this.totalUpperSection += this.foursValue;
            this.grandTotal += this.foursValue;
        }
        checkUpperBonus(); // Check for bonus
    }

    public void setFivesValue(int fivesValue) {
        this.fivesValue = fivesValue;
        if (fivesValue != -1) {
            this.totalUpperSection += this.fivesValue;
            this.grandTotal += this.fivesValue;
        }
        checkUpperBonus(); // Check for bonus
    }

    public void setSixsValue(int sixsValue) {
        this.sixsValue = sixsValue;
        if (sixsValue != -1) {
            this.totalUpperSection += this.sixsValue;
            this.grandTotal += this.sixsValue;
        }
        checkUpperBonus(); // Check for bonus
    }

    public void setThreeOfAKindValue(int threeOfAKindValue) {
        this.threeOfAKindValue = threeOfAKindValue;
        if (threeOfAKindValue != -1) {
            this.grandTotal += this.threeOfAKindValue;
        }
    }

    public void setFourOfAKindValue(int fourOfAKindValue) {
        this.fourOfAKindValue = fourOfAKindValue;
        if (fourOfAKindValue != -1) {
            this.grandTotal += this.fourOfAKindValue;
        }
    }

    public void setFullHouseValue(int fullHouseValue) {
        this.fullHouseValue = fullHouseValue;
        if (fullHouseValue != -1) {
            this.grandTotal += this.fullHouseValue;
        }
    }

    public void setSmallSeqValue(int smallSeqValue) {
        this.smallSeqValue = smallSeqValue;
        if (smallSeqValue != -1) {
            this.grandTotal += this.smallSeqValue;
        }
    }

    public void setLargeSeqValue(int largeSeqValue) {
        this.largeSeqValue = largeSeqValue;
        if (largeSeqValue != -1) {
            this.grandTotal += this.largeSeqValue;
        }
    }

    public void setYahtzeeValue(int yahtzeeValue) {
        // This is only for the first yahtzee
        this.yahtzeeValue = yahtzeeValue;
        if (this.yahtzeeValue != -1) {
            this.grandTotal += this.yahtzeeValue;
        }
    }

    public void setChanceValue(int chanceValue) {
        this.chanceValue = chanceValue;
        if (chanceValue != -1) {
            this.grandTotal += this.chanceValue;
        }
    }

    public void setTotalUpperSection(int totalUpperSection) {
        this.totalUpperSection = totalUpperSection;
    }

    public void setGrandTotal(int grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void setNumYahtzee(int numYahtzee) {
        this.numYahtzee = numYahtzee;
    }

    //__________________Upper Section Point Calculation Methods_____________________
    public int pointsOnes(int[] roll) {
        //Check the number of ONES in the array
        int numOnes = 0;
        for (int i = 0; i < roll.length; i++) {
            if (roll[i] == 1) {
                numOnes++;
            }
        }
        //Return the points player would get
        return numOnes * 1;
    }

    public int pointsTwos(int[] roll) {
        //Check the number of TWOS in the array
        int numTwos = 0;
        for (int i = 0; i < roll.length; i++) {
            if (roll[i] == 2) {
                numTwos++;
            }
        }
        //Return the points player would get
        return numTwos * 2;
    }

    public int pointsThrees(int[] roll) {
        //Check the number of THREE in the array
        int numThrees = 0;
        for (int i = 0; i < roll.length; i++) {
            if (roll[i] == 3) {
                numThrees++;
            }
        }
        //Return the points player would get
        return numThrees * 3;
    }

    public int pointsFours(int[] roll) {
        //Check the number of FOURS in the array
        int numFours = 0;
        for (int i = 0; i < roll.length; i++) {
            if (roll[i] == 4) {
                numFours++;
            }
        }
        //Return the points player would get
        return numFours * 4;
    }

    public int pointsFives(int[] roll) {
        //Check the number of FIVES in the array
        int pointsFives = 0;
        for (int i = 0; i < roll.length; i++) {
            if (roll[i] == 5) {
                pointsFives++;
            }
        }
        //Return the points player would get
        return pointsFives * 5;
    }

    public int pointsSixs(int[] roll) {
        //Check the number of SIXS in the array
        int numSixs = 0;
        for (int i = 0; i < roll.length; i++) {
            if (roll[i] == 6) {
                numSixs++;
            }
        }
        //Return the points player would get
        return numSixs * 6;
    }

    public int upperSectionBonus(int totalUp) {
        if (totalUp >= 63) {
            return 35;
        } else {
            return 0;
        }
    }

    //____________________Lower Section Calculation Methods_____________________
    public int pointsThreeOfAKind(int[] roll) {
        int numSame = 0;
        int highestNumSame = 0;
        // Goal is to find if the array contain a 3 dice of the same value
        //Check through 1-6
        for (int i = 1; i <= 6; i++) {
            numSame = 0;
            // If the current dice is the same as the number we want to find. Add to numSame.
            for (int j = 0; j < roll.length; j++) {
                if (roll[j] == i) {
                    numSame++;
                }
            }
            // If the numSame is higher than the highest, update
            if (numSame > highestNumSame) {
                highestNumSame = numSame;
            }
        }
        //If the array contain 3 of the same kind then find the sum of the dice
        if (highestNumSame >= 3) {
            int sumAllDice = 0;
            for (int k = 0; k < roll.length; k++) {
                sumAllDice += roll[k];
            }
            return sumAllDice;
        } else {
            return 0;
        }
    }

    public int pointsFourOfAKind(int[] roll) {
        int numSame = 0;
        int highestNumSame = 0;
        // Goal is to find if the array contain a 4 dice of the same value
        //Check through 1-6
        for (int i = 1; i <= 6; i++) {
            numSame = 0;
            // If the current dice is the same as the number we want to find. Add to numSame.
            for (int j = 0; j < roll.length; j++) {
                if (roll[j] == i) {
                    numSame++;
                }
            }
            // If the numSame is higher than the highest, update
            if (numSame > highestNumSame) {
                highestNumSame = numSame;
            }
        }
        //If the array contain 4 of the same kind then find the sum of the dice
        if (highestNumSame >= 4) {
            int sumAllDice = 0;
            for (int k = 0; k < roll.length; k++) {
                sumAllDice += roll[k];
            }
            return sumAllDice;
        } else {
            return 0;
        }
    }

    public int pointsFullHouse(int[] roll) {
        int numOne = 0, numTwo = 0, numThree = 0, numFour = 0, numFive = 0, numSix = 0;
        //Loop through the array, check and store the number of each value
        for (int i = 0; i < roll.length; i++) {
            if (roll[i] == 1) {
                numOne++;
            } else if (roll[i] == 2) {
                numTwo++;
            } else if (roll[i] == 3) {
                numThree++;
            } else if (roll[i] == 4) {
                numFour++;
            } else if (roll[i] == 5) {
                numFive++;
            } else if (roll[i] == 6) {
                numSix++;
            }
        }
        //If there are 3 dices of the same value and 2 dices of the same value 
        if (numOne == 3 || numTwo == 3 || numThree == 3 || numFour == 3 || numFive == 3 || numSix == 3) {
            if (numOne == 2 || numTwo == 2 || numThree == 2 || numFour == 2 || numFive == 2 || numSix == 2) {
                //Points = 25
                return 25;
            }
        }
        return 0;
    }

    public int pointsSmallSeq(int[] roll) {
        //Create a copy of array and sort it.
        int[] copyRoll = roll.clone();
        insertionSort(copyRoll);
        //Loop through the array and see how many dices are consecutive  
        int lengthSeq = 1;
        for (int i = 1; i < copyRoll.length; i++) {
            if (copyRoll[i] == (copyRoll[i - 1] + 1)) {
                lengthSeq++;
                //If we found 4 consecutive return 30
                if (lengthSeq >= 4) {
                    return 30;
                }
            } else if (copyRoll[i] != copyRoll[i - 1]) {
                //Reset the counter to 1if it is not a duplicate pair
                lengthSeq = 1;
            }
        }
        return 0;
    }

    public int pointsLargeSeq(int[] roll) {
        //Create a copy of array and sort it.
        int[] copyRoll = roll.clone();
        insertionSort(copyRoll);
        //Loop through the array and see how many dices are consecutive  
        int lengthSeq = 1;
        for (int i = 1; i < copyRoll.length; i++) {
            if (copyRoll[i] == (copyRoll[i - 1] + 1)) {
                lengthSeq++;
                //If we found 4 consecutive return 30
                if (lengthSeq >= 5) {
                    return 40;
                }
            } else if (copyRoll[i] != copyRoll[i - 1]) {
                //Reset the counter to 1if it is not a duplicate pair
                lengthSeq = 1;
            }
        }
        return 0;
    }

    public int pointsYahtzee(int[] roll) {
        //Create a copy of array and sort it.
        int[] copyRoll = roll.clone();
        insertionSort(copyRoll);
        //Loop through the array and see how many dices are the same
        int numSame = 0;
        for (int i = 1; i < copyRoll.length; i++) {
            if (copyRoll[i] == copyRoll[i - 1]) {
                numSame++;
            }
        }
        //If 5 same, get 50 points
        if (numSame == 4) {
            return 50;
        }
        return 0;
    }

    public void addYahtzeeBonus() {
        //add bonus if more than one yatzee
        this.yahtzeeValue += 100;
        this.grandTotal += 100;
    }
    
    public void increaseNumYahtzee(){
        this.numYahtzee++;
    }
    

    public int pointsChance(int[] roll) {
        //Simply add value of all dice together
        int sumAllDice = 0;
        for (int i = 0; i < roll.length; i++) {
            sumAllDice += roll[i];
        }
        return sumAllDice;
    }

    //_______________________Helper Methods______________________
    private void insertionSort(int[] numbers) {
        int last = 0;
        for (int i = 1; i < numbers.length; i++) { //number of passes    
            for (int j = i; j > 0; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    last = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = last;
                } else {
                    break;
                }
            }
        }
    }

    //Only give the upperBonus if meet the 63 points and has not be applied yet
    private void checkUpperBonus() {
        if (!upperBonusAwarded && this.totalUpperSection >= 63) {
            this.upperBonusAwarded = true;
            this.totalUpperSection += 35;
            this.grandTotal += 35;
        }
    }

}
