package sk.uniba.fmph.dcs.game_board;

public interface FigureLocationAdaptor implements InterfaceFigureLocationInternal {
    private final InterfaceFigureLocation interfaceFigureLocation;

    public FigureLocationAdaptor(InterfaceFigureLocation interfaceFigureLocation) {
        this.interfaceFigureLocation = interfaceFigureLocation;
    }

    @Override
    public boolean placeFigures(Player player, int figureCount) {
        return interfaceFigureLocation.placeFigures(player, figureCount);
    }

    @Override
    public HasAction tryToPlaceFigures(Player player, int count) {
        return interfaceFigureLocation.tryToPlaceFigures(player, count);
    }

    @Override
    public ActionResult makeAction(Player player, Effect[] inputResources, Effect[] outputResources) {
        return interfaceFigureLocation.makeAction(player, inputResources, outputResources);
    }

    @Override
    public boolean skipAction(Player player) {
        return interfaceFigureLocation.skipAction(player);
    }

    @Override
    public HasAction tryToMakeAction(Player player) {
        return interfaceFigureLocation.tryToMakeAction(player);
    }

    @Override
    public boolean newTurn() {
        return interfaceFigureLocation.newTurn();
    }
}