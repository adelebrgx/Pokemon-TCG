package cc3002.tarea1;

import cc3002.tarea1.Electric.ElectricEnergy;
import cc3002.tarea1.Electric.IElectricPokemon;
import cc3002.tarea1.Fighting.FightingEnergy;
import cc3002.tarea1.Fighting.IFightingPokemon;
import cc3002.tarea1.Fire.FireEnergy;
import cc3002.tarea1.Fire.IFirePokemon;
import cc3002.tarea1.Plant.IPlantPokemon;
import cc3002.tarea1.Plant.PlantEnergy;
import cc3002.tarea1.Psychic.IPsychicPokemon;
import cc3002.tarea1.Psychic.PsychicEnergy;
import cc3002.tarea1.Water.IWaterPokemon;
import cc3002.tarea1.Water.WaterEnergy;

import java.util.HashMap;

/**
 * Class which allows instantiating abilities of type EnergyBurn. Implemented using a Visitor pattern to visit the player and the opponent's pokemon according to their type.
 * @author Adèle Bourgeix
 */
public class EnergyBurn extends AAbility {

    private HashMap<String,Integer> en= new HashMap();


    /**
     * Constructor for an ability of type EnergyBurn
     * @param aName name for the ability
     * @param aDescription description for the ability
     */
    public EnergyBurn(String aName, String aDescription){super(aName, aDescription);}


    @Override
    public void isBeingEnabled(Player p){
        IPokemon pokemon= p.getSelectedPokemon();
        if(!pokemon.getAbilitiesList().contains(this)){
            System.out.println("Pokemon cannot use EnergyBurn because he doesn't posess it");
        }
        else {
            pokemon.receiveAbility(this);
        }

    }

    @Override
    public void enableFirePokemon(IFirePokemon pokemon){
        FireEnergy fire=new FireEnergy();
        int quantity= recuperateAllEnergies(pokemon);
        for (int j=0; j<quantity; j++){
            pokemon.addFireEnergy(fire);
        }
    }

    @Override
    public void enableWaterPokemon(IWaterPokemon pokemon){
        WaterEnergy water= new WaterEnergy();
        int quantity= recuperateAllEnergies(pokemon);
        for (int j=0; j<quantity; j++){
            pokemon.addWaterEnergy(water);
        }

    }

    @Override
    public void enablePlantPokemon(IPlantPokemon pokemon){
        PlantEnergy plant= new PlantEnergy();
        int quantity= recuperateAllEnergies(pokemon);
        for (int j=0; j<quantity; j++){
            pokemon.addPlantEnergy(plant);
        }

    }

    @Override
    public void enableElectricPokemon(IElectricPokemon pokemon){
        ElectricEnergy electric= new ElectricEnergy();
        int quantity= recuperateAllEnergies(pokemon);
        for (int j=0; j<quantity; j++){
            pokemon.addElectricEnergy(electric);
        }

    }

    @Override
    public void enablePsychicPokemon(IPsychicPokemon pokemon){
        PsychicEnergy psychic= new PsychicEnergy();
        int quantity= recuperateAllEnergies(pokemon);
        for (int j=0; j<quantity; j++){
            pokemon.addPsychicEnergy(psychic);
        }
    }

    @Override
    public void enableFightingPokemon(IFightingPokemon pokemon){
        FightingEnergy fighting= new FightingEnergy();
        int quantity= recuperateAllEnergies(pokemon);
        for (int j=0; j<quantity; j++){
            pokemon.addFightingEnergy(fighting);
        }
    }

    /**
     * Method to get the total amount of energies of a Pokemon
     * @param pokemon Pokemon we want to get the energies from
     * @return an integer which is the amount of total energy
     */
    public int recuperateAllEnergies(IPokemon pokemon){
        int quantity=0;
        en.put(new WaterEnergy().type(),0);
        en.put(new FireEnergy().type(),0);
        en.put(new PlantEnergy().type(),0);
        en.put(new FightingEnergy().type(),0);
        en.put(new ElectricEnergy().type(),0);
        en.put(new PsychicEnergy().type(),0);
        HashMap<String,Integer> energies= pokemon.getEnergiesAssociated();
        for (String key: en.keySet()){

            quantity+=energies.get(key);
            energies.remove(key);
            energies.put(key,0);

        }
        return quantity;

    }


}
