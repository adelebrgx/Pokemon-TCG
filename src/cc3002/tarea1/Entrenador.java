package cc3002.tarea1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Entrenador {
    private String name;
    private List<ICard> hand;
    private List<IPokemon> pokemonBank;
    private IPokemon selectedPokemon;

    //Constructor del entrenador
    public Entrenador(String name){
        this.name=name;
        hand= new ArrayList<ICard>(6);
        pokemonBank=new ArrayList<IPokemon>(6);
        selectedPokemon= null;

    }

    public void addPokemontoBank(IPokemon pokemon){
        if(!hand.contains(pokemon)){
            System.out.println("The player does not have this pokemon in his or her hand");
        }
        else{
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

    }

    public void selectPokemon(IPokemon aPokemon){
        if(!hand.contains(aPokemon)){
            System.out.println("Player does not posess this pokemon");
        }
        else if (this.pokemonBank.size()==0){
            addPokemontoBank(aPokemon);
        }
        else {
            int i= this.pokemonBank.indexOf(aPokemon);
            IPokemon temp= this.pokemonBank.get(0);
            this.pokemonBank.set(0,aPokemon);
            this.pokemonBank.set(i,temp);
            selectedPokemon=this.pokemonBank.get(0);


        }
    }

    public void drawCard(ICard card){
        this.hand.add(card);
    }

    public String getName(){
        return this.name;
    }

    public int getHandSize(){
        return this.hand.size();
    }

    public IPokemon getSelectedPokemon(){
        return this.selectedPokemon;
    }

    public List<IPokemon> getBank(){
        return this.pokemonBank;
    }

    public List<ICard> getHand(){
        return this.hand;
    }

    public void playCard(ICard aCard){
        if(!hand.contains(aCard)){
            System.out.println("The player cannot play a card which is not in his hand");
        }
        aCard.beingPlayedBy(this);
    }

    public void attack(IAttack anAttack, Entrenador following) {
        if (!this.getSelectedPokemon().getAttacksList().contains(anAttack)) {
            System.out.println("Pokemon cannot use attack he doesn't posess");
        } else {
            //compare energies
            HashMap<String,Integer> map= anAttack.getCosts();
            boolean canAttack=true;
            for (String key:map.keySet()) {
                int energy=map.get(key);
                int quantity= this.getSelectedPokemon().getQuantityofAnEnergy(key);
                if(energy!=quantity){
                    canAttack=false;
                    break;
                }
            }
            if(canAttack==true){
                anAttack.performAttack(following.getSelectedPokemon());
                //verificamos si murio el Pokemon
                if (following.getSelectedPokemon().getHP()<=0){
                    following.getBank().remove(0);
                    following.selectedPokemon=following.getBank().get(0);
                }
            }
            else{
                System.out.println("The pokemon doesn't posess enough energy to use this attack");
            }
        }
    }

}
