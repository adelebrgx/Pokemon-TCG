package cc3002.tarea1;

import java.util.HashMap;

public interface IHability {

    public String getName();
    public HashMap<String, Integer> getCosts();
    public int quantityOneEnergy(IEnergy energy);
    public void setEnergyCost(String energy, int quantity);
}
