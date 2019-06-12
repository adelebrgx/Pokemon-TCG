package cc3002.tarea1.Psychic;

import cc3002.tarea1.AEnergy;
import cc3002.tarea1.Player;

/**
 * Class which extends the notion of energy card to psychic energies
 * @author Adèle Bourgeix
 */
public class PsychicEnergy extends AEnergy {

    /**
     * Creates an energy of type water given it the name "Psychic"
     */
    public PsychicEnergy(){super("Psychic");}

    @Override
    public String type(){
        return "Psychic";
    }


    @Override
    public void beingPlayedBy(Player inAction) {
        int index=inAction.submitIndex(this);
        if(canbeUsed(inAction, index)){
            inAction.getBank().get(index).addPsychicEnergy(this);
            inAction.setPlayingEnergy(true);
        }

    }
}

