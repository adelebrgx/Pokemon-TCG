package cc3002.tarea1;

import java.util.HashMap;

/**
 * Abstract class which implements the IEnergy interface and extends the concept of energy card
 * @author Adèle Bourgeix
 */
public abstract class AEnergy implements IEnergy{

    private String name;

    /** Creates a new energy
     * @param someName name given to the energy card
     */
    public AEnergy(String someName){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void beingPlayedBy(Player inAction){
        if (inAction.getBank().size()==0){
            System.out.println("There is no Pokemon to apply this energy to");
        }
        else{
        IPokemon selectedPokemon= inAction.getSelectedPokemon();
        HashMap<String, Integer> EnergiesAssociated=selectedPokemon.getEnergiesAssociated();
        int numberAlreadyAssociated=EnergiesAssociated.get(this.type());
        numberAlreadyAssociated+=1;
        EnergiesAssociated.remove(this.type());
        EnergiesAssociated.put(this.type(),numberAlreadyAssociated);}
    }
}
