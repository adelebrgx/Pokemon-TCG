package cc3002.tarea1.Plant;

import cc3002.tarea1.AEnergy;

public class PlantEnergy extends AEnergy {

    public PlantEnergy(String someName){super(someName);}

    @Override
    public String type(){
        return "Plant";
    }
}
