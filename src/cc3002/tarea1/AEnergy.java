package cc3002.tarea1;

import java.util.HashMap;

/**
 * Abstract class which implements the IEnergy interface and extends the concept of energy card
 * @author Adèle Bourgeix
 */
public abstract class AEnergy extends ACard implements IEnergy {


    /** Creates a new energy
     */
    public AEnergy(String name){
        super(name);

    }


}
