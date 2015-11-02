package View;

import java.awt.Graphics;
import java.util.Observable;
import Constants.Layout;
import Constants.Resource;
import Controller.TileController;
import Model.Tile;

public class TileView implements IView {
	private Tile tile;
	private int x;
	private int y;

	public TileView(Tile tile, int x, int y) {
		this.tile = tile;
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics g) {
		g.drawImage(Resource.getInstance().getTileImage(tile.getType(), tile.getDigit()), x, y, null);
		if (tile.isSelected())
			g.drawImage(Resource.getInstance().getFocusTile(), x, y, null);
	}

	public void mousseEvent(int x, int y) {
		if (x < this.x + Layout.getInstance().getTileImageSize() * 3 / 4
				&& x > this.x + Layout.getInstance().getTileImageSize() * 1 / 4
				&& y < this.y + Layout.getInstance().getTileImageSize() * 3 / 4
				&& y > this.y + Layout.getInstance().getTileImageSize() * 1 / 4) {
			TileController.getInstance().interpretInput(tile);
		}
	}

	public void update(Observable o, Object arg1) {
		tile = (Tile) o;
	}
}
