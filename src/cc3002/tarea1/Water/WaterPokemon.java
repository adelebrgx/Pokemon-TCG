package cc3002.tarea1.Water;

import cc3002.tarea1.*;

import java.util.ArrayList;

public class WaterPokemon extends APokemon {
    public WaterPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }

    public void hurt(IPokemon pokemon, Attack anattack){
        pokemon.receiveWaterAttack(anattack);
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
    public void receiveElectricAttack(Attack anAttack){ this.receiveWeaknessAttack(anAttack);}
    @Override
    public void receiveFightingAttack(Attack anAttack){ this.receiveResistantAttack(anAttack); }
    @Override
    public void receivePsychicAttack(Attack anAttack){
        this.receiveNormalAttack(anAttack);
    }
}
