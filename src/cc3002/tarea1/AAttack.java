package cc3002.tarea1;

import cc3002.tarea1.IEnergy;

import java.util.HashMap;

public abstract class AAttack implements IAttack{
    private String name;
    private int baseDamage;
    private String description;
    private HashMap<String, Integer> cost;

    public AAttack(String aName, int abaseDamage, String aDescription){
        this.name=aName;
        this.baseDamage=abaseDamage;
        this.description=aDescription;
        this.cost= new HashMap<>(4);
    }


    public int getBaseDamage() {
        return this.baseDamage;
    }


    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public HashMap<String, Integer> getCost(){
        return this.cost;
    }

    public void setEnergyCost(String energy, int quantity){
        this.cost.put(energy,quantity);
    }


}
