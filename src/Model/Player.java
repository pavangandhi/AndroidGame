package Model;

import java.util.Observable;

import Constants.PlayerStatus;
import GUI.Component;
import Historic.Historic;
import Rules.SetOfRules;

public class Player extends Observable {
	private Hand hand;
	private Player next = null;
	private PlayerStatus status = null;
	private String name;

	public Player(String name) {
		this.name = name;
	}

	public void initializeHand() {
		hand = new Hand();
		hand.addObserver(Component.getInstance().getHandView());
		for (int k = 0; k < 13; k++) {
			pickupFromDeck();
		}
	}

	public void pickupFromDeck() {
		Tile drawedTile = Deck.getInstance().drawTile();
		hand.addTile(drawedTile);
		Historic.getInstance().addEvent(name + " picked a tile from the deck.");
		if (SetOfRules.getInstance().checkGongPickup(drawedTile, hand)) {
			Historic.getInstance().addEvent(name + " has gonged.");
			pickupFromDeck();
		} else if (SetOfRules.getInstance().checkVictory(hand)) {
			setStatus(PlayerStatus.victory);
			Historic.getInstance().addEvent(name + " has win.");
		} else
			setStatus(PlayerStatus.tilePicked);
	}

	public void pickupFromBoard() {
		Tile drawedTile = Board.getInstance().pickLastTile();
		hand.addTile(drawedTile);
		Historic.getInstance().addEvent(name + " picked a tile from the board.");
		if (SetOfRules.getInstance().checkGongPickup(drawedTile, hand)) {
			Historic.getInstance().addEvent(name + " has gonged.");
			pickupFromDeck();
		} else if (SetOfRules.getInstance().checkVictory(hand)) {
			setStatus(PlayerStatus.victory);
			Historic.getInstance().addEvent(name + " has win.");
		} else
			setStatus(PlayerStatus.tilePicked);
	}

	public void throwTile() {
		System.out.println(name + " throw tile");
		if (hand.hasSelectedTile()) {
			Historic.getInstance().addEvent(name + " has throw a tile.");
			Board.getInstance().addTile(hand.removeTile());
			setStatus(PlayerStatus.turnEnded);
		}
	}

	public void checkInterruption() {
		System.out.println(name + " check interruption");
		hand.update();
		if (SetOfRules.getInstance().checkInterruption(hand))
			setStatus(PlayerStatus.interruptionAllowed);
		else
			setStatus(PlayerStatus.interruptionRefused);
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
