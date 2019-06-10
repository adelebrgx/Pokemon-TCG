package cc3002.tarea1;

import cc3002.tarea1.IHability;

public interface IAttack extends IHability {
    /**
     * What happens when a player activates an ability during the game, ambiguity is solved
     * @param first the player activating the ability
     * @param following the other player involved if other player is involved
     */
    void isBeingActivated(Player first, Player following);
}
