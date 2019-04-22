package cc3002.tarea1;

import java.util.HashMap;

public interface IPokemon extends ICard{
    public String getName();
    public int getHP();
    public int getPokedexID();
    public String type();
    public HashMap<String, Integer> getEnergiesAssociated();
    public int getQuantityofAnEnergy(IEnergy energy);


    public void receiveFireAttack(Attack anAttack);
    public void receiveWaterAttack(Attack anAttack);
    public void receivePlantAttack(Attack anAttack);
    public void receiveElectricAttack(Attack anAttack);
    public void receiveFightingAttack(Attack anAttack);
    public void receivePsychicAttack(Attack anAttack);
    public void receiveWeaknessAttack(Attack attack);
    public void receiveResistantAttack(Attack attack);
    public void receiveNormalAttack(Attack attack);

    public void beingPlayedBy(Entrenador inAction, Entrenador following);


}
