package cc3002.tarea1;

import java.util.HashMap;

public abstract class AAbility implements IHability{
    private String name;
    private String description;
    private HashMap<String, Integer> cost;

    /**Constructor of an attack, giving it a name, a number of points taken to the player's opponent's pokemon and a short description of the attack
     * @param aName name used to refer to the attack
     * @param aDescription short description of the attack, giving its type for example
     */
    public AAbility(String aName,String aDescription){
        this.name=aName;
        this.description=aDescription;
        this.cost= new HashMap<>(4);
    }
    /** Getter for the name of the attack
     * @return string which the attack's name
     */
    public String getName(){
        return this.name;
    }


    /** Method which returns the energies a Pokemon must posess to perform an attack
     * @return return HashMap with the type and quantity of energies needed
     */
    public HashMap<String, Integer> getCosts(){
        return this.cost;
    }

    /** Returns the quantity of one type of energy owned by a pokemon
     * @param energy energy looked for among the pokemon's energies associated
     * @return Quantity needed of one type of energy
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

    public void beingActivated(Player first, Player following){
        System.out.println("hability being activated");
    }
}
