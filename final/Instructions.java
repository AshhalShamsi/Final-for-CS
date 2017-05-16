/**
 * A quick class with the game instructions so that we don't forget
 * to write them.
 * 
 * @author (Payton Schubel) 
 * @version (5/16/2017)
 */
public class Instructions
{
    private String[] instructions;
    private int myPage;

    /**
     * Default constructor for objects of class Instructions
     * @param none
     */
    public Instructions()
    {
        //page1 = the first page of instructions
        String page1 = "Welcome to the Paper Toss Game!\n\nThe objective of this game is to throw the paper ball into";
        page1 += " the paper waste basket successfully. \n\nTo start the game, click start and move around the office";
        page1 += " building until you find a paper waste basket.\n\n Hit space to stop.";
        
        //page2 = the second page of instructions
        String page2 = "Once you're stopped, a wind speed will be displayed. Use the arrow keys (ARE WE USING WASD?)\n";
        page2 += "to turn yourself towards or away from the wind.\n\nHit space to once you like you're angle.";
        
        //page3 = the third page of instructions
        String page3 = "Now, an intensity bar should be displayed. Use the up and down arrow keys to \n";
        page3 += "increase or decrease the intensity of your throw. \n\nHit space once you're at the right ";
        page3 += "intensity.";
        
        //page4 = the fourth page of instructions
        String page4 = "The ball will be throws according to how you threw it, and will land either inside or \n";
        page4 += "outside of the wastepaper basket.\n\nIf your ball went in, your score will increase by one. \n";
        page4 += "If your ball did not land in the basket, your game will be over and we'll check to see if\n";
        page4 += "your score was a Top Score.\n\nGood Luck!";
        
        //instructions = a list of all pages of instructions
        instructions = {page1, page2, page3, page4};
        
        //myPage = What instruction page I'm currently on.
        //Remember 0 = page 1, 1 = page 2...
        myPage = 0;
    }

    /**
     * A method that increases your page number by one
     * @param none
     * @return String -- Whatever page corresponding to the number you want.
     */
    public String next(){
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
    public String previous(){
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
    public String getPage(){
        return instructions[myPage];
    }
    
    /**
     * Gets the current page number
     * @param none
     * @return int -- the current page number
     */
    public int getPageNumber(){
        return myPage;
    }
}
