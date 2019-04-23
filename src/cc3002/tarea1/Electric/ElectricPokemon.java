package cc3002.tarea1.Electric;

import cc3002.tarea1.APokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.IPokemon;

import java.util.ArrayList;

public class ElectricPokemon extends APokemon {
    public ElectricPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }

    public void hurt(IPokemon pokemon, Attack anattack){
        pokemon.receiveElectricAttack(anattack);
    }

    @Override
    public String type(){
        return "Electric";
    }
    @Override
    public void receiveFireAttack(Attack anAttack){ this.receiveNormalAttack(anAttack); }
    @Override
    public void receiveWaterAttack(Attack anAttack){
        this.receiveNormalAttack(anAttack);
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
        this.receiveWeaknessAttack(anAttack);
    }
    @Override
    public void receivePsychicAttack(Attack anAttack){
        this.receiveNormalAttack(anAttack);
    }
}
