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

/**
 * Pokemon Abstract class which extends the Pokemon interface
 * @author Adèle Bourgeix
 */
public abstract class APokemon implements IPokemon  {
    private String name;
    private int pokedexID;
    private int hp;
    public HashMap<String, Integer> EnergiesAssociated;
    private ArrayList<Attack> attackList;

    /** A Pokemon is created: a name is given to it, it's assigned an index of the Pokedex, some hp and a set of attacks it'll be allowed to perform.
     * @param someName name given to the pokemon
     * @param somePokedexID Pokedex index used to refer to it
     * @param someHP HP which shows if the pokemon can remain on the battlefield to fight
     * @param attacks attacks pokemon can perform
     */
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

    @Override
    public String getTitle(){
        return this.name;
    }
    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public int getHP(){
        return this.hp;
    }
    @Override
    public int getPokedexID(){
        return this.pokedexID;
    }

    public List<Attack> getAttackList(){
        return this.attackList;
    }
    @Override
    public HashMap<String, Integer> getEnergiesAssociated(){
        return this.EnergiesAssociated;
    }
    @Override
    public int getQuantityofAnEnergy(IEnergy energy){
        return this.EnergiesAssociated.get(energy.type());
    }

    @Override
    public ArrayList<Attack> getAttacksList(){
        return this.attackList;
    }
    @Override
    public boolean isAlive(){
        if(this.hp<=0){
            return false;
        }
        else{return true;}

    }

    @Override
    public void setAttack(Attack anAttack){
        if(this.attackList.size()>=4){
            System.out.println("Pokemon already has 4 attacks");
        }
        else{
            this.attackList.add(anAttack);
        }
    }

    @Override
    public void receiveFireAttack(Attack anAttack){this.receiveNormalAttack(anAttack);}
    @Override
    public void receiveWaterAttack(Attack anAttack){this.receiveNormalAttack(anAttack);}
    @Override
    public void receivePlantAttack(Attack anAttack){this.receiveNormalAttack(anAttack);}
    @Override
    public void receiveElectricAttack(Attack anAttack){this.receiveNormalAttack(anAttack);}
    @Override
    public void receiveFightingAttack(Attack anAttack){this.receiveNormalAttack(anAttack);}
    @Override
    public void receivePsychicAttack(Attack anAttack){this.receiveNormalAttack(anAttack);}


    @Override
    public void receiveWeaknessAttack(Attack anAttack){
        this.hp-=anAttack.getBaseDamage()*2;
        if (this.hp<0){this.hp=0;}
    }
    @Override
    public void receiveResistantAttack(Attack anAttack){
        this.hp-=(anAttack.getBaseDamage()-30);
        if (this.hp<0){this.hp=0;}
    }
    @Override
    public void receiveNormalAttack(Attack anAttack){
        this.hp-=anAttack.getBaseDamage();
        if (this.hp<0){this.hp=0;}
    }
    @Override
    public void beingPlayedBy(Player inAction){
        inAction.addPokemontoBank(this);
    }

    @Override
    public void addElectricEnergy(ElectricEnergy en){
        this.receiveEnergy(en);
    }

    @Override
    public void addFightingEnergy(FightingEnergy en){
        this.receiveEnergy(en);
    }

    @Override
    public void addFireEnergy(FireEnergy en){
        this.receiveEnergy(en);
    }

    @Override
    public void addPsychicEnergy(PsychicEnergy en){
        this.receiveEnergy(en);
    }

    @Override
    public void addPlantEnergy(PlantEnergy en){
        this.receiveEnergy(en);
    }

    @Override
    public void addWaterEnergy(WaterEnergy en){
        this.receiveEnergy(en);
    }

    @Override
    public void receiveEnergy(IEnergy en){
        int numberAlreadyAssociated=EnergiesAssociated.get(en.type());
        numberAlreadyAssociated+=1;
        EnergiesAssociated.remove(en.type());
        EnergiesAssociated.put(en.type(),numberAlreadyAssociated);}

}
