package cc3002.tarea1;

import java.util.HashMap;

public abstract class AEnergy implements IEnergy {
    public void beingPlayedBy(Entrenador inAction){
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
