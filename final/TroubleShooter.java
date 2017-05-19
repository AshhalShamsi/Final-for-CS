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
        
        /**TROUBLE-SHOOTING SCORE CLASS**/ //It works now!
        /**
        Score testScore = new Score();
        
        System.out.println(testScore.getScore());
        for (int i = 1; i <= 5; i++)
            testScore.add();
            
        System.out.println(testScore.getScore());
        System.out.println(testScore);
        
        testScore.setName("Isabella");
        testScore.checkScore();
        testScore.reset();
        System.out.println(testScore.getScore());
        System.out.println(testScore);
        /**/
        
        /**WIND TROUBLE-SHOOT (Not complicated)**/ //It worked first try!
        /**

        Wind test = new Wind();
        System.out.println(test.getSpeed());
        System.out.println(test);
        
        for (int i = 0; i < 10; i++){
            System.out.println(test.changeSpeed());
        }
        **/
        
        /**INSTRUCTIONS TROUBLE-SHOOT (Not complicated either, but static. It works)**/
        /**/
        Instructions.setUp();
        System.out.println(Instructions.getPage());
        System.out.println(Instructions.next());
        System.out.println(Instructions.next());
        System.out.println(Instructions.next());
        System.out.println(Instructions.next());
        System.out.println(Instructions.next());
        System.out.println(Instructions.previous());
        System.out.println(Instructions.getPageNumber());
        System.out.println(Instructions.toStringStatic());
        /**/
        
        /**INTENSITY TROUBLE-SHOOT**/
        /**
        Intensity_1 testI = new Intensity_1(5, 5, 5);
        System.out.println(testI.getIntensity());
        testI.decrease();
        System.out.println(testI.getIntensity());
        testI.increase(); testI.increase();
        System.out.println(testI.getIntensity());
        System.out.println(testI.getX());
        **/
        
        
    }
}
