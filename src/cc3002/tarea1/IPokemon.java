package cc3002.tarea1;

import java.util.ArrayList;
import java.util.HashMap;

public interface IPokemon extends ICard{
    public String getName();
    public int getHP();
    public int getPokedexID();
    public ArrayList<IAttack> getAttacksList();
    public String type();
    public HashMap<String, Integer> getEnergiesAssociated();
    public int getQuantityofAnEnergy(IEnergy energy);
    public int getQuantityofAnEnergy(String energy);

    public void setAttack(IAttack anAttack);


    public void receiveFireAttack(IAttack anAttack);
    public void receiveWaterAttack(IAttack anAttack);
    public void receivePlantAttack(IAttack anAttack);
    public void receiveElectricAttack(IAttack anAttack);
    public void receiveFightingAttack(IAttack anAttack);
    public void receivePsychicAttack(IAttack anAttack);
    public void receiveWeaknessAttack(IAttack attack);
    public void receiveResistantAttack(IAttack attack);
    public void receiveNormalAttack(IAttack attack);


    public void beingPlayedBy(Entrenador inAction);


}
