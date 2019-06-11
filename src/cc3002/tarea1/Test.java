package cc3002.tarea1;

import cc3002.tarea1.Fire.BasicFirePokemon;
import cc3002.tarea1.Fire.FireEnergy;
import cc3002.tarea1.Water.BasicWaterPokemon;
import cc3002.tarea1.Water.WaterEnergy;

import java.util.ArrayList;

public class Test {



    public static void main(String [] args)
    {

        Controller controller;
        Player Blue;
        Player Red;
        ArrayList list;
        FireEnergy fire;
        WaterEnergy water;
        IPokemon squirtle;
        BasicAttack bubble;
        IPokemon charmander;



        list=new ArrayList();
        fire=new FireEnergy();
        water= new WaterEnergy();
        list.add(fire);
        list.add(water);
        controller=new Controller();
        controller.initGame();
        charmander=new BasicFirePokemon("Charmander",4,100,new ArrayList<>());
        bubble = new BasicAttack("Bubble", 40,"Attack of pokemon type: water");
        squirtle=new BasicWaterPokemon("Squirtle",7,70,new ArrayList<>());
        Player blue= controller.getFirst();
        Player red= controller.getSecond();

        //System.out.println(blue.getIsPlaying());
        //System.out.println(red.getIsPlaying());

        blue.initiateDeck(list);
        blue.drawCard();
        System.out.println(blue.getState().isInFirstState());
        blue.endActions();
        blue.endTurn();
        System.out.println(blue.getIsPlaying());
        System.out.println(blue.getEndingTurn());
        System.out.println(controller.getPlaying().getName());
        System.out.println(red.getIsPlaying());
        System.out.println(red.getEndingTurn());




    }

}
