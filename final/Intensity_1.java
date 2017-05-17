/**
 * The intensity thing. Shows user how much power is behind their throw
 * 
 * @author (Payton Schubel & Ashhal Shamsi) 
 * @version (5/17/2017)
 */
public class Intensity_1 extends Objc
{
    /** Instance Variable */
    private int intensity; //How strongly the player will be throwing the ball

    /**
     * Constructor for Intensity
     * @param double --> the x coordinate
     * @param double --> the y coordinate
     * @param double --> the z coordinate
     * A model and texture should still be used, but
     * the color can be constant, and I was thinking
     * that the model could be an arrow (it getting
     * bigger will be getting more & less intense);
     */
    public Intensity_1(double x, double y, double z)
    {
        //Right now, the texture is a solid green sheet. Can change.
        //NEED AN UPWARDS ARROW MODEL For now using a different one
        super("textures/terrain/alpha.png", "models/arrows/arrow4.obj", x, y, z);
        
        //Default intensity -- User will change
        //NOTE: We can use larger or smaller numbers,
        //I'm just trying to make sure it exists right
        //now.
        intensity = 10;
        
    }

    /**
     * Increases the intensity by 1 (can change amount later)
     * NOTE TO SELF: Maybe include a maximum intensity. Ask Ashhal what will work physics-wise
     * @param none
     * @return none
     */
    public void increase(){
        intensity += 1;
        
        //Changes the size of the intensity-indicator (the arrow)
        //so that the user knows that their intensity is changing
        super.setscale(((double)intensity) / 10.0);
    }
    
    /**
     * Decreases intensity by 1
     * RIGHT NOW Minimum intensity is 0. Can change in future.
     * @param none
     * @return none
     */
    public void decrease(){
        if (intensity > 0)
            intensity -= 1;
        
        //Changes the size of the intensity-indicator (the arrow)
        //so that the user knows that their intensity is changing
        super.setscale(((double)intensity) / 10.0);        
    }
    
    /**
     * Gets the intensity
     * @param none
     * @return int (double? check with Ashhal) --> The intensity level
     */
    public int getIntensity(){
        return intensity;
    }

}
