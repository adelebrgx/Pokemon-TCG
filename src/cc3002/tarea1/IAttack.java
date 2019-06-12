package cc3002.tarea1;

public interface IAttack extends IAbility {
    /**
     * What happens when a player activates an attack during the game, ambiguity is solved
     * @param first the player activating the attack
     * @param following the other player involved
     */
    void isBeingActivated(Player first, Player following);

    /**
     * Sees if an attack can be used according to its cost
     * @param player using the attack
     * @return true if the pokemon's player has enough energies to use the attack
     */
    boolean canBeUsed(Player player);
}
