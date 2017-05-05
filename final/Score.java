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
     * The method used to write to the file
     * @param String fileName: The file to write the content to
     * @param String content: What you want to write to the file
     * @return none START HERE TO CLEAN STUFF UP
     */
    private void writeToFile (String fileName, String content) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            //Gets the file to write the info into
            fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);
            
            //Writes the content into the file with newLines where appropriate
            while (content.indexOf("\n") >= 0){
                //Writes the given info into the file up to the newLine
                bw.write(content.substring(0, content.indexOf("\n")));
                
                //Adds the newLine
                bw.newLine();
                
                //Slices down the size of content to not include whatever
                //was just writen into the file.
                content = content.substring(content.indexOf("\n")+1, content.length());
            }
            
        } catch (IOException e) {
            //Says if there's an error
            e.printStackTrace();
        } finally {
            try {
                //Closes the file
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }    
    
    /**
     * Adds a score to the topScores array, then writes the array to the file.
     * Is private, because I only want to write scores if the checkScore says
     * it's appropriate. It will add the score in there if it should be added.
     * @param none
     * @return none
     */
    private void addScore(){
        //Makes a tempScore and tempName for swaps (also a holdScore & holdName, 
        //so that I can change it w/o changing the actual score & name).
        String tempName;
        String holdName = name.substring(0);
        int tempScore;
        int holdScore = score;
        
        //Sees to see where in top scores it belongs
        for (int i = 1; i < topScores.length; i += 2){
            
            //If score is higher than the one in the list, pushes everything down
            if (topScores[i] < holdScore){
                //Gets the information from the list
                tempScore = topScores[i];
                tempName = topScores[i-1];
                
                //Assigns the holdScore and holdName to the list
                topScores[i] = holdScore;
                topScores[i-1] = holdName;
                
                //Assigns the temps to the holds (now, this means that once the original holdScore
                //and holdName are added to the list, everything will get pushed down from there).
                holdScore = tempScore;
                holdName = tempName.substring(0);
            }
        }
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
        
        if (isTop == true); //START HERE WITH THE PRIVATE METHOD
    }
    
}
