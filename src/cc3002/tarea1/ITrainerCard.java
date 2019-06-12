package cc3002.tarea1;

/**
 * Interface which implements the logic of a trainer card
 * @author Adèle Bourgeix
 */
public interface ITrainerCard extends ICard {

    /**
     * Getter to the Trainer card's description
     * @return a String description
     */
    String getDescription();

    /**
     * Allows inspecting pokemons of basic type and acting in consequence. (cc Visitor Pattern implemented in Training Center.
     * @param basic Basic Pokemon being inspected
     */
    void inspectBasicPokemon(IBasicPokemon basic);

    /**
     *Allows inspecting pokemons of basic type and acting in consequence. (cc Visitor Pattern implemented in Training Center.
     * @param phase1 Phase1 pokemon being inspected
     */
    void inspectPhase1Pokemon(IPhase1Pokemon phase1);

    /**
     *Allows inspecting pokemons of basic type and acting in consequence. (cc Visitor Pattern implemented in Training Center.
     * @param phase2 Phase2 pokemon being inspected
     */
    void inspectPhase2Pokemon(IPhase2Pokemon phase2);
}
