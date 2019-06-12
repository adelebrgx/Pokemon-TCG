package cc3002.tarea1;

import cc3002.tarea1.Electric.IElectricPokemon;
import cc3002.tarea1.Fighting.IFightingPokemon;
import cc3002.tarea1.Fire.IFirePokemon;
import cc3002.tarea1.Plant.IPlantPokemon;
import cc3002.tarea1.Psychic.IPsychicPokemon;
import cc3002.tarea1.Water.IWaterPokemon;

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
    public void affect(IPokemon pokemon){}

    @Override
    public void isBeingEnabled(Player p){
        if(!p.getSelectedPokemon().getAbilitiesList().contains(this)){
            System.out.println("The player's selected pokemeon doesn't poseess this ability");
        }
        else{
            System.out.println("Pokemon is receiving ability");
        }
    }

    @Override
    public void enableFirePokemon(IFirePokemon pokemon){}

    @Override
    public void enableWaterPokemon(IWaterPokemon pokemon){}

    @Override
    public void enablePlantPokemon(IPlantPokemon pokemon){}

    @Override
    public void enableElectricPokemon(IElectricPokemon pokemon){}

    @Override
    public void enablePsychicPokemon(IPsychicPokemon pokemon){}

    @Override
    public void enableFightingPokemon(IFightingPokemon pokemon){}

}
