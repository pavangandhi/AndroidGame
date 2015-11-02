package Manager;

import java.util.Observable;
import java.util.Observer;
import Constants.PlayerStatus;
import Model.Player;

public class TurnManager implements Observer {

	private Player currentPlayer;
	private Player lastPlayer;

	public void on(Player player) {
		currentPlayer = player;
		lastPlayer = currentPlayer;
		currentPlayer.pickupFromDeck();
	}

	public void update(Observable obs, Object status) {
		switch ((PlayerStatus) status) {
		case turnEnded:
			currentPlayer = currentPlayer.getNext();
			currentPlayer.checkInterruption();
			;
			break;
		case doInterrupt:
			lastPlayer = currentPlayer;
			currentPlayer.pickupFromBoard();
			break;
		case doNotInterrupt:
			if (currentPlayer.getNext() != lastPlayer) {
				currentPlayer = currentPlayer.getNext();
				currentPlayer.checkInterruption();
			} else {
				currentPlayer = lastPlayer.getNext();
				lastPlayer = currentPlayer;
				currentPlayer.pickupFromDeck();
			}
			break;
		case victory:
			currentPlayer = currentPlayer.getNext();
			lastPlayer = currentPlayer;
			currentPlayer.pickupFromDeck();
			break;
		default:
			break;
		}
	}
}
