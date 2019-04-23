package cc3002.tarea1;

import java.util.HashMap;

public class Attack {
    private String name;
    private int baseDamage;
    private String description;
    private HashMap<String, Integer> cost;

    public Attack(String aName, int abaseDamage, String aDescription){
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

    public HashMap<String, Integer> getCosts(){
        return this.cost;
    }

    public int quantityOneEnergy(IEnergy energy){
        return this.cost.get(energy.type());
    }

    public void setEnergyCost(String energy, int quantity){
        this.cost.put(energy,quantity);
    }

}
