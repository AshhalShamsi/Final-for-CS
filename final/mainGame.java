import java.util.ArrayList;
import env3d.Env;
import org.lwjgl.input.Keyboard;
/**
 * Write a description of class mainGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mainGame
{
    // instance variables - replace the example below with your own
    private Env env;
    private Room room;
    /**
     * Constructor for objects of class mainGame
     */
    public mainGame()
    {
        room = new Room (10,10,10, "Mi cabeza es ROJO");
        room.setTextureEast("textures/bricks.jpg");
        room.setTextureNorth("textures/bricks.jpg");
        room.setTextureSouth("textures/bricks.jpg");
        room.setTextureWest("textures/bricks.jpg");
     
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void play()
    {
        // put your code here
        // Position the camera
        env = new Env();
        room.setCurrentRoom(env);
        env.setCameraXYZ(5, 13, 9);        
        env.setCameraPitch(-75);
         
        // Disable mouse and camera control
        env.setDefaultControl(true);
         
        while (true)
        {
            env.advanceOneFrame();
            // Position the camera
            
        }
    }
}
