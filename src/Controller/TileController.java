package Controller;

import Model.Tile;

public class TileController {
	private static TileController instance = null;

	protected TileController() {

	}

	public static TileController getInstance() {
		if (instance == null) {
			instance = new TileController();
		}
		return instance;
	}

	private Tile lastTile = null;

	public void interpretInput(Tile tile) {
		if (lastTile != null)
			lastTile.setSelected(false);
		tile.setSelected(true);
		lastTile = tile;
	}
}
