package Controller.State;

import Constants.ButtonType;
import GUI.Component;
import GUI.Dialog;
import GUI.Window;
import Model.Player;
import View.ButtonView;

/**
 * Created by Kreliou on 29/10/2015.
 */
public class TileSelectionControllerState implements IPlayerControllerState {
	private Player player;

	public TileSelectionControllerState(Player player) {
		this.player = player;
		ButtonView[] tabView = { new ButtonView(ButtonType.throwTile, 0) };
		Component.getInstance().getPlayerView().setButtonView(tabView);
		//new Dialog(Window.getInstance(),"titre", player.getName() + ", select the tile you want to throw");
	}

	public void interpretInput(ButtonType buttonType) {
		if (buttonType == ButtonType.throwTile) {
			player.throwTile();
		}
	}
}
