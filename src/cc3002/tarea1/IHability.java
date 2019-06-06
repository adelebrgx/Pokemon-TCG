package cc3002.tarea1;

import java.util.HashMap;

/**
 * Interface which represents the game's abilities
 * @author Adèle Bourgeix
 */
public interface IHability {

    String getName();
    HashMap<String, Integer> getCosts();
    int quantityOneEnergy(IEnergy energy);
    void setEnergyCost(String energy, int quantity);
    void beingActivated(Player frist, Player following);
}
