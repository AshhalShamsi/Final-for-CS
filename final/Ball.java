import env3d.Env;

/**
 *This is the ball class
 *Tried using Polymorphism with Objc, but because the defualt model is a ball it would not work
 */
public class Ball
{
    //initializes instance vvariables to be used by Env3d
    private int mass;
    private String texture;
    private double x,y,z,scale, rotateZ, rotateX, ox,oy,oz;
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
        rotateX = 0;
        rotateZ = 0;
    }
    
     /**
     * sets the Texture of the object
     * @param String path
     */
    public void settype(String type2){
        texture = type2;
    }
    
    /**
     * returns the current scale of the ball
     */
    public double getScale()
    {
        return this.scale;
    }
    
     /**
     * sets the Scale of the Ball
     * @param double Scale
     */
    public void setscale(double scale2){
        scale = scale2;
    }
    
     /**
     * sets the Mass of the object
     * @param double Mass
     */
    public void setmass(int mass2)
    {
        this.mass = mass2;
    }
  
     /**
     * gets the mass of the object
     */
    public double getmass()
    {
        return this.mass;
    }
    
    /**
      * Payton here --> Sets the x coordinate
      * @param double --> The new x coordinate
      * @return none
      */
     public void setX(double e){
         ox= x;
         x = e;
     }
    
    /**
     * Payton here --> Gets the x coordinate
     * @param none
     * @return double - The x coordinate
     */
    public double getX(){
        return x;
    }
    
    /**
     * Payton here --> Sets the y coordinate
     * @param double --> The new y coordinate
     * @return none
     */
    public void setY(double f){
        oy = y;
        y = f;
    }
    
    /**
     * Payton here --> Gets the y coordinate
     * @param none
     * @return double - The y coordinate
     */
    public double getY(){
        return y;
    }
    
    
    /**
     * Payton here --> Gets the old-y coordinate
     * @param none
     * @return double - The old-y coordinate
     */
    public double getoy(){
        return oy;
    }
    
    /**
     * Payton here --> Gets the old-z coordinate
     * @param none
     * @return double - The old-z coordinate
     */
    public double getoz(){
        return oz;
    }
    
    /**
     * Payton here --> Gets the old-x coordinate
     * @param none
     * @return double - The old-x coordinate
     */
    public double getox(){
        return ox;
    }
    
    /**
     * Payton here --> Sets the z coordinate
     * @param double --> The new z coordinate
     * @return none
     */
    public void setZ(double g){
        oz = z;
        z = g;
    }
    
    /**
     * Payton here --> Gets the z coordinate
     * @param none
     * @return double --> The z coordinate
     */
    public double getZ(){
        return z;
    }
    
    /**
     * Payton here --> Sets all the coordinates at once (in case you're moving
     * in more than one direction at the same time for convinence reasons)
     * @param double --> The new x coordinate
     * @param double --> The new y coordinate
     * @param double --> The new z coordinate
     * @return none
     */
    public void setxyz (double g, double e, double f)
     {
         ox = x;
         oy = y;
         oz = z;
         x = g;
         y = e;
         z = f;
    }
    
    /**
     * Reverts doty back to the previous position
     */
    public void revert()
    {
        x = ox;
        y = oy;
        z = oz;
    }
    
    
     /**
     * @param env initialization, horizontal velocity
     * returns either true or false if the ball hit the bucket
     */
    public boolean throwBall(Env env, double velocity)
    {
       double initialY = this.getY();
       double initialX = this.getX();
       double initialZ = this.getZ();
       oy = initialY;
       ox = initialX;
       oz = initialZ;
       double Tf = Math.sqrt(2*-initialY/-9.8);
       double xv = velocity * Math.cos(Math.atan((this.getZ()-env.getCameraZ())/(this.getX()-env.getCameraX())));
       double zv = velocity * Math.sin(Math.atan((this.getZ()-env.getCameraZ())/(this.getX()-env.getCameraX())));
       boolean flag = false;
       if (env.getCameraYaw() >= 0){
           double Xi = initialX - xv * Tf;
           double Zi = initialZ - zv * Tf;
           for(double i = 0; i<Tf; i+= .01)
           {
               double Hf = -4.9*i*i+initialY;
               double Xf = initialX - xv * i;
               double Zf = initialZ - zv * i;
               if (Hf == .05)
                   if( check(Xf, initialZ))
                        flag = true;
               this.setxyz(Xf,Hf,Zf);
               env.advanceOneFrame(30);
               
            }
           flag = check(Xi, Zi);
        }
       else
            {
           double Xi = initialX + xv * Tf;
           double Zi = initialZ + zv * Tf;     
           for(double i = 0; i<Tf; i+= .01)
           {
               double Hf = -4.9*i*i+initialY;
               double Xf = initialX + xv * i;
               double Zf = initialZ + zv * i;
               if (Hf == .05)
                   if( check(Xf, initialZ))
                        flag = true;
               this.setxyz(Xf,Hf,Zf);
               env.advanceOneFrame(30);
               
            }
           flag = check(Xi,Zi);
        }
       return flag;
    }
    
     /**
     * Used by the throwBall method to check for bucket success
     * returns true or false depending on it
     */
    private boolean check(double x, double z)
    {
        if (x < 3.5 & x > 2.5)
            if ( z > 15 && z < 18)
                return true;
                
        System.out.println(x+"--"+z);
        return false;
        
        
    }
    
    /**
     * Payton here --> Sets the texture (in case you change it)
     * @param String --> The new texture
     * @return none
     */
    public void setTexture(String txt){
        texture = txt;
    }
    
    /**
     * Payton here --> Gets the texture of the objc object
     * @param none
     * @return String the texture
     */
    public String getTexture(){
        return texture;
    }
    
    /**
     * Payton herre --> Returns the rotation of X for the placeBall method
     * @param none
     * @return double -- rotateX
     */
    public double getRotateX(){
        return rotateX;
    }
    
}
