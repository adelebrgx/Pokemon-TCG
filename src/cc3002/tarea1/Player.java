package cc3002.tarea1;

import java.util.*;

/**
 * Class which represents a Pokemon player and all the actions he/she can perform
 * @author Adèle Bourgeix
 */
public class Player {
    private String name;
    private List<ICard> hand;
    private List<IPokemon> pokemonBank;
    private IPokemon selectedPokemon;
    private IPokemon beneficientPokemon;
    private List<ICard> lostCards;
    private List<ICard> cardStack;
    private List<ICard> primeCards;
    private PlayerState state;
    private boolean hasPlayedSupport;
    private boolean isPlaying;
    private boolean hasEndedTurn;
    private boolean EnergyPlayed;
    private boolean AbilityUsed;
    private Controller controller;

    /**
     * Trainer's constructor
     * @param name player's name that we'll use to refer to him
     */

    public Player(String name){
        this.name=name;
        hand= new ArrayList<>();
        pokemonBank=new ArrayList<>(6);
        selectedPokemon= null;
        lostCards =new ArrayList<>();
        cardStack=new ArrayList<>(60);
        primeCards=new ArrayList<>(6);
        state=new InitialState();
        controller=new NullController();


    }

    /**
     * Assigning a controller to a player to control his/her actions
     * @param controller which is being assigned
     */
    public void assignController(Controller controller){
        this.controller=controller;
    }


    /**
     * Setting a state to the player. Used when performing a crucial action.
     * @param aState state assigned to the player
     */
    public void setState(PlayerState aState) {
        state.setPlayer(this);
        state = aState;
        controller.update(this);
    }

    /**
     * Returns the player's controller
     * @return a controller
     */
    public Controller getController(){
        return controller;
    }


    /**
     * getter to the player's state
     * @return a state in which is the player
     */
    public PlayerState getState(){
        return this.state;
    }

    /**
     * Gives permission to play to a player
     * @param bool true if playing
     */
    public void setPlaying(boolean bool){
        isPlaying=bool;
    }

    /**
     * Indicates if the player is playing or not
     * @return true if yes
     */
    public boolean getIsPlaying(){
        return this.isPlaying;
    }

    /**
     * When a player ends his/her turn
     * @param bool true if ended
     */
    public void setEndingTurn(boolean bool){
        this.hasEndedTurn=bool;
    }

    /**
     * indicates if the player's done his turn
     * @return true if yes
     */
    public boolean getEndingTurn(){
        return this.hasEndedTurn;
    }

    /**
     * When a player uses one ability during his turn
     * @param bool true if used
     */
    public void setUsingAbility(boolean bool){
        AbilityUsed=bool;}


    /**
     * Indicates if the player's used an ability during the turn (cannot use more than one during each turn)
     * @return true if yes
     */
    public boolean getUsingAbility(){
        return AbilityUsed;
    }


    /**
     * When a player play an energy card during his turn
     * @param bool true if used
     */

    public void setPlayingEnergy(boolean bool){
        EnergyPlayed=bool;
    }

    /**
     *  Indicates if the player's played an energy card during the turn (cannot use more than one during each turn)
     * @return true if played
     */
    public boolean getPlayingEnergy(){
        return EnergyPlayed;
    }

    /**
     * Indicates if the player has used a support card
     * @return true if used
     */
    public boolean getSupportPlayed(){
        return hasPlayedSupport;
    }

