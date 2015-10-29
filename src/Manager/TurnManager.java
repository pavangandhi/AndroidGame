package Manager;

import Model.Player;

import java.util.Observable;
import java.util.Observer;

public class TurnManager implements Observer {
	
	private Player currentPlayer;
	private Player lastPlayer;
	private int count;
	
	public void update(Observable obs, Object status) {
		switch ((Player.Status)status) {
		case turnEnded:
			count++;
			currentPlayer = currentPlayer.getNext();
			currentPlayer.checkInterruption();
			break;
		case doNotInterrupt:
			count++;
			
			/** Ici il faut faire une initiation pour modifi� la variable totalPlayer en fonction du nombre de joueur.
			 * Une autre m�thode serait avec un currentPlayer.getNext() == lastPlayer();
			 * Seulement cette m�thode implique que deux joueurs ne peuvent pas avoir le m�me nom..
			 */
			
			int totalPlayer = 4;
			
			if (count < totalPlayer){
				currentPlayer = currentPlayer.getNext();
				currentPlayer.checkInterruption();
			}
			else{
				count = 0;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				currentPlayer = lastPlayer.getNext();
				lastPlayer = currentPlayer;
				currentPlayer.play();
			}
			break;
		default:
			break;
		}
	}

	public void on(Player player1) {
		currentPlayer = player1;
		lastPlayer = currentPlayer;
		currentPlayer.play();
	}


}
