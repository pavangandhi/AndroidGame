package Model;

import Model.TileList.TileList;

public class Hand extends TileList {
	private int selectedTile = -1;
	
	public Tile removeTile() {
		Tile tempTile = removeTile(tileList.get(selectedTile));
		selectedTile = -1;
		return tempTile;
	}

	public int getSelectedTile() {
		return selectedTile;
	}

	public void setSelectedTile(int selectedTile) {
		this.selectedTile = selectedTile;
		update();
	}
}