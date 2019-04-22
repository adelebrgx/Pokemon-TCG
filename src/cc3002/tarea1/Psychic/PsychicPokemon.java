package cc3002.tarea1.Psychic;

import cc3002.tarea1.APokemon;
import cc3002.tarea1.IAttack;

public class PsychicPokemon extends APokemon {
    public PsychicPokemon(String someName, int somePokedexID, int someHP) {
        super(someName, somePokedexID, someHP);
    }

    @Override
    public String type(){
        return "Psychic";
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
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receiveElectricAttack(IAttack anAttack){
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receiveFightingAttack(IAttack anAttack){
        this.receiveResistantAttack(anAttack);
    }
    @Override
    public void receivePsychicAttack(IAttack anAttack){
        this.receiveWeaknessAttack(anAttack);
    }
}
