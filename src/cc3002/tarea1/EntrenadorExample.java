package cc3002.tarea1;

import cc3002.tarea1.Electric.ElectricPokemon;
import cc3002.tarea1.Fighting.FightingPokemon;
import cc3002.tarea1.Fighting.FigthingEnergy;
import cc3002.tarea1.Fire.FireEnergy;
import cc3002.tarea1.Fire.FirePokemon;
import cc3002.tarea1.Plant.PlantEnergy;
import cc3002.tarea1.Plant.PlantPokemon;
import cc3002.tarea1.Psychic.PsychicPokemon;
import cc3002.tarea1.Water.WaterEnergy;
import cc3002.tarea1.Water.WaterPokemon;

public class EntrenadorExample extends Entrenador {

    public EntrenadorExample(String name) {
        super(name);
    }
    public static void main(String[] args) {
        Entrenador Red= new Entrenador("Red");
        Entrenador Blue= new Entrenador("Blue");
        IPokemon charmander=new FirePokemon("Charmander",4,50);
        IPokemon squirtle= new WaterPokemon("Squirtle", 7, 50);
        IPokemon abra= new PsychicPokemon("Abra", 7, 50);
        IPokemon bulbasaur=new PlantPokemon("Bulbasaur",1,50);
        IPokemon mankey=new FightingPokemon("Mankey",56,60);
        IPokemon pikachu=new ElectricPokemon("Pikachu",25,70);
        IEnergy plant= new PlantEnergy();
        IEnergy fire=new FireEnergy();
        IEnergy water=new WaterEnergy();
        IEnergy fighting=new FigthingEnergy();
        Red.drawCard(charmander);
        Red.playCard(charmander,Blue);
        Red.drawCard(squirtle);
        Red.drawCard(water);
        Red.drawCard(plant);
        Red.playCard(water,Blue);

        Red.playCard(squirtle, Blue);

        System.out.println(Red.getSelectedPokemon().getName());
        System.out.println(Red.getBank().get(1).getName());
        System.out.println(Red.getSelectedPokemon().getQuantityofAnEnergy(water));
        System.out.println(Red.getSelectedPokemon().getQuantityofAnEnergy(plant));


    }
}
