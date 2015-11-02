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
public class AllowedInterruptionControllerState implements IPlayerControllerState {
	private Player player;

	public AllowedInterruptionControllerState(Player player) {
		this.player = player;
		ButtonView[] tabView = { new ButtonView(ButtonType.pass, 0), new ButtonView(ButtonType.take, 1) };
		Component.getInstance().getPlayerView().setButtonView(tabView);
		//new Dialog(Window.getInstance(),"titre", player.getName() + ", chose if you want to interrupt and take this last tile");
	}

	public void interpretInput(ButtonType buttonType) {
		switch (buttonType) {
		case take:
			player.setStatus(PlayerStatus.doInterrupt);
			break;
		case pass:
			player.setStatus(PlayerStatus.doNotInterrupt);
			break;
		default:
			break;
		}
	}
}
