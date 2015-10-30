import Controller.PlayerController;
import Manager.TurnManager;
import Model.Board;
import Model.Deck;
import Model.Player;
import Rules.SetOfRules;
import Rules.Strategys.Sichuan.SichuanInterruptionCondition;
import Rules.Strategys.Sichuan.SichuanVictoryCondition;
import View.PlayerView;

public class Round {
    private TurnManager turnManager;
    
    public Round(){
		turnManager = new TurnManager();
    }

    public void start() {
        turnManager.on(initializeRound());
    }

    public Player initializeRound() {
		Deck.getInstance().addObserver(PlayerView.getInstance().getDeckView());
		Board.getInstance().addObserver(PlayerView.getInstance().getBoardView());
        Deck.getInstance().initializeDeck();
        Board.getInstance().initializeBoard();
        
        SetOfRules.getInstance().setInterruptionCondition(new SichuanInterruptionCondition());
        SetOfRules.getInstance().setVictoryCondition(new SichuanVictoryCondition());
    	Player player1 = initializePlayer("Player 1");
		Player player2 = initializePlayer("Player 2");
		Player player3 = initializePlayer("Player 3");
		Player player4 = initializePlayer("Player 4");
		player1.setNext(player2);
		player2.setNext(player3);
		player3.setNext(player4);
		player4.setNext(player1);
		
		return player1;
    }
    
    public Player initializePlayer(String name) {
    	Player player = new Player(name);
		player.addObserver(turnManager);
		player.addObserver(PlayerController.getInstance());
		player.addObserver(PlayerView.getInstance());
    	player.initializeHand();
    	return player;
    }
}