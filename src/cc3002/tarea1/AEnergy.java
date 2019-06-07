package cc3002.tarea1;

import java.util.HashMap;

/**
 * Abstract class which implements the IEnergy interface and extends the concept of energy card
 * @author Adèle Bourgeix
 */
public abstract class AEnergy implements IEnergy{

    protected String name;

    /** Creates a new energy
     */
    public AEnergy(){
    }

    @Override
    public String getTitle(){
        return this.name;
    }

    @Override
    public String getName(){
        return this.name;
    }


}
