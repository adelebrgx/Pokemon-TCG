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


public class EnergyBurn extends AAbility {

    private HashMap<String,Integer> en= new HashMap();

    public EnergyBurn(String aName, String aDescription){super(aName, aDescription);}


    @Override
    public void isBeingEnabled(Player p, IPokemon pokemon){

        pokemon.receiveAbility(this);
    }

    public void enableFirePokemon(IFirePokemon pokemon){
        FireEnergy fire=new FireEnergy();
        int quantity= recuperateAllEnergies(pokemon);
        for (int j=0; j<quantity; j++){
            pokemon.addFireEnergy(fire);
        }
    }

    public void enableWaterPokemon(IWaterPokemon pokemon){
        WaterEnergy water= new WaterEnergy();
        int quantity= recuperateAllEnergies(pokemon);
        for (int j=0; j<quantity; j++){
            pokemon.addWaterEnergy(water);
        }

    }

    public void enablePlantPokemon(IPlantPokemon pokemon){
        PlantEnergy plant= new PlantEnergy();
        int quantity= recuperateAllEnergies(pokemon);
        for (int j=0; j<quantity; j++){
            pokemon.addPlantEnergy(plant);
        }

    }
    public void enableElectricPokemon(IElectricPokemon pokemon){
        ElectricEnergy electric= new ElectricEnergy();
        int quantity= recuperateAllEnergies(pokemon);
        for (int j=0; j<quantity; j++){
            pokemon.addElectricEnergy(electric);
        }

    }
    public void enablePsychicPokemon(IPsychicPokemon pokemon){
        PsychicEnergy psychic= new PsychicEnergy();
        int quantity= recuperateAllEnergies(pokemon);
        for (int j=0; j<quantity; j++){
            pokemon.addPsychicEnergy(psychic);
        }
    }
    public void enableFightingPokemon(IFightingPokemon pokemon){
        FightingEnergy fighting= new FightingEnergy();
        int quantity= recuperateAllEnergies(pokemon);
        for (int j=0; j<quantity; j++){
            pokemon.addFightingEnergy(fighting);
        }
    }

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
