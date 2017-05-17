import java.util.ArrayList;
import env3d.Env;
import org.lwjgl.input.Keyboard;
import java.util.*;

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MainMenu
{
    private Env env;
   
    /**
     * Default constructor for objects of class MainMenu
     */
    public MainMenu() throws InterruptedException
    {
        //Objc o = new Objc(/*Parameters*/);
        env = new Env();
        String[] stuff = new String[5];
        env.exit();
        mainGame.main(stuff);
        
        while (env.getKey() != 1)
       
    }

   

}
