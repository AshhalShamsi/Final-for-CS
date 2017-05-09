/**
 * This is just to Trouble Shoot Methods before we add graphics.
 * 
 * @author Payton&Ashhal
 * @version 5/9/2017
 */

import java.util.*;
import java.text.*;
import javax.swing.*;
import java.io.*;

public class TroubleShooter
{
    public static void main(String[] args) throws IOException{
        
        /**TROUBLE-SHOOTING SCORE CLASS**/
        Score testScore = new Score();
        
        System.out.println(testScore.getScore());
        for (int i = 1; i <= 10; i++)
            testScore.add();
            
        System.out.println(testScore.getScore());
        testScore.setName("Ashhal");
        testScore.checkScore();
        testScore.reset();
        System.out.println(testScore.getScore());
        System.out.println(testScore);
        
    }
}
