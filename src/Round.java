public class Round {

    private TurnManager turnManager;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    public Round() {
        turnManager = new TurnManager(player1, player2, player3, player4);
    }

    public void start() {
        initializeRound();
        turnManager.on();
    }

    public void initializeRound() {
        Deck.getInstance().initializeDeck();
        Board.getInstance().initializeBoard();
        player1 = new Player("1");
        player2 = new Player("2");
        player3 = new Player("3");
        player4 = new Player("4");
        turnManager = new TurnManager(player1, player2, player3, player4);
        turnManager.distributeTiles();
    }
}