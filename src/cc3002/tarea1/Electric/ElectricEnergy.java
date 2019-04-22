package cc3002.tarea1.Electric;

import cc3002.tarea1.AEnergy;

public class ElectricEnergy extends AEnergy {

    public ElectricEnergy(String someName){super(someName);}

    @Override
    public String type(){
        return "Electric";
    }
}
