package Controller;

import Controller.State.IPlayerControllerState;
import Model.Player;

import java.util.Observable;
import java.util.Observer;

public class PlayerController implements Observer{
	private IPlayerControllerState state;

	Player currentPlayer;

	public void update(Observable obs, Object status) {
		currentPlayer = (Player)obs;
		
		// Attention j'ai pris uniquement l'instance du player, ce n'est pas une bonne méthode pour la récupérer il faut donc modifier ce point.
		
		
		switch ((Player.Status)status)	{
		case tilePicked:
			currentPlayer.thowTile();
			break;
		case interruptionRefused:
			currentPlayer.doNotInterrupt();
			break;
		default:
			break;
		}
	}

	public IPlayerControllerState getState() {
		return state;
	}

	public void setState(IPlayerControllerState state) {
		this.state = state;
	}
}
