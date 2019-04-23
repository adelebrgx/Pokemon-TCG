package cc3002.tarea1;

import cc3002.tarea1.Electric.ElectricEnergy;
import cc3002.tarea1.Fire.FireEnergy;
import cc3002.tarea1.Plant.PlantEnergy;
import cc3002.tarea1.Psychic.PsychicEnergy;
import cc3002.tarea1.Water.WaterEnergy;
import cc3002.tarea1.Fighting.FightingEnergy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class APokemon implements IPokemon  {
    private String name;
    private int pokedexID;
    private int hp;
    public HashMap<String, Integer> EnergiesAssociated;
    private ArrayList<Attack> attackList;

    public APokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> attacks){
        this.name=someName;
        this.pokedexID=somePokedexID;
        this.hp=someHP;
        this.attackList= attacks;
        this.EnergiesAssociated= new HashMap<String, Integer>();
        this.EnergiesAssociated.put(new WaterEnergy().type(),0);
        this.EnergiesAssociated.put(new FireEnergy().type(),0);
        this.EnergiesAssociated.put(new PlantEnergy().type(),0);
        this.EnergiesAssociated.put(new FightingEnergy().type(),0);
        this.EnergiesAssociated.put(new ElectricEnergy().type(),0);
        this.EnergiesAssociated.put(new PsychicEnergy().type(),0);
    }

    public String getName(){
        return this.name;
    }
    public int getHP(){
        return this.hp;
    }
    public int getPokedexID(){
        return this.pokedexID;
    }
    public List<Attack> getAttackList(){
        return this.attackList;
    }
    public HashMap<String, Integer> getEnergiesAssociated(){
        return this.EnergiesAssociated;
    }
    public int getQuantityofAnEnergy(IEnergy energy){
        return this.EnergiesAssociated.get(energy.type());
    }
    public int getQuantityofAnEnergy(String energy){
        return this.EnergiesAssociated.get(energy);
    }
    public ArrayList<Attack> getAttacksList(){
        return this.attackList;
    }
    public boolean isAlive(){
        if(this.hp<=0){
            return false;
        }
        else{return true;}

    }

    public void setAttack(Attack anAttack){
        if(this.attackList.size()>=4){
            System.out.println("Pokemon already has 4 attacks");
        }
        else{
            this.attackList.add(anAttack);
        }
    }



    public void receiveWeaknessAttack(Attack anAttack){
        this.hp-=anAttack.getBaseDamage()*2;
        if (this.hp<0){this.hp=0;}
    }
    public void receiveResistantAttack(Attack anAttack){
        this.hp-=(anAttack.getBaseDamage()-30);
        if (this.hp<0){this.hp=0;}
    }
    public void receiveNormalAttack(Attack anAttack){
        this.hp-=anAttack.getBaseDamage();
        if (this.hp<0){this.hp=0;}
    }

    public void beingPlayedBy(Entrenador inAction){
        inAction.addPokemontoBank(this);
    }
}
