
/**
 * Write a description of class Objc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objc
{
    private double x,y,z, roomWidth, roomDepth, scale;
    private String texture, model;
    public Objc(String txt, String mod, double e, double f, double g)
    {
        x = e;
        y = f;
        z = g;
        texture = txt;
        model = mod;
        scale = 1;
    }
    
    public double setscale(double num)
    {
        double rekt = scale;
        scale = num;
        return rekt;
        
    }
     /**
     * Set the dimension of the room Doty is in
     */
    public void setRoomDim(double w, double d)
    {
        roomWidth = w;
        roomDepth = d;
    }
    
}
