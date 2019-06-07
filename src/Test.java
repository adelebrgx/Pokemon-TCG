import cc3002.tarea1.Attack;
import cc3002.tarea1.Fighting.FightingEnergy;
import cc3002.tarea1.Fire.FireEnergy;
import cc3002.tarea1.Fire.FirePokemon;
import cc3002.tarea1.ICard;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.Player;
import cc3002.tarea1.Water.WaterEnergy;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String [] args)
    {

        Player first = new Player("first");
        ICard Charmander= new FirePokemon("charmander",3,50,new ArrayList<>());
        ICard charmeleon= new FirePokemon("charmeleon",3,50,new ArrayList<>());
        ICard squirtle= new FirePokemon("squirtle",3,50,new ArrayList<>());
        IEnergy water = new FightingEnergy();

        List<ICard> list=new ArrayList<>();
        list.add(Charmander);
        list.add(charmeleon);
        list.add(squirtle);
        System.out.println(water.getTitle());


        first.initiateDeck(list);
        //System.out.println(first.getStack().get(60).getTitle());
        //System.out.println(first.getStack().get(0).getTitle());


        first.initiatePrimeCards(list);
        //for (int i=0; i<6; i++){
            //System.out.println(first.getPrimeCards().get(i).getTitle());
        //}



    }
}
