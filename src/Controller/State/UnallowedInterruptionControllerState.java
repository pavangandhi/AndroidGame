package Controller.State;

import Constants.Layout;
import Constants.PlayerStatus;
import Model.Player;
import View.PlayerView;
import View.Button.UnallowedInterruptionButton;

/**
 * Created by Kreliou on 29/10/2015.
 */
public class UnallowedInterruptionControllerState implements IPlayerControllerState{
	private Player player;

	public UnallowedInterruptionControllerState(Player player){
		this.player = player;
		PlayerView.getInstance().setIPaintButton(new UnallowedInterruptionButton());
	}
    public void interpretInput(int x, int y) {
    	if (Math.pow((x - Layout.getInstance().getButtonX() - Layout.getInstance().getButtonSize() / 2), 2)
				+ Math.pow(y - Layout.getInstance().getButtonY() - Layout.getInstance().getMargin() - Layout.getInstance().getButtonSize() * 3/2, 2) 
				< Math.pow(Layout.getInstance().getButtonSize() * 2 / 3, 2)) {
			player.setStatus(PlayerStatus.doNotInterrupt);
		}
    }
}
