package cc3002.tarea1.Psychic;

import cc3002.tarea1.AEnergy;

public class PsychicEnergy extends AEnergy {

    public PsychicEnergy(String someName){super(someName);}

    @Override
    public String type(){
        return "Psychic";
    }
}
