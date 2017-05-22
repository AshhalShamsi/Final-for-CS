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
    private Score myScore; //The user's score
    private Scanner keyboard; //For input
    private boolean firstUse; //To see if it is the user's first use
    //private mainGame game; //The actual game

    /**
     * Constructor for objects of class GraphiclessMenu
     */
    public GraphiclessMenu() throws IOException
    {
        Instructions.setUp();
        myScore = new Score();
        keyboard = new Scanner(System.in);
        firstUse = true;
        // game = new mainGame();
    }
    
    /**
     * A display in the event this is the first time with menu
     * @param none
     * @return none
     */
    private void firstDisplay(){
        System.out.println("\n1) Exit");
        System.out.println("2) Instructions");
        System.out.println("3) Top Scores");
        System.out.println("4) Play Game");
    }
    
    /**
     * A display to call if this isn't the first time
     * running the menu through
     * @param none
     * @return none
     */
    public void nextDisplay(){
        System.out.println("\n1) Exit");
        System.out.println("2) Instructions");
        System.out.println("3) Top Scores");
    }

    /**
     * Calls and uses the menu
     * 
     * @param none
     * @return none
     */
    public void useMenu() throws IOException, InterruptedException
    {
        
        //Sees if this is the user's first time through
        //the menu (if so, need their name, and if not,
        //can't let them play because they should already
        //be playing)
        System.out.println(this);
        if (this.firstUse){
            System.out.print("Enter your name: ");
            myScore.setName(keyboard.nextLine());
            this.firstDisplay();
        }
        else
            this.nextDisplay();
        
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
            if (this.firstUse)
                this.firstDisplay();
            else
                this.nextDisplay();
            
            System.out.print("\nChoice: ");
            choice = keyboard.nextLine().charAt(0);
                    
        }
        
        //If they want to play the game, and they aren't already playing
        //the game, launches the game for them.
        if (choice == '4' && this.firstUse){
            firstUse = false;
            //game.play();
        }

        System.exit(0);
    }
}

