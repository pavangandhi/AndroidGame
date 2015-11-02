package Controller.State;

import Constants.ButtonType;
import Constants.PlayerStatus;
import GUI.Component;
import GUI.Dialog;
import GUI.Window;
import Model.Player;
import View.ButtonView;

/**
 * Created by Kreliou on 29/10/2015.
 */
public class UnallowedInterruptionControllerState implements IPlayerControllerState {
	private Player player;

	public UnallowedInterruptionControllerState(Player player) {
		this.player = player;
		ButtonView[] tabView = { new ButtonView(ButtonType.pass, 0), new ButtonView(ButtonType.cantTake, 1) };
		Component.getInstance().getPlayerView().setButtonView(tabView);
		//new Dialog(Window.getInstance(),"titre", player.getName() + ", chose if you want to interrupt and take this last tile");
	}

	public void interpretInput(ButtonType buttonType) {
		if (buttonType == ButtonType.pass) {
			player.setStatus(PlayerStatus.doNotInterrupt);
		}
	}
}
