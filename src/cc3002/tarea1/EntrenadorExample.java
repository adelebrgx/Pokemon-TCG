package cc3002.tarea1;

import cc3002.tarea1.Electric.ElectricPokemon;
import cc3002.tarea1.Fighting.FightingPokemon;
import cc3002.tarea1.Fighting.FightingEnergy;
import cc3002.tarea1.Fire.FireEnergy;
import cc3002.tarea1.Fire.FirePokemon;
import cc3002.tarea1.Plant.PlantEnergy;
import cc3002.tarea1.Plant.PlantPokemon;
import cc3002.tarea1.Psychic.PsychicPokemon;
import cc3002.tarea1.Water.WaterEnergy;
import cc3002.tarea1.Water.WaterPokemon;

import java.util.ArrayList;

public class EntrenadorExample extends Entrenador {

    public EntrenadorExample(String name) {
        super(name);
    }
    public static void main(String[] args) {
        Entrenador Red= new Entrenador("Red");
        Entrenador Blue= new Entrenador("Blue");
        IPokemon charmander=new FirePokemon("Charmander",4,50,new ArrayList<>());
        IPokemon squirtle= new WaterPokemon("Squirtle", 7, 50,new ArrayList<>());
        IPokemon abra= new PsychicPokemon("Abra", 7, 50,new ArrayList<>());
        IPokemon bulbasaur=new PlantPokemon("Bulbasaur",1,50,new ArrayList<>());
        IPokemon mankey=new FightingPokemon("Mankey",56,60,new ArrayList<>());
        IPokemon pikachu=new ElectricPokemon("Pikachu",25,70,new ArrayList<>());
        Attack VineWhip= new Attack("Vine Whip", 10, "a Whip Attack");
        Attack Torpedo= new Attack("Torpedo", 50, "a Whip Attack");
        IEnergy plant= new PlantEnergy();
        IEnergy fire=new FireEnergy();
        IEnergy water=new WaterEnergy();
        IEnergy fighting=new FightingEnergy();
        Torpedo.setEnergyCost("Fire", 2);
        Torpedo.setEnergyCost("Plant",1);

        Red.drawCard(charmander);
        Red.drawCard(fire);
        Red.drawCard(fire);
        Red.drawCard(plant);


        Blue.drawCard(squirtle);
        Blue.drawCard(bulbasaur);
        Blue.playCard(squirtle);
        Blue.playCard(bulbasaur);


        Red.playCard(charmander);


        System.out.println(Red.getSelectedPokemon().getName());
        System.out.println(Blue.getSelectedPokemon().getHP());
        Red.playCard(fire);
        Red.playCard(fire);
        Red.playCard(plant);
        charmander.setAttack(Torpedo);
        Red.useAttack(Torpedo,Blue);

        System.out.println(Red.getSelectedPokemon().getQuantityofAnEnergy(fire));
        System.out.println(Red.getSelectedPokemon().getQuantityofAnEnergy(water));
        System.out.println(Blue.getSelectedPokemon().getHP());
        System.out.println(Blue.getSelectedPokemon().getName());










    }
}
