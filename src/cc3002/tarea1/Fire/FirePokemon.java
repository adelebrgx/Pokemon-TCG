package cc3002.tarea1.Fire;

import cc3002.tarea1.APokemon;
import cc3002.tarea1.IAttack;


public class FirePokemon extends APokemon {
    public FirePokemon(String someName, int somePokedexID, int someHP) {
        super(someName, somePokedexID, someHP);
    }

    @Override
    public String type(){
        return "Fire";
    }
    @Override
    public void receiveFireAttack(IAttack anAttack){
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receiveWaterAttack(IAttack anAttack){
        this.receiveWeaknessAttack(anAttack);
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
