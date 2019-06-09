package cc3002.tarea1;

/**
 * Interface which implements the logic of state's cards
 * @author Adèle Bourgeix
 */
public interface IStateCard {

    void inspectBasicPokemon(IBasicPokemon basic);

    void inspectPhase1Pokemon(IPhase1Pokemon basic);

    void inspectPhase2Pokemon(IPhase2Pokemon basic);


}
