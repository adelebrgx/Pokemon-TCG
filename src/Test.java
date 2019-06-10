import cc3002.tarea1.*;
import cc3002.tarea1.Fighting.FightingEnergy;
import cc3002.tarea1.Fire.BasicFirePokemon;
import cc3002.tarea1.Fire.Phase1FirePokemon;
import cc3002.tarea1.Fire.Phase2FirePokemon;
import cc3002.tarea1.Plant.PlantEnergy;
import cc3002.tarea1.Water.BasicWaterPokemon;
import cc3002.tarea1.Water.Phase1WaterPokemon;
import cc3002.tarea1.Water.Phase2WaterPokemon;
import cc3002.tarea1.Water.WaterEnergy;

import java.util.ArrayList;

public class Test {

    public static void main(String [] args)
    {

        Player first = new Player("first");
        Player second=new Player("");
        IPokemon Charmander= new BasicFirePokemon("charmander",3,50,new ArrayList<>());
        IPokemon charmeleon= new Phase1FirePokemon( "charmeleon",4,50,new ArrayList<>());
        ICard salmander= new Phase2FirePokemon("salmander", 5, 60, new ArrayList<>());
        ICard squirtle= new BasicWaterPokemon("squirtle",6,50,new ArrayList<>());
        IEnergy water = new WaterEnergy();
        IEnergy plant = new PlantEnergy();
        IEnergy plant2 = new PlantEnergy();
        IEnergy fighting=new FightingEnergy();
        IPokemon watortle= new Phase1WaterPokemon("squirtle",7,90,new ArrayList<>());
        IPokemon tortoise=new Phase2WaterPokemon("squirtle",8,90,new ArrayList<>());
        ICard one= new ProfessorCozmosDiscovery("p","p");
        ICard two= new TrainingCenter("p","p", 10);
        ICard three= new TrainingCenter("p","p", 30);
        ICard four= new TrainingCenter("p","p", 30);
        ElectricShock es= new ElectricShock("",20,"",30);
        EnergyBurn eb=new EnergyBurn("","");

        //System.out.println(first.getHand().size());

        //Charmander.receiveEnergy(water);
        first.drawCard(two);
        first.drawCard(three);
        first.drawCard(four);
        first.drawCard(Charmander);
        first.drawCard(squirtle);
        first.drawCard(water);
        first.drawCard(charmeleon);
        first.drawCard(salmander);
        first.drawCard(watortle);
        first.drawCard(tortoise);
        charmeleon.setAttack(es);
        charmeleon.receiveEnergy(water);
        charmeleon.receiveEnergy(water);
        charmeleon.receiveEnergy(water);
        charmeleon.receiveEnergy(plant);
        charmeleon.receiveEnergy(plant2);
        charmeleon.receiveEnergy(fighting);

        second.drawCard(squirtle);


        first.playCard(Charmander);
        first.playCard(squirtle);
        first.playCard(charmeleon);
        first.playCard(watortle);
        second.playCard(squirtle);

        System.out.println(first.getBank());
        System.out.println(first.getSelectedPokemon().getEnergiesAssociated());

        first.enableHability(eb,first.getSelectedPokemon());
        System.out.println(first.getSelectedPokemon().getEnergiesAssociated());










    }
}
