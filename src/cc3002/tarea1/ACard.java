package cc3002.tarea1;

/**
 * Abstract class which represents the logic of cards and implements the interface ICard
 */
public abstract class ACard implements ICard {

    private String title;


    public ACard(String aName){
        this.title=title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
