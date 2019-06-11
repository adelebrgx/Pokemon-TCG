package cc3002.tarea1;

import java.util.ArrayList;
import java.util.List;

public class TrainingCenter extends AStateCard {

    private int x;

    public TrainingCenter(String aName, String aDescription, int x){
        super(aName,aDescription);
        this.x=x;
    }

    public int getX(){
        return this.x;
    }

    @Override
    public void beingPlayedBy(Player player) {
        List<IPokemon> list= player.getBank();
        for (IPokemon pokemon: list){
            pokemon.isBeingInspected(this);
        }

    }

    @Override
    public void inspectPhase1Pokemon(IPhase1Pokemon phase1){
        int hp= phase1.getHP()+x;
        phase1.setHP(hp);
    }

    @Override
    public void inspectPhase2Pokemon(IPhase2Pokemon phase2){
        int hp= phase2.getHP()+x;
        phase2.setHP(hp);
    }
}
