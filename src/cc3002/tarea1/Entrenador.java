package cc3002.tarea1;
import java.util.ArrayList;
import java.util.List;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.APokemon;
import cc3002.tarea1.Fire.FirePokemon;

public class Entrenador {
    private String name;
    private List<ICard> hand;
    private List<IPokemon> pokemonBank;
    private IPokemon selectedPokemon;

    public Entrenador(String name){
        this.name=name;
        hand= new ArrayList<ICard>(6);
        pokemonBank=new ArrayList<IPokemon>(6);
        selectedPokemon= null;




    }

    public void addPokemontoBank(IPokemon pokemon){
        if (this.pokemonBank.size()==0){
            selectedPokemon=pokemon;
            this.pokemonBank.add(pokemon);
        }
        else if (this.pokemonBank.size()<6){
            this.pokemonBank.add(pokemon);}
        else{
            System.out.println("Player already has 6 Pokemon in his Pokemon Bank");
        }

    }

    public IPokemon getSelectedPokemon(){
        return this.selectedPokemon;
    }

    public List<IPokemon> getBank(){
        return this.pokemonBank;
    }


    public void addCardToHand(ICard card){
        if (this.hand.size()<6){
            this.hand.add(card);}
        else {
            System.out.println("Player already has 6 cards in his hand");
        }
    }
    public String getName(){
        return this.name;
    }
    public int getHand(){return this.hand.size();}
}
