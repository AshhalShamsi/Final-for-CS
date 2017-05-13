
/**
 * Write a description of class Objc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objc
{
    private double x,y,z, roomWidth, roomDepth;
    private String texture, model;
    public Objc(String txt, String mod, double e, double f, double g)
    {
        x = e;
        y = f;
        z = g;
        texture = txt;
        model = mod;
       
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
