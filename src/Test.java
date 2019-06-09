import cc3002.tarea1.Fighting.FightingEnergy;
import cc3002.tarea1.Fighting.Phase1FightingPokemon;
import cc3002.tarea1.Fire.AFirePokemon;
import cc3002.tarea1.Fire.BasicFirePokemon;
import cc3002.tarea1.Fire.Phase1FirePokemon;
import cc3002.tarea1.Fire.Phase2FirePokemon;
import cc3002.tarea1.ICard;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.Player;
import cc3002.tarea1.Water.BasicWaterPokemon;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String [] args)
    {

        Player first = new Player("first");
        IPokemon Charmander= new BasicFirePokemon("charmander",3,50,new ArrayList<>());
        IPokemon charmeleon= new Phase1FirePokemon( "charmeleon",4,50,new ArrayList<>());
        ICard salmander= new Phase2FirePokemon("salmander", 5, 60, new ArrayList<>());
        ICard squirtle= new BasicWaterPokemon("squirtle",3,50,new ArrayList<>());
        IEnergy water = new FightingEnergy();

        System.out.println(first.getHand().size());

        Charmander.receiveEnergy(water);
        first.drawCard(Charmander);
        first.drawCard(squirtle);
        first.drawCard(water);
        first.drawCard(charmeleon);
        first.drawCard(salmander);
        first.playCard(Charmander);
        first.playCard(squirtle);
        //first.playCard(charmeleon);
        //first.playCard(salmander);
        System.out.println(first.getBank().get(0));
        System.out.println(first.getBank().get(1));
        first.playCard(water);
        //System.out.println(first.getSelectedPokemon());
        System.out.println(Charmander.getQuantityofAnEnergy(water));
        //System.out.println(charmeleon.getQuantityofAnEnergy(water));
        //System.out.println(first.getSelectedPokemon().getQuantityofAnEnergy(water));










    }
}
