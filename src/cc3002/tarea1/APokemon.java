package cc3002.tarea1;

import java.util.ArrayList;
import java.util.List;

public abstract class APokemon implements IPokemon{
    private String name;
    private int pokedexID;
    private int hp;
    private List<IAttack> attackList;

    public APokemon(String someName, int somePokedexID, int someHP){
        this.name=someName;
        this.pokedexID=somePokedexID;
        this.hp=someHP;
        this.attackList= new ArrayList<IAttack>(4);
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

}
