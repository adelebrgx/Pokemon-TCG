package cc3002.tarea1;

import java.util.HashMap;

/**
 * Class used to describe the behavior of an attack one pokemon posess
 * @author Adèle Bourgeix
 */
public class Attack {
    private String name;
    private int baseDamage;
    private String description;
    private HashMap<String, Integer> cost;

    /**Constructor of an attack, giving it a name, a number of points taken to the player's opponent's pokemon and a short description of the attack
     * @param aName name used to refer to the attack
     * @param abaseDamage number of points taken to the pokemon which receives the attack
     * @param aDescription short description of the attack, giving its type for example
     */
    public Attack(String aName, int abaseDamage, String aDescription){
        this.name=aName;
        this.baseDamage=abaseDamage;
        this.description=aDescription;
        this.cost= new HashMap<>(4);
    }


    /** Getter for the number of points lost by the pokemon which will receive this attack
     * @return
     */
    public int getBaseDamage() {
        return this.baseDamage;
    }


    /** Getter for the name of the attack
     * @return
     */
    public String getName(){
        return this.name;
    }


    /** Method which returns the energies a Pokemon must posess to perform an attack
     * @return
     */
    public HashMap<String, Integer> getCosts(){
        return this.cost;
    }

    /** Returns the quantity of one type of energy owned by a pokemon
     * @param energy energy looked for among the pokemon's energies associated
     * @return
     */
    public int quantityOneEnergy(IEnergy energy){
        return this.cost.get(energy.type());
    }

    /** When initializing an attack, energies can be assigned which will be needed by a pokemon to perform the attack
     * @param energy type of energy set to the attack
     * @param quantity quantity of energy set to the attack
     */
    public void setEnergyCost(String energy, int quantity){
        this.cost.put(energy,quantity);
    }

}
