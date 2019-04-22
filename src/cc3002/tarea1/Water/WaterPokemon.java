package cc3002.tarea1.Water;

import cc3002.tarea1.APokemon;
import cc3002.tarea1.Attack;

public class WaterPokemon extends APokemon {
    public WaterPokemon(String someName, int somePokedexID, int someHP) {
        super(someName, somePokedexID, someHP);
    }

    @Override
    public String type(){
        return "Water";
    }

    @Override
    public void receiveFireAttack(Attack anAttack){
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receiveWaterAttack(Attack anAttack){
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receivePlantAttack(Attack anAttack){
        this.receiveWeaknessAttack(anAttack);
    }
    @Override
    public void receiveElectricAttack(Attack anAttack){
        this.receiveWeaknessAttack(anAttack);
    }
    @Override
    public void receiveFightingAttack(Attack anAttack){
        this.receiveResistantAttack(anAttack);
    }
    @Override
    public void receivePsychicAttack(Attack anAttack){
        this.receiveNormalAttack(anAttack);
    }
}
