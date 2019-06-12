package cc3002.tarea1;

import java.util.Random;

public class ElectricShock extends Attack {

    private int x;

    public ElectricShock(String aName, int aBaseDamage, String aDescription, int x){
        super(aName,aBaseDamage,aDescription);
        this.x=x;}




    @Override
    public void isBeingActivated(Player first, Player following){
        if(!first.getSelectedPokemon().getAbilitiesList().contains(this)){
            System.out.println("The pokemon cannot use Electric Shock");
        }
        else{
            IPokemon pokemon= following.getSelectedPokemon();
            pokemon.isBeingAffectedBy(this);
        }

    }


    @Override
    public void affect(IPokemon pokemon){
        Random random = new Random();
        int rand= random.nextInt(2);
        System.out.println(rand);
        if (rand==0){
            int hp= pokemon.getHP()-x;
            pokemon.setHP(hp);
        }
    }


    public int getX(){
        return this.x;
    }


}
