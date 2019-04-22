package cc3002.tarea1.Fighting;

import cc3002.tarea1.AEnergy;

public class FightingEnergy extends AEnergy {

    public FightingEnergy(String someName){super(someName);}

    @Override
    public String type(){
        return "Fighting";
    }
}
