package cc3002.tarea1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Abstract class which implements the IEnergy interface and extends the concept of energy card
 * @author Adèle Bourgeix
 */
public abstract class AEnergy extends ACard implements IEnergy {


    /** Constructor to creates a new energy
     */
    public AEnergy(String name){
        super(name);

    }

    public boolean canbeUsed(Player p){
        boolean b=true;
        if (p.getPlayingEnergy()){
                System.out.println("One energy has already been used");
                b=false;
            }
        return b;
    }



}
