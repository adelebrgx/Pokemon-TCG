package cc3002.tarea1;

import java.util.HashMap;

public interface IAttack{

    public int getBaseDamage();
    public String getName();
    public String getDescription();
    public HashMap<String, Integer> getCosts();
    public int quantityOneEnergy(IEnergy energy);
    public void setEnergyCost(String energy, int quantity);
    public void performAttack(IPokemon aPokemon);
}
