

/**
 *This is the ball class
 */
public class Ball
{
    private int mass;
    private String type;
    /**
     * Default constructor for objects of class Ball
     */
    public Ball(int mass2, String type2)
    {
        this.mass = mass2;
        this.type = type2;
    }

    public void settype(String type2)
    {
        this.type = type2;
    }

    public void setmass(int mass2)
    {
        this.mass = mass2;
    }
    
    public String gettype()
    {
        return this.type;
    }
    
    public int getmass()
    {
        return this.mass;
    }
}
