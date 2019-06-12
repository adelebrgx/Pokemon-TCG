package cc3002.tarea1.Fighting;

import cc3002.tarea1.AEnergy;
import cc3002.tarea1.Player;

/**
 * Class which extends the notion of energy card to fighting energies
 * @author Adèle Bourgeix
 */
public class FightingEnergy extends AEnergy {

    /**
     * Creates an energy of type water given it the name "Fighting"
     */
    public FightingEnergy(){super("Fighting");}

    @Override
    public String type(){
        return "Fighting";
    }

    @Override
    public void beingPlayedBy(Player inAction) {
        int index=inAction.submitIndex(this);
        if (inAction.getBank().size() == 0 || index==-1) {
            System.out.println("There is no Pokemon to apply this energy to");
        } else {
            if(inAction.getPlayingEnergy()){
                System.out.println("One energy has already been used");
            }
            else {
                if(inAction.getPlayingEnergy()){
                    System.out.println("One energy has already been used");
                }
                else {
                    inAction.getBank().get(index).addFightingEnergy(this);
                    inAction.setPlayingEnergy(true);
                }
            }
        }
    }
}
