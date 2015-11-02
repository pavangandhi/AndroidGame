package Model;

import Model.TileList.TileList;

public class Hand extends TileList {
	public Tile removeTile() {
		Tile tempTile = null;
		for (Tile tile : tileList) {
			if (tile.isSelected()) {
				tempTile = tile;
			}
		}
		tempTile.setSelected(false);
		removeTile(tempTile);
		return tempTile;
	}

	public boolean hasSelectedTile() {
		for (Tile tile : tileList) {
			if (tile.isSelected()) {
				return true;
			}
		}
		return false;
	}
}