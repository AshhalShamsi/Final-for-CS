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
    private int score; //The cummulative sum of the distances at which the baskets were scored
    private int shots; //The total number of shots takes
    private String name; //Their name
    private String[] topScores; //Top 10 scores {Format: Name1, Score1, Name2, Score2...Score10);

    /**
     * Default Constructor -- Sets player score as 0 and name as null. Also gets list of topScores for
     * future reference.
     * @param none
     * @return You must be kidding me, it's a constructor.
     */
    public Score() throws IOException{
        score = 0; //Sets initial score
        shots = 0; //No shots have been taken yet
        name = "No1"; //Sets initial name (which is nonexistant: No1 = No-one)
        
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
     * @param double -- the x coordinate of the player
     * @param double -- the y coordinate of the player
     * @param double -- the z coordinate of the player
     * @param boolean -- Whether or not the shot was made
     * @param boolean -- Whether or not the shot was in basket 1
     *                   (the alternative being basket 2)
     * @return none
     */
    public void add(double x, double y, double z, boolean made, boolean basket1){
        double points = 0; //the number of points scored this round
        double basketX = 0; //The x coordinate of the chosen basket
        shots += 1;
        
        //Sees if the shot was made
        if (made){
            
            //if scored in the first basket, calculates distance
            //from the first basket.
            if (basket1){
                //Bucket 1 is located at (42, 0, 32.5), so basktX = 42
                basketX = 3;
            }
            
            //Calculates the points using the pythagorean theorem
            points = ((x - basketX) * (x - basketX)) + (y * y) + ((z - 32.5) * (z - 32.5));
            points = Math.sqrt(points);
                
            }
            
        score += points;
    }
    
    /**
     * Gets the score
     * @param none
     * @return int Player's current score
     */
    public int getScore(){
        return score;
    }
    
    /**
     * Gets the # of shots
     * @param none
     * @return int the number of shots taken thus far
     */
    public int getShots(){
        return shots;
    }
    
    /**
     * Gets the # of shots
     * @param none
     * @return int the number of shots taken thus far
     */
    public void addShots(){
        shots++;
    }
    
    /**
     * Gets the name
     * @param none
     * @return String player name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Changes the name
     * @param String player's new name
     * @return none
     */
    public void setName(String name){
        this.name = name;
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
     * @return none
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
                System.out.println(content.substring(0, content.indexOf("\n")));
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
        String holdName = name.substring(0, name.length());
        String tempScore;
        String holdScore = "" + score;
        
        //Sees to see where in top scores it belongs
        for (int i = 1; i < topScores.length; i += 2){
            
            //If score is higher than the one in the list, pushes everything down
            if (Integer.parseInt(topScores[i]) < Integer.parseInt(holdScore)){
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
        
        //Since we've changed the list, write the new topScore list to the file
        String info = this.toString();
        this.writeToFile("topScores.txt", info);
    }
    
    /**
     * Sees if score is a top score
     * @param none
     * @return boolean
     */
    public boolean checkScore(){
        boolean isTop = false; //To see if the current score is higher than any score in list
                               //Note: If equal to, earlier score remains higher
        
        System.out.println(topScores);
        for (int i = 1; i < topScores.length; i += 2){
            System.out.println(topScores[i]);
            if (Integer.parseInt(topScores[i]) < score){
                isTop = true;
            }
        }
        
        if (isTop == true){
            this.addScore(); //Adds the new score into scores
        }
        
        return isTop;
    }
    
    /**
     * Gets all of the topScores into a string
     * @param none
     * @return none
     */
    public String toString(){
        String info = "";//topScores[0];
        
        for (int i = 0; i < topScores.length; i++){
            info += (topScores[i] + "\n");
        }
        
        return info;
    }
    
    
}
