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
		currentPlayer.pickUpFromDeck();
	}

	public void update(Observable obs, Object status) {
		switch ((PlayerStatus) status) {
		case turnEnded:
			System.out.println("turnEnded");
			currentPlayer = currentPlayer.getNext();
			currentPlayer.checkInterruption();
			break;
		case doInterrupt:
			currentPlayer.pickUpFromBoard();
			break;
		case doNotInterrupt:
			if (currentPlayer.getNext() != lastPlayer) {
				currentPlayer = currentPlayer.getNext();
				currentPlayer.checkInterruption();
			} else {
				currentPlayer = lastPlayer.getNext();
				lastPlayer = currentPlayer;
				currentPlayer.pickUpFromDeck();
			}
			break;
		case victory:
			currentPlayer = currentPlayer.getNext();
			currentPlayer.pickUpFromDeck();
			break;
		default:
			break;
		}
	}
}
