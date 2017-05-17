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
        //Right now, the texture is a solid green sheet. Can change
        super("models/test/test.jpg", "GET MODEL FOR UPWARDS ARROW", x, y, z);
        
        //Default intensity -- User will change
        //NOTE: We can use larger or smaller numbers,
        //I'm just trying to make sure it exists right
        //now.
        intensity = 10;
        
    }

    /**
     * Increases the intensity by 1
     * NOTE TO SELF: Maybe include a maximum intensity
     * @param none
     * @return none
     */
    public void increase(){
        intensity += 1;
    }

}
