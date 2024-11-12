public interface InterfaceFigureLocationInternal {
    boolean placeFigures(player: Player, figureCount: int);
    HasAction tryToPlaceFigures(player: Player, count: int);
    ActionResult makeAction(player: Player, inputResources: Effect[], outputResources: Effect[]);
    boolean skipAction(player: Player);
    HasAction tryToMakeAction(player: Player);
    boolean newTurn(); //{returns true if end of game is implied by given location}
}