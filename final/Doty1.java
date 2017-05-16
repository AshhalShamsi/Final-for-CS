import env3d.EnvObject;
 
/**
 * A Doty object that can be "picked" by the mouse
 */
public class Doty1 extends EnvObject
{
    double defaultX, defaultY, defaultZ;
     
    public Doty1(double x, double y, double z)
    {
        defaultX = x;
        defaultY = y;
        defaultZ = z;       
        setX(x);
        setY(y);
        setZ(z);
        setScale(0.5);
        setTexture("textures/doty_happy.png");
    }
     
    /**
     * Simply change the texture when the object is picked.
     */
    public void picked() 
    {
        setTexture("textures/doty_angry.png");
    }
     
    /**
     * Resets the object to its original location
     */
    public void reset()
    {
        setTexture("textures/doty.png");
        setX(defaultX);
        setY(defaultY);
        setZ(defaultZ);
    }
 
}