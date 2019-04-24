package cc3002.tarea1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interface which represents the Pokemon behavior.
 * @author Adèle Bourgeix
 */
public interface IPokemon extends ICard{
    /**
     * Getter to a Pokemon's name
     * @return
     */
    public String getName();

    /**
     * Getter to a Pokemon's hp
     * @return
     */
    public int getHP();

    /**
     * Getter to a Pokemon's pokedex ID
     * @return
     */
    public int getPokedexID();

    /**
     * Getter to a Pokemon's list of attacks
     * @return
     */
    public ArrayList<Attack> getAttacksList();

    /**
     * Getter to a Pokemon's type: fire, water, plant, psychic, fighting, electric
     * @return
     */
    public String type();

    /**
     * Getter to the energies that've been associated to a pokemon
     * @return
     */
    public HashMap<String, Integer> getEnergiesAssociated();

    /**Getter of the quantity of one specific energy that's been associated to a pokemon
     * @param energy the energy looked for
     * @return
     */
    public int getQuantityofAnEnergy(IEnergy energy);

    /**Method which allows us to know if a pokemon was lost on the battlefield. Returns false if the pokemon's hp is egual or inferior to 0.
     * @return
     */
    public boolean isAlive();

    /**Method to assign an attack to a Pokemon he'll be able to use in the game
     * @param anAttack attack given to the pokemon
     */
    public void setAttack(Attack anAttack);

    /** A Pokemon, once asked by the player, we'll be able to perform an attack over another pokemon, more precisely the one selected by its player's opponent
     * @param pokemon pokemon which receives the attack
     * @param anAttack attack performed by the pokemon
     */
    public void hurt(IPokemon pokemon, Attack anAttack);


    /** Method which shows the damages received by a pokemon after receiving a fire attack
     * @param anAttack attack of type fire received by the pokemon
     */
    public void receiveFireAttack(Attack anAttack);

    /** Method which shows the damages received by a pokemon after receiving a water attack
     * @param anAttack attack of type water received by the pokemon
     */
    public void receiveWaterAttack(Attack anAttack);

    /**Method which shows the damages received by a pokemon after receiving a plant attack
     * @param anAttack attack of type plant received by the pokemon
     */
    public void receivePlantAttack(Attack anAttack);

    /** Method which shows the damages received by a pokemon after receiving an electric attack
     * @param anAttack attack of type electric received by the pokemon
     */
    public void receiveElectricAttack(Attack anAttack);

    /** Method which shows the damages received by a pokemon after receiving a fighting attack
     * @param anAttack attack of type fighting received by the pokemon
     */
    public void receiveFightingAttack(Attack anAttack);

    /** Method which shows the damages received by a pokemon after receiving a psychic attack
     * @param anAttack attack of type psychic received by the pokemon
     */
    public void receivePsychicAttack(Attack anAttack);


    /**Method which affects a pokemon's hp after an attack given he's not resistant to his opponent's pokemon
     * @param attack attack the other player's pokemon performs on it
     */
    public void receiveWeaknessAttack(Attack attack);

    /**Method which affects a pokemon's hp after an attack given he's resistant to his opponent's pokemon
     * @param attack attack the other player's pokemon performs on it
     */
    public void receiveResistantAttack(Attack attack);

    /**Method which affects a pokemon's hp after an attack given he's nor resistant nor weak to his opponent's pokemon
     * @param attack attack the other player's pokemon performs on it
     */
    public void receiveNormalAttack(Attack attack);


    /** What happens when the pokemon card is played
     * @param inAction Player who plays the pokemon card
     */
    public void beingPlayedBy(Entrenador inAction);



}
