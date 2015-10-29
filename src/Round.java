import Manager.TurnManager;
import Model.Board;
import Model.Deck;
import Model.Player;
import Rules.SetOfRules;
import Rules.Strategys.Sichuan.SichuanInterruptionCondition;
import Rules.Strategys.Sichuan.SichuanVictoryCondition;

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
        SetOfRules.getInstance().setInterruptionCondition(new SichuanInterruptionCondition());
        SetOfRules.getInstance().setVictoryCondition(new SichuanVictoryCondition());
        player1 = new Player("1");
        player2 = new Player("2");
        player3 = new Player("3");
        player4 = new Player("4");
        turnManager = new TurnManager(player1, player2, player3, player4);
        turnManager.distributeTiles();
    }
}