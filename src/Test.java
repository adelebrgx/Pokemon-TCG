import cc3002.tarea1.*;
import cc3002.tarea1.Fighting.FightingEnergy;
import cc3002.tarea1.Fighting.Phase1FightingPokemon;
import cc3002.tarea1.Fire.AFirePokemon;
import cc3002.tarea1.Fire.BasicFirePokemon;
import cc3002.tarea1.Fire.Phase1FirePokemon;
import cc3002.tarea1.Fire.Phase2FirePokemon;
import cc3002.tarea1.Water.BasicWaterPokemon;
import cc3002.tarea1.Water.Phase1WaterPokemon;
import cc3002.tarea1.Water.Phase2WaterPokemon;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String [] args)
    {

        Player first = new Player("first");
        IPokemon Charmander= new BasicFirePokemon("charmander",3,50,new ArrayList<>());
        IPokemon charmeleon= new Phase1FirePokemon( "charmeleon",4,50,new ArrayList<>());
        ICard salmander= new Phase2FirePokemon("salmander", 5, 60, new ArrayList<>());
        ICard squirtle= new BasicWaterPokemon("squirtle",6,50,new ArrayList<>());
        IEnergy water = new FightingEnergy();
        IPokemon watortle= new Phase1WaterPokemon("squirtle",7,90,new ArrayList<>());
        IPokemon tortoise=new Phase2WaterPokemon("squirtle",8,90,new ArrayList<>());
        ICard one= new ProfessorCozmosDiscovery("p","p");
        ICard two= new TrainingCenter("p","p", 10);
        ICard three= new TrainingCenter("p","p", 30);
        ICard four= new TrainingCenter("p","p", 30);

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


        first.playCard(Charmander);
        first.playCard(squirtle);
        first.playCard(charmeleon);
        first.playCard(watortle);

        System.out.println(charmeleon.getHP());
        System.out.println(watortle.getHP());
        //ArrayList list= new ArrayList();
        //list.add(charmeleon);

        //first.initiateDeck(list);

        //System.out.println(first.getStack().size());

        first.playCard(two);
        System.out.println(charmeleon.getHP());
        System.out.println(watortle.getHP());
        first.playCard(three);
        System.out.println(charmeleon.getHP());
        System.out.println(watortle.getHP());

        first.playCard(tortoise);
        first.playCard(four);
        System.out.println(first.getBank());
        System.out.println(charmeleon.getHP());
        System.out.println(tortoise.getHP());




        //first.playCard(charmeleon);
        //first.playCard(salmander);
        //System.out.println(first.getBank().get(0));
        //System.out.println(first.getBank().get(1));
        //first.playCard(water);
        //System.out.println(first.getSelectedPokemon());
        //System.out.println(Charmander.getQuantityofAnEnergy(water));
        //System.out.println(charmeleon.getQuantityofAnEnergy(water));
        //System.out.println(first.getSelectedPokemon().getQuantityofAnEnergy(water));

        //first.playCard(one);
        //System.out.println(first.getHand().size());









    }
}
