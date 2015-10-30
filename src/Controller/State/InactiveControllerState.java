package Controller.State;

import View.PlayerView;
import View.Button.NoButton;

/**
 * Created by Kreliou on 29/10/2015.
 */
public class InactiveControllerState implements IPlayerControllerState{
	public InactiveControllerState(){
		PlayerView.getInstance().setIPaintButton(new NoButton());
	}
    public void interpretInput(int x, int y) {
    }

}
