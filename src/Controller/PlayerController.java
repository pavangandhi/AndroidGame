package Controller;

import java.util.Observable;
import java.util.Observer;

import Constants.ButtonType;
import Constants.PlayerStatus;
import Controller.State.AllowedInterruptionControllerState;
import Controller.State.IPlayerControllerState;
import Controller.State.InactiveControllerState;
import Controller.State.TileSelectionControllerState;
import Controller.State.UnallowedInterruptionControllerState;
import Model.Player;

public class PlayerController implements Observer {
	private static PlayerController instance = null;

	protected PlayerController() {

	}

	public static PlayerController getInstance() {
		if (instance == null) {
			instance = new PlayerController();
		}
		return instance;
	}

	private IPlayerControllerState state;

	private Player currentPlayer;

	public void interpretInput(ButtonType buttonType) {
		state.interpretInput(buttonType);
	}

	public void update(Observable obs, Object status) {
		currentPlayer = (Player) obs;
		switch ((PlayerStatus) status) {
		case tilePicked:
			setState(new TileSelectionControllerState(currentPlayer));
			break;
		case interruptionAllowed:
			setState(new AllowedInterruptionControllerState(currentPlayer));
			System.out.println("interruption allowed");
			break;
		case interruptionRefused:
			setState(new UnallowedInterruptionControllerState(currentPlayer));
			System.out.println("interruption refused");
			break;
		default:
			setState( new InactiveControllerState());
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
