package cc3002.tarea1;

import java.util.HashMap;

/**
 * Class used to describe the behavior of an attack one pokemon posess which is a special type of ability
 * @author Adèle Bourgeix
 */
public abstract class Attack extends AAbility implements IAttack{
    private int baseDamage;



    /**Constructor of an attack, giving it a name, a number of points taken to the player's opponent's pokemon and a short description of the attack
     * @param aName name used to refer to the attack
     * @param abaseDamage number of points taken to the pokemon which receives the attack
     * @param aDescription short description of the attack, giving its type for example
     */
    public Attack(String aName, int abaseDamage, String aDescription){
        super(aName,aDescription);
        this.baseDamage=abaseDamage;

    }


    /** Getter for the number of points lost by the pokemon which will receive this attack
     * @return an integer which represents the base damage of an attack
     */
    public int getBaseDamage() {
        return this.baseDamage;
    }

    @Override
    public void isBeingActivated(Player first, Player following){
        if (!first.getSelectedPokemon().getAttacksList().contains(this)) {
            System.out.println("Pokemon cannot use attack he doesn't posess");
        } else {
            boolean canAttack=canBeUsed(first);
            if(canAttack){
                first.getSelectedPokemon().hurt(following.getSelectedPokemon(), this);
                if (!following.getSelectedPokemon().isAlive()){
                    IPokemon lost=following.getBank().get(0);
                    following.getBank().remove(0);
                    following.getLostCards().add(lost);
                    IPokemon newPokemoninGame=following.getBank().get(0);
                    following.selectPokemon(newPokemoninGame);
                }
            }
            else{
                System.out.println("The pokemon doesn't posess enough energy to use this attack");
            }
        }
    }


    public boolean canBeUsed(Player player){
        //compare energies
        HashMap<String,Integer> map= this.getCosts();
        boolean canAttack=true;
        for (String key:map.keySet()) {
            int energy=map.get(key);
            int quantity= player.getSelectedPokemon().getEnergiesAssociated().get(key);
            if(energy>quantity){
                canAttack=false;
                break;
            }
        }
        if (canAttack){
            for (String key:map.keySet()) {
                int energy=map.get(key);
                int quantity= player.getSelectedPokemon().getEnergiesAssociated().get(key);
                player.getSelectedPokemon().getEnergiesAssociated().remove(key);
                player.getSelectedPokemon().getEnergiesAssociated().put(key,quantity-energy);
            }
        }
        return canAttack;
    }





}
