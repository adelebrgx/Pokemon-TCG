package cc3002.tarea1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class APokemon implements IPokemon  {
    private String name;
    private int pokedexID;
    private int hp;
    public HashMap<String, Integer> EnergiesAssociated;
    private ArrayList<IAttack> attackList;

    public APokemon(String someName, int somePokedexID, int someHP){
        this.name=someName;
        this.pokedexID=somePokedexID;
        this.hp=someHP;
        this.attackList= new ArrayList<IAttack>(4);
        this.EnergiesAssociated= new HashMap<String, Integer>();
        this.EnergiesAssociated.put("Water",0);
        this.EnergiesAssociated.put("Fire",0);
        this.EnergiesAssociated.put("Plant",0);
        this.EnergiesAssociated.put("Fighting",0);
        this.EnergiesAssociated.put("Electric",0);
        this.EnergiesAssociated.put("Psychic",0);
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
    public List<IAttack> getAttackList(){
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
    public ArrayList<IAttack> getAttacksList(){
        return this.attackList;
    }

    public void setAttack(IAttack anAttack){
        if(this.attackList.size()>=4){
            System.out.println("Pokemon already has 4 attacks");
        }
        else{
            this.attackList.add(anAttack);
        }
    }

    public void receiveWeaknessAttack(IAttack anAttack){
        this.hp-=anAttack.getBaseDamage()*2;
    }
    public void receiveResistantAttack(IAttack anAttack){
        this.hp-=(anAttack.getBaseDamage()-30);
    }
    public void receiveNormalAttack(IAttack anAttack){
        this.hp-=anAttack.getBaseDamage();
    }

    public void beingPlayedBy(Entrenador inAction){
        inAction.addPokemontoBank(this);
    }
}
