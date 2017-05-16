
import env3d.Env;
import env3d.EnvRay;
 
public class Game1 
{
    public void play() 
    {
        Env env = new Env();
        Doty1 [] objects = new Doty1[100];
         
        // Create a "wall" of doty objects
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                int i = 10*y+x;
                objects[i]=new Doty1(x+0.5, y+0.5, 1);
                env.addObject(objects[i]);
            }
        }
         
        env.setCameraXYZ(5,5,15);
        env.setDefaultControl(true);
        Doty1 selected = null;
        while (env.getKey() != 1) {            
            Doty1 pick = (Doty1) env.getPick(env.getMouseX(), env.getMouseY());
            if (selected != pick) {
                // We have selected a different object, reset the current object
                if (selected != null) {
                    selected.reset();
                }
                // set the new object as selected
                if (pick != null) {
                    pick.picked();
                }
                selected = pick;                
            }
             
            // Move the selected Doty object close to the pick origin
            // Exercise: move this code into the Doty class.
            if (selected != null) {
                // The pick ray object contains the origin and direction of the
                // mouse location, translated into 3D coordinate.
                EnvRay ray = env.getPickRay(env.getMouseX(), env.getMouseY());
                // Move the object along the direction of the ray.
                selected.setX(selected.getX()-0.2*ray.getDirection().getX());
                selected.setY(selected.getY()-0.2*ray.getDirection().getY());
                selected.setZ(selected.getZ()-0.2*ray.getDirection().getZ());                
            }
            env.advanceOneFrame();
        }
         
        env.exit();
    }
     
    public static void main(String args[])
    {
        (new Game1()).play();
    }
}
