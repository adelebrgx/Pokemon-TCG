package cc3002.tarea1;

/**
 * States Card abstract class which implements the interface IStateCard and extends the abstrct class AStateCard
 * @author Adèle Bourgeix
 */
public abstract class AStateCard extends ATrainerCard implements IStateCard {

    public AStateCard(String aName, String aDescription){super(aName,aDescription);}
}
