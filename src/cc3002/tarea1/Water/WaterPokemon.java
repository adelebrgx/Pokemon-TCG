package cc3002.tarea1.Water;

import cc3002.tarea1.APokemon;
import cc3002.tarea1.IAttack;
import cc3002.tarea1.IAttack;

public class WaterPokemon extends APokemon {
    public WaterPokemon(String someName, int somePokedexID, int someHP) {
        super(someName, somePokedexID, someHP);
    }

    @Override
    public String type(){
        return "Water";
    }
    @Override
    public void receiveFireAttack(IAttack anAttack){
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receiveWaterAttack(IAttack anAttack){
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receivePlantAttack(IAttack anAttack){
        this.receiveWeaknessAttack(anAttack);
    }
    @Override
    public void receiveElectricAttack(IAttack anAttack){ this.receiveWeaknessAttack(anAttack);}
    @Override
    public void receiveFightingAttack(IAttack anAttack){ this.receiveResistantAttack(anAttack); }
    @Override
    public void receivePsychicAttack(IAttack anAttack){
        this.receiveNormalAttack(anAttack);
    }
}
