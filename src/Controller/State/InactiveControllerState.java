package Controller.State;

import Constants.ButtonType;
import GUI.Component;
import View.ButtonView;

/**
 * Created by Kreliou on 29/10/2015.
 */
public class InactiveControllerState implements IPlayerControllerState {
	public InactiveControllerState() {
		ButtonView[] tabView = {};
		Component.getInstance().getPlayerView().setButtonView(tabView);
	}

	public void interpretInput(ButtonType buttonType) {
	}

}
