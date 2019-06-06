package cc3002.tarea1;

import java.util.HashMap;

public interface IHability {

    String getName();
    HashMap<String, Integer> getCosts();
    int quantityOneEnergy(IEnergy energy);
    void setEnergyCost(String energy, int quantity);
}
