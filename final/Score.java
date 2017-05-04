/**
 * Keeps track of player's score, and also adds it to file if it's one
 * of the top 10 scores
 * 
 * @author (Payton Schubel) 
 * @version (05/04/217, Version 1)
 */

import java.util.*;
import java.text.*;
import javax.swing.*;
import java.io.*;
public class Score
{
    /** Instance Variables **/
    private int score; //How many consecutive shots they've made (which is their score)
    private String name; //Their name
    private String[] topScores; //Top 10 scores {Format: Name1, Score1, Name2, Score2...Score10);

    /**
     * Default Constructor -- Sets player score as 0 and name as null. Also gets list of topScores for
     * future reference.
     * @param none
     * @return You must be kidding me, it's a constructor.
     */
    public Score(){
        score = 0; //Sets initial score
        name = null; //Sets initial name (which is nonexistant)
        
        //Alright, here's the fun part:
        //Gets info from the topScores file about the other topScores
        Scanner file = new Scanner(new File("topScores.txt"));
        
        //Creates the topScores list
        topScores = new String[20]; //Two lines per score: One for name, other for score
       
        //Puts all of the topScores into the topScores list
        for (int i = 0; file.hasNext(); i++)
            topScores[i] = file.next();
        
    }
    
    /**
     * Adds one to score (to be called when you want to update score)
     * @param none
     * @return none
     */
    public void add(){
        score += 1;
    }

    /**
     * Resets score to 0 (to be used when shot missed
     * @param none
     * @return none
     */
    public void reset(){
        score = 0;
    }
    
    /**
     * Sees if score is a top score
     * @param none
     * @return none
     */
    public void checkScore(){
        boolean isTop = false; //To see if the current score is higher than any score in list
                               //Note: If equal to, earlier score remains higher
        
        for (int i = 1; i < topScore.length; i += 2){
            if (topScore[i].parseInt() < score){
                isTop = true;
            }
        }
    }
}
