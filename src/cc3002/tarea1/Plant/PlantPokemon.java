package cc3002.tarea1.Plant;

import cc3002.tarea1.APokemon;
import cc3002.tarea1.IAttack;

public class PlantPokemon extends APokemon {
    public PlantPokemon(String someName, int somePokedexID, int someHP) {
        super(someName, somePokedexID, someHP);
    }

    @Override
    public String type(){
        return "Plant";
    }
    @Override
    public void receiveFireAttack(IAttack anAttack){
        this.receiveWeaknessAttack(anAttack);
    }
    @Override
    public void receiveWaterAttack(IAttack anAttack){
        this.receiveResistantAttack(anAttack);
    }
    @Override
    public void receivePlantAttack(IAttack anAttack){
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receiveElectricAttack(IAttack anAttack){
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receiveFightingAttack(IAttack anAttack){
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receivePsychicAttack(IAttack anAttack){
        this.receiveNormalAttack(anAttack);
    }
}
