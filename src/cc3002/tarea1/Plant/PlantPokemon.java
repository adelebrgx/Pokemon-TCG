package cc3002.tarea1.Plant;

import cc3002.tarea1.APokemon;
import cc3002.tarea1.Attack;

public class PlantPokemon extends APokemon {
    public PlantPokemon(String someName, int somePokedexID, int someHP) {
        super(someName, somePokedexID, someHP);
    }

    @Override
    public String type(){
        return "Plant";
    }

    @Override
    public void receiveFireAttack(Attack anAttack){
        this.receiveWeaknessAttack(anAttack);
    }
    @Override
    public void receiveWaterAttack(Attack anAttack){
        this.receiveResistantAttack(anAttack);
    }
    @Override
    public void receivePlantAttack(Attack anAttack){
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receiveElectricAttack(Attack anAttack){
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receiveFightingAttack(Attack anAttack){
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receivePsychicAttack(Attack anAttack){
        this.receiveNormalAttack(anAttack);
    }
}
