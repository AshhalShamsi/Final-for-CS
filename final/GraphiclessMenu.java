/**
 * In case we can't get the menu with graphcis to work, so we have
 * a reasonable substitute
 * 
 * @author (Payton Schubel) 
 * @version (5/21/2017)
 */
import java.util.*;
import java.text.*;
import javax.swing.*;
import java.io.*;
public class GraphiclessMenu
{
    private Score myScore;
    private Scanner keyboard;

    /**
     * Constructor for objects of class GraphiclessMenu
     */
    public GraphiclessMenu() throws IOException
    {
        Instructions.setUp();
        myScore = new Score();
        keyboard = new Scanner(System.in);
    }
    

    /**
     * Calls and uses the menu
     * 
     * @param none
     * @return none
     */
    public void useMenu() throws IOException, InterruptedException
    {
        System.out.print("Enter your name: ");
        myScore.setName(keyboard.nextLine());
        
        System.out.println("1) Exit");
        System.out.println("2) Instructions");
        System.out.println("3) Top Scores");
        System.out.println("4) Play Game");
        
        System.out.print("\nChoice: ");
        char choice = keyboard.nextLine().charAt(0);
        
        //Continues at the menu while the user still wants to look at the mneu
        while (choice != '1' && choice != '4'){
            
            //Instructions
            if (choice == '2'){
                System.out.println();
                
                //Runs through the menu until user clicks and enters E for exit
                while (choice != 'e' && choice != 'E'){
                                    
                    System.out.println(Instructions.getPage());
                    choice = keyboard.nextLine().charAt(0);
                    
                    //If they want the previous page, gives them previous
                    if (choice == 'P' || choice == 'p')
                        Instructions.previous();
                    
                    //If they want the next page, gives them next
                    if (choice  == 'n' || choice == 'N')
                        Instructions.next();
                }
                
                //Resets the page to 0 (in case the user clicks on instructions
                //again and didn't exit on the first page.
                Instructions.setPageNumber(0);
                
            }
            
            //Shows the user top scores
            if (choice == '3'){
                
                //Displays the topScores for the user
                System.out.println("\nTOP SCORES: ");
                System.out.println(myScore);
                System.out.print("\n\nPress Enter to Exit");
                keyboard.nextLine();
            }
            
            //Gets the user's next choice
            System.out.println("\n\n1) Exit");
            System.out.println("2) Instructions");
            System.out.println("3) Top Scores");
            System.out.println("4) Play Game");
            
            System.out.print("\nChoice: ");
            choice = keyboard.nextLine().charAt(0);
                    
        }
        
        //NOT SURE IF THIS CODE WORKS, TROUBLESHOOT IT
        if (choice == '4'){
            mainGame game = new mainGame();
            game.play();
        }
    }
}

