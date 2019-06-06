package cc3002.tarea1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Class which represents a Pokemon player and all the actions he/she can perform
 * @author Adèle Bourgeix
 */
public class Player {
    private String name;
    private List<ICard> hand;
    private List<IPokemon> pokemonBank;
    private IPokemon selectedPokemon;
    private List<ICard> lostCards;
    private List<ICard> cardStack;
    private List<ICard> primeCards;

    /**
     * Trainer's constructor
     * @param name player's name that we'll use to refer to him
     */

    public Player(String name){
        this.name=name;
        hand= new ArrayList<ICard>(6);
        pokemonBank=new ArrayList<IPokemon>(6);
        selectedPokemon= null;
        lostCards =new ArrayList<ICard>();
        cardStack=new ArrayList<ICard>();
        primeCards=new ArrayList<ICard>();

    }

    /**
     * Initiate the player's deck of cards using a set of existing cards and shuffling them to simulate hazard
     * @param list the set of cards to be shuffled
     */
    public void initiateDeck(List<ICard> list){
        shuffleCards(60,this.cardStack,list);

    }

    /**
     * Initiate the player's prime cards using a set of existing cards and shuffling them to simulate hazard
     * @param list the set of cards to be shuffled
     */
    public void initiatePrimeCards(List<ICard> list){
        shuffleCards(6,this.primeCards,list);

    }

    /**
     * Shuffle function which allows to shuffle a set of cards to fill a stack (avoid code duplication)
     * @param x size of the stack to be filled
     * @param list stack to be filled
     * @param shuffled set of cards to be shuffled
     */
    public void shuffleCards(int x, List<ICard> list, List<ICard> shuffled){
        int countSet= shuffled.size();
        System.out.println(countSet);
        int countleft=60;
        while (list.size()!=x){
            Collections.shuffle(shuffled);
            if (countleft>=countSet){
                for (int i=0; i<countSet; i++){
                    list.add(shuffled.get(i));
                }
                countleft-=countSet;
            }
            else{
                for (int i=0;i<countleft;i++ ){
                    list.add(shuffled.get(i));
                }
            }
        }
    }


    /**
     * A player can add one Pokemon from his hand to his Pokemon bank
     * @param pokemon Pokemon that's going to be put in the player's bank
     */
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

    /**
     * A player can select one of his Pokemons to be put on the battle field
     * @param aPokemon Pokemon that is going to be selected
     */
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

    /**
     * Player draws card from stack
     * @param card Card from stack
     */
    public void drawCard(ICard card){
        this.hand.add(card);
    }

    /**
     * Getter to the player's name
     * @return
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter to the number of cards in the player's hand
     * @return
     */
    public int getHandSize(){
        return this.hand.size();
    }

    /**
     * Getter to the Pokemon, the player put in the battlefield
     * @return
     */
    public IPokemon getSelectedPokemon(){
        return this.selectedPokemon;
    }

    /**
     * Getter to the Pokemons the player put in his bank
     * @return
     */
    public List<IPokemon> getBank(){
        return this.pokemonBank;
    }

    /**
     * Getter to the cards in the player's hand
     * @return
     */
    public List<ICard> getHand(){
        return this.hand;
    }

    public List<ICard> getStack(){
        return this.cardStack;
    }

    public List<ICard> getPrimeCards(){
        return this.primeCards;
    }

    /** A player can play an Energy Card on his selected Pokemon or add a Pokemon Card to his Pokemon bank
     * @param aCard Energy or Pokemon card played by the player
     */
    public void playCard(ICard aCard){
        if(!hand.contains(aCard)){
            System.out.println("The player cannot play a card which is not in his hand");
        }
        aCard.beingPlayedBy(this);
    }

    /**
     * A player uses one of his selected pokemon's attack to play it against the pokemon of his opponent. The attack can only be performed if the Pokemon posesses it and has enough energy to use it.
     * @param anAttack attack used by the player
     * @param following the opponent of the player who uses the attack
     */
    public void useAttack(Attack anAttack, Player following) {
        if (!this.getSelectedPokemon().getAttacksList().contains(anAttack)) {
            System.out.println("Pokemon cannot use attack he doesn't posess");
        } else {
            //compare energies
            HashMap<String,Integer> map= anAttack.getCosts();
            boolean canAttack=true;
            for (String key:map.keySet()) {
                int energy=map.get(key);
                int quantity= this.getSelectedPokemon().getEnergiesAssociated().get(key);
                if(energy!=quantity){
                    canAttack=false;
                    break;
                }
            }
            if(canAttack==true){
                this.getSelectedPokemon().hurt(following.getSelectedPokemon(), anAttack);
                if (!following.getSelectedPokemon().isAlive()){
                    IPokemon lost=following.pokemonBank.get(0);
                    following.getBank().remove(0);
                    following.lostCards.add(lost);
                    IPokemon newPokemoninGame=following.getBank().get(0);
                    following.selectPokemon(newPokemoninGame);
                }
            }
            else{
                System.out.println("The pokemon doesn't posess enough energy to use this attack");
            }
        }
    }

}
