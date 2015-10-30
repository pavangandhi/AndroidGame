package Model;

import java.util.Observable;
import Constants.PlayerStatus;
import Rules.SetOfRules;
import View.PlayerView;

public class Player extends Observable {
	//private static volatile Player instance = new Player();

	private Hand hand;
	private Player next = null;
	private PlayerStatus status = null;
	private String name;

	public Player(String name) {
		this.name = name;
	}
	

	public void initializeHand() {
		hand = new Hand();
		hand.addObserver(PlayerView.getInstance().getHandView());
		for (int k = 0; k<13;k++){
			pickUpFromDeck();
		}
	}

	public void pickUpFromDeck() {
		hand.addTile(Deck.getInstance().drawTile());
		if (SetOfRules.getInstance().checkVictory(hand))
			setStatus(PlayerStatus.victory);
		else
			setStatus(PlayerStatus.tilePicked);
	}

	public void pickUpFromBoard() {
		hand.addTile(Board.getInstance().getLastTile());
		if (SetOfRules.getInstance().checkVictory(hand))
			setStatus(PlayerStatus.victory);
		else
			setStatus(PlayerStatus.tilePicked);
	}

	public void throwTile() {
		System.out.println(name + " throw tile");
		Board.getInstance().addTile(hand.removeTile());
		setStatus(PlayerStatus.turnEnded);

	}

	public void checkInterruption() {
		System.out.println(name + " check interruption");
		hand.update();
		if (SetOfRules.getInstance().checkInterruption(hand))
			setStatus(PlayerStatus.interruptionAllowed);
		else
			setStatus(PlayerStatus.interruptionRefused);
	}

	public void selectTile(int pos) {
		hand.setSelectedTile(pos);
	}

	public boolean hasWin() {
		return status == PlayerStatus.victory;
	}
	
	public Player getNext() {
		if (next.hasWin())
			return next.getNext();
		else
			return next;
	}

	public void update() {
		setChanged();
		notifyObservers(status);
	}

	public PlayerStatus getStatus() {
		return status;
	}

	public void setStatus(PlayerStatus status) {
		this.status = status;
		update();
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public void setNext(Player next) {
		this.next = next;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
