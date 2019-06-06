package cc3002.tarea1;

import java.util.HashMap;

/**
 * Class used to describe the behavior of an attack one pokemon posess
 * @author Adèle Bourgeix
 */
public class Attack extends AAbility {
    private int baseDamage;


    /**Constructor of an attack, giving it a name, a number of points taken to the player's opponent's pokemon and a short description of the attack
     * @param aName name used to refer to the attack
     * @param abaseDamage number of points taken to the pokemon which receives the attack
     * @param aDescription short description of the attack, giving its type for example
     */
    public Attack(String aName, int abaseDamage, String aDescription){
        super(aName,aDescription);
        this.baseDamage=abaseDamage;
    }


    /** Getter for the number of points lost by the pokemon which will receive this attack
     * @return an integer which represents the base damage of an attack
     */
    public int getBaseDamage() {
        return this.baseDamage;
    }




}