    /**
     * When a player uses a support card during a turn
     * @param b true if used
     */
    public void setHasPlayedSupport(boolean b){
        hasPlayedSupport=b;
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
            hand.remove(pokemon);
        }

    }

    /**
     * A player can select one of his Pokemons to be put on the battle field
     * @param aPokemon Pokemon that is going to be selected
     */
    public void selectPokemon(IPokemon aPokemon){
        if(!pokemonBank.contains(aPokemon)){
            if(!hand.contains(aPokemon)){
                System.out.println("Player does not posess this pokemon");
            }
            addPokemontoBank(aPokemon);
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
     * Player can draw a card from his/her deck
     */
    public void getCard(int i){
        if(cardStack.size()==0 || cardStack.size()<i){
            System.out.println("There aren't enough cards in the stack");
        }
        else{
            for (int j=0; j<i; j++){
                ICard newCard= this.cardStack.get(i);
                this.hand.add(newCard);
                cardStack.remove(newCard);
            }
        }
    }

    /**
     * method to draw one card to make easier testing, will not be used to implement the game
     * @param card the card which will be drawn for the test
     */
    public void takeCard(ICard card){
        this.hand.add(card);
    }


    /**
     * When a card is put aside by the player for any reason
     * @param card card being put aside
     */
    public void eliminate(ICard card){
        this.hand.remove(card);
        this.lostCards.add(card);
    }

    /**
     * Getter to the player's name
     * @return a String which is the player's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter to the Pokemon the player put in the battlefield
     * @return a Pokemon which is in the battlefields
     */
    public IPokemon getSelectedPokemon(){
        return this.selectedPokemon;
    }

    /**
     * Getter to the Pokemons the player put in his bank
     * @return a list of pokemons the player put in his bank
     */
    public List<IPokemon> getBank(){
        return this.pokemonBank;
    }

    /**
     * Getter to the cards in the player's hand
     * @return a list of cards in the  player's hand
     */
    public List<ICard> getHand(){
        return this.hand;
    }

    /**
     * A getter to the player's deck of cards
     * @return a list of cards which is it's deck of cards
     */
    public List<ICard> getStack(){
        return this.cardStack;
    }

    /**
     * A getter to the player's prime cards
     * @return a list of the player's prime cards
     */
    public List<ICard> getPrimeCards(){
        return this.primeCards;
    }

    /**
     * A getter to the cards put aside by the player for some reason (defeated Pokemon...)
     * @return a list of cards which are the player's lost cards
     */
    public List<ICard> getLostCards(){
        return this.lostCards;
    }

    /** A player can play an Energy Card on his selected Pokemon or add a Pokemon Card to his Pokemon bank
     * @param aCard Energy or Pokemon card played by the player
     */
    public void playCard(ICard aCard){
        if(isPlaying){
            if(!hand.contains(aCard)){
                System.out.println("The player cannot play a card which is not in his hand");
            }
            else if(!state.isInFirstState()){
                System.out.println("The player needs to draw a card before beginning playing cards");
            }
            else{
                aCard.beingPlayedBy(this);

            }
        }
        else{
            controller.error();
        }


    }

    /**
     * A player uses one of his selected pokemon's attack to play it against the pokemon of his opponent. The attack can only be performed if the Pokemon posesses it and has enough energy to use it.
     * @param anAttack ability used by the player
     * @param following the opponent of the player who uses the attack
     */
    public void useAttack(IAttack anAttack, Player following) {
        if(isPlaying){
            if(state.isInInitialState()){
                System.out.println("The player hasn't drawn any card yet");
            }
            else if (state.isInFirstState()){
                System.out.println("The player needs to declare he/she's done performing actions");
            }
            else{
                anAttack.isBeingActivated(this,following);
                state.attack(this);
            }
        }
        else{
            controller.error();
        }


    }

    /**
     * When a player enables ability of his selected pokemon
     * @param ability being enabled
     */
    public void enableHability(IAbility ability){
        if(isPlaying){
            if (state.isInFirstState()){
                if(AbilityUsed){
                    System.out.println("One ability has already been played by player");
                }
                else {
                    AbilityUsed=true;
                    ability.isBeingEnabled(this);
                }
            }
            else if(state.isInInitialState()){
                System.out.println("The player hasn't drawn any card yet");
            }
            else {
                System.out.println("The player has already performed all attacks he could perform");
            }
        }
        else{
            controller.error();
        }



    }

    /**
     * Player draws card from his stack
     */
    public void drawCard(){
        if(isPlaying){
            if (!state.isInInitialState()){
                System.out.println("You've already drawn a card ");
            }
            else{
                this.hand.add(cardStack.get(0));
                cardStack.remove(0);
                state.drawCard(this);
            }
        }
        else{
            controller.error();
        }

    }

    /**
     * Player declares he/she's done performing actions of type abilities/ playing cards/see cards
     */
    public void endActions(){
        if(isPlaying){
            state.endActions(this);
        }
        else {
            controller.error();
        }
    }

    /**
     * Player ends his/her turn
     */
    public void endTurn(){
        if(isPlaying){
            state.endTurn(this);

        }
        else {
            controller.error();
        }

    }

    /**
     * Player can see his/her cards
     * @return
     */
    public List<ICard> seeCards(){
        if(isPlaying){
            if (state.isInFirstState()){
                return this.hand;
            }
            else{
                System.out.println("The player cannot see the opponent's Pokemon now");
                return new ArrayList<>();
            }

        }
        else{
            System.out.println("This is not the player's turn");
            return new ArrayList<>();
        }

    }

    /**
     * Player can his Pokemons
     * @return list of the player's Pokemons
     */
    public  List<IPokemon> seeMyPokemons(){
        if(isPlaying){
            if(state.isInFirstState()){
                return this.getBank();
            }
            else{
                System.out.println("The player cannot see his Pokemon now");
                return new ArrayList<>();
            }

        }
        else {
            System.out.println("This is not the player's turn");
            return new ArrayList<>();
        }


    }

    /**
     * Player can see his opponent's Pokemon
     * @param opponent Player's opponent
     * @return list of the oppoent's Pokemons
     */
    public List<IPokemon> seeOpponentPokemons(Player opponent){
        if(isPlaying){
            if(state.isInFirstState()){
                return opponent.getBank();
            }
            else {
                System.out.println("The player cannot see the opponent's Pokemon now");
                return new ArrayList<>();
            }

        }
        else {
            System.out.println("This is not the player's turn");
            return new ArrayList<>();
        }


    }

    /**
     * Allows select a pokemon which will receive an energy for example
     * @param pokemon which will receive the energy
     */
    public void selectBeneficientPokemon(IPokemon pokemon){
        if(!this.pokemonBank.contains(pokemon)){
            System.out.println("You cannot perform action on this Pokemon as you do not have it on your battlefield");
        }
        else{
            this.beneficientPokemon=pokemon;
        }
    }

    /**
     * return the pokemon which was selected
     * @return a pokemon selected by the player
     */
    public IPokemon getbenefiecient(){
        return this.beneficientPokemon;
    }









}
