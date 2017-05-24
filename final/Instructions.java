/**
 * A quick class with the game instructions so that we don't forget
 * to write them.
 * 
 * @author (Payton Schubel) 
 * @version (5/16/2017)
 */
public class Instructions
{
   private static String[] instructions;
   private static int myPage;
   
   /**
    * SetUp method -- gets things ready (because it's static)
    * @param none
    * @return none
    */
    public static void setUp(){
        //page1 = the first page of instructions
        String page1 = "Welcome to the Paper Toss Game!\n\nThe objective of this game is to throw the paper ball into";
        page1 += " the paper waste basket successfully. \nTo start playing the game,  move around the rooom";
        page1 += "  until you find a paper waste basket.\n";
        
        //page2 = the second page of instructions
        String page2 = "Use WASD to move yourself around the room, and use the mouse to turn yourself left and right.\n";
        page2 += "Once you're in a position in front of the waste basket, click F3 to throw.\n";
        
        //page3 = the third page of instructions
        String page3 = "If the basket is made, points will be added to your score.\n\nThe number of points you receive";
        page3 += " depends on how far away you were from the basket when the ball\nwas throws. You get more points from";
        page3 += "being farther away from the basket.\n Good Luck!";
        
        //page4 = the fourth page of instructions
        String page4 = "Controls:\n";
        page4 += "Click esc to force the program to quit.\n";
        page4 += "Use WASD to move and the mouse cursor to turn.\n";
        page4 += "Press F1 to access the menu during gameplay.\nPress F3 to throw the ball.";
        
        //instructions = a list of all pages of instructions
        instructions = new String[]{page1, page2, page3, page4};
        
        //Adds a common instruction to the bottom of each page
        for (int i = 0; i < instructions.length; i++){
            instructions[i] = (instructions[i] += "\n\nType P) Previous\t\tType N) Next\t\tType E) Exit");
        }
        
        //myPage = What instruction page I'm currently on.
        //Remember 0 = page 1, 1 = page 2...
        myPage = 0;
    }

    /**
     * A method that increases your page number by one
     * @param none
     * @return String -- Whatever page corresponding to the number you want.
     */
    public static String next(){
        //Makes sure you're not going to a page that doesn't exist (page 5, myPage 4)
        if (myPage < 3)
            myPage += 1;
            
        //Returns the page that the user is now on
        return instructions[myPage];
    }
    
    /**
     * A method that decreases your page number by one
     * @param none
     * @return String -- Whatever page corresponding to the number you want.
     */
    public static String previous(){
        //Makes sure you're not going to a negative page
        if (myPage > 0)
            myPage -= 1;
            
        //Returns the page that the user is now on
        return instructions[myPage];
    }

    /**
     * Gets the current page
     * @param none
     * @return String -- Whatever page you're on
     */
    public static String getPage(){
        return instructions[myPage];
    }
    
    /**
     * Sets the page number
     * Precondition: The number is between 0-3
     * @param int the new page number
     * @return none
     */
    public static void setPageNumber(int n){
        myPage = n;
    }
    
    /**
     * Gets the current page number
     * @param none
     * @return int -- the current page number
     */
    public static int getPageNumber(){
        return myPage;
    }
    
    /**
     * toStringStatic -- Gets all of the instructions in a giant string
     * This WILL NOT automatically be called on a print, must call it
     * personally.
     * 
     * @param none
     * @return String All of the instructions
     */
    public static String toStringStatic(){
        String info = "";
        
        for (int i = 0; i < 4; i++)
            info += (instructions[i] + "\n\n");
            
        return info;
    }
}
