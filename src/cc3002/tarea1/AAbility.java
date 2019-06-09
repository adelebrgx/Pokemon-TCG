package cc3002.tarea1;

import java.util.HashMap;

/**
 * Abstract class representing the game's abilities which implements the IAbility interface
 * @author Adèle Bourgeix
 */
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

    @Override
    public String getName(){
        return this.name;
    }


    @Override
    public HashMap<String, Integer> getCosts(){
        return this.cost;
    }

    @Override
    public int quantityOneEnergy(IEnergy energy){
        return this.cost.get(energy.type());
    }

    @Override
    public void setEnergyCost(String energy, int quantity){
        this.cost.put(energy,quantity);
    }

    @Override
    public void beingActivated(Player first, Player following){
        System.out.println("hability being activated");
    }

    @Override
    public void affect(IPokemon pokemon){}

}
