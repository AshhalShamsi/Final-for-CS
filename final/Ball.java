

/**
 *This is the ball class
 */
public class Ball
{
    private int mass;
    private String texture;
    private double x,y,z,scale, rotateZ;
    /**
     * Default constructor for objects of class Ball
     */
    public Ball(int mass2, String type2, double g, double e, double f, double scle)
    {
        this.mass = mass2;
        texture = type2;
        x = g;
        y = e;
        z = f;
        scale = scle;
        rotateZ = 0;
    }
    
    public void setYaw(double yee)
    {
        rotateZ = yee;
        
        
        
    }

    public void settype(String type2)
    {
        texture = type2;
    }
    
    public void setscale(double scale2)
    {
        scale = scale2;
        
    }
    
    public void setxyz (double g, double e, double f)
    {
        x = g;
        y = e;
        z = f;
    }
    
    public void setmass(int mass2)
    {
        this.mass = mass2;
    }
  
    public int getmass()
    {
        return this.mass;
    }
}
