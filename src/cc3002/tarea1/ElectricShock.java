package cc3002.tarea1;

import java.util.Random;

/**
 * Class which allows instantiating attacks of type electric Shock. Implemented using a Visitor pattern to visit the player and the opponent's pokemon.
 * @author Adèle Bourgeix
 */
public class ElectricShock extends Attack {

    private int x;

    /**
     * Constructor for attacks of type electric shock
     * @param aName name for the electric shock attack
     * @param aBaseDamage base damage for the electric shock attack
     * @param aDescription description for the electric shock attack
     * @param x what damage will be caused to the opponent's selected Pokemon if it's tails
     */
    public ElectricShock(String aName, int aBaseDamage, String aDescription, int x){
        super(aName,aBaseDamage,aDescription);
        this.x=x;}




    @Override
    public void isBeingActivated(Player first, Player following){
        if(!first.getSelectedPokemon().getAbilitiesList().contains(this)){
            System.out.println("The pokemon cannot use Electric Shock");
        }
        else{
            IPokemon pokemon= following.getSelectedPokemon();
            pokemon.isBeingAffectedBy(this);
        }

    }


    @Override
    public void affect(IPokemon pokemon){
        Random random = new Random();
        int rand= random.nextInt(2);
        System.out.println(rand);
        if (rand==0){
            int hp= pokemon.getHP()-x;
            pokemon.setHP(hp);
        }
    }


    /**
     * Getter to the damage inflected
     * @return the damage inflected of type integer
     */
    public int getX(){
        return this.x;
    }


}
