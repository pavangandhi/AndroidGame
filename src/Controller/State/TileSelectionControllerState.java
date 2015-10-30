package Controller.State;

import Constants.Layout;
import Model.Player;
import View.PlayerView;
import View.Button.ThrowButton;

/**
 * Created by Kreliou on 29/10/2015.
 */
public class TileSelectionControllerState implements IPlayerControllerState {
	private Player player;

	public TileSelectionControllerState(Player player) {
		this.player = player;
		PlayerView.getInstance().setIPaintButton(new ThrowButton());
	}

	public void interpretInput(int x, int y) {
		if (Math.pow((x - Layout.getInstance().getButtonX() - Layout.getInstance().getButtonSize() / 2), 2)
				+ Math.pow(y - Layout.getInstance().getButtonY() - Layout.getInstance().getButtonSize() / 2, 2) 
				< Math.pow(Layout.getInstance().getButtonSize() * 2 / 3, 2)) {
			player.throwTile();
		}
		else {
			player.selectTile(-1);
			for (int k = 0; k < Layout.getInstance().getHandSize(); k++) {
				if (Math.pow((x - Layout.getInstance().getMargin() - k * Layout.getInstance().getHandStep()
						- Layout.getInstance().getTileImageSize() / 2), 2)
						+ Math.pow(y - Layout.getInstance().getHandHeight() - Layout.getInstance().getTileImageSize()/2,
								2) < Math.pow(Layout.getInstance().getTileImageSize() * 2 / 3, 2)) {
					player.selectTile(k);
				}
			}
		}
	}
}
